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
public final class TrainingStatus {
    
    private int idTrainingStatus;
    private String description = null;
    
    public TrainingStatus(){}
    
    public TrainingStatus( String description ){
        setDescription(description);
    }

    public int getIdTrainingStatus() {
        return idTrainingStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setIdTrainingStatus(int idTrainingStatus) {
        this.idTrainingStatus = idTrainingStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
