package com.parcial.NievesPerri.model;

public enum TypePerson {
    MANAGER("Manager"),
    FRIEND("Friend"),
    PLAYER("Player");

    private String descripcion;

    TypePerson(String descripcion) {
        this.descripcion = descripcion;
    }

    public static TypePerson find(final String value) {
        for (TypePerson v : values()) {
            if (v.toString().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypePerson inserted: %s", value));
    }

    public String getDescripcion() {
        return descripcion;
    }
}

