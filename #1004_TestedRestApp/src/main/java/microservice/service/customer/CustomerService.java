package microservice.service.customer;

import microservice.entity.DebtCard;
import microservice.dto.customer.CustomerDTO;
import microservice.dto.customer.CustomerRequestDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAll();

    CustomerDTO getOneById(Long id);

    void create(CustomerRequestDTO customerRequestDTO) throws Exception;

    void updateById(Long id, CustomerRequestDTO customerRequestDTO) throws Exception;

    void deleteById(Long id);

    void attachCard(Long customerId, DebtCard debtCard);
}
