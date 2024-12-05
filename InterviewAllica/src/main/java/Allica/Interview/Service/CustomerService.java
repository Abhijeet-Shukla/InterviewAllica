package Allica.Interview.Service;

import Allica.Interview.Entity.Customer;
import Allica.Interview.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Pattern SPECIAL_CHARACTERS_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    public Customer saveCustomer(Customer customer){
        if (null == customer.getFirstName() || customer.getFirstName().isEmpty() || containsSpecialCharacters(customer.getFirstName())) {
            throw new IllegalArgumentException("First Name cannot be empty or contain special characters.");
        }

        if (null != customer.getLastName() && containsSpecialCharacters(customer.getLastName())) {
            throw new IllegalArgumentException("Last Name cannot contain special characters.");
        }

        if (null == customer.getDateOfBirth() || !customer.getDateOfBirth().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date of Birth must be in the past.");
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getCustomersByFirstOrLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<Customer> getCustomersByName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    private boolean containsSpecialCharacters(String str) {
        Matcher matcher = SPECIAL_CHARACTERS_PATTERN.matcher(str);
        return matcher.find();
    }

}
