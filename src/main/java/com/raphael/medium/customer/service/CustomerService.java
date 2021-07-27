package com.raphael.medium.customer.service;

import com.raphael.medium.customer.dao.CustomerDAO;
import com.raphael.medium.customer.dao.entity.CustomerEntity;
import com.raphael.medium.customer.dao.mapper.CustomerEntityMapper;
import com.raphael.medium.customer.service.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public Customer saveCustomer(Customer customer) {
        return persistCustomer(customer);
    }

    private Customer persistCustomer(Customer customer) {
        CustomerEntity customerEntity = CustomerEntityMapper.INSTANCE.customerToCustomerEntity(customer);
        CustomerEntity storedEntity = customerDAO.save(customerEntity);
        Customer returnCustomer = CustomerEntityMapper.INSTANCE.customerEntityToCustomer(storedEntity);
        return returnCustomer;
    }

}
