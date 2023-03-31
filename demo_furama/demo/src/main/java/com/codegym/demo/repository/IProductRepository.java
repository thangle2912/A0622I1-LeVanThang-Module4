package com.codegym.demo.repository;


import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findProductByNameContaining(String name, Pageable pageable);
    Page<Product> findProductsByNameContainingAndPrice(String name, double price,Pageable pageable);
    Page<Product> findProductsByNameContainingAndProductType_Id(String name, int idProductType,Pageable pageable);
    Page<Product> findByNameContainingAndPriceAndProductType_Id(String name,double price, int idProductType, Pageable pageable);

}
