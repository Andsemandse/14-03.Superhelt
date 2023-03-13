package com.example.hero1403.dto;

import java.util.ArrayList;
import java.util.List;

public class DTOCity {
    private String city;
    private List<String> heroList;
    public DTOCity(String city, List <String> heroList) {
        this.city = city;
        this.heroList = heroList;
    }

    public String getCity() {
        return city;
    }

    public List<String> getHeroList() {
        return heroList;
    }

    public void addSuperhero(String name){
        heroList.add(name);
    }
}
