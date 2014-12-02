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
    private int permission = -1;
    
    public Account(){}
    
    public Account(String email, String password, String typeOfAccount, int permission){
        setEmail(email);
        setPassword(password);
        setTypeOfAccount(typeOfAccount);
        setPermission(permission);
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

    public void setPermission(int permission) {
        this.permission = permission;
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

    public int getPermission() {
        return permission;
    }
    
}
