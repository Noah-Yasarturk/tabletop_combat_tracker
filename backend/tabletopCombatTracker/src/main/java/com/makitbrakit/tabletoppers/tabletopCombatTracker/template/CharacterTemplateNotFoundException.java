package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

public class CharacterTemplateNotFoundException extends RuntimeException {
    
    CharacterTemplateNotFoundException(Long id) {
        super("Could not find character template with id " + id);
    }

    CharacterTemplateNotFoundException(String charTemplateName) {
        super("Could not find character template with name " + charTemplateName);
    }
}
