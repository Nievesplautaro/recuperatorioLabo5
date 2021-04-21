package com.parcial.NievesPerri.controller;

import com.parcial.NievesPerri.model.Person;
import com.parcial.NievesPerri.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class personController {

    @Autowired
    private PersonService personService;

    //POST /person
    @PostMapping
    public void AddOne (@RequestBody Person person){
        personService.add(person);
    }

    //GET /person
    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }

    //GET /person/{id}
    @GetMapping("/{id}")
    public Person getByID(@PathVariable Integer id){
        return personService.getByID(id);
    }
    //DELETE /person/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        personService.delete(id);
    }

    //PUT  /person/{id}/jugadores/{idJugador}
    @PutMapping("/{managerId}/players/{playerId}")
    public void addPlayerToManager(@PathVariable Integer managerId, @PathVariable Integer playerId) {
        personService.addPlayerToManager(managerId, playerId);
    }

}