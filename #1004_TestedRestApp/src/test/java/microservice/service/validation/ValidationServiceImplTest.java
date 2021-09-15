package microservice.service.validation;


import microservice.entity.enums.ValidationRule;
import microservice.service.validation.pojo.WrongInputFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ValidationServiceImplTest {

    @InjectMocks
    ValidationServiceImpl validationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validateFieldIsCorrectTest() throws Exception {
        validationService.validateFieldIsCorrect("05/24", ValidationRule.CARD_EXPIRATION_DATE);
        validationService.validateFieldIsCorrect("email@example.com", ValidationRule.CUSTOMER_EMAIL);
    }

    @Test
    void validateFieldIsIncorrectTest() {
        assertValidationExceptionThrown("99/99", ValidationRule.CARD_EXPIRATION_DATE);
        assertValidationExceptionThrown("wrongEmail", ValidationRule.CUSTOMER_EMAIL);
        assertValidationExceptionThrown("gmail.com", ValidationRule.CUSTOMER_EMAIL);
        assertValidationExceptionThrown("@gmail.com", ValidationRule.CUSTOMER_EMAIL);

    }

    private void assertValidationExceptionThrown(String message, ValidationRule rule) {
        Assertions.assertThrows(WrongInputFormatException.class, () -> {
            validationService.validateFieldIsCorrect(message, rule);
        });
    }

}