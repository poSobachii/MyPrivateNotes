package microservice.service.customer;

import microservice.dto.customer.CustomerRequestDTO;
import microservice.entity.DebtCard;
import microservice.entity.Customer;
import microservice.repository.CustomerRepository;
import microservice.service.validation.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerService;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    ValidationService validationService;
    @Mock
    CustomerRepository customerRepository;

    private CustomerRequestDTO customerRequestDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerRequestDTO = getCustomerRequest();
        when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
    }

    @Test
    void create() throws Exception {
        customerService.create(customerRequestDTO);
        verify(customerRepository, times(1)).save(any(Customer.class));

    }

    @Test
    void updateById() throws Exception {
        customerService.updateById(1L, customerRequestDTO);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void attachCard() {
        DebtCard debtCard = new DebtCard();
        customerService.attachCard(1L, debtCard);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    private CustomerRequestDTO getCustomerRequest() {
        return new CustomerRequestDTO(
                "Jhon", "Snow", "GB", "snow@games.com", "pass123");
    }
}