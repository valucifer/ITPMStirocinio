/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author katiasolomita
 */
public class ConcreteOfferTraining implements OfferTraining{

   private int idOfferTraining;
   private String description;
   private int FK_Organization;
   private int FK_Department;
   private int FK_Professor;
   private int Organization_idOrganization;
           
    public ConcreteOfferTraining(){
    }
    
    public ConcreteOfferTraining(int idOfferTraining, String description,int FK_Department,int FK_Professor, int FK_Organization, int Organization_idOrganization){
        this.idOfferTraining=idOfferTraining;
        this.description=description;
        this.FK_Organization= FK_Organization;
        this.FK_Department= FK_Department;
        this.FK_Professor= FK_Professor;
        this.Organization_idOrganization=Organization_idOrganization;
    }
    
    public int getPrimaryKey() {
        return idOfferTraining;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idOfferTraining=primaryKey;
    }
    
    public int getFKProfessor() {
        return this.FK_Professor;
    }

    public void setFKProfessor(int fkProf) {
        this.FK_Professor=fkProf;
    }
    
    public int getFKDepartment() {
        return this.FK_Department;
    }

    public void setFKDepartment(int fkDep) {
        this.FK_Department=fkDep;
    }
    
    public int getidOfferTraining(){
        return idOfferTraining;
    }
    
    public void setidOfferTraining(int idOfferTraining){
        this.idOfferTraining=idOfferTraining;
    }
    
    public int getFKOrganization(){
        return FK_Organization;
    }
    
    public void setFKOrganization(int FK_Organization){
        this.FK_Organization=FK_Organization;
    }
    
    public int getOrganization_idOrganization(){
        return Organization_idOrganization;
    }
    
    public void setOrganization_idOrganization(int Organization_idOrganization){
        this.Organization_idOrganization= Organization_idOrganization;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String descr){
        this.description= descr;
    }
            
}
