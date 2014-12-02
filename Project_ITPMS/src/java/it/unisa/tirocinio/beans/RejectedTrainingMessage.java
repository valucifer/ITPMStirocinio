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
    private String serialNumber = null;
    
    public RejectedTrainingMessage(){}  
    public RejectedTrainingMessage( String description, String serialNumber ){
        setDescription(description);
        setSerialNumber(serialNumber);
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setDescription(String description) {
        this.message = description;
    }
    
}
