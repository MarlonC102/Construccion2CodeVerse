package app.code.verse.domain.model.enums;

public enum Role {
    HR("Human Resources"),
    ADMINISTRATIVE_STAFF("Administrative Staff"),
    INFORMATION_SUPPORT("Information Support"),
    NURSE("Nurse"),
    DOCTOR("Doctor");

    private final String rol;

    Role(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}