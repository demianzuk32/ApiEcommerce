package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}
