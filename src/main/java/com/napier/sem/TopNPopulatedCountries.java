package com.napier.sem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopNPopulatedCountries {
    static void topNPopulatedCountriesWorld(Connection con, int N){
        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM world.country "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("Name");
                coun.Continent = rset.getString("Continent");
                coun.Region = rset.getString("Region");
                coun.Population = rset.getInt("Population");
                coun.Capital = rset.getInt("Capital");
                coun.displayCountry(coun);
            }
            // Check one is returned
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCountriesContinent(Connection con, String conti, int N){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM world.country "
                            + "WHERE Continent = '" + conti + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT  " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("Name");
                coun.Continent = conti;
                coun.Region = rset.getString("Region");
                coun.Population = rset.getInt("Population");
                coun.Capital = rset.getInt("Capital");
                coun.displayCountry(coun);
            }
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCountriesRegion(Connection con, String reg, int N){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM world.country "
                            + "WHERE Region = '" + reg + "'"
                            + "ORDER BY Population DESC "
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("Name");
                coun.Continent = rset.getString("Continent");
                coun.Region = reg;
                coun.Population = rset.getInt("Population");
                coun.Capital = rset.getInt("Capital");
                coun.displayCountry(coun);
            }
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
}
