/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Questionnaire;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IQuestionnaire;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentino
 */
public class ConcreteQuestionnaire implements IQuestionnaire {
    
    private static ConcreteQuestionnaire instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    
    public static synchronized ConcreteQuestionnaire getInstance(){
        if(instance == null)
            instance = new ConcreteQuestionnaire();
        return instance;
    }
    
    private void initializeConnection(){
        try {
            if(connector.isClosed())
                connector = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteQuestionnaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ConcreteQuestionnaire() {
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    
    @Override
    public boolean insertQuestionnaire(Questionnaire aQuestionnaire) {
        initializeConnection();
        try {
            if( aQuestionnaire == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertQuestionnaire(?,?,?,?,?,?,?,?,?,?)}");       
            aCallableStatement.setString("studentSSN",aQuestionnaire.getStudentSSN());    
            aCallableStatement.setString("companyName",aQuestionnaire.getNomeAzienda());    
            aCallableStatement.setString("typologyOrganization",aQuestionnaire.getTipologiaAzienda());    
            aCallableStatement.setString("firs",aQuestionnaire.getPrimaDomanda());    
            aCallableStatement.setString("secon",aQuestionnaire.getSecondaDomanda());   
            aCallableStatement.setString("third",aQuestionnaire.getTerzaDomanda());    
            aCallableStatement.setString("fourth",aQuestionnaire.getQuartaDomanda());
            aCallableStatement.setString("fifth",aQuestionnaire.getQuintaDomanda());    
            aCallableStatement.setString("sixth",aQuestionnaire.getSestaDomanda()); 
            aCallableStatement.setString("seventh",aQuestionnaire.getSettimaDomanda());
            
            int check = aCallableStatement.executeUpdate();
            aCallableStatement.close();
            
            return check > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Questionnaire readQuestionnaire(String SSN) {
        initializeConnection();
        Questionnaire aQuestionnaire = null;
        try {
           aCallableStatement = connector.prepareCall("{call selectQuestionnaire(?)}");
           aCallableStatement.setString("studentSSN",SSN);    
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
                aQuestionnaire = new Questionnaire();
                aQuestionnaire.setNomeAzienda(rs.getString("company_name"));
                aQuestionnaire.setPrimaDomanda(rs.getString("first_question"));
                aQuestionnaire.setQuartaDomanda(rs.getString("fourth_question"));
                aQuestionnaire.setQuintaDomanda(rs.getString("fifth_question"));
                aQuestionnaire.setSecondaDomanda(rs.getString("second_question"));
                aQuestionnaire.setSestaDomanda(rs.getString("sixth_question"));
                aQuestionnaire.setSettimaDomanda(rs.getString("seventh_question"));
                aQuestionnaire.setStudentSSN(rs.getString("student_ssn"));
                aQuestionnaire.setTerzaDomanda(rs.getString("third_question"));
                aQuestionnaire.setTipologiaAzienda(rs.getString("typologt_organization"));
                
           }
           rs.close();
           return aQuestionnaire;
           
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

    @Override
    public ArrayList<Questionnaire> readAllQuestionnaire() {
        initializeConnection();
        ArrayList<Questionnaire> allQuestionnaires = new ArrayList<Questionnaire>();
        Questionnaire aQuestionnaire = null;
        try {
           aCallableStatement = connector.prepareCall("{call selectAllQuestionnaire()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
                aQuestionnaire = new Questionnaire();
                aQuestionnaire.setNomeAzienda(rs.getString("company_name"));
                aQuestionnaire.setPrimaDomanda(rs.getString("first_question"));
                aQuestionnaire.setQuartaDomanda(rs.getString("fourth_question"));
                aQuestionnaire.setQuintaDomanda(rs.getString("fifth_question"));
                aQuestionnaire.setSecondaDomanda(rs.getString("second_question"));
                aQuestionnaire.setSestaDomanda(rs.getString("sixth_question"));
                aQuestionnaire.setSettimaDomanda(rs.getString("seventh_question"));
                aQuestionnaire.setStudentSSN(rs.getString("student_ssn"));
                aQuestionnaire.setTerzaDomanda(rs.getString("third_question"));
                aQuestionnaire.setTipologiaAzienda(rs.getString("typologt_organization"));
                
                allQuestionnaires.add(aQuestionnaire);
           }
           rs.close();
           return allQuestionnaires;
           
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
    
}
