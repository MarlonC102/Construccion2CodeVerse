package app.code.verse.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends PersonEntity{

    @Column(nullable = false)
    private String role;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;


    public String getRol() {
        return role;
    }

    public void setRol(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
