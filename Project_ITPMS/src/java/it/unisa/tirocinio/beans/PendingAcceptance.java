/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

import java.sql.Date;

/**
 *
 * @author johneisenheim
 */
public final class PendingAcceptance {
    
    private int idPendingAcceptance;
    private Date requestDate;
    private String personSSN = null;
    
    public PendingAcceptance(){}
    
    public PendingAcceptance( int idPendingAcceptance, Date requestDate, String personSSN ){
        setIdPendingAcceptance(idPendingAcceptance);
        setRequestDate(requestDate);
        setPersonSSN(personSSN);
    }

    public int getIdPendingAcceptance() {
        return idPendingAcceptance;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getPersonSSN() {
        return personSSN;
    }

    public void setIdPendingAcceptance(int idPendingAcceptance) {
        this.idPendingAcceptance = idPendingAcceptance;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setPersonSSN(String personSSN) {
        this.personSSN = personSSN;
    }
    
}
