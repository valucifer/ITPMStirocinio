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
public final class OfferTraining {
   
    private int idOfferTraining;
    private String description;
    private Organization organization = null;
    private Person professor = null;
    private Department department = null;
    
    public OfferTraining(){}
    
    public OfferTraining(String description, Organization organization, Person professor, Department department){
        setDescription(description);
        setOrganization(organization);
        setProfessor(professor);
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
    
     public void setProfessor(Person professor) {
        this.professor = professor;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getProfessor() {
        return professor;
    }

    public Department getDepartment() {
        return department;
    }
    
}
