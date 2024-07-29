package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

class EncounterNotFoundException extends RuntimeException {
    
    EncounterNotFoundException(Long id) {
        super("Could not found encounter id " + id);
    }

    EncounterNotFoundException(String encounterName) {
        super("Could not find encounter with name " + encounterName);
    }
}
