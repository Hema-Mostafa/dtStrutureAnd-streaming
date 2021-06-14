/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ibrahim
 */
public class City {
    String   population;
    
    String city_id,cityName, country_id , capital;

    public City(String city_id,  String cityName, String country_id, String capital , String population) {
        this.city_id = city_id;
        this.population = population;
        this.cityName = cityName;
        this.country_id = country_id;
        this.capital = capital;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" + "city_id=" + city_id + ", population=" + population + ", cityName=" + cityName + ", country_id=" + country_id + ", capital=" + capital + '}';
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    
}
