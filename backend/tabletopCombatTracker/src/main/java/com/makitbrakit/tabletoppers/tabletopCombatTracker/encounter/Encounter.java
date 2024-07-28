package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Encounter {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long encounterId;

    @NotEmpty
    private String encounterName; 

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    Encounter() {}

    Encounter(String encounterName) {
        this.encounterName = encounterName; 
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    @Override
    public String toString() {
        return String.format(
            "Encounter[id=%d, name=%s]",
            encounterId, encounterName
        );
    }

    public String getName(){
        return encounterName;
    }

    public Long getId(){
        return encounterId;
    } 

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setName(String newName){
        this.updatedAt = new Date();;
        this.encounterName = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Encounter)) return false; 
        Encounter encounter = (Encounter) o;
        return Objects.equals(this.encounterName, encounter.encounterName);
    }


}