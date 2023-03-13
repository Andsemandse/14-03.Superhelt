package com.example.hero1403.controller;
import com.example.hero1403.dto.DTOCity;
import com.example.hero1403.dto.DTOCountSuperpower;
import com.example.hero1403.model.Superhero;
import com.example.hero1403.Repository.Repository_DATA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/Hero")
@Controller
public class controller {
    private Repository_DATA repository;

    public controller(Repository_DATA repository) {
        this.repository = repository;
    }

    @GetMapping("/AllHeroes")
    public ResponseEntity<List<Superhero>> getSuperheros() {
        List<Superhero> SuperheroList = repository.getSuperheroList();
        return new ResponseEntity<>(SuperheroList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name) {
        Superhero superhero = repository.getSuperhero(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/Power/count")
    public ResponseEntity<List<DTOCountSuperpower>> getPowerCount() {
        List<DTOCountSuperpower> PowerCountList = Repository_DATA.getPowerCount();
        return new ResponseEntity<>(PowerCountList, HttpStatus.OK);
    }
    @GetMapping("/City/{name}")
    public ResponseEntity<List<DTOCity>> getCity(@PathVariable String name) {
        List<DTOCity> citys = Repository_DATA.getCity(name);
        return new ResponseEntity<>(citys, HttpStatus.OK);
    }
    @GetMapping("/city")
    public ResponseEntity<List<DTOCity>> getEntireCity() {
        List<DTOCity> entireCity = Repository_DATA.getentireCity();
        return new ResponseEntity<>(entireCity,HttpStatus.OK);
    }
}



