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
    private Account accountEmail = null;
    private Person personFiscalCode = null;
    private Department departmentAbbreviation;
    private StudentStatus studentStatus;
    private TrainingRequest trainingRequest;
    private StudentInformation studentInformation;
    
    public Student(){}
    
    public Student(String coverLetter, Date yearsEnrollment, int cycle, Account accountEmail, Person personFiscalCode, Department departmentAbbreviation, StudentStatus studentStatus, TrainingRequest trainingRequest, StudentInformation studentInformation){
        setCoverLetter(coverLetter);
        setYearsEnrollment(yearsEnrollment);
        setCycle(cycle);
        setAccountEmail(accountEmail);
        setDepartmentAbbreviation(departmentAbbreviation);
        setPersonFiscalCode(personFiscalCode);
        setStudentStatus(studentStatus);
        setTrainingRequest(trainingRequest);
        setStudentInformation(studentInformation);
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

    public Account getAccountEmail() {
        return accountEmail;
    }

    public Person getPersonFiscalCode() {
        return personFiscalCode;
    }

    public Department getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public TrainingRequest getTrainingRequest() {
        return trainingRequest;
    }

    public StudentInformation getStudentInformation() {
        return studentInformation;
    }

    public void setAccountEmail(Account accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setPersonFiscalCode(Person personFiscalCode) {
        this.personFiscalCode = personFiscalCode;
    }

    public void setDepartmentAbbreviation(Department departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public void setTrainingRequest(TrainingRequest trainingRequest) {
        this.trainingRequest = trainingRequest;
    }

    public void setStudentInformation(StudentInformation studentInformation) {
        this.studentInformation = studentInformation;
    }
    
}
