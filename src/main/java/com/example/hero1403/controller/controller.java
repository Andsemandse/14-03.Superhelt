package com.example.hero1403.controller;
import com.example.hero1403.model.Superhero;
import com.example.hero1403.Repository.Repository_DATA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/Hero")
@Controller
public class controller {
    private Repository_DATA repository;

    public controller(Repository_DATA repository){
        this.repository = repository;
    }

    @GetMapping("/AllHeroes")
    public ResponseEntity<List<Superhero>> getSuperheros() {
        List<Superhero> superheroList = repository.getSuperheroList();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }



    }
