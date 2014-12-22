/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.AccountNotActiveException;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.manager.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gemmacatolino
 */
public class AccountManager {

    private static AccountManager instance;

    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;

    }

    public Account login(String pUsername, String pPassword) throws AccountNotActiveException,  SQLException, ConnectionException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        Account person = null;

        String query = "select * from account where email='" + pUsername + "' and password='" + pPassword + "'";

        try {
            connection = DBConnector.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setTypeOfAccount(rs.getString("typeOfAccount"));
                account.setActive(rs.getInt("active"));
                
                person = account;
                if(account.getActive()==0) {
                    throw new AccountNotActiveException();
                }

            }
        } finally {
            if(rs != null)
                rs.close();
            
            if(stmt != null)
                stmt.close();
            
            if(connection != null)
                connection.close();
        }
        
        return person;
    }

    private Person getPersonByEmail(String pEmail) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person person = null;

        String query = "select * from person where Account_email = '" + pEmail + "'";
        
        try {
            connection = DBConnector.getConnection();
            
            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setSSN(rs.getString("SSN"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPhone(rs.getString("phone"));
                person.setCity(rs.getString("city"));
                person.setAddress(rs.getString("address"));
                person.setZipCode(rs.getString("zip_code"));
                person.setGender(rs.getString("gender"));
                person.setCitizenship(rs.getString("citizenship"));
                person.setWebPage(rs.getString("web_page"));
                person.setUniversity(rs.getString("university"));
                person.setMatricula(rs.getString("matricula"));
                person.setPosition(rs.getString("position"));
                person.setCycle(rs.getInt("cycle"));
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return person;
    }

}