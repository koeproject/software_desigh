package com.cp.lab08sec1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.lab08sec1.demo.model.Customer;
import com.cp.lab08sec1.demo.repositories.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
  @Autowired
  CustomerService customerService;
  @GetMapping
  public ResponseEntity<List<Customer>> getCustomers(){
          List<Customer> customers = customerService.getCustomers();
          return new ResponseEntity<>(customers, HttpStatus.OK);
  }

  @GetMapping("/{id}")  //http://localhost:8085/api/customers/1
  public ResponseEntity<Customer> getCustomerById(@PathVariable("id")
  Long Id){
          Customer customer = customerService.getCustomerById(Id);
          return new ResponseEntity<>(customer,HttpStatus.OK);
  }
  //Post to add a new customer  http://localhost:8085/api/customers/?customer=
  @PostMapping
  public Customer addNewCustomer(@RequestBody Customer customer) {
          System.out.println(customer);

          Customer savedCustomer = customerService.addCustomer(customer);
          return savedCustomer;
  }

  @PutMapping("/{id}") //update http://localhost:8085/api/customers/1?customer=
  ResponseEntity<Customer> updateCustomer(@RequestBody Customer newCustomer,
                  @PathVariable Long id) {

     Customer updateCustomer = customerService.updateCustomer(id, newCustomer);
     return ResponseEntity.ok(updateCustomer);
  }

  @DeleteMapping("/{id}") // http://localhost:8085/api/customers/1
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
