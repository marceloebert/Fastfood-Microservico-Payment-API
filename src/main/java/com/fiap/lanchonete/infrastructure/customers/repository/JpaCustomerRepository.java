package com.fiap.lanchonete.infrastructure.customers.repository;

import com.fiap.lanchonete.infrastructure.customers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.document = :document")
    Optional<CustomerEntity> findCustomerByDocument(@Param("document") String document);
}
