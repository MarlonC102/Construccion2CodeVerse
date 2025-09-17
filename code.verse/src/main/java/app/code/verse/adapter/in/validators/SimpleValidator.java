package app.code.verse.adapter.in.validators;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class SimpleValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public String stringValidator(String value, String fieldName) throws Exception {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " no puede ser nulo o vacío");
        }
        return value;
    }

    public LocalDate localDateValidator(LocalDate localDate, String fieldName) {
        if (localDate == null) {
            throw new IllegalArgumentException(fieldName + " no puede ser nula o vacía");
        }

        if (localDate.isBefore(LocalDate.now().minusYears(150)) || localDate.isAfter(LocalDate.now().plusYears(150))) {
            throw new IllegalArgumentException("La fecha no puede ser mayor o menor a 150 años");
        }

        if (localDate.isBefore(LocalDate.now()) && fieldName.contains("póliza")) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
        return localDate;
    }

    public void maximumSizeValidator(String field, String fieldName, int maxSize) {
        if (field.length() > maxSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener más de " + maxSize + " caracteres");
        }
    }

    public void minimumSizeValidator(String field, String fieldName, int minSize) {
        if (field.length() < minSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener menos de " + minSize + " caracter");
        }
    }

    public void emailFormatValidator(String email) {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("El correo electrónico debe tener un formato válido");
        }
    }

    public static void phoneSizeValidator(String phone){
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El número de teléfono debe tener 10 dígitos");
        }
    }

}