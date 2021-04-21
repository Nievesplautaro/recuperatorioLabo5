package com.parcial.NievesPerri.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Manager extends Person{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private List<Player> listPlayers;

    private Double vaultWeight;
    private Double totalAmount;

    @Override
    public TypePerson typePerson() {
        return TypePerson.MANAGER;
    }

    public void addCurrencyToVault(Currency currency){
        double amount = currency.getAmount();
        this.vaultWeight += amount;
        this.totalAmount += amount * currency.getCurrencyType().getValue();
    }

    //metodo para calcular el total
    public double getMontoTotal(){
        double totalAmountPlayers = 0;
        if(this.getListPlayers()!= null){
            List<Player> players = this.getListPlayers();
            for (Player iterate : players){
                if(iterate.getCurrency().getCurrencyType().equals("EURO")){
                    totalAmountPlayers += iterate.getCurrency().getAmount() / 170;
                }else if(iterate.getCurrency().getCurrencyType().equals("DOLAR")){
                    totalAmountPlayers += iterate.getCurrency().getAmount() / 150;
                }
            }
        }
        return totalAmountPlayers;
    }

}