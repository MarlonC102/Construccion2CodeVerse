package app.code.verse;

import app.code.verse.adapter.in.client.AdministrativeStaffClient;
import app.code.verse.adapter.in.client.HumanResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private HumanResourceClient humanResourceClient;
    @Autowired
    private AdministrativeStaffClient staffClient;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //humanResourceClient.session();
        staffClient.session();
    }


}
