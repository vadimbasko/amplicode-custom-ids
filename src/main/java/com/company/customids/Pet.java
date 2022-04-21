package com.company.customids;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "customizedId", nullable = false)
    private String customizedId;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    public String getCustomizedId() {
        return customizedId;
    }

    public void setCustomizedId(String id) {
        this.customizedId = id;
    }


    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

}