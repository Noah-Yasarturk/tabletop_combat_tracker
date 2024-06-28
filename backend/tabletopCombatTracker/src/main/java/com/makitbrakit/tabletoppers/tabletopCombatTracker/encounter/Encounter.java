package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Encounter {

    @Id
    @GeneratedValue Long id;
    private String name; 
    private Date createdAt;
    private Date updatedAt;

    protected Encounter() {}

    public Encounter(String name) {
        this.name = name; 
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    @Override
    public String toString() {
        return String.format(
            "Encounter[id=%d, name=%s]",
            id, name
        );
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    } 

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setName(String newName){
        this.updatedAt = new Date();;
        this.name = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Encounter)) return false; 
        Encounter encounter = (Encounter) o;
        return Objects.equals(this.name, encounter.name);
    }


}