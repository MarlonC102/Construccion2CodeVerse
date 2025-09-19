package app.code.verse.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator extends SimpleValidator{
    public String userNameValidator(String value) throws Exception {
        maximumSizeValidator(value, "nombre de usuario", 15);
        return stringValidator(value, "nombre de usuario");
    }

    public String passwordValidator(String value) throws Exception {
        minimumSizeValidator(value, "contraseña", 8);
        if (!value.matches(".*[A-Z].*") || !value.matches(".*\\d.*") || !value.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException(
                    "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial");
        }
        return stringValidator(value, "contraseña");
    }

    public String roleValidator(String value) throws Exception {
        return stringValidator(value, "rol");
    }
}
