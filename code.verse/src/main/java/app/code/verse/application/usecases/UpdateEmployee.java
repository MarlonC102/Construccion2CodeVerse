package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.ports.PersonPort;

public class UpdateEmployee {
    private EmployeePort employeePort;
    private FindEmployee findEmployee;
    private PersonPort personPort;

    public void update(Employee employee) throws Exception {
        if (findEmployee.existsById(employee)){
            ValidateDataUtil.validateString(employee.getName(), "El nombre del empleado no puede estar vacío");
            ValidateDataUtil.validateString(employee.getEmail(), "El correo electrónico no puede estar vacío");
            ValidateDataUtil.validateEmail(employee.getEmail(),"Ingrese un correo electrónico con un formato válido");
            ValidateDataUtil.validateString(employee.getAddress(), "La dirección no puede estar vacía");
            ValidateDataUtil.validateString(employee.getUserName(), "El nombre de usuario estar vacío");
            ValidateDataUtil.validateMaximumSize(employee.getUserName(),"nombre de usuario",15);
            ValidateDataUtil.validateString(employee.getPassword(), "La contraseña no puede estar vacía");
            ValidateDataUtil.validateMaximumSize(employee.getPassword(),"contraseña",8);
            ValidateDataUtil.validateString(employee.getRole(), "El rol no puede estar vacío");
            ValidateDataUtil.validateLocalDate(employee.getBirthDate(), "La fecha de nacimiento  no puede estar vacía");
            ValidateDataUtil.validateMaximumSize(employee.getEmail(), "correo electrónico", 50);
            ValidateDataUtil.validateMaximumSize(employee.getAddress(), "dirección", 30);
            ValidateDataUtil.validateMaximumSize(employee.getPhoneNumber(), "número de teléfono", 10);
            ValidateDataUtil.validateMinimumSize(employee.getPhoneNumber(), "número de teléfono", 1);
            if (personPort.existsByUserName(employee.getUserName()) && !findEmployee.existsById(employee)) {
                throw new Exception("Ese nombre de usuario ya está en uso por otro empleado");
            }
            employeePort.update(employee);
        }


    }
}
