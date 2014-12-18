/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

/**
 *
 * @author Valentino
 */
public class Questionnaire {
    private String nomeAzienda = null;
    private String tipologiaAzienda = null;
    private String primaDomanda = null;
    private String secondaDomanda = null;
    private String terzaDomanda = null;
    private String quartaDomanda = null;
    private String quintaDomanda = null;
    private String sestaDomanda = null;
    private String settimaDomanda = null;
    private String studentSSN = null;

    public Questionnaire(String nomeAzienda, String tipologiaAzienda, String primaDomanda, String secondaDomanda, String studentSSN, String terzaDomanda, String quartaDomanda, String quintaDomanda, String sestaDomanda, String settimaDomanda) {
        setNomeAzienda(nomeAzienda);
        setTipologiaAzienda(tipologiaAzienda);
        setPrimaDomanda(primaDomanda);
        setSecondaDomanda(secondaDomanda);
        setTerzaDomanda(terzaDomanda);
        setQuartaDomanda(quartaDomanda);
        setQuintaDomanda(quintaDomanda);
        setSestaDomanda(sestaDomanda);
        setSettimaDomanda(settimaDomanda);
        setStudentSSN(studentSSN);
    }

    public String getStudentSSN() {
        return studentSSN;
    }

    public void setStudentSSN(String studentSSN) {
        this.studentSSN = studentSSN;
    }
    
    public Questionnaire() {
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getTipologiaAzienda() {
        return tipologiaAzienda;
    }

    public String getPrimaDomanda() {
        return primaDomanda;
    }

    public String getSecondaDomanda() {
        return secondaDomanda;
    }

    public String getTerzaDomanda() {
        return terzaDomanda;
    }

    public String getQuartaDomanda() {
        return quartaDomanda;
    }

    public String getQuintaDomanda() {
        return quintaDomanda;
    }

    public String getSestaDomanda() {
        return sestaDomanda;
    }

    public String getSettimaDomanda() {
        return settimaDomanda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public void setTipologiaAzienda(String tipologiaAzienda) {
        this.tipologiaAzienda = tipologiaAzienda;
    }

    public void setPrimaDomanda(String primaDomanda) {
        this.primaDomanda = primaDomanda;
    }

    public void setSecondaDomanda(String secondaDomanda) {
        this.secondaDomanda = secondaDomanda;
    }

    public void setTerzaDomanda(String terzaDomanda) {
        this.terzaDomanda = terzaDomanda;
    }

    public void setQuartaDomanda(String quartaDomanda) {
        this.quartaDomanda = quartaDomanda;
    }

    public void setQuintaDomanda(String quintaDomanda) {
        this.quintaDomanda = quintaDomanda;
    }

    public void setSestaDomanda(String sestaDomanda) {
        this.sestaDomanda = sestaDomanda;
    }

    public void setSettimaDomanda(String settimaDomanda) {
        this.settimaDomanda = settimaDomanda;
    }
    
    
    
    
}
