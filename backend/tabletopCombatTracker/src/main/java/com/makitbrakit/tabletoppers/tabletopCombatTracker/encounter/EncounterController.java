package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EncounterController {

    private final EncounterService encounterService;
    private final EncounterModelAssembler encounterModelAssembler;

    EncounterController(EncounterService encounterService, EncounterModelAssembler encounterModelAssembler) {
        this.encounterService = encounterService;
        this.encounterModelAssembler = encounterModelAssembler;
    }

    @GetMapping("/encounters")
    CollectionModel<EntityModel<Encounter>> all() {

        List<EntityModel<Encounter>> encounters = encounterService.fetchEncounterList().stream()
                .map(encounter -> EntityModel.of(encounter,
                        linkTo(methodOn(EncounterController.class).one(encounter.getId())).withSelfRel(),
                        linkTo(methodOn(EncounterController.class).all()).withRel("encounters")))
                .collect(Collectors.toList());

        return CollectionModel.of(encounters,
                linkTo(methodOn(EncounterController.class).all()).withSelfRel());
    }

    @GetMapping("/encounter/{id}")
    EntityModel<Encounter> one(@PathVariable Long id) {
        try {
            Encounter encounter = this.encounterService.getEncounterById(id);
            return EntityModel.of(encounter,
                    linkTo(methodOn(EncounterController.class).one(id)).withSelfRel(),
                    linkTo(methodOn(EncounterController.class).all()).withRel("encounters"));
        } catch (EncounterNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    @PostMapping("/encounter")
    ResponseEntity<?> newEncounter(@Valid @RequestBody Encounter newEncounter) {
        EntityModel<Encounter> entityModel = encounterModelAssembler
                .toModel(encounterService.saveEncounter(newEncounter));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/encounter/{id}")
    ResponseEntity<?> deleteEncounter(@PathVariable("id") String id) {
        Encounter encounterToDelete = encounterService.getEncounterById(Long.valueOf(id));
        encounterService.deleteEncounter(encounterToDelete);
        return ResponseEntity.noContent().build();
    }

}
