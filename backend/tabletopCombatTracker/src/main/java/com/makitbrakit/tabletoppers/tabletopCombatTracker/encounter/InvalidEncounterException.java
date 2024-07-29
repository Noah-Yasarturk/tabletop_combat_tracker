package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

public class InvalidEncounterException extends RuntimeException {

    public InvalidEncounterException(String encounterName) {
        super("Encounter with provided name exists: " + encounterName);
    }
    
}
