package com.makitbrakit.tabletoppers.tabletopCombatTracker.template;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CharacterTemplateModelAssembler implements RepresentationModelAssembler<CharacterTemplate, EntityModel<CharacterTemplate>>{

    @Override
    public EntityModel<CharacterTemplate> toModel(CharacterTemplate characterTemplate) {
        return EntityModel.of(characterTemplate,
            linkTo(methodOn(CharacterTemplateController.class).one(characterTemplate.getId())).withSelfRel(),
            linkTo(methodOn(CharacterTemplateController.class).all()).withRel("characterTemplates"));
    }
    
}
