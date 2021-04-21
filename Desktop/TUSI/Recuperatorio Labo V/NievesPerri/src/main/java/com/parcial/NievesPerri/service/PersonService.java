package com.parcial.NievesPerri.service;

import com.parcial.NievesPerri.model.Manager;
import com.parcial.NievesPerri.model.Person;
import com.parcial.NievesPerri.model.Player;
import com.parcial.NievesPerri.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository PersonRepository;

    @Autowired
    public PersonService(com.parcial.NievesPerri.repository.PersonRepository personRepository) {
        PersonRepository = personRepository;
    }


    public List<Person> getAll() {
        return PersonRepository.findAll();
    }

    public void add(Person person) {
        PersonRepository.save(person);
    }

    public Person getByID(Integer id) {
        return PersonRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        PersonRepository.deleteById(id);
    }

    public void addPlayerToManager(Integer managerId, Integer playerId) {
        Manager manager = (Manager) this.getByID(managerId);
        Player player = (Player) this.getByID(playerId);
        manager.getListPlayers().add(player);
        manager.addCurrencyToVault(player.getCurrency());
        PersonRepository.save(manager);
    }

}