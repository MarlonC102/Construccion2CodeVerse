package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.ports.PersonPort;


public class FindEmployee {
    private EmployeePort employeePort;
    private PersonPort personPort;
    public boolean existsById(Employee employee) {
        ValidateDataUtil.validateString(employee.getIdNumber(), "El número de identificación no puede ser nulo o vacío");
        return personPort.existsByIdNumber(employee.getIdNumber());
    }

    public Employee findById(String idNumber) {
        ValidateDataUtil.validateString(idNumber,
                "El número de identificación no puede ser nulo o vacío");
        Employee employee = employeePort.findByIdNumber(idNumber);
        if (employee == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        return employee;
    }

}
