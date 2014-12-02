/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author johneisenheim
 */
public final class Student {
    
    private String serialNumber = null;
    private String coverLetter = null;
    private Date yearsEnrollment = null;
    private int cycle;
    private String fkAccountEmail = null;
    private String fkPersonCF = null;
    private int fkDepartmentAbbreviation;
    private int fkStudentStatus;
    private int fkTrainingRequest;
    private int fkStudentInformation;
    
    public Student(){}
    
    public Student(String coverLetter, Date yearsEnrollment, int cycle, String fkAccountEmail, String fkPersonCF, int fkDepartment, int fkStudentStatus, int fkTrainingRequest, int fkStudentInformation){
        setCoverLetter(coverLetter);
        setYearsEnrollment(yearsEnrollment);
        setCycle(cycle);
        setFkAccountEmail(fkAccountEmail);
        setFkDepartmentAbbreviation(fkDepartmentAbbreviation);
        setFkPersonCF(fkPersonCF);
        setFkStudentStatus(fkStudentStatus);
        setFkTrainingRequest(fkTrainingRequest);
        setFkStudentInformation(fkStudentInformation);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public Date getYearsEnrollment() {
        return yearsEnrollment;
    }

    public int getCycle() {
        return cycle;
    }

    public String getFkAccountEmail() {
        return fkAccountEmail;
    }

    public String getFkPersonCF() {
        return fkPersonCF;
    }

    public int getFkDepartmentAbbreviation() {
        return fkDepartmentAbbreviation;
    }

    public int getFkStudentStatus() {
        return fkStudentStatus;
    }

    public int getFkTrainingRequest() {
        return fkTrainingRequest;
    }

    public int getFkStudentInformation() {
        return fkStudentInformation;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public void setYearsEnrollment(Date yearsEnrollment) {
        this.yearsEnrollment = yearsEnrollment;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public void setFkAccountEmail(String fkAccountEmail) {
        this.fkAccountEmail = fkAccountEmail;
    }

    public void setFkPersonCF(String fkPersonCF) {
        this.fkPersonCF = fkPersonCF;
    }

    public void setFkDepartmentAbbreviation(int fkDepartmentAbbreviation) {
        this.fkDepartmentAbbreviation = fkDepartmentAbbreviation;
    }

    public void setFkStudentStatus(int fkStudentStatus) {
        this.fkStudentStatus = fkStudentStatus;
    }

    public void setFkTrainingRequest(int fkTrainingRequest) {
        this.fkTrainingRequest = fkTrainingRequest;
    }

    public void setFkStudentInformation(int fkStudentInformation) {
        this.fkStudentInformation = fkStudentInformation;
    }
    
    
}
