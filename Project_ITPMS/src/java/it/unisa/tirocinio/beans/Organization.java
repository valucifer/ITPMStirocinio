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
    private String email = null;
    private Person personCF = null;
    private Account accountEmail = null;
    
    public Organization(){}
    
    public Organization(String VATNumber, String companyName, String city, String address, String phone, String email, Account accountEmail, Person personCF){
        setVATNumber(VATNumber);
        setCompanyName(companyName);
        setCity(city);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setAccount(accountEmail);
        setPerson(personCF);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public Account getAccount() {
        return accountEmail;
    }

    public Person getPerson() {
        return personCF;
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
    
    public void setAccount(Account accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setPerson(Person personCF) {
        this.personCF = personCF;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }
    
}
