package app.code.verse.domain.model.enums;

public enum PersonType {
    PATIENT("Patient"),
    EMPLOYEE("Employee");

    private final String personType;

    PersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }
}
