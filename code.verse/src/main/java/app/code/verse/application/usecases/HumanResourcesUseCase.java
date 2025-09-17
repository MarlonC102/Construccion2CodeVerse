package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.services.RegisterEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanResourcesUseCase {
    @Autowired
    private RegisterEmployee registerEmployee;
    @Autowired
    private EmployeePort employeePort;

    public void create(Employee employee) throws Exception {
        Employee employeeById = findById(employee.getIdNumber());
        Employee employeeByUserName = findByUserName(employee.getUserName());
        if (employeeByUserName != null){
            throw new Exception("Ese nombre de usuario ya está en uso por otro empleado");
        }
        if (employeeById != null){
            throw new Exception("Este empleado ya está registrado");
        }
        registerEmployee.create(employee);
    }

    public void update(Employee employee) throws Exception {
        Employee employeeData = findById(employee.getIdNumber());
        if (employeeData != null && !employeeData.getIdNumber().equals(employee.getIdNumber())) {
            throw new Exception("Ese nombre de usuario ya está en uso por otro empleado");
        }
        employeePort.update(employee);
    }

    public void delete(Employee employee) throws Exception {
        if (employeePort.findByIdNumber(employee.getIdNumber()) != null) {
            employeePort.delete(employee);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeePort.findAll();
    }

    public Employee findById(String idNumber) {
        Employee employee = employeePort.findByIdNumber(idNumber);
        if (employee == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        return employee;
    }

    public Employee findByUserName(String userName){
        Employee employee = employeePort.findByUserName(userName);
        if (employee == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        return employee;
    }
}