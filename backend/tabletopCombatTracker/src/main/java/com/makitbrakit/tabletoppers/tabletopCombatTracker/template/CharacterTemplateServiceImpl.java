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
     * All stats should be between 0 and 30
     * @param characterTemplate
     */
    private void validateStats(CharacterTemplate characterTemplate) {
        List<Integer> statsToCheck = new ArrayList<Integer>(){{
            add(characterTemplate.getCharisma());
            add(characterTemplate.getConstitution());
            add(characterTemplate.getDexterity());
            add(characterTemplate.getIntelligence());
            add(characterTemplate.getStrength());
            add(characterTemplate.getWisdom());
        }};
        statsToCheck.forEach(stat -> {
            if (stat > 30 || stat < 0) {
                throw new InvalidCharacterTemplateException(stat);
            }
        });
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
        validateStats(characterTemplate);
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
