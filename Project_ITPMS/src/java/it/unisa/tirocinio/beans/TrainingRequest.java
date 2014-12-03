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
    private TrainingStatus trainingStatus;
    private Person professor;
    private Organization organizationVATNumber;
    
    public TrainingRequest(){}
    
    public TrainingRequest(String description, String title, TrainingStatus trainingStatus, Person professor, Organization organizationVATNumber){
        setDescription(description);
        setTitle(title);
        setTrainingStatus(trainingStatus);
        setProfessor(professor);
        setOrganizationVATNumber(organizationVATNumber);
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

    public void setIdTrainingRequest(int idTrainingRequest) {
        this.idTrainingRequest = idTrainingRequest;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TrainingStatus getTrainingStatus() {
        return trainingStatus;
    }

    public Person getProfessor() {
        return professor;
    }

    public Organization getOrganizationVATNumber() {
        return organizationVATNumber;
    }

    public void setTrainingStatus(TrainingStatus trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public void setProfessor(Person professor) {
        this.professor = professor;
    }

    public void setOrganizationVATNumber(Organization organizationVATNumber) {
        this.organizationVATNumber = organizationVATNumber;
    }
    
}
