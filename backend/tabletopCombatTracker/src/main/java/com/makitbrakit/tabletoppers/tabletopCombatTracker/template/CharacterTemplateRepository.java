package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterTemplateRepository extends JpaRepository<CharacterTemplate, Long>{
    
}
