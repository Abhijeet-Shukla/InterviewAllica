package Allica.Interview.Controller;

import Allica.Interview.Entity.Customer;
import Allica.Interview.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer;

        try{
           savedCustomer = customerService.saveCustomer(customer);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> getCustomersByName(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        List<Customer> customers;

        if (firstName != null && lastName != null) {
            customers = customerService.getCustomersByName(firstName, lastName);
        } else {
            customers = customerService.getCustomersByFirstOrLastName(firstName, lastName);
        }

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

}
