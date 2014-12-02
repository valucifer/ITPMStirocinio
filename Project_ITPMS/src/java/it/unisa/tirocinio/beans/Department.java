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
public final class Department {
    
    private String abbreviation = null;
    private String title = null;
    private String urlMoodle = null;
    private String token = null;
    
    public Department(){}
    public Department(String abbreviation, String title, String urlMoodle, String token){
        setAbbreviation(abbreviation);
        setTitle(title);
        setUrlMoodle(urlMoodle);
        setToken(token);
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlMoodle() {
        return urlMoodle;
    }

    public String getToken() {
        return token;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrlMoodle(String urlMoodle) {
        this.urlMoodle = urlMoodle;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
