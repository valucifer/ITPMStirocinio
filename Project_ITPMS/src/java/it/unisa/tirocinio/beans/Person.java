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
    
    private String SSN = null;
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
    private String position = null;
    private String matricula = null;
    private String accountEmail = null;
    private int cycle;
    private String departmentAbbreviation = null;
    
    public Person(){}
    
    public Person(String SSN, String name, String lastName, String phone, String city, String address, String zipCode, String gender, String citizenship, String accountEmail, String departmentAbbreviation, String webPage, String university, String role, String matricula, int cycle){
        setSSN(SSN);
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
        setPosition(role);
        setMatricula(matricula);
        setCycle(cycle);
    }

    public String getSSN() {
        return SSN;
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

    public void setSSN(String SSN) {
        this.SSN = SSN;
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

    public String getPosition() {
        return position;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public String getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setDepartmentAbbreviation(String departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }
   
}
