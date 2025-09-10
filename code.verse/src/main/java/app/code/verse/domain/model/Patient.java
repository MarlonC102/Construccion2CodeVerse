package app.code.verse.domain.model;

public class Patient extends Person {
    private String gender;

    public Patient() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}