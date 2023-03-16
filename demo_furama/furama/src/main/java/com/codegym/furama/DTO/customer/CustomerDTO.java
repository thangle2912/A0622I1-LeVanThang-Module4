package com.codegym.furama.DTO.customer;

import com.codegym.furama.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDTO implements Validator {
    private int id;

    private String name;
    private String birthday;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private CustomerType customerType;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String birthday, boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        String name = customerDTO.getName();
        String phoneNumber = customerDTO.getPhoneNumber();
        String idCard = customerDTO.getIdCard();
        String email = customerDTO.getEmail();
        String address = customerDTO.getAddress();
        if (name.equals("")) {
            errors.rejectValue("name", null, "Không được để trống");
        } else if (!name.matches("^[A-Z][a-z]+ [A-Z][a-z]+(?: [A-Z][a-z]*)*")) {
            errors.rejectValue("name", null, "Tên sai định dạng");
        }
        if (phoneNumber.equals("")) {
            errors.rejectValue("phoneNumber", null, "Không được để trống");
        } else if (!phoneNumber.matches("^(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại sai định dạng");
        }
        if (idCard.equals("")) {
            errors.rejectValue("idCard", null, "Không được để trống");
        } else if (!idCard.matches("(([\\d]{9})|([\\d]{12}))")) {
            errors.rejectValue("idCard", null, "Số CMND sai định dạng");
        }
        if (email.equals("")) {
            errors.rejectValue("email", null, "Không được để trống");
        } else if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            errors.rejectValue("email", null, "Email sai định dạng");
        }
        if (address.equals("")) {
            errors.rejectValue("address", null, "Không được để trống");
        }

    }
}
