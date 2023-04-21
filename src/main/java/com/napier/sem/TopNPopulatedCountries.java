package com.napier.sem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopNPopulatedCountries {
    static void topNPopulatedCountriesWorld(int N){
        Connection con = null;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // get N from user
            //System.out.println("Enter value for N: ");
            //N = Integer.parseInt(reader.readLine());

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CountryCode, Name, Continent, Region, Population, Capital"
                            + "FROM country "
                            + "ORDER BY Population"
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCountriesContinent(String conti, int N){
        Connection con = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CountryCode, Name, Continent, Region, Population, Capital"
                            + "FROM country "
                            + "WHERE Continent = '" + conti + "'"
                            + "ORDER BY Population"
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
    static void topNPopulatedCountriesRegion(String reg, int N){
        Connection con = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CountryCode, Name, Continent, Region, Population, Capital"
                            + "FROM country "
                            + "WHERE Region = '" + reg + "'"
                            + "ORDER BY Population"
                            + "LIMIT " + N;
            // Execute SQL statement
            System.out.println("Results: ");
            ResultSet rset = stmt.executeQuery(strSelect);
        }// Check one is returned
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details");
        }
    }
}
