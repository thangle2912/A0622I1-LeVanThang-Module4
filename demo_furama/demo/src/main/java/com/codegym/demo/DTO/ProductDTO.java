package com.codegym.demo.DTO;

import com.codegym.demo.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductDTO implements Validator {
    private int id;

    private String name;

    @NotNull(message = "Không được để trống")
    private double price;
    private String status;
    private ProductType productType;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, double price, String status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        double price = productDTO.getPrice();
        String name = productDTO.getName();
        ProductType productType = productDTO.getProductType();


       if (price < 100000) {
           errors.rejectValue("price", null, "Giá khởi điểm từ 100.000 VNĐ");
       }
        if (name.equals("")) {
            errors.rejectValue("name", null, "Không được để trống");
        }else {
            int nameLength=name.length();
            if (nameLength<5 || nameLength>50){
                errors.rejectValue("name", null, "Tên sản phẩm từ 5 đến 50 ký tự");
            }
        }
        if (productType.equals("")) {
            errors.rejectValue("productType", null, "Không được để trống");
        }

    }
}
