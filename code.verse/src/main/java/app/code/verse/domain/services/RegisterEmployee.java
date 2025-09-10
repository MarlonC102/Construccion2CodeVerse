package app.code.verse.domain.services;

import app.code.verse.application.usecases.FindEmployee;
import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.ports.PersonPort;

public class RegisterEmployee {
    private EmployeePort employeePort;
    private PersonPort personPort;
    private FindEmployee findEmployee;

    public void create(Employee employee) throws Exception {
        ValidateDataUtil.validateString(employee.getName(), "El nombre del empleado no puede estar vacío");
        ValidateDataUtil.validateString(employee.getIdNumber(), "EL número de identificación no puede estar vacío");
        ValidateDataUtil.validateString(employee.getEmail(), "El correo electrónico no puede estar vacío");
        ValidateDataUtil.validateEmail(employee.getEmail(),"Ingrese un correo electrónico con un formato válido");
        ValidateDataUtil.validateString(employee.getAddress(), "La dirección no puede estar vacía");
        ValidateDataUtil.validateString(employee.getUserName(), "El nombre de usuario no puede estar vacío");
        ValidateDataUtil.validateMaximumSize(employee.getUserName(),"nombre de usuario",15);
        ValidateDataUtil.validateString(employee.getPassword(), "La contraseña no puede estar vacía");
        ValidateDataUtil.validateMaximumSize(employee.getPassword(),"contraseña",8);
        ValidateDataUtil.validateString(employee.getRole(), "El rol no puede ser estar vacío");
        ValidateDataUtil.validateLocalDate(employee.getBirthDate(), "La fecha de nacimiento  no puede estar vacía");
        ValidateDataUtil.validateMaximumSize(employee.getEmail(), "correo electrónico", 50);
        ValidateDataUtil.validateMaximumSize(employee.getAddress(), "dirección", 30);
        ValidateDataUtil.validateMaximumSize(employee.getPhoneNumber(), "número de teléfono", 10);
        ValidateDataUtil.validateMinimumSize(employee.getPhoneNumber(), "número de teléfono", 1);
        if (findEmployee.existsById(employee)) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        if (personPort.existsByUserName(employee.getUserName())) {
            throw new Exception("Ese nombre de usuario ya está en uso");
        }
        employeePort.save(employee);
    }
}