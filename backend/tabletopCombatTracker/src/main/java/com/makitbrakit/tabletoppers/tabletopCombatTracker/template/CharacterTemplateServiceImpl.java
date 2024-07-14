package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterTemplateServiceImpl implements CharacterTemplateService {

    @Autowired
    private CharacterTemplateRepository characterTemplateRepository; 

    @Override
    public CharacterTemplate getCharacterTemplateById(Long characterTemplateId) {
        return this.characterTemplateRepository.findById(characterTemplateId)
        .orElseThrow(() -> new CharacterTemplateNotFoundException(characterTemplateId));
    }

    @Override
    public CharacterTemplate saveCharacterTemplate(CharacterTemplate characterTemplate) {
        characterTemplateRepository.save(characterTemplate);
        return characterTemplate;
    }

    @Override
    public List<CharacterTemplate> fetchCharacterTemplateList() {
        return characterTemplateRepository.findAll();
    }

    @Override
    public CharacterTemplate updateCharacterTemplate(CharacterTemplate newCharacterTemplate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCharacterTemplate'");
    }

    @Override
    public void deleteCharacterTemplate(CharacterTemplate characterTemplate) {
        this.characterTemplateRepository.delete(characterTemplate);
    }
    
}
