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
    
    private String fiscalCode = null;
    private String name = null;
    private String surname = null;
    private String phone = null;
    private String city = null;
    private String address = null;
    private String zipCode = null;
    private String gender = null;
    private String citizenship = null;
    private String webPage = null;
    private String university = null;
    private String role = null;
    private String matricula = null;
    private Account accountEmail = null;
    private Department departmentAbbreviation = null;
    
    public Person(){}
    
    public Person(String CF, String name, String lastName, String phone, String city, String address, String zipCode, String gender, String citizenship, Account accountEmail, Department departmentAbbreviation, String webPage, String university, String role, String matricula){
        setFiscalCode(CF);
        setName(name);
        setSurname(lastName);
        setPhone(phone);
        setCity(city);
        setAddress(address);
        setZipCode(zipCode);
        setGender(gender);
        setCitizenship(citizenship);
        setAccountEmail(accountEmail);
        setDepartmentAbbreviation(departmentAbbreviation);
        setWebPage(webPage);
        setUniversity(university);
        setRole(role);
        setMatricula(matricula);
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getWebPage() {
        return webPage;
    }

    public String getUniversity() {
        return university;
    }

    public String getRole() {
        return role;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Account getAccountEmail() {
        return accountEmail;
    }

    public Department getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setAccountEmail(Account accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setDepartmentAbbreviation(Department departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }
    
}
