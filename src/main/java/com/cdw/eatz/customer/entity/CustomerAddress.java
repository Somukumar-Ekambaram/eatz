package com.cdw.eatz.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * A Hibernate Entity class that contains columns of customer_address table
 *
 * @author somukumar.ekambaram
 * @version 0.0.1-SNAPSHOT
 * @since May 2023
 */
@Entity
@Table(name = "customer_address", schema = "eatz_app")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_address_id")
    private Long customerAddressId;

    @Column(name = "door_number")
    private String doorNumber;

    @Column(name = "address_line_one")
    private String addressLineOne;

    @Column(name = "address_line_two")
    private String addressLineTwo;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zipcode", columnDefinition = "BIGINT(6)")
    private Long zipcode;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
