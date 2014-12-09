/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @Override
    public Account readAccount(String email) {
        initializeConnection();
        try {
            Account anAccount = new Account();
            aCallableStatement = connector.prepareCall("{call getAccount(?)}");
            aCallableStatement.setString("pkAccount",email);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                anAccount.setEmail(rs.getString(1));
                anAccount.setPassword(rs.getString(2));
                anAccount.setTypeOfAccount(rs.getString(3));
                anAccount.setActive(rs.getInt(4));
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
                anAccount.setTypeOfAccount(rs.getString("type_of_account"));
                anAccount.setActive(rs.getInt("active"));
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
    
    public static synchronized ConcreteAccount getInstance(){
        if(instance == null)
            instance = new ConcreteAccount();
        return instance;
    }

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
