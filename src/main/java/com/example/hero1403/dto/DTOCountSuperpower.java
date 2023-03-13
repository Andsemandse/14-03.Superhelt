package com.example.hero1403.dto;

public class DTOCountSuperpower {

    private String realName;
    private String heroName;
    private int PowerCount;

    public DTOCountSuperpower(String heroName, String realName, int PowerCount) {
        this.realName = realName;
        this.heroName = heroName;
        this.PowerCount = PowerCount;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }


    public int getPowerCount() {
        return PowerCount;
    }

    public void setPowerCount(int PowerCount) {
        this.PowerCount = PowerCount;
    }


    }
