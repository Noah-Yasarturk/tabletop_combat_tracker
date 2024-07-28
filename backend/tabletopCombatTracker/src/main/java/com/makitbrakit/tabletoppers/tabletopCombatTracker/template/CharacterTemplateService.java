package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.List;

public interface CharacterTemplateService {

    CharacterTemplate getCharacterTemplateById(Long characterTemplateId);

    CharacterTemplate findCharacterTemplateByName(String characterTemplateName);

    /**
     * Create CharacterTemplate if the stats & creatureType are valid & the name is unique
     * @param characterTemplate
     * @return The created CharacterTemplate
     */
    CharacterTemplate saveCharacterTemplate(CharacterTemplate characterTemplate);

    List<CharacterTemplate> fetchCharacterTemplateList();

    CharacterTemplate updateCharacterTemplate(CharacterTemplate newCharacterTemplate);

    void deleteCharacterTemplate(CharacterTemplate characterTemplate);
    
} 