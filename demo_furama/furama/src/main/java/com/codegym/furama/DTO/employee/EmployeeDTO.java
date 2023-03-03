package com.codegym.furama.DTO.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Position;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EmployeeDTO {
    private int id;
    private String name;
    private String birthday;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
}
