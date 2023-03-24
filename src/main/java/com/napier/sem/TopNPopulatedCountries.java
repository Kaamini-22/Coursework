package com.napier.sem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopNPopulatedCountries {
    static void topNPopulatedCountriesWorld(){
        Connection con = null;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // get N from user
            int N;
            System.out.println("Enter value for N: ");
            N = Integer.parseInt(reader.readLine());
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
}
