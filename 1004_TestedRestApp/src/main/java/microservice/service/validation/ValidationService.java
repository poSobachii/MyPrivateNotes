package microservice.service.validation;

import microservice.entity.enums.ValidationRule;

public interface ValidationService {

    void validateFieldIsCorrect(String field, ValidationRule rule) throws Exception;

}
