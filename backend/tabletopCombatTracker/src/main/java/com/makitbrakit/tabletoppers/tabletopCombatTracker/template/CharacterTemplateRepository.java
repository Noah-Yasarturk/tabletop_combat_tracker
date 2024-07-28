package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterTemplateRepository extends JpaRepository<CharacterTemplate, Long>{

    @Query("SELECT c FROM CharacterTemplate c WHERE c.charTemplateName = :char_template_name")
    Optional<CharacterTemplate> findCharacterTemplateByName(@Param("char_template_name") String characterTemplateName);
    
}
