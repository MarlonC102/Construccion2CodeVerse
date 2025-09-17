package app.code.verse.adapter.in.client;

import app.code.verse.adapter.in.builder.EmployeeBuilder;
import app.code.verse.application.usecases.HumanResourcesUseCase;
import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Controller
public class HumanResourceClient {
    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
    @Autowired
    private EmployeeBuilder employeeBuilder;
    Scanner reader = new Scanner(System.in);
    private static final String HEADER = "| %-15s | %-15s | %-15s | %-15s |%n";
    private static final String ROW_FORMAT = "| %-15s | %-15s | %-15s | %-15s |%n";
    private static final String MENU = "Ingrese una opción:\n" + "1. Registrar un empleado.\n" + "2. Mostar todos los empleados,\n" + "3. Buscar empleado por número de documento.\n" + "4. Buscar empleado por nombre de usuario.\n5. Actualizar empleado.\n6. Eliminar empleado.";

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println();
            return true;
        }
    }

    private boolean options(String op) throws Exception {
        switch (op) {
            case "1":
                Employee employee = registerEmployeeInformation();
                humanResourcesUseCase.create(employee);
                return true;
            case "2":
                getAllEmployee();
                return true;
            case "3":
                System.out.println("Ingrese el número de documento del empleado");
                String id = reader.nextLine();
                getEmployeeById(id);
                return true;
            case "4":
                System.out.println("Ingrese el nombre de usuario del empleado");
                String userName = reader.nextLine();
                getEmployeeByUserName(userName);
            default:
                return true;
        }
    }

    private Employee registerEmployeeInformation() throws Exception {
        String name, idNumber, email, phoneNumber, addres, rol, userName, passwoord;
        LocalDate birthDate;
        System.out.println("Ingrese el nombre del empleado.");
        name = reader.nextLine();
        System.out.println("Ingrese el número de documento del empleado.");
        idNumber = reader.nextLine();
        System.out.println("Ingrese el correo electrónico del empleado.");
        email = reader.nextLine();
        System.out.println("Ingrese el número de telefono del empleado.");
        phoneNumber = reader.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del empleado. (Formato: yyyy-MM-dd))");
        birthDate = LocalDate.parse(reader.nextLine());
        System.out.println("Ingrese la dirección del empleado.");
        addres = reader.nextLine();
        System.out.println("Seleccione el rol del empleado");
        rol = selectRol();
        System.out.println("Ingrese el nombre de usuario del empleado.");
        userName = reader.nextLine();
        System.out.println("Ingrese la contraseña del empleado.");
        passwoord = reader.nextLine();
        return employeeBuilder.build(name, idNumber, email, phoneNumber, birthDate, addres, rol, userName, passwoord);
    }

    private String selectRol() {
        System.out.println("1. Recursos humanos\n2. Enfermera\n3. Médico\n4. Personal Administrativoo\n5. Personal de soporte");
        String op = reader.nextLine();
        String rol = "";
        switch (op) {
            case "1":
                rol = Role.HR.getRol();
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        return rol;
    }

    private void getAllEmployee() {
        System.out.println("Lista de todos los empleados");
        List<Employee> employees = humanResourcesUseCase.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.printf(HEADER, "Documento", "Nombre", "Cargo", "Usuario");
            employees.forEach(emp -> System.out.printf(ROW_FORMAT, emp.getIdNumber(), emp.getName(), emp.getRole(), emp.getUserName()));
        }
    }

    private void getEmployeeById(String idEmployee) {
        System.out.println("Lista de todos los empleados");
        Employee employee = humanResourcesUseCase.findById(idEmployee);
        if (employee == null) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.printf(HEADER, "Documento", "Nombre", "Cargo", "Usuario");
            System.out.printf(ROW_FORMAT, employee.getIdNumber(), employee.getName(), employee.getRole(), employee.getUserName());
        }
    }

    private void getEmployeeByUserName(String userName) {
        System.out.println("Lista de todos los empleados");
        Employee employee = humanResourcesUseCase.findByUserName(userName);
        if (employee == null) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.printf(HEADER, "Documento", "Nombre", "Cargo", "Usuario");
            System.out.printf(ROW_FORMAT, employee.getIdNumber(), employee.getName(), employee.getRole(), employee.getUserName());
        }
    }
}
