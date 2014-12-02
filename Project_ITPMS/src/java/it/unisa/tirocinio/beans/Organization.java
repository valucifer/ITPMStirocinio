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
public final class Organization {
    
    private String VATNumber = null;
    private String companyName = null;
    private String city = null;
    private String address = null;
    private String phone = null;
    private String training = null;
    private String email = null;
    private String CF = null;
    
    public Organization(){}
    
    public Organization(String VATNumber, String companyName, String city, String address, String phone, String trainining, String email, String CF){
        setVATNumber(VATNumber);
        setCompanyName(companyName);
        setCity(city);
        setAddress(address);
        setPhone(phone);
        setTraining(training);
        setAccount(email);
        setPerson(CF);
    }

    public String getEmail() {
        return email;
    }

    public String getCF() {
        return CF;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getTraining() {
        return training;
    }

    public String getAccount() {
        return email;
    }

    public String getPerson() {
        return CF;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public void setAccount(String email) {
        this.email = email;
    }

    public void setPerson(String CF) {
        this.CF = CF;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }
    
}
