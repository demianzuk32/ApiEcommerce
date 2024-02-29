package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,Long> {
}
