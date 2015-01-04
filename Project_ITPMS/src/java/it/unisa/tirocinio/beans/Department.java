package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public class Department {
    
    private String abbreviation = null;
    private String title = null;
    private String urlMoodle = null;
    private String token = null;
    
    /**
     *
     */
    public Department(){}

    /**
     *
     * @param abbreviation
     * @param title
     * @param urlMoodle
     * @param token
     */
    public Department(String abbreviation, String title, String urlMoodle, String token){
        this.abbreviation = abbreviation;
        this.title = title;
        this.urlMoodle = urlMoodle;
        this.token = token;
    }
    
    /**
     *
     * @return department abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     *
     * @return title 
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return urlMoodle
     */
    public String getUrlMoodle() {
        return urlMoodle;
    }

    /**
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param urlMoodle
     */
    public void setUrlMoodle(String urlMoodle) {
        this.urlMoodle = urlMoodle;
    }

    /**
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }
    
}
