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
public final class StudentStatus {
    
    private int idStudentStatus;
    private String description = null;

    public StudentStatus() {}
    
    public StudentStatus( String description ) {
        setDescription(description);
    }

    public int getIdStudentStatus() {
        return idStudentStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setIdStudentStatus(int idStudentStatus) {
        this.idStudentStatus = idStudentStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
