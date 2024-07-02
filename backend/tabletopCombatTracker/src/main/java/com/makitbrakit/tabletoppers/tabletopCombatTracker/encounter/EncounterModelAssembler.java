package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EncounterModelAssembler implements RepresentationModelAssembler<Encounter, EntityModel<Encounter>> {

    @Override
    public EntityModel<Encounter> toModel(Encounter encounter) {
        return EntityModel.of(encounter,
            linkTo(methodOn(EncounterController.class).one(encounter.getId())).withSelfRel(),
            linkTo(methodOn(EncounterController.class).all()).withRel("encounters"));
    }

    
}
