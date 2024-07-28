package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class CharacterTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long charTemplateId;


    @NotBlank(message="charTemplateName may not be null")
    private String charTemplateName;

    private String creatureType;

    private int armorClass;

    @NotNull(message="strength required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int strength;

    @NotNull(message="dexterity required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int dexterity;


    @NotNull(message="constitution required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int constitution;


    @NotNull(message="intelligence required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int intelligence;


    @NotNull(message="wisdom required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int wisdom;


    @NotNull(message="charisma required for CharacterTemplate")
    @Min(0)
    @Max(30)
    private int charisma;
  
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    CharacterTemplate() {
    }

    CharacterTemplate(String characterTemplateName, String creatureType, int armor, int str, int dex, int cnst,
            int intell, int wis, int chr) {
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


    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public String getCharTemplateName() {
        return charTemplateName;
    }

    public void setCharTemplateName(String charTemplateName) {
        this.charTemplateName = charTemplateName;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public Long getId() {
        return this.charTemplateId;
    }

}
