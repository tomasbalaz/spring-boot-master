package sk.balaz.springbootmaster.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    //intellij program arguments --app.useCustomerRepo=false
    @Value("${app.useCustomerRepo:false}")
    private Boolean useCustomerRepo;

   @Bean
    CommandLineRunner commandLineRunner() {
        return  args -> System.out.println("Command line runner");
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useCustomerRepo = " + useCustomerRepo);
        return useCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }
}
