package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Long> {

    @Query("SELECT e FROM Encounter e WHERE e.encounterName = :encounterName")
    Optional<Encounter> getEncounterByName(@Param("encounterName") String encounterName);

}
