package sk.balaz.springbootmaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import sk.balaz.springbootmaster.infoapp.InfoApp;

import java.util.Arrays;

@Configuration
public class CustomerConfig {

    //intellij program arguments --app.useCustomerRepo=false
    @Value("${app.useCustomerRepo:false}")
    private Boolean useCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {

            System.out.println("Command line runner");

            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(Arrays.toString(environment.getActiveProfiles()));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useCustomerRepo = " + useCustomerRepo);
        return new CustomerFakeRepository();
    }
}
