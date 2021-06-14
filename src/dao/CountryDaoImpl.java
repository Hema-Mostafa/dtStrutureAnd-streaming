/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Country;

/**
 *
 * @author Ibrahim
 */
public class CountryDaoImpl  implements CountryDao{

    @Override
    public List<Country> getAllCountries(String path) {
         List<Country> countryList = new ArrayList<>();
        
        try {
          
            Scanner sc = new Scanner(new File(path));
            
             if(sc.hasNextLine())
                sc.nextLine();
             while (sc.hasNextLine()) {
                 String line = sc.nextLine();
                 String [] parts=line.split(",");
           
                 countryList.add(new Country(parts[0], parts[1]));
                 
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Country  Dao Impl  Error");
           
        }
        return countryList;
    }
    
}
