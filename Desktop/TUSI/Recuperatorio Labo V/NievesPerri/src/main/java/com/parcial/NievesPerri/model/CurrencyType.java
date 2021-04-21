package com.parcial.NievesPerri.model;

public enum CurrencyType {
    EURO("Euro", 170),
    DOLAR("dolar", 150);

    private String description;
    private double value;

    CurrencyType(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public static CurrencyType find(final String in) {
        for (CurrencyType v : values()) {
            if (v.toString().equalsIgnoreCase(in)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid CurrencyType inserted: %s", in));
    }

    public String getDescription() {
        return description;
    }

    public double getValue(){
        return value;
    }
}