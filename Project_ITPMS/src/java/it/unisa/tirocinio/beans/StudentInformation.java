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
public final class StudentInformation {
    
    private int idStudentInformation;
    private String CVPath = null;
    private String ATPath = null;
    
    public StudentInformation(){}
    
    public StudentInformation( String CVPath, String ATPath ){
        setATPath(ATPath);
        setCVPath(CVPath);
    }

    public int getIdStudentInformation() {
        return idStudentInformation;
    }

    public String getCVPath() {
        return CVPath;
    }

    public String getATPath() {
        return ATPath;
    }

    public void setIdStudentInformation(int idStudentInformation) {
        this.idStudentInformation = idStudentInformation;
    }

    public void setCVPath(String CVPath) {
        this.CVPath = CVPath;
    }

    public void setATPath(String ATPath) {
        this.ATPath = ATPath;
    }
    
}
