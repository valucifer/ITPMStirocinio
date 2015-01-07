package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IAccount;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johneisenheim
 */
public class ConcreteAccount implements IAccount{
    
    private static ConcreteAccount instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteAccount(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    /**
     *
     * @param account
     * @return true if account is created, false otherwise 
     */
    public boolean createAccount(Account account){
        initializeConnection();
        try {
            if( account == null )
                throw new NullPointerException("Account is null!");
            
            aCallableStatement = connector.prepareCall("{call insertAccount(?,?,?,?)}");       
            aCallableStatement.setString("emailInput",account.getEmail());
            aCallableStatement.setString("passwordInput",account.getPassword());
            aCallableStatement.setString("typology",account.getTypeOfAccount());
            aCallableStatement.setBoolean("activeInput",account.isActive());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     * @param email
     * @return an Account object if reading operation is correct, null otherwise
     */
    @Override
    public Account readAccount(String email) {
        initializeConnection();
        try {
            Account anAccount = new Account();
            aCallableStatement = connector.prepareCall("{call getAccount(?)}");
            aCallableStatement.setString("pkAccount",email);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                anAccount.setEmail(rs.getString("email"));
                anAccount.setPassword(rs.getString("password"));
                anAccount.setTypeOfAccount(rs.getString("typeOfAccount"));
                anAccount.setActive(rs.getBoolean("active"));
            }
            rs.close();
            return anAccount;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of Account if DB select is correct, null otherwise
     */
    @Override
    public ArrayList<Account> getAllAccounts() {
        initializeConnection();
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account anAccount = null;
        try {
            aCallableStatement = connector.prepareCall("{call getAllAccounts()}");
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                anAccount = new Account();
                anAccount.setEmail(rs.getString("email"));
                anAccount.setPassword(rs.getString("password"));
                anAccount.setTypeOfAccount(rs.getString("typeOfAccount"));
                anAccount.setActive(rs.getBoolean("active"));
                accounts.add(anAccount);
            }
            rs.close();
            return accounts;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
    /**
     *
     * @return a new instance of ConcreteAccount if there is any instance of ConcreteAccount alive
     */
    public static synchronized ConcreteAccount getInstance(){
        if(instance == null)
            instance = new ConcreteAccount();
        return instance;
    }

    /**
     *
     * @param email
     * @return type of account
     */
    @Override
    public String getTypeOfAccount(String email) {
        initializeConnection();
        try {
            String aTypeOfAccount = null;
            aCallableStatement = connector.prepareCall("{call getTypeOfAccount(?)}");
            aCallableStatement.setString("pkAccount",email);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTypeOfAccount = rs.getString("typeOfAccount");
            }
            rs.close();
            return aTypeOfAccount;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void initializeConnection(){
        try {
            if(connector.isClosed())
                connector = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
