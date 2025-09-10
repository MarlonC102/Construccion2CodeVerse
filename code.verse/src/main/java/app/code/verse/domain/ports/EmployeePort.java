package app.code.verse.domain.ports;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.Patient;

import java.util.Optional;

public interface EmployeePort {
    void save(Employee employee) throws Exception;
    void delete(Employee employee) throws Exception;
    void update(Employee employee) throws Exception;
    Employee findByIdNumber(String idNumber);

}
