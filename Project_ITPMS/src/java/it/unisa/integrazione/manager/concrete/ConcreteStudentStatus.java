/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author albamansillacoca
 */
public class ConcreteStudentStatus implements StudentStatus{
    
    private int IDstudentStatus;
    private String description;
    
    public ConcreteStudentStatus(int IDstudentStatus, String description){
        this.IDstudentStatus=IDstudentStatus;
        this.description=description;
    }
    
    public ConcreteStudentStatus(){
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return ("IDstudentStatus: \n"+IDstudentStatus+"Description: \n"+description);
    }
    @Override
    public int getPrimaryKey() {
        return this.IDstudentStatus;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.IDstudentStatus = primaryKey;
    }
}
