package com.cdw.eatz.customer.repository;

import com.cdw.eatz.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * CustomerRepository.java
 * A Spring Repository interface that extends JpaRepository
 *
 * @author somukumar.ekambaram
 * @since May 2023
 * @version 0.0.1-SNAPSHOT
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Boolean existsByEmailIgnoreCaseOrPhoneNumber(String email, Long phoneNumber);

    Customer findOneByEmailIgnoreCaseAndPassword(String email, String password);
}
