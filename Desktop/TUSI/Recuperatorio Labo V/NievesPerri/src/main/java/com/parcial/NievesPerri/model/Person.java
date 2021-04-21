package com.parcial.NievesPerri.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Player.class, name = "PLAYER"),
        @JsonSubTypes.Type(value = Friend.class, name = "FRIEND"),
        @JsonSubTypes.Type(value = Manager.class, name = "MANAGER")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "name must have a value")
    private  String name;

    @NotNull(message = "lastName must have a value")
    private  String lastname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "birthdateId", referencedColumnName = "id")
    private Set<Birthdate> birthdate;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePerson typePerson();

}