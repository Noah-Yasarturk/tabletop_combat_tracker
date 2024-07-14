package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.List;

public interface CharacterTemplateService {

    CharacterTemplate getCharacterTemplateById(Long characterTemplateId);

    CharacterTemplate saveCharacterTemplate(CharacterTemplate characterTemplate);

    List<CharacterTemplate> fetchCharacterTemplateList();

    CharacterTemplate updateCharacterTemplate(CharacterTemplate newCharacterTemplate);

    void deleteCharacterTemplate(CharacterTemplate characterTemplate);
    
} 