package com.raphael.medium.customer.controller;

import com.raphael.medium.customer.controller.dto.CustomerDTO;
import com.raphael.medium.customer.controller.mapper.CustomerDTOMapper;
import com.raphael.medium.customer.service.CustomerService;
import com.raphael.medium.customer.service.model.Customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> saveCustomer(
            @RequestBody @Valid CustomerDTO customerDTO) throws URISyntaxException {
        System.out.println("test endpoint");
        Customer customer = CustomerDTOMapper.INSTANCE.customerDTOToCustomer(customerDTO);

        Customer savedCustomer = customerService.saveCustomer(customer);

        CustomerDTO savedCustomerDTO = CustomerDTOMapper.INSTANCE.customerToCustomerDTO(savedCustomer);
        return new ResponseEntity<CustomerDTO>(savedCustomerDTO, HttpStatus.CREATED);
    }
}