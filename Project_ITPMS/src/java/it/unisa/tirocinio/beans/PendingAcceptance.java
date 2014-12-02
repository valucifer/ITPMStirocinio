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
public final class PendingAcceptance {
    
    private int idPendingAcceptance;
    private Date requestDate;
    private String fkStudentMail = null;
    
    public PendingAcceptance(){}
    
    public PendingAcceptance( Date requestDate, String fkStudentMail ){
        setRequestDate(requestDate);
        setFkStudentMail(fkStudentMail);
    }

    public int getIdPendingAcceptance() {
        return idPendingAcceptance;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getFkStudentMail() {
        return fkStudentMail;
    }

    public void setIdPendingAcceptance(int idPendingAcceptance) {
        this.idPendingAcceptance = idPendingAcceptance;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setFkStudentMail(String fkStudentMail) {
        this.fkStudentMail = fkStudentMail;
    }
    
}
