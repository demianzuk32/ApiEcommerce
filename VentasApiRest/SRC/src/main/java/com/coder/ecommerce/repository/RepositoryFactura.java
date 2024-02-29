package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryFactura extends JpaRepository<Factura, Long> {

}
