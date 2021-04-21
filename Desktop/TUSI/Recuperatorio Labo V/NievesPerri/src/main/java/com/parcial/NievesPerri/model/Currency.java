package com.parcial.NievesPerri.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue
    private Integer Id;

    private CurrencyType currencyType;
    private double amount;
}