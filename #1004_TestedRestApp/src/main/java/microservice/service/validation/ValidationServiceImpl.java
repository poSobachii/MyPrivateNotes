package microservice.service.validation;

import microservice.entity.enums.ValidationRule;
import microservice.service.validation.pojo.WrongInputFormatException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validateFieldIsCorrect(String field, ValidationRule rule) throws Exception {
        Pattern pattern = Pattern.compile(rule.getRegex());
        Matcher matcher = pattern.matcher(field);
        if(!matcher.matches()){
            throw new WrongInputFormatException(rule.getMessage());
        }
    }
}
