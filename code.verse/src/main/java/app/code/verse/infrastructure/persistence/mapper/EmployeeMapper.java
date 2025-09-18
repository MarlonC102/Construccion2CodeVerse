package app.code.verse.infrastructure.persistence.mapper;

import app.code.verse.domain.model.Employee;
import app.code.verse.infrastructure.persistence.entities.EmployeeEntity;

public class EmployeeMapper{

    public static EmployeeEntity toEntity(Employee employee) {
        if (employee == null) return null;
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(null);
        entity.setName(employee.getName());
        entity.setIdNumber(employee.getIdNumber());
        entity.setEmail(employee.getEmail());
        entity.setPhoneNumber(employee.getPhoneNumber());
        entity.setBirthDate(employee.getBirthDate());
        entity.setAddress(employee.getAddress());
        entity.setRol(employee.getRole());
        entity.setPassword(employee.getPassword());
        entity.setUserName(employee.getUserName());
        return entity;
    }

    public static Employee toDomain(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) return null;
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setName(employeeEntity.getName());
        employee.setIdNumber(employeeEntity.getIdNumber());
        employee.setEmail(employeeEntity.getEmail());
        employee.setPhoneNumber(employeeEntity.getPhoneNumber());
        employee.setBirthDate(employeeEntity.getBirthDate());
        employee.setAddress(employeeEntity.getAddress());
        employee.setRole(employeeEntity.getRol());
        employee.setPassword(employeeEntity.getPassword());
        employee.setUserName(employeeEntity.getUserName());
        return employee;
    }

    public static void partialUpdate(Employee source, EmployeeEntity employee) {
        if (source.getName() != null) employee.setName(source.getName());
        if (source.getEmail() != null) employee.setEmail(source.getEmail());
        if (source.getPhoneNumber() != null) employee.setPhoneNumber(source.getPhoneNumber());
        if (source.getBirthDate() != null) employee.setBirthDate(source.getBirthDate());
        if (source.getAddress() != null) employee.setAddress(source.getAddress());
        if (source.getRole() != null) employee.setRol(source.getRole());
        if (source.getUserName() != null) employee.setUserName(source.getUserName());
        if (source.getPassword() != null) employee.setPassword(source.getPassword());
    }


}

