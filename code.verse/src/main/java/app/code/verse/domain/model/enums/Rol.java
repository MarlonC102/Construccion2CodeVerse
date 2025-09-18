package app.code.verse.domain.model.enums;

public enum Rol {
    HR("Recursos Humanos"),
    ADMINISTRATIVE_STAFF("Personal Administrativo"),
    INFORMATION_SUPPORT("Soporte"),
    NURSE("Enfermera"),
    DOCTOR("Doctor");

    private final String rol;

    Rol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static Rol fromDescription(String rolSearch) {
        for (Rol role : Rol.values()) {
            if (role.rol.equalsIgnoreCase(rolSearch)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Rol no encontrado: " + rolSearch);
    }
}