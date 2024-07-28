package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.makitbrakit.tabletoppers.tabletopCombatTracker.GameUtils;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

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
    public CharacterTemplate findCharacterTemplateByName(String characterTemplateName) {
        return this.characterTemplateRepository.findCharacterTemplateByName(characterTemplateName)
        .orElseThrow(() -> new CharacterTemplateNotFoundException(characterTemplateName));
    }


    /**
     * Ensure the passed creature type is amonst the defined creature types
     * @param characterTemplate
     */
    private void validateCreatureType(CharacterTemplate characterTemplate) {
        if (!GameUtils.creatureTypes.contains( characterTemplate.getCreatureType())) {
            throw new InvalidCharacterTemplateException(characterTemplate.getCreatureType());
        }
    }

    /**
     * Should not be able to create a character template using an existing name
     * @param characterTemplate
     */
    private void validateCharacterName(CharacterTemplate characterTemplate) {
        try {
            findCharacterTemplateByName(characterTemplate.getCharTemplateName());
            throw new InvalidCharacterTemplateException(characterTemplate);
        } catch (CharacterTemplateNotFoundException e) {
            return;
        }
    }

    @Override
    public CharacterTemplate saveCharacterTemplate(CharacterTemplate characterTemplate) {
        validateCreatureType(characterTemplate);
        validateCharacterName(characterTemplate);
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
