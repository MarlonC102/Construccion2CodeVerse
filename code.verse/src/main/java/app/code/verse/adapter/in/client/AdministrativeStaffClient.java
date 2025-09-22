package app.code.verse.adapter.in.client;

import app.code.verse.adapter.in.builder.PatientBuilder;
import app.code.verse.application.usecases.AdministrativeStaffUseCase;
import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.enums.Gender;
import app.code.verse.domain.model.enums.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.util.Scanner;

@Controller
public class AdministrativeStaffClient {

    @Autowired
    private AdministrativeStaffUseCase staffUseCase;
    @Autowired
    private PatientBuilder patientBuilder;
    Patient patient;
    Scanner reader = new Scanner(System.in);
    private static final String HEADER = "| %-20s | %-20s | %-20s | %-20s |%n";
    private static final String ROW_FORMAT = "| %-20s | %-20s | %-20s | %-20s |%n";
    private static final String MENU = "Ingrese una opción:\n" +
            "1. Registrar paciente.\n" +
            "2. Mostar todos los pacientes,\n" +
            "3. Buscar paciente por número de documento.\n" +
            "4. Buscar paciente por nombre de usuario.\n" +
            "5. Actualizar paciente.\n" +
            "6. Eliminar paciente.";

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

        String idNumber;
        switch (op) {
            case "1":
                patient = registerPatientInformation();
                staffUseCase.create(patient);
                return true;
            case "2":

                return true;
            case "3":
                System.out.println("Ingrese el número de documento del paciente");
                idNumber = reader.nextLine();

                return true;
            case "4":
                System.out.println("Ingrese el nombre de usuario del paciente");
                String userName = reader.nextLine();

                return true;
            case "5":
                System.out.println("Ingrese el número de documento del paciente que desea actualizar");
                idNumber = reader.nextLine();


                return true;
            case "6":
                System.out.println("Ingrese el número de documento del paciente que desea eliminar");
                idNumber = reader.nextLine();


                return true;

            default:
                return true;
        }
    }

    private Patient registerPatientInformation() throws Exception {
        String name, idNumber, email, phoneNumber, address, gender;
        LocalDate birthDate;
        System.out.println("Ingrese el nombre del paciente.");
        name = reader.nextLine();
        System.out.println("Ingrese el número de documento del paciente.");
        idNumber = reader.nextLine();
        System.out.println("Ingrese el correo electrónico del paciente.");
        email = reader.nextLine();
        System.out.println("Ingrese el número de telefono del paciente.");
        phoneNumber = reader.nextLine();
        System.out.println("Seleccione el género del paciente");
        gender = selectGender();
        System.out.println("Ingrese la fecha de nacimiento del paciente. (Formato: yyyy-MM-dd))");
        birthDate = LocalDate.parse(reader.nextLine());
        System.out.println("Ingrese la dirección del paciente.");
        address = reader.nextLine();
        return patientBuilder.build(idNumber, name, birthDate, gender, address, phoneNumber, email);
    }

    private String selectGender() {
        System.out.println("1. Femenino\n2. Masculino\n3. Otro");
        String op = reader.nextLine();
        String rol = "";
        switch (op) {
            case "1":
                rol = Gender.FEMALE.gender();
                break;
            case "2":
                rol = Gender.MALE.gender();
                break;
            case "3":
                System.out.println("Ingrese el género");
                rol = reader.nextLine();
                //rol = Gender.OTHER.gender();
                break;
            case "4":
                rol = Rol.ADMINISTRATIVE_STAFF.getRol();
                break;
            case "5":
                rol = Rol.INFORMATION_SUPPORT.getRol();
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        return rol;
    }


}
