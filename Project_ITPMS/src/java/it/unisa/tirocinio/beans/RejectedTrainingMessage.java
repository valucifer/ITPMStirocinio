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
    private String description = null;
    private String personSSN = null;
    
    public RejectedTrainingMessage(){}  
    public RejectedTrainingMessage( int idRejectedTraingMessage, String description, String personSSN ){
        setIdRejectedTraingMessage(idRejectedTraingMessage);
        setDescription(description);
        setPersonSSN(personSSN);
    }  

    public int getIdRejectedTraingMessage() {
        return idRejectedTraingMessage;
    }

    public void setIdRejectedTraingMessage(int idRejectedTraingMessage) {
        this.idRejectedTraingMessage = idRejectedTraingMessage;
    }
    
    public String getDescription() {
        return description;
    }

    public String getPersonSSN() {
        return personSSN;
    }

    public void setPersonSSN(String personSSN) {
        this.personSSN = personSSN;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
