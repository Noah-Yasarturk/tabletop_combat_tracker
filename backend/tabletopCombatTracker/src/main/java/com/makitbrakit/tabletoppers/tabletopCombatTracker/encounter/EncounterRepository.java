package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import org.springframework.data.repository.CrudRepository;

public interface EncounterRepository extends CrudRepository<Encounter, Long> {
    
    Encounter findById(long id);
}
