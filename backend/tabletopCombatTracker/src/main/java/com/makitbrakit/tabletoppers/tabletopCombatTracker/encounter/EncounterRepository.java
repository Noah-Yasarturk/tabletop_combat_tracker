package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EncounterRepository extends JpaRepository<Encounter, Long> {
    
}
