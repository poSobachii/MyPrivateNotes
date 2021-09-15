package microservice.service.customer;

import microservice.dto.card.DebtCardDTO;
import microservice.dto.customer.CustomerDTO;
import microservice.dto.customer.CustomerRequestDTO;
import microservice.entity.DebtCard;
import microservice.entity.Customer;
import microservice.entity.enums.ValidationRule;
import microservice.repository.CustomerRepository;
import microservice.service.card.CardService;
import microservice.service.validation.ValidationService;
import microservice.service.validation.pojo.EmptyFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private CardService cardService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        return getCustomerDtos(customerList);
    }

    @Override
    public CustomerDTO getOneById(Long id) {
        return transformToCustomerDto(getIfExists(id));
    }

    @Override
    public void create(CustomerRequestDTO customerRequest) throws Exception {
        validateFormIsFilledCorrectly(customerRequest);
        Customer customer = transformToEntity(customerRequest);
        customerRepository.save(customer);
    }

    @Override
    public void updateById(Long id, CustomerRequestDTO changesRequest) throws Exception {
        validateFormIsFilledCorrectly(changesRequest);
        Customer customer = getIfExists(id);
        Customer updatedCustomer = updateCustomer(customer, changesRequest);
        customerRepository.save(updatedCustomer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.delete(getIfExists(id));
    }

    @Override
    public void attachCard(Long customerId, DebtCard debtCard) {
        Customer customer = getIfExists(customerId);
        customer.getCardList().add(debtCard);
        customerRepository.save(customer);
    }

    private void validateFormIsFilledCorrectly(CustomerRequestDTO customerRequest) throws Exception {
        if (customerRequest.checkFieldsFilled()) {
            throw new EmptyFieldException();
        }
        validationService.validateFieldIsCorrect(customerRequest.getEmail(), ValidationRule.CUSTOMER_EMAIL);
    }

    private Customer transformToEntity(CustomerRequestDTO customerRequestDTO) {
        return new Customer(
                customerRequestDTO.getName(),
                customerRequestDTO.getSurname(),
                customerRequestDTO.getCountry(),
                customerRequestDTO.getEmail(),
                passwordEncoder.encode(customerRequestDTO.getPassword())
        );
    }

    private Customer updateCustomer(Customer customer, CustomerRequestDTO changes) {
        customer.setName(changes.getName());
        customer.setSurname(changes.getSurname());
        customer.setCountry(changes.getCountry());
        customer.setEmail(changes.getEmail());
        customer.setPassword(passwordEncoder.encode(changes.getPassword()));
        return customer;
    }

    private List<CustomerDTO> getCustomerDtos(List<Customer> customerList) {
        return customerList.stream().map(this::transformToCustomerDto).collect(Collectors.toList());
    }

    private CustomerDTO transformToCustomerDto(Customer customer) {
        List<DebtCardDTO> cardList = cardService.transformToCardDto(customer.getCardList());
        return new CustomerDTO(customer, cardList);
    }

    private Customer getIfExists(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            String message = MessageFormat.format("No customer with id [{0}] exists", id);
            throw new EntityNotFoundException(message);
        }
        return customer;
    }

}
