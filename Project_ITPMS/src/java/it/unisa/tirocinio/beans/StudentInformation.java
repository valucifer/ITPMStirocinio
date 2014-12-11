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
    
    private String studentSSN = null;
    private String CVPath = null;
    private String ATPath = null;
    private int studentStatus;
    private String matricula = null;
    
    public StudentInformation(){}
    
    public StudentInformation( String matricula, String studentSSN, String CVPath, String ATPath, int studentStatus ){
        setATPath(ATPath);
        setCVPath(CVPath);
        setStudentSSN(studentSSN);
        setStudentStatus(studentStatus);
        setMatricula(matricula);
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getStudentSSN() {
        return studentSSN;
    }

    public String getCVPath() {
        return CVPath;
    }

    public String getATPath() {
        return ATPath;
    }

    public int getStudentStatus() {
        return studentStatus;
    }

    public void setStudentSSN(String studentSSN) {
        this.studentSSN = studentSSN;
    }

    public void setCVPath(String CVPath) {
        this.CVPath = CVPath;
    }

    public void setATPath(String ATPath) {
        this.ATPath = ATPath;
    }

    public void setStudentStatus(int studentStatus) {
        this.studentStatus = studentStatus;
    }
    
}
