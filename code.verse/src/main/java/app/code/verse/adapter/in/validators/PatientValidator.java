package app.code.verse.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class PatientValidator extends SimpleValidator {
    public String genderValidator(String value) throws Exception {
        return stringValidator(value, "género");
    }
}
