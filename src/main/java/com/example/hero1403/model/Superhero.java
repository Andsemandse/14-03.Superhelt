package com.example.hero1403.model;


public class Superhero {
    private String realName;
    private String heroName;
    private String BirthYear;
    private String heroPower;
    private int id;

    public Superhero(String realName, String heroName, String BirthYear, String heroPower, int id) {
        this.realName = realName;
        this.heroName = heroName;
        this.BirthYear = BirthYear;
        this.heroPower = heroPower;
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



    public String getHeroPower() {
        return heroPower;
    }

    public int getid() {
        return id;
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



    public void setHeroPower(String heroPower) {
        this.heroPower = heroPower;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Superhero(String realName, String heroName, String BirthYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.BirthYear = BirthYear;


    }
}
