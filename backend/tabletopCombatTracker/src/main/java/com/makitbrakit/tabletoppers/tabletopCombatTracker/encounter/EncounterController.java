package com.makitbrakit.tabletoppers.tabletopCombatTracker.encounter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {

    @Autowired
    private EncounterService encounterService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // @GetMapping("/encounters")
    // CollectionModel<EntityModel<Encounter>> all() {

    //     List<EntityModel<Encounter>> encounters = repository.findAll().stream()
    //         .map(encounter -> EntityModel.of(encounter,
    //             linkTo(methodOn(EncounterController.class).one(encounter.getId())).withSelfRel(),
    //             linkTo(methodOn(EncounterController.class).all()).withRel("encounters")))
    //         .collect(Collectors.toList());

    //     return CollectionModel.of(encounters, 
    //         linkTo(methodOn(EncounterController.class).all()).withSelfRel());
    // }


    // @GetMapping("/encounters/{id}")
    // EntityModel<Encounter> one(@PathVariable Long id) {
    //     Encounter encounter = this.encounterService.getEncounterById(id);

    //     return EntityModel.of(encounter,
    //         linkTo(methodOn(EncounterController.class).one(id)).withSelfRel()
    //     );
    // }

    // @PostMapping("/encounters")
    // Encounter newEncounter(@RequestBody Encounter newEncounter) {
    //     return repository.save(newEncounter);
    // }
    
}
