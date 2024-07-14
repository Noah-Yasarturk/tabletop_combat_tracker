package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CharacterTemplate {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long charTemplateId;

    private String charTemplateName;

    private int armorClass;

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    @CreationTimestamp
    private Date createdAt; 

    @UpdateTimestamp
    private Date updatedAt;

    CharacterTemplate() {}

    CharacterTemplate(String characterTemplateName, int armor, int str, int dex, int cnst, int intell, int wis, int chr) {
        this.charTemplateName = characterTemplateName;
        this.armorClass = armor;
        this.strength = str;
        this.dexterity = dex;
        this.constitution = cnst;
        this.intelligence = intell;
        this.wisdom = wis;
        this.charisma = chr; 
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public Long getId() {
        return this.charTemplateId;
    }

    public String getCharTemplateName() {
        return charTemplateName;
    }

    public void setCharTemplateName(String charTemplateName) {
        this.charTemplateName = charTemplateName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    
    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
    
}
