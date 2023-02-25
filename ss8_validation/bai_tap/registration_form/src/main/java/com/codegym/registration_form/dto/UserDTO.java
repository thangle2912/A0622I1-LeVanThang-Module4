package com.codegym.registration_form.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {
    private int id;
    @NotEmpty
    @Length(min = 5,max = 45,message = "First name min 5 and max 45" )
    @Pattern(regexp = "^[A-Za-zÁ-Ỵ]*$")
    private String firstName;

    @NotEmpty
    @Length(min = 5,max = 45,message = "Last name min 5 and max 45")
    private String lastName;

    @Pattern(regexp = "^(0)\\d{9}$", message = "Phone number is not valid")
    private String phoneNumber;

    @Min(value = 18,message = "18+")
    private int age;
    @Email(message = "Email is not valid")
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        String phoneNumber = userDTO.getPhoneNumber();
        if (!phoneNumber.matches("^\\d+$")){
            errors.rejectValue("phoneNumber",null,"Contains only numeric characters");
        }else if (phoneNumber.length()<10 && phoneNumber.length()>11){
            errors.rejectValue("phoneNumber",null,"Invalid length");
        }
    }
}
