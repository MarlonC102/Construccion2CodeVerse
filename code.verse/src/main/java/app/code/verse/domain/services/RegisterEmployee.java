package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.ports.PersonPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterEmployee {

    @Autowired
    private EmployeePort employeePort;
    @Autowired
    private PersonPort personPort;

    public void create(Employee employee) throws Exception {
        //checkIfEmployeeExists(employee);
        employeePort.create(employee);
    }

    private void checkIfEmployeeExists(Employee employee) throws Exception {
        if (personPort.existsByIdNumber(employee.getIdNumber())) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        if (employeePort.findByUserName(employee.getUserName()) != null) {
            throw new Exception("Ese nombre de usuario ya está en uso");
        }
    }
}