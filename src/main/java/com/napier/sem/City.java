package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
     * Represents an employee
     */
    public class City
    {
        /**
         * City ID
         */
        public int ID;

        /**
         * City's name
         */
        public String Name;

        /**
         * City's code
         */
        public String CountryCode;

        /**
         * City's District
         */
        public String District;

        /**
         * City's population
         */
        public int Population;


        public City() {
            ID = 0;
            Name = null;
            CountryCode = null;
            District = null;
            Population = 0;
        }
        public City(int id, String name, String countryCode, String district, int population) {
            ID = id;
            Name = name;
            CountryCode = countryCode;
            District = district;
            Population = population;
        }

        static City getCity(Connection con, String CID)
        {
            try
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT ID, Name, CountryCode, District, Population "
                                + "FROM world.city "
                                + "WHERE ID = '" + CID + "'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Return new country if valid.
                // Check one is returned
                if (rset.next())
                {
                    City cit = new City();
                    cit.ID = rset.getInt("ID");
                    cit.Name = rset.getString("Name");
                    cit.CountryCode = rset.getString("CountryCode");
                    cit.District = rset.getString("District");
                    cit.Population = rset.getInt("Population");
                    return cit;
                }
                else
                    return null;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get city details");
                return null;
            }
        }
        static void displayCity(City cit)
        {
            if (cit != null)
            {
                System.out.println(
                        cit.ID + " "
                                + cit.Name + " "
                                + cit.CountryCode + " "
                                + cit.District + "\n"
                                + cit.Population + "\n");
            }
        }

}
