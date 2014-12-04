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
    private TrainingStatus trainingStatus = null;
    private Person personSSN = null;
    private Organization organizationVATNumber = null;
    private StudentInformation studentSSN = null;
    
    public TrainingRequest(){}
    
    public TrainingRequest(int idTrainingRequest, String description, String title, TrainingStatus trainingStatus, Person professor, Organization organizationVATNumber, StudentInformation studentSSN){
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

    public Person getPersonSSN() {
        return personSSN;
    }

    public Organization getOrganizationVATNumber() {
        return organizationVATNumber;
    }

    public void setTrainingStatus(TrainingStatus trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public void setPersonSSN(Person personSSN) {
        this.personSSN = personSSN;
    }

    public void setOrganizationVATNumber(Organization organizationVATNumber) {
        this.organizationVATNumber = organizationVATNumber;
    }

    public StudentInformation getStudentSSN() {
        return studentSSN;
    }

    public void setStudentSSN(StudentInformation studentSSN) {
        this.studentSSN = studentSSN;
    }
    
}
