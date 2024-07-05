package org.example.ecommerce.repository;

import org.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE " +
    "LOWER(p.name) LIKE LOWER(CONCAT('%', ':keyword', '%'))")
    public List<Product> searchProducts(String keyword);

}
