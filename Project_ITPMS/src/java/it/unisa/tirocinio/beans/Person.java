/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public final class Person {
    
    private String CF = null;
    private String name = null;
    private String lastName = null;
    private String phone = null;
    private String city = null;
    private String address = null;
    private String zipCode = null;
    private String gender = null;
    private String citizenship = null;
    
    public Person(){}
    
    public Person(String CF, String name, String lastName, String phone, String city, String address, String zipCode, String gender, String cityzenship){
        setCF(CF);
        setName(name);
        setLastName(lastName);
        setPhone(phone);
        setCity(city);
        setAddress(address);
        setZipCode(zipCode);
        setGender(gender);
        setCitizenship(citizenship);
    }

    public String getCF() {
        return CF;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getGender() {
        return gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
