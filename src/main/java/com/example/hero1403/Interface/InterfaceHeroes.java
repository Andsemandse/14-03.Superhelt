package com.example.hero1403.Interface;
import com.example.hero1403.dto.DTOCountSuperpower;
import com.example.hero1403.dto.DTOCity;
import com.example.hero1403.model.Superhero;

import java.util.List;

public interface InterfaceHeroes {
    default Superhero getSuperhero(String name) {
        return null;
    }

    default List<Superhero> getSuperheroList() {
        return null;
    }

    default List<DTOCountSuperpower> getPowerCount() {
        return null;
    }

    default DTOCity getCity(String name) {
        return null;

    }
    default List<DTOCity> getEntireCity() {
        return null;
    }
}

