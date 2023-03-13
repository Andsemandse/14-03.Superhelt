package com.example.hero1403.dto;

    import java.util.List;

    public class DTOSuperpowerhero {
        private String realName;
        private String heroName;
        private List<String> superpower;

        public void addSuperpower(String name) {

            superpower.add(name);
        }

        public DTOSuperpowerhero(String realName, String heroName, List<String> superpower) {
            this.realName = realName;
            this.heroName = heroName;
            this.superpower = superpower;
        }

        public String getRealName() {

            return realName;
        }

        public String getHeroName() {
            return heroName;
        }

        public List<String> getSuperpower() {
            return superpower;
        }

    }
