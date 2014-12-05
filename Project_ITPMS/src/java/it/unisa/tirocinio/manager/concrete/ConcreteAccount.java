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
        instance = new ConcreteAccount();
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public Account readAccount(String email) {
        try {
            Account anAccount = new Account();
            aCallableStatement = connector.prepareCall("{call getAccount(?)}");
            aCallableStatement.setString("pkAccount",email);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                anAccount.setEmail(rs.getString("email"));
                anAccount.setPassword(rs.getString("password"));
                anAccount.setTypeOfAccount(rs.getString("type_of_account"));
                anAccount.setActive(rs.getInt("active"));
            }
            rs.close();
            return anAccount;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account anAccount = null;
        try {
            aCallableStatement = connector.prepareCall("{call getAllAccounts()}");
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
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
       }
       
    }
    
    public static ConcreteAccount getInstance(){
        return instance;
    }

    @Override
    public String getTypeOfAccount(String email) {
        try {
            String aTypeOfAccount = null;
            aCallableStatement = connector.prepareCall("{call getTypeOfAccount(?)}");
            aCallableStatement.setString("pkAccount",email);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                aTypeOfAccount = rs.getString("typeOfAccount");
            }
            rs.close();
            return aTypeOfAccount;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
