package microservice.api;

import microservice.IntegrationTestHelper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.not;


class CustomerControllerITTest extends IntegrationTestHelper {

    private final Long CUSTOMER_ID = 1L;

    @Test
    void getAllCustomerItTest() {
        get(CUSTOMER_URL)
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", hasItem("Steve"));
    }

    @Test
    void getCustomerByIdItTest() {
        get(getCustomerUrlById(CUSTOMER_ID))
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Steve"));
    }

    @Test
    void createCustomerItTest() {
        String url = CUSTOMER_URL + "/create";
        given()
                .contentType("application/json")
                .body(getCustomerRequest())
                .when()
                .put(url);
        get(CUSTOMER_URL)
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", hasItem("Jhon"));

    }

    @Test
    void createIncorrectCustomerItTest() {
        String url = CUSTOMER_URL + "/create";
        given()
                .contentType("application/json")
                .body(getCustomerWithWrongEmailRequest())
                .when()
                .put(url)
                .then()
                .statusCode(500);
    }

    @Test
    void createEmptyValueCustomerItTest() {
        String url = CUSTOMER_URL + "/create";
        given()
                .contentType("application/json")
                .body(getCustomerWithEmptyFieldRequest())
                .when()
                .put(url)
                .then()
                .statusCode(500);
    }

    @Test
    void editCustomerItTest() {
        String url = CUSTOMER_URL + "/" + CUSTOMER_ID;
        given()
                .contentType("application/json")
                .body(getCustomerRequest())
                .when()
                .post(url);

        get(getCustomerUrlById(CUSTOMER_ID))
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Jhon"));
    }

    @Test
    void deleteCustomerItTest() {
        String url = CUSTOMER_URL + "/2/delete";
        delete(url);
        get(CUSTOMER_URL)
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", not(hasItem("James")));
    }
}