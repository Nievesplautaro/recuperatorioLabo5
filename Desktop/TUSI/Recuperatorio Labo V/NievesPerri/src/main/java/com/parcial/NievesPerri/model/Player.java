package com.parcial.NievesPerri.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player extends Person{
    private Double heigth;
    private Double weigth;
    private Integer goals;
    private Double minutesPlayed;
    private LocalDate birthdayPlayer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private Currency currency;

    @Override
    public TypePerson typePerson() {
        return TypePerson.PLAYER;
    }
}
