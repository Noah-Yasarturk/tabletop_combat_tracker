package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import java.util.List;

public interface EncounterService {

    Encounter getEncounterById(Long encounterId);

    Encounter getEncounterByName(String encounterName);

    Encounter saveEncounter(Encounter encounter);

    List<Encounter> fetchEncounterList();

    Encounter updateEncounter(Encounter encounter);

    void deleteEncounter(Encounter encounter);

    
}
