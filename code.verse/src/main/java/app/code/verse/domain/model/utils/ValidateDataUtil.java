package app.code.verse.domain.model.utils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateDataUtil {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static void validateString(String field, String message) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateLocalDate(LocalDate localDate, String message) {
        if (localDate == null) {
            throw new IllegalArgumentException(message);
        }

        if (localDate.isBefore(LocalDate.now().minusYears(150)) || localDate.isBefore(LocalDate.now().plusYears(150))) {
            throw new IllegalArgumentException("La fecha no puede ser mayor o menor a 150 años");
        }

        if (localDate.isAfter(LocalDate.now()) && !message.contains("póliza")) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
    }

    public static void validateMaximumSize(String field, String fieldName, int maxSize) {
        if (field.length() > maxSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener más de " + maxSize + " caracteres");
        }
    }

    public static void validateMinimumSize(String field, String fieldName, int minSize) {
        if (field.length() < minSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener menos de " + minSize + " caracter");
        }
    }

    public static void validateEmail(String email, String message) {
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validatePhoneSize(String phone){
        if (phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El número de teléfono debe tener 10 dígitos");
        }
    }
}

