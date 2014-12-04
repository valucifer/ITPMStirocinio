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
    
    private Person studentSSN = null;
    private String CVPath = null;
    private String ATPath = null;
    private StudentStatus studentStatus = null;
    
    public StudentInformation(){}
    
    public StudentInformation( Person studentSSN, String CVPath, String ATPath, StudentStatus studentStatus ){
        setATPath(ATPath);
        setCVPath(CVPath);
        setStudentSSN(studentSSN);
        setStudentStatus(studentStatus);
    }

    public Person getStudentSSN() {
        return studentSSN;
    }

    public String getCVPath() {
        return CVPath;
    }

    public String getATPath() {
        return ATPath;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentSSN(Person studentSSN) {
        this.studentSSN = studentSSN;
    }

    public void setCVPath(String CVPath) {
        this.CVPath = CVPath;
    }

    public void setATPath(String ATPath) {
        this.ATPath = ATPath;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }
    
}
