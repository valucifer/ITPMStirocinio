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
public final class Staff {
    
    private int idStaff;
    private String phone = null;
    private String email = null;
    private String CF = null;
    private String departmentAbbreviation = null;
    
    public Staff(){}
    
    public Staff(String phone, String email, String CF, String departmentAbbreviation){
        setPhone(phone);
        setEmail(email);
        setCF(CF);
        setDepartmentAbbreviation(departmentAbbreviation);
    }

    public int getIdStaff() {
        return idStaff;
    }

    public String getPhone() {
        return phone;
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

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
