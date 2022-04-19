package com.company.customids;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @Column(name = "ownerId", nullable = false)
    private String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String id) {
        this.ownerId = id;
    }

}