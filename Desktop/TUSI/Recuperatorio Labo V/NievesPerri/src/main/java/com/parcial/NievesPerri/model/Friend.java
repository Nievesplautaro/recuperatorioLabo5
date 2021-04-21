package com.parcial.NievesPerri.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Friend extends Person{
    private String profession;
    private String Status;


    @Override
    public TypePerson typePerson() {
        return TypePerson.FRIEND;
    }
}
