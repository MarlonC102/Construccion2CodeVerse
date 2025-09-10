package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;

public class DeleteEmployee {
    private EmployeePort employeePort;
    private FindEmployee findEmployee;

    public void delete(Employee employee) throws Exception {
        ValidateDataUtil.validateString(employee.getIdNumber(), "EL número de identificación no puede estar vacío");
        if (findEmployee.existsById(employee)){
            employeePort.delete(employee);
        }


    }
}
