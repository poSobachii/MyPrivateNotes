package microservice;

import microservice.dto.card.CardAmountChangeRequestDTO;
import microservice.dto.card.CardRequestDTO;
import microservice.dto.customer.CustomerRequestDTO;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTestHelper {

    protected final String LOCALHOST_BASE_URl = "http://localhost:8080";
    protected final String CUSTOMER_URL = LOCALHOST_BASE_URl + "/customers";
    protected final String CARD_URL = LOCALHOST_BASE_URl + "/cards";



    protected CustomerRequestDTO getCustomerRequest() {
        return new CustomerRequestDTO("Jhon", "Snow", "GB", "snow@games.com", "strongPass");
    }

    protected CustomerRequestDTO getCustomerWithWrongEmailRequest() {
        return new CustomerRequestDTO("Jhon", "Snow", "GB", "gmail.com", "strongPass");
    }

    protected CustomerRequestDTO getCustomerWithEmptyFieldRequest() {
        return new CustomerRequestDTO("Jhon", null, "GB", "gmail.com", "strongPass");
    }

    protected CardRequestDTO getCardRequest() {
        return new CardRequestDTO( 200, "EUR", "04/26");
    }

    protected CardAmountChangeRequestDTO getCardAmountRequest(Integer amount) {
        return new CardAmountChangeRequestDTO(amount);
    }

    protected String getCustomerUrlById(Long id) {
        return CUSTOMER_URL + "/" + id;
    }

}
