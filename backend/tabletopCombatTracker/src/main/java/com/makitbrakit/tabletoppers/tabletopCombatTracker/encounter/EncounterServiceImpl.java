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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveEncounter'");
    }

    @Override
    public List<Encounter> fetchEncounterList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchEncounterList'");
    }

    @Override
    public Encounter updateEncounter(Encounter encounter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEncounter'");
    }

    @Override
    public void deleteEncounter(Encounter encounter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEncounter'");
    }

    @Override
    public Encounter getEncounterById(Long encounterId) {
        return this.encounterRepository.findById(encounterId)
        .orElseThrow(() -> new EncounterNotFoundException(encounterId));
    }
    
}
