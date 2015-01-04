package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public class Account {
    
    private String email = null;
    private String password = null;
    private String typeOfAccount = null;
    private int active;
    
    /**
     *
     */
    public Account(){}
    
    /**
     *
     * @param email
     * @param password
     * @param typeOfAccount
     * @param active
     */
    public Account(String email, String password, String typeOfAccount, int active){
        this.email = email;
        this.password = password;
        this.typeOfAccount = typeOfAccount;
        this.active = active;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param typeOfAccount
     */
    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    /**
     *
     * @return account email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return the account password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return type of account
     */
    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    /**
     *
     * @param active
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     *
     * @return true if account is active
     */
    public int getActive() {
        return active;
    }
    
    
}
