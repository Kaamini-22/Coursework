package com.napier.sem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TopNPopulatedCities {
    static void topNPopulatedCitiesWorld(Connection con, int N){
        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM world.city "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cit = new City();
                cit.ID = rset.getInt("ID");
                cit.Name = rset.getString("Name");
                cit.CountryCode = rset.getString("CountryCode");
                cit.District = rset.getString("District");
                cit.Population = rset.getInt("Population");
                cit.displayCity(cit);
            }
            // Check one is returned
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCitiesContinent(Connection con, String conti, int N){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM world.city "
                            + "JOIN world.country ON world.city.CountryCode = world.country.Code "
                            + "WHERE Continent = '" + conti + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT  " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cit = new City();
                cit.ID = rset.getInt("ID");
                cit.Name = rset.getString("Name");
                cit.CountryCode = rset.getString("CountryCode");
                cit.District = rset.getString("District");
                cit.Population = rset.getInt("Population");
                cit.displayCity(cit);
            }
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCitiesRegion(Connection con, String reg, int N){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM world.city "
                            + "WHERE Region = '" + reg + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cit = new City();
                cit.ID = rset.getInt("ID");
                cit.Name = rset.getString("Name");
                cit.CountryCode = rset.getString("CountryCode");
                cit.District = rset.getString("District");
                cit.Population = rset.getInt("Population");
                cit.displayCity(cit);
            }
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
}
