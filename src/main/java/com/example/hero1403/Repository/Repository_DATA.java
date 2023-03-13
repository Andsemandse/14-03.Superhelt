package com.example.hero1403.Repository;
import com.example.hero1403.dto.DTOCity;
import com.example.hero1403.dto.DTOCountSuperpower;
import com.example.hero1403.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository

public class Repository_DATA {


    @Value("${spring.datasource.url}")
    String db_url;
    @Value("${spring.datasource.username}")
    String u_id;
    @Value("${spring.datasource.password}")
    String pwd;


    //Udleverer alle helte
    public List<Superhero> getSuperheroList() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, u_id, pwd)) {
            String SQL = "SELECT * FROM super_heroes";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                int id = rs.getInt("id");
                String heroName = rs.getString("real_name");
                String realName = rs.getString("hero_name");
                String BirthYear = rs.getString("Birth_year");
                superheroes.add(new Superhero(id, realName, heroName, BirthYear));
            }
            return superheroes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //helt ved navn
    public Superhero getSuperhero(String name) {
        Superhero superhero = null;
        try (Connection con = DriverManager.getConnection(db_url, u_id, pwd)) {
            String SQL = "SELECT * FROM superhero WHERE real_name = ? OR hero_name = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setString(2, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("Id");
                String heroName = rs.getString("real_name");
                String realName = rs.getString("hero_name");
                String BirthYear = rs.getString("Birth_year");
                superhero = new Superhero(id, realName, heroName, BirthYear);
            }

            return superhero;
        } catch (SQLException e) {
            throw new RuntimeException(e);


        }


    }

    //Liste der nu også indeholder antal superpower
    public static List<DTOCountSuperpower> getPowerCount() {
        List<DTOCountSuperpower> PowerCount = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_heroes", "root", "root")) {
            String SQL = "SELECT hero_name, real_name, COUNT(*) AS powers FROM superhero JOIN superheropower ON superhero.id = superheropower.superheroid and hero_name = ? GROUP BY real_name";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String realName = rs.getString("real_name");
                String heroName = rs.getString("hero_name");
                int powerCount = rs.getInt("count");

                PowerCount.add(new DTOCountSuperpower(realName, heroName, powerCount));
            }
            return PowerCount;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }


    //City
    public static List<DTOCity> getCity(String name) {
        List<DTOCity> superherosCity = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_heroes", "root", "root")) {
            String SQL = "SELECT city.cityname, superhero.hero_name FROM superhero JOIN city ON superhero.city.id = city.id ORDER BY city.cityname";


            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            String currentCity = "";
            DTOCity herosCity = null;

            while (rs.next()) {
                String city = rs.getString("city");
                String realName = rs.getString("real_name");

                if (city.equals(currentCity)) {
                    herosCity.addSuperhero(realName);
                } else {
                    herosCity = new DTOCity(city, new ArrayList<>(List.of(realName)));
                    superherosCity.add(herosCity);
                    currentCity = city;
                }
            }
            return superherosCity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public static List<DTOCity> getentireCity() {
        List<DTOCity> entireCity = new ArrayList();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_heroes", "root", "root")) {
            String SQL = "SELECT city, hero_name FROM city JOIN superhero WHERE superhero.city.id = city.city.id GROUP BY superhero.id";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            String currentCity = "";
            DTOCity herosCity = null;
            while (rs.next()) {
                String city = rs.getString("city");
                String heroName = rs.getString("hero_name");

                if (city.equals(currentCity)) {
                    herosCity.addSuperhero(heroName);
                } else {
                    herosCity = new DTOCity(city, new ArrayList<>(List.of(heroName)));
                    entireCity.add(herosCity);
                    currentCity = city;
                }

            }
            return entireCity;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}





