package app.code.verse.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PolicyValidator extends SimpleValidator {

    public String policyNameValidator(String value) throws Exception {
        return stringValidator(value, "Nombre");
    }

    public String policyNumberValidator(String value) throws Exception {
        return stringValidator(value, "Número de póliza");
    }

    public LocalDate policyDateValidator(LocalDate value) throws Exception {
        return localDateValidator(value, "fecha de póliza");
    }

}