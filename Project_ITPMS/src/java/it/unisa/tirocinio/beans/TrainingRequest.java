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
public final class TrainingRequest {
    
    private int idTrainingRequest;
    private String description = null;
    private String title = null;
    private int fkTrainingStatus;
    private int fkProfessor;
    private int fkOrganization;
    
    public TrainingRequest(){}
    
    public TrainingRequest(String description, String title, int fkTrainingStatus, int fkProfessor, int fkOrganization){
        setDescription(description);
        setTitle(title);
        setFkTrainingStatus(fkTrainingStatus);
        setFkProfessor(fkProfessor);
        setFkOrganization(fkOrganization);
    }

    public int getIdTrainingRequest() {
        return idTrainingRequest;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getFkTrainingStatus() {
        return fkTrainingStatus;
    }

    public int getFkProfessor() {
        return fkProfessor;
    }

    public int getFkOrganization() {
        return fkOrganization;
    }

    public void setIdTrainingRequest(int idTrainingRequest) {
        this.idTrainingRequest = idTrainingRequest;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFkTrainingStatus(int fkTrainingStatus) {
        this.fkTrainingStatus = fkTrainingStatus;
    }

    public void setFkProfessor(int fkProfessor) {
        this.fkProfessor = fkProfessor;
    }

    public void setFkOrganization(int fkOrganization) {
        this.fkOrganization = fkOrganization;
    }
    
}
