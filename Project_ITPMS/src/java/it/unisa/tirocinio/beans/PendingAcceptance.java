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
    private Account accountStudentMail = null;
    
    public PendingAcceptance(){}
    
    public PendingAcceptance( Date requestDate, Account accountStudentMail ){
        setRequestDate(requestDate);
        setAccountStudentMail(accountStudentMail);
    }

    public int getIdPendingAcceptance() {
        return idPendingAcceptance;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Account getAccountStudentMail() {
        return accountStudentMail;
    }

    public void setIdPendingAcceptance(int idPendingAcceptance) {
        this.idPendingAcceptance = idPendingAcceptance;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setAccountStudentMail(Account accountStudentMail) {
        this.accountStudentMail = accountStudentMail;
    }
    
}
