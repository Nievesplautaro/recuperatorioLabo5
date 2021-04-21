package com.parcial.NievesPerri.service;

import com.parcial.NievesPerri.model.Currency;
import com.parcial.NievesPerri.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;



    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    public Currency getByID(Integer id) {
        return currencyRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        currencyRepository.deleteById(id);
    }

}
