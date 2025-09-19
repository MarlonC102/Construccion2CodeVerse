package app.code.verse.adapter.in.builder;

import app.code.verse.adapter.in.validators.EmployeeValidator;
import app.code.verse.adapter.in.validators.PersonValidator;
import app.code.verse.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeBuilder {

    @Autowired
    private EmployeeValidator employeeValidator;
    @Autowired
    private PersonValidator personValidator;

    public Employee build(String name, String idNumber, String email, String phoneNumber, LocalDate birthDate, String addres, String rol, String userName, String passwoord) throws Exception {
        Employee employee = new Employee();
        employee.setName(personValidator.nameValidator(name));
        employee.setIdNumber(personValidator.idNumberValidator(idNumber));
        employee.setEmail(personValidator.emailValidator(email));
        employee.setPhoneNumber(personValidator.phoneNumberValidator(phoneNumber));
        employee.setBirthDate(personValidator.birthDateValidator(birthDate));
        employee.setAddress(personValidator.addressValidator(addres));
        employee.setRole(employeeValidator.roleValidator(rol));
        employee.setUserName(employeeValidator.userNameValidator(userName));
        employee.setPassword(employeeValidator.passwordValidator(passwoord));
        return employee;
    }

    public Employee update(Employee employee, String name, String email, String phoneNumber, LocalDate birthDate, String addres, String rol, String userName, String passwoord) throws Exception {
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setBirthDate(birthDate);
        employee.setAddress(addres);
        employee.setRole(rol);
        employee.setUserName(userName);
        employee.setPassword(passwoord);
        return employee;
    }
}
