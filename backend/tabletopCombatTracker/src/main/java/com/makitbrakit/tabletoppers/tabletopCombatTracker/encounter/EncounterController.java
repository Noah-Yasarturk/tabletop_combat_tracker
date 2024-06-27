package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EncounterController {

    private final EncounterRepository encounterRepo;

    EncounterController(EncounterRepository repo) {
        this.encounterRepo = repo;
    }


    @GetMapping("/encounters")
	CollectionModel<EntityModel<Encounter>> all() {

		List<EntityModel<Encounter>> encounters = Encounter.findAll().stream()
				.map(encounter -> EntityModel.of(encounter,
						linkTo(methodOn(EncounterController.class).one(encounter.getId())).withSelfRel(),
						linkTo(methodOn(EncounterController.class).all()).withRel("encounters")))
				.collect(Collectors.toList());

		return CollectionModel.of(encounters,
         linkTo(methodOn(EncounterController.class).all()).withSelfRel());
	}


    @GetMapping("/encounters/{id}")
    EntityModel<Encounter> one(@PathVariable Long id) {
        Encounter encounter = this.encounterRepo.findById(id)
            .orElseThrow(() -> new EncounterNotFoundException(id));
        return EntityModel.of(encounter,
            linkTo(methodOn(Encounter.class).one(d)).withSelfRel(),
            linkTo(methodOn(Encounter.class).all()).withRel("encounters")
        );

    }
    
}
