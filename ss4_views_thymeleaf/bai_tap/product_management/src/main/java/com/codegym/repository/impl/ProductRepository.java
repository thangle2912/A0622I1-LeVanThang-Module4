package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Bánh Solite",34000,"Bánh này rất ngon","Không biết"));
        productList.add(new Product(2,"Chocolate",50000,"Loại này siêu ngon","Không biết"));
        productList.add(new Product(3,"Bánh gấu",30000,"Bánh này rất ngon","Cũng không biết"));
        productList.add(new Product(6,"Bút chì",3000,"Bút chì 2B","Không biết"));
        productList.add(new Product(8,"Bút bi",3000,"Bút bi 0.25","Không biết"));

    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(Product product) {
        for (Product productUpdate: productList){
            if (productUpdate.getId()==product.getId()){
                productUpdate.setProduct(product.getName(),product.getPrice(),product.getDescription(),product.getManufacturer());
            }
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        for(Product product:productList){
            if (product.getId()==id){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
    @Override
    public List<Product> searchByName(String name) {
        List<Product> productListSearch = new ArrayList<>();

        for (Product product:productList){
            String nameSearch = name.toLowerCase();
            String nameProduct = product.getName().toLowerCase();
            if(nameProduct.contains(nameSearch)){
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}
