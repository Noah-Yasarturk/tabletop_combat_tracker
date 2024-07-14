package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

public class CharacterTemplateNotFoundException extends RuntimeException {
    
    CharacterTemplateNotFoundException(Long id) {
        super("Could not found character template with id " + id);
    }
}
