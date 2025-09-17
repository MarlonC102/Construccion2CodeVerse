package app.code.verse.domain.ports;

import app.code.verse.domain.model.Employee;

import java.util.List;

public interface EmployeePort extends PersonPort{
    Employee create(Employee employee) throws Exception;
    void delete(Employee employee) throws Exception;
    void update(Employee employee) throws Exception;
    Employee findByIdNumber(String idNumber);
    Employee findByUserName(String userName);
    List<Employee> findAll();

}
