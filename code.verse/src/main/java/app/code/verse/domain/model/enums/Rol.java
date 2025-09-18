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

    public static Role fromDescription(String rolSearch) {
        for (Role role : Role.values()) {
            if (role.rol.equalsIgnoreCase(rolSearch)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Rol no encontrado: " + rolSearch);
    }
}