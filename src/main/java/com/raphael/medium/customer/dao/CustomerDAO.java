package com.raphael.medium.customer.dao;

import com.raphael.medium.customer.dao.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends CrudRepository<CustomerEntity, Long> {
}
