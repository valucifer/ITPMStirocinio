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
public final class Professor {
    
    private int idProfessor;
    private String position = null;
    private String phone = null;
    private String officeHours = null;
    private String email = null;
    private String CF = null;
    private String departmentAbbreviation = null;
    
    private Professor(){}
    private Professor(String position, String phone, String officeHours, String email, String CF, String departmentAbbreviation){
        setPosition(position);
        setPhone(phone);
        setOfficeHours(officeHours);
        setEmail(email);
        setCF(CF);
        setDepartmentAbbreviation(departmentAbbreviation);
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    } 

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getEmail() {
        return email;
    }

    public String getCF() {
        return CF;
    }

    public String getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public void setDepartmentAbbreviation(String departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }
    
    
    
}
