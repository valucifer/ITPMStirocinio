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
    private Permissions permissions = null;
    
    public Account(){}
    
    public Account(String email, String password, String typeOfAccount, Permissions permissions){
        setEmail(email);
        setPassword(password);
        setTypeOfAccount(typeOfAccount);
        setPermissions(permissions);
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

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
    
}
