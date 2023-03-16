package com.codegym.furama.DTO.contract;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.facility.Facility;

import java.util.Set;

public class ContractDTO {
    private int id;
    private String startDate;
    private String endDate;
    private double deposit;

    private double payment;

    private Customer customer;

    private Employee employee;

    private Facility facility;

    private Set<AttachFacility> attachFacilitySet;

    public ContractDTO() {
    }

    public ContractDTO(int id, String startDate, String endDate, double deposit, double payment, Customer customer, Employee employee, Facility facility, Set<AttachFacility> attachFacilitySet) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.payment = payment;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.attachFacilitySet = attachFacilitySet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<AttachFacility> getAttachFacilitySet() {
        return attachFacilitySet;
    }

    public void setAttachFacilitySet(Set<AttachFacility> attachFacilitySet) {
        this.attachFacilitySet = attachFacilitySet;
    }
}
