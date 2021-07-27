package com.raphael.medium.customer.dao.mapper;

import com.raphael.medium.customer.dao.entity.CustomerEntity;
import com.raphael.medium.customer.service.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerEntityMapper {
    CustomerEntityMapper INSTANCE =
            Mappers.getMapper(CustomerEntityMapper.class);

    CustomerEntity customerToCustomerEntity(Customer customer);

    Customer customerEntityToCustomer(CustomerEntity customerEntity);
}
