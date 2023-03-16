package com.codegym.furama.model.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    @JsonIgnore
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "id")
    @JsonIgnore
    private AttachFacility attachFacility;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
