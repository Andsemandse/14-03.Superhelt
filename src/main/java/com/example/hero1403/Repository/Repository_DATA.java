package com.example.hero1403.Repository;
import com.example.hero1403.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
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
            String SQL = "SELECT * FROM superhero";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                String heroName = rs.getString("real_name");
                String realName = rs.getString("hero_name");
                String BirthYear = rs.getString("Birth_year");
                superheroes.add(new Superhero(realName, heroName, BirthYear));
            }
            return superheroes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
