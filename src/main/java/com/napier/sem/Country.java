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

    static Country getCountry(String CCode)
    {
        Connection con = null;

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Population, GNP, Capital "
                            + "FROM country "
                            + "WHERE Code = " + "'" + CCode + "'";
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
