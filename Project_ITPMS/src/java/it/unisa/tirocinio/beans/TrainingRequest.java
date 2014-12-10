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
    private int trainingStatus;
    private String personSSN = null;
    private String organizationVATNumber = null;
    private String studentSSN = null;
    
    public TrainingRequest(){}
    
    public TrainingRequest(int idTrainingRequest, String description, String title, int trainingStatus, String professor, String organizationVATNumber, String studentSSN){
        setIdTrainingRequest(idTrainingRequest);
        setDescription(description);
        setTitle(title);
        setTrainingStatus(trainingStatus);
        setPersonSSN(professor);
        setOrganizationVATNumber(organizationVATNumber);
        setStudentSSN(studentSSN);
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

    public int getTrainingStatus() {
        return trainingStatus;
    }

    public String getPersonSSN() {
        return personSSN;
    }

    public String getOrganizationVATNumber() {
        return organizationVATNumber;
    }

    public String getStudentSSN() {
        return studentSSN;
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

    public void setTrainingStatus(int trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public void setPersonSSN(String personSSN) {
        this.personSSN = personSSN;
    }

    public void setOrganizationVATNumber(String organizationVATNumber) {
        this.organizationVATNumber = organizationVATNumber;
    }

    public void setStudentSSN(String studentSSN) {
        this.studentSSN = studentSSN;
    }

}
