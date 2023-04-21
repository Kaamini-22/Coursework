package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Country {
    public String Code;
    public String Name;
    public String Continent;
    public String Region;
    public int SurfaceArea;
    public int IndepYear;
    public int Population;
    public int LifeExpectancy;
    public int GNP;
    public int GNPOld;
    public String LocalName;
    public String GovernmentForm;
    public String HeadOfState;
    public int Capital;
    public String Code2;

    public Country() {
        Code = null;
        Name = null;
        Continent = null;
        Region = null;
        Population = 0;
        this.GNP = 0;
        Capital = 0;
    }
    public Country(String code, String name, String continent, String region, int population, int GNP, int capital) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Population = population;
        this.GNP = GNP;
        Capital = capital;
    }

    static Country getCountry(Connection con, String CCode)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Population, GNP, Capital "
                            + "FROM world.country "
                            + "WHERE Code = " + "'ARG'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country coun = new Country();
                coun.Code = rset.getString("Code");
                coun.Name = rset.getString("Name");
                coun.Continent = rset.getString("Continent");
                coun.Population = rset.getInt("Population");
                coun.GNP = rset.getInt("GNP");
                coun.Capital = rset.getInt("Capital");
                return coun;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    static void displayCountry(Country coun)
    {
        if (coun != null)
        {
            System.out.println(
                    coun.Code + " "
                            + coun.Name + " "
                            + coun.Continent + "\n"
                            + coun.Population + "\n"
                            + coun.GNP + "\n"
                            + coun.Capital + "\n");
        }
    }
}
