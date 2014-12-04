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
public final class TrainingOffer {
   
    private int idOfferTraining;
    private String description;
    private Organization organization = null;
    private Person personSSN = null;
    private Department department = null;
    
    public TrainingOffer(){}
    
    public TrainingOffer(int idOfferTraining, String description, Organization organization, Person personSSN, Department department){
        setIdOfferTraining(idOfferTraining);
        setDescription(description);
        setOrganization(organization);
        setPersonSSN(personSSN);
        setDepartment(department);
    }

    public int getIdOfferTraining() {
        return idOfferTraining;
    }
    
    public void setIdOfferTraining(int newId){
        idOfferTraining = newId;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }
    
     public void setPersonSSN(Person personSSN) {
        this.personSSN = personSSN;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getPersonSSN() {
        return personSSN;
    }

    public Department getDepartment() {
        return department;
    }
    
}
