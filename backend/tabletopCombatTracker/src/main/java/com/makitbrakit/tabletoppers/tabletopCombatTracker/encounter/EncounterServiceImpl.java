package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncounterServiceImpl implements EncounterService{

    @Autowired
    private EncounterRepository encounterRepository;

    @Override
    public Encounter saveEncounter(Encounter encounter) {
        try {
            getEncounterByName(encounter.getName());
            throw new InvalidEncounterException(encounter.getName());
        } catch (EncounterNotFoundException e) {
            encounterRepository.save(encounter);
            return encounter;
        }
    }

    @Override
    public List<Encounter> fetchEncounterList() {
        return encounterRepository.findAll();
    }

    @Override
    public Encounter updateEncounter(Encounter encounter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEncounter'");
    }

    @Override
    public void deleteEncounter(Encounter encounter) {
        this.encounterRepository.delete(encounter);
    }

    @Override
    public Encounter getEncounterById(Long encounterId) {
        return this.encounterRepository.findById(encounterId)
        .orElseThrow(() -> new EncounterNotFoundException(encounterId));
    }

    @Override
    public Encounter getEncounterByName(String encounterName) {
        return this.encounterRepository.getEncounterByName(encounterName)
        .orElseThrow(() -> new EncounterNotFoundException(encounterName));
    }
    
}
