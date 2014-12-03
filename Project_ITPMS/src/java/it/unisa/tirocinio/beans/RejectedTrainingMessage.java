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
public final class RejectedTrainingMessage {
 
    private int idRejectedTraingMessage;
    private String message = null;
    private Account accountEmail = null;
    
    public RejectedTrainingMessage(){}  
    public RejectedTrainingMessage( String description, Account accountEmail ){
        setDescription(description);
        setSerialNumber(accountEmail);
    }  

    public int getIdRejectedTraingMessage() {
        return idRejectedTraingMessage;
    }

    public void setIdRejectedTraingMessage(int idRejectedTraingMessage) {
        this.idRejectedTraingMessage = idRejectedTraingMessage;
    }
    
    public String getDescription() {
        return message;
    }

    public Account getSerialNumber() {
        return accountEmail;
    }

    public void setSerialNumber(Account accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setDescription(String description) {
        this.message = description;
    }
    
}
