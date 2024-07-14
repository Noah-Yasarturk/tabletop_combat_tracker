package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter.Encounter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class CharacterTemplateController {

    private final CharacterTemplateService characterTemplateService;
    private final CharacterTemplateModelAssembler characterTemplateModelAssembler;

    CharacterTemplateController(CharacterTemplateService characterTemplateService, CharacterTemplateModelAssembler characterTemplateModelAssembler) {
        this.characterTemplateService = characterTemplateService;
        this.characterTemplateModelAssembler = characterTemplateModelAssembler;
    }

    @GetMapping("/characterTemplates")
    CollectionModel<EntityModel<CharacterTemplate>> all() {

        List<EntityModel<CharacterTemplate>> characterTemplates = characterTemplateService.fetchCharacterTemplateList().stream()
            .map(charTemplate -> EntityModel.of(charTemplate,
                linkTo(methodOn(CharacterTemplateController.class).one(charTemplate.getId())).withSelfRel(),
                linkTo(methodOn(CharacterTemplateController.class).all()).withRel("characterTemplates")))
            .collect(Collectors.toList());
        
        return CollectionModel.of(characterTemplates,
            linkTo(methodOn(CharacterTemplateController.class).all()).withSelfRel());
    }

    @GetMapping("/characterTemplate/{id}")
    EntityModel<CharacterTemplate> one(@PathVariable Long id) {
        CharacterTemplate characterTemplate = this.characterTemplateService.getCharacterTemplateById(id);

        return EntityModel.of(characterTemplate,
            linkTo(methodOn(CharacterTemplateController.class).one(id)).withSelfRel(),
            linkTo(methodOn(CharacterTemplateController.class).all()).withRel("characterTemplates")
        );
    }

    @PostMapping("/characterTemplate")
    ResponseEntity<?> newCharacterTemplate(@RequestBody CharacterTemplate chrTemplate) {
        EntityModel<CharacterTemplate> chrEntityModel = characterTemplateModelAssembler.toModel(characterTemplateService.saveCharacterTemplate(chrTemplate));
        return ResponseEntity.created(chrEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(chrEntityModel);
    }

    @DeleteMapping("characterTemplate/{id}")
    ResponseEntity<?> deleteCharacterTemplate(@PathVariable String id) {
        CharacterTemplate characterTemplate = characterTemplateService.getCharacterTemplateById(Long.valueOf(id));
        characterTemplateService.deleteCharacterTemplate(characterTemplate);
        return ResponseEntity.noContent().build();
    }
    

}
