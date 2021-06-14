/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandstreaming;

import dao.CityDaoImpl;
import dao.CountryDaoImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import models.City;
import models.Country;

/**
 *
 * @author Ibrahim
 */
public class DataStructureAndStreaming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CountryDaoImpl countryDaoImpl = new CountryDaoImpl();
        CityDaoImpl cityDaoImpl = new CityDaoImpl();
        
        
        List<City> citiesList = cityDaoImpl.getAllCities("cities.csv");
        List <Country> countriesList = countryDaoImpl.getAllCountries("countries.csv");
        
//        System.out.println("The City List Size = "+citiesList.size());
//        System.out.println("The Country List size = "+countriesList.size());
      
        // Mapping 
         Map<String , List<City>> map = AllCityOperations.toMapByCountryID(citiesList);
         
          // Sorting
        map.entrySet().forEach(entry -> {
            entry.getValue().sort(Comparator.comparing(City::getPopulation).reversed());
            });
      

    /*Get Highest population of each country */
    Map<String , String > maxPopByCountry = AllCityOperations.getHeighiesPopulation_1(map);
    Map<String , Double > maxPopByCountry2 = AllCityOperations.getHeighiesPopulation_2(map);
    
    
       // Print Country Map -> key = Country Code , Value = Heighest Popualation of this Country
       // AllCityOperations.printHieghiestPopByCountry(maxPopByCountry2);
       
       
       Map<String , List<String>> mapByCapital = AllCityOperations.toMapByCapital(citiesList);
       
       //Print Capital Map -> key = Capital Name , Value = Heighest Popualation of this Capital       
       AllCityOperations.printHighiestPopByCapital(mapByCapital);
       
      

      /*BetterString Method Excution */
      
      String string1 = "hello World !!!!!!";
      String string2 = "Hello World !! ";
      
      String better = betterString(string1, string2, (s1,s2)-> string1.length() > string2.length());
      System.out.println("The Better String is " + better);
    
    /* Lab Exercise 2  , check the alphabet */
    
    String str = "Stopwishingstartdoing"; // retutn True
    String str2 = "Stop wishing start doing "; // retutn False
    
    System.out.println("After Checking The alphbets of string We Found  "+checkAlphabets(str,Character::isLetter)); // By Method refrence
//    System.out.println(checkAlphabets(str2,ch -> ch.isLetter(ch))); // By Lambda Expression
    
    }
    
    public static String betterString(String s1 , String s2, BiPredicate<String , String> p){
       
        boolean res =  p.test(s1, s2);
        if(res)
            return s1;
        return s2;
       
       
    }
    public  static boolean checkAlphabets( String s , Function <Character , Boolean> f ){
        
        char[] charArray = s.toCharArray();
        
        for(int i=0 ; i < charArray.length ; i++){
            if(!f.apply(charArray[i]))
                return false; // if Char in string is not letter
        }
        return true;
        
    }
}