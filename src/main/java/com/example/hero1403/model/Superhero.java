package com.example.hero1403.model;


public class Superhero {
    private String realName;
    private String heroName;
    private String BirthYear;
    private int id;
    private String City;

    public Superhero(String realName, String heroName, String BirthYear, int id) {
        this.realName = realName;
        this.heroName = heroName;
        this.BirthYear = BirthYear;
        this.id = id;

    }


    public String getRealName() {
        return realName;
    }


    public String getHeroName() {
        return heroName;
    }

    public String getBirthYear() {
        return BirthYear;
    }



    public int getId() {
        return id;
    }

    public String getCity() {
        return City;
    }


    //setters
    public void setRealName(String realName) {
        this.realName = realName;
    }


    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setBirthYear(String BirthYear) {
        this.BirthYear = BirthYear;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public Superhero(int Id, String realName, String heroName, String BirthYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.BirthYear = BirthYear;


    }
}
