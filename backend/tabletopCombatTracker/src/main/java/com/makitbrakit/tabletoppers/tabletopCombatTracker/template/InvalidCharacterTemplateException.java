package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

public class InvalidCharacterTemplateException extends RuntimeException {

    public InvalidCharacterTemplateException(Integer badStat) {
        super(String.format("Invalid character template provided with faulty stat %s", badStat));
    }

    public InvalidCharacterTemplateException(String invalidCreatureType) {
        super(String.format("Invalid character template provided with invalid creature type %s", invalidCreatureType));
    }

    public InvalidCharacterTemplateException(CharacterTemplate charTemplate ) {
        super(String.format("Character template already exists with name %s", charTemplate.getCharTemplateName()));
    }
    
}
