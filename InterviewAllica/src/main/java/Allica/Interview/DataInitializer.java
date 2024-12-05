package Allica.Interview;

import Allica.Interview.Entity.Customer;
import Allica.Interview.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        customerRepository.save(new Customer("John", "Doe", LocalDate.of(1985, 5, 15)));
        customerRepository.save(new Customer("Jane", "Smith", LocalDate.of(1990, 8, 22)));
        customerRepository.save(new Customer("Michael", "Johnson", LocalDate.of(1982, 11, 30)));
        customerRepository.save(new Customer("Emily", "Williams", LocalDate.of(1993, 4, 12)));
        customerRepository.save(new Customer("James", "Brown", LocalDate.of(1979, 1, 24)));
        customerRepository.save(new Customer("Olivia", "Jones", LocalDate.of(2000, 3, 5)));
        customerRepository.save(new Customer("David", "Garcia", LocalDate.of(1995, 12, 1)));
        customerRepository.save(new Customer("Sophia", "Martinez", LocalDate.of(1987, 6, 18)));
        customerRepository.save(new Customer("William", "Davis", LocalDate.of(1992, 9, 28)));
        customerRepository.save(new Customer("Isabella", "Rodriguez", LocalDate.of(1998, 7, 10)));
        customerRepository.save(new Customer("Alice", "Walker", LocalDate.of(1910, 1, 1)));
        customerRepository.save(new Customer("Old", "Man", LocalDate.of(1900, 5, 5)));
    }
}

