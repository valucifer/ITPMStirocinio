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
    private Person personSSN = null;
    
    public RejectedTrainingMessage(){}  
    public RejectedTrainingMessage( int idRejectedTraingMessage, String description, Person personSSN ){
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

    public Person getPersonSSN() {
        return personSSN;
    }

    public void setPersonSSN(Person personSSN) {
        this.personSSN = personSSN;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
