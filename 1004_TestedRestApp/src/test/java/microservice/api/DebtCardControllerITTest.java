package microservice.api;

import microservice.IntegrationTestHelper;
import microservice.dto.customer.CustomerDTO;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DebtCardControllerITTest extends IntegrationTestHelper {

    @Test
    void createCardItTest() {
        Long customerId = 4L;
        String url = CARD_URL + "/create/" + customerId;
        given()
                .contentType("application/json")
                .body(getCardRequest())
                .when()
                .put(url);
        CustomerDTO customer = get(getCustomerUrlById(customerId))
                .then()
                .statusCode(200)
                .extract()
                .as(CustomerDTO.class);

        assertNotNull(customer);
        assertFalse(customer.getCardList().isEmpty());
    }

    @Test
    void editCardItTest() {
        String url = CARD_URL + "/1";
        int amount = 666;
        given()
                .contentType("application/json")
                .body(getCardAmountRequest(amount))
                .when()
                .post(url);
        CustomerDTO customer = get(getCustomerUrlById(1L))
                .then()
                .statusCode(200)
                .extract()
                .as(CustomerDTO.class);
        assertNotNull(customer);
        assertFalse(customer.getCardList().isEmpty());
        assertEquals(amount, customer.getCardList().get(0).getAmount());

    }

    @Test
    void deleteCardItTest() {
        String url = CARD_URL + "/3/delete";
        delete(url);
        CustomerDTO customer = get(getCustomerUrlById(3L))
                .then()
                .statusCode(200)
                .extract()
                .as(CustomerDTO.class);

        assertNotNull(customer);
        assertTrue(customer.getCardList().isEmpty());
    }
}