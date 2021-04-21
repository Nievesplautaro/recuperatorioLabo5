package com.parcial.NievesPerri.controller;

import com.parcial.NievesPerri.model.Currency;
import com.parcial.NievesPerri.model.Person;
import com.parcial.NievesPerri.service.CurrencyService;
import com.parcial.NievesPerri.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class currencyController {

    @Autowired
    private CurrencyService currencyService;

    //POST /currency
    @PostMapping
    public void AddOne (@RequestBody Currency currency){
        currencyService.add(currency);
    }

    //GET /currency
    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    //GET /currency/{id}
    @GetMapping("/{id}")
    public Currency getByID(@PathVariable Integer id){
        return currencyService.getByID(id);
    }
    //DELETE /currency/{id}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        currencyService.delete(id);
    }


}
