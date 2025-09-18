package app.code.verse.domain.model.enums;

public enum Gender {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String gender() {
        return gender;
    }
}
