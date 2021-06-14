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
public class Country {
    String country_name , code;

    @Override
    public String toString() {
        return "Country{" + "country_name=" + country_name + ", code=" + code + '}';
    }

    public String getCountry_name() {
        return country_name;
    }

    public Country(String country_name, String code) {
        this.country_name = country_name;
        this.code = code;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
