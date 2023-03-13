package com.example.hero1403.Repository;

import com.example.hero1403.Interface.InterfaceHeroes;
import com.example.hero1403.dto.DTOCity;
import com.example.hero1403.dto.DTOCountSuperpower;
import com.example.hero1403.dto.DTOSuperpowerhero;
import com.example.hero1403.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("stub")


public class Repository_stub implements InterfaceHeroes {
    private List<Superhero> superheroList;
    private List<DTOCountSuperpower> DTOCountSuperpower;
    private List<DTOSuperpowerhero> DTOSuperpowerhero;
    private List<DTOCity> DTOCity;

    public Repository_stub() {
        superheroList = new ArrayList<Superhero>(List.of(
                new Superhero("Tony", "Ironman", "1980", 1),
                new Superhero("Andreas", "SuperAndreas", "2001", 2),
                new Superhero("Peter", "Spiderman", "1995", 3),
                new Superhero("Thor", "Godofthunder", "200", 4),
                new Superhero("Bruce", "Batman", "1980", 5),
                new Superhero("Banner", "Hulk", "1999", 6),
                new Superhero("Clark", "Superman", "1950", 7)
        ));


        DTOCountSuperpower = new ArrayList<>(List.of(
                new DTOCountSuperpower ("Tony", "Ironman", 15),
                new DTOCountSuperpower ("Andreas", "SuperAndreas", 11),
                new DTOCountSuperpower ("Peter", "Spiderman", 10),
                new DTOCountSuperpower ("Thor", "GodofThunder", 8),
                new DTOCountSuperpower ("Bruce", "Batman", 7),
                new DTOCountSuperpower ("Banner", "Hulk", 17),
                new DTOCountSuperpower ("Clark", "Superman", 20)
        ));

        DTOSuperpowerhero = new ArrayList<>(List.of(
                new DTOSuperpowerhero("Tony", "Ironman", new ArrayList<>(List.of( "smart", "rich"))),
                new DTOSuperpowerhero("Andreas", "SuperAndreas", new ArrayList<>(List.of( "flying", "strong" ))),
                new DTOSuperpowerhero("Peter", "Spiderman", new ArrayList<>(List.of("Web", "wallclimbing"))),
                new DTOSuperpowerhero("Thor", "GodofThunder", new ArrayList<>(List.of("Hammer", "God"))),
                new DTOSuperpowerhero("Bruce", "Batman", new ArrayList<>(List.of("rich", "smart", "bat"))),
                new DTOSuperpowerhero("Banner", "Hulk", new ArrayList<>(List.of("green", "strong" ))),
                new DTOSuperpowerhero("Clark", "Superman", new ArrayList<>(List.of("flying", "strong"))
        )));

        DTOCity = new ArrayList<>(List.of(
                new DTOCity("Veksoe", new ArrayList<>(List.of("Ironman", "SuperAndreas", "Spiderman"))),
                new DTOCity("Gotham", new ArrayList<>(List.of("GodofThunder", "Batman", "Hulk", "Superman")))


        ));



    }



    public Superhero getSuperhero(String name) {
        for (Superhero superhero : superheroList) {
            if (superhero.getHeroName().toLowerCase().equals(name)) {
                return superhero;
            }
        }
        return null;
    }

    public List<Superhero> getSuperheroList() {
        return superheroList;
    }

    public List<DTOCountSuperpower> getPowerCount() {
        return DTOCountSuperpower;
    }

    public DTOCity getCity(String cityName) {
        for (DTOCity dto : DTOCity) {
            if (cityName.equalsIgnoreCase(dto.getCity())) {
                return dto;
            }

            }
        return null;
        }



    public List<DTOCity> getEntireCity() {
        return DTOCity;
    }
}

