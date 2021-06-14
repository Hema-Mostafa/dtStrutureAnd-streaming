/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandstreaming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.City;

/**
 *
 * @author Ibrahim
 */
public class AllCityOperations {
    
                /*Mapping*/
    // Convert City List to Map -> key = City.countryID , Value = List<City>
    public static Map<String , List<City>> toMapByCountryID(List<City> citiesList){
        
        Map<String , List<City>> map = new HashMap<>();
         // Mapping 
        for(int i = 0 ; i < citiesList.size(); i++ ){
            
            String key = citiesList.get(i).getCountry_id();
          
            if (map.containsKey(key)) {
                map.get(key).add(citiesList.get(i));
                               
            } else {
                List<City> countryCity = new ArrayList<>();
                countryCity.add(citiesList.get(i));
                map.put(key, countryCity);        
            }
        }
    return map;
    
    }
    
    // Convert City List to Map -> key = City.capital , Value = List<String> City.GetPopulation
    public static Map<String , List<String>> toMapByCapital(List<City> citiesList){
            
            Map<String ,List<String>> mapByCapital = new HashMap<>();
             
            for(int i = 0 ; i < citiesList.size(); i++ ){
            
            String key = citiesList.get(i).getCapital();
          
            if (key == "" || key == "   ")
                continue;
            
            if (mapByCapital.containsKey(key)) {
                mapByCapital.get(key).add(citiesList.get(i).getPopulation());
                
            } else {
                List<String> l = new ArrayList<>();
                l.add(citiesList.get(i).getPopulation());
                mapByCapital.put(key,l);        
            }
        }
            return mapByCapital;
    }
    
         /*Printing*/ 
   public static void printHighiestPopByCapital(Map <String, List<String>> mapByCapital){
        
       
         mapByCapital.forEach((k , values)->{
            
            Double heightiesPop = values.stream()
                    .mapToDouble(Double:: parseDouble)
                    .max().getAsDouble();
            
                    System.out.println("Capital name = "+ k  + String.format( " , The Hightes Population  %.0f", heightiesPop));
            
            });
    }
   public static void printHieghiestPopByCountry(Map<String , Double> mapByCountry){
       
       mapByCountry.forEach(((k,values)->{
       
           System.out.println("Country Code = " + k +" , heighest Population = " +values.toString());
           
       
       }));
       
       
       
   
   }
    
    
    /*Get Highest population of each country */
    public static Map<String , String> getHeighiesPopulation_1(Map<String ,List<City>> map){
    
         Map<String , String > maxPopByCountry = new HashMap<>();
         
          map.forEach((key , values) ->{
          String maxPopulation = values.stream()
                .map(City::getPopulation)
                  .findFirst().get();  // Because it sorted
          
          maxPopByCountry.put(key, maxPopulation);
       });
          return maxPopByCountry;
    }
    
     /*Get Highest population of each country with Another Way */
    public static Map<String , Double> getHeighiesPopulation_2(Map<String ,List<City>> map){
        
         Map<String , Double > maxPopByCountry = new HashMap<>();
         
           map.forEach((k , values) ->{
            double maxPop = values.stream()
                    .map(City::getPopulation)
                    .mapToDouble(Double :: parseDouble)
                    .max().getAsDouble();
                    
            maxPopByCountry.put(k, maxPop);
        });
        return maxPopByCountry;
        
    }
    
    
    
  
}
