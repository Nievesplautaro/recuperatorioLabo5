package com.parcial.NievesPerri.controller;

import com.parcial.NievesPerri.model.Birthdate;
import com.parcial.NievesPerri.model.Currency;
import com.parcial.NievesPerri.service.BirthdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birthdate")
public class birthdateController {

    @Autowired
    private BirthdateService birthdateService;

    //POST /birthdate
    @PostMapping
    public void AddOne (@RequestBody Birthdate birthdate){
        birthdateService.add(birthdate);
    }

    //GET /birthdate
    @GetMapping
    public List<Birthdate> getAll(){
        return birthdateService.getAll();
    }

    //GET /birthdate/{id}
    @GetMapping("/{id}")
    public Birthdate getByID(@PathVariable Integer id){
        return birthdateService.getByID(id);
    }
    //DELETE /birthdate/{id}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        birthdateService.delete(id);
    }
}
