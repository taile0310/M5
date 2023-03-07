package com.furama.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attachFacility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;

    public ContractDetail() {

    }

    public ContractDetail(int quantity, Contract contract, AttachFacility attachFacility) {
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
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

    public Contract getContractId() {
        return contract;
    }

    public void setContractId(Contract contractId) {
        this.contract = contract;
    }

    public void setAttachFacilityId(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

}
