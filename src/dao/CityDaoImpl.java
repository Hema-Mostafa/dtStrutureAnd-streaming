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
import models.City;

/**
 *
 * @author Ibrahim
 */
public class CityDaoImpl  implements CityDao{

    @Override
    public List<City> getAllCities(String path) {
        List<City> citiesList = new ArrayList<>();
        
        try {
            Scanner sc = new Scanner(new File(path));
            
             if(sc.hasNextLine())
                sc.nextLine();
             while (sc.hasNextLine()) {
                 String line = sc.nextLine();
                 String [] parts=line.split(",");
                  
                 if(parts.length != 5)
                     continue;
                 
                 String capital = parts[3].isEmpty() ? "" : parts[3];
                 
                  citiesList.add(new City(parts[0], parts[1], 
                          parts[2], parts[3], parts[4]));
                 
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("City Dao Impl  Error");
        }
        return citiesList;
    }
    
    
    
    
    
}
