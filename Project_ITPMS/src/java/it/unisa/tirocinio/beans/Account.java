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
public final class Account {
    
    private String email = null;
    private String password = null;
    private String typeOfAccount = null;
    private int active;
    
    public Account(){}
    
    public Account(String email, String password, String typeOfAccount, int active){
        setEmail(email);
        setPassword(password);
        setTypeOfAccount(typeOfAccount);
        setActive(active);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }
    
    
}
