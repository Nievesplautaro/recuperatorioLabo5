package com.parcial.NievesPerri.service;

import com.parcial.NievesPerri.model.Birthdate;
import com.parcial.NievesPerri.model.Currency;
import com.parcial.NievesPerri.repository.BirthdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class BirthdateService {
    private BirthdateRepository birthdateRepository;

    @Autowired
    public BirthdateService(BirthdateRepository birthdayRepository) {
        this.birthdateRepository = birthdayRepository;
    }



    public List<Birthdate> getAll() {
        return birthdateRepository.findAll();
    }

    public void add(Birthdate birthdate) {
        birthdateRepository.save(birthdate);
    }

    public Birthdate getByID(Integer id) {
        return birthdateRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        birthdateRepository.deleteById(id);
    }
}
