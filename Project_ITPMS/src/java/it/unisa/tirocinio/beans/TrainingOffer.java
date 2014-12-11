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
    private String organization = null;
    private String personSSN = null;
    private String department = null;
    private String contact = null;
    
    public TrainingOffer(){}
    
    public TrainingOffer(int idOfferTraining,String contact, String description, String organization, String personSSN, String department){
        setIdOfferTraining(idOfferTraining);
        setDescription(description);
        setOrganization(organization);
        setPersonSSN(personSSN);
        setDepartment(department);
        setContact(contact);
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public int getIdOfferTraining() {
        return idOfferTraining;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPersonSSN() {
        return personSSN;
    }

    public String getDepartment() {
        return department;
    }

    public void setIdOfferTraining(int idOfferTraining) {
        this.idOfferTraining = idOfferTraining;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPersonSSN(String personSSN) {
        this.personSSN = personSSN;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
