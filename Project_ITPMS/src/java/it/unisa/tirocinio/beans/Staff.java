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
    private Account accountEmail = null;
    private Person personFiscalCode = null;
    private Department departmentAbbreviation = null;
    
    public Staff(){}
    
    public Staff(String phone, Account accountEmail, Person personFiscalCode, Department departmentAbbreviation){
        setPhone(phone);
        setEmail(accountEmail);
        setCF(personFiscalCode);
        setDepartmentAbbreviation(departmentAbbreviation);
    }

    public int getIdStaff() {
        return idStaff;
    }

    public String getPhone() {
        return phone;
    }

    public Account getEmail() {
        return accountEmail;
    }

    public Person getCF() {
        return personFiscalCode;
    }

    public Department getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(Account accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setCF(Person CF) {
        this.personFiscalCode = CF;
    }

    public void setDepartmentAbbreviation(Department departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }

}
