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
    
    /**
     *
     * @return a ConcreteQuestionnaire instance if there are no ConcreteQuestionnaire instances currently alive
     */
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
    
    /**
     *
     */
    public ConcreteQuestionnaire() {
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    /**
     *
     * @param aQuestionnaire
     * @return true if insert into Database operation is correct, false otherwise
     */
    @Override
    public boolean insertQuestionnaire(Questionnaire aQuestionnaire) {
        initializeConnection();
        try {
            if( aQuestionnaire == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertQuestionnaire(?,?,?,?,?,?,?,?,?,?)}");       
            aCallableStatement.setString("studentSSN",aQuestionnaire.getStudentSSN());    
            aCallableStatement.setString("companyName",aQuestionnaire.getOrganizationName());    
            aCallableStatement.setString("typologyOrganization",aQuestionnaire.getOrganizationType());    
            aCallableStatement.setString("firs",aQuestionnaire.getFirstQuestion());    
            aCallableStatement.setString("secon",aQuestionnaire.getSecondQuestion());   
            aCallableStatement.setString("third",aQuestionnaire.getThirdQuestion());    
            aCallableStatement.setString("fourth",aQuestionnaire.getFourthQuestion());
            aCallableStatement.setString("fifth",aQuestionnaire.getFifthQuestion());    
            aCallableStatement.setString("sixth",aQuestionnaire.getSixthQuestion()); 
            aCallableStatement.setString("seventh",aQuestionnaire.getSeventhQuestion());
            
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

    /**
     *
     * @param SSN
     * @return a Questionnaire object if reading operation from Database is correct, null otherwise
     */
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
                aQuestionnaire.setOrganizationName(rs.getString("company_name"));
                aQuestionnaire.setFirstQuestion(rs.getString("first_question"));
                aQuestionnaire.setFourthQuestion(rs.getString("fourth_question"));
                aQuestionnaire.setFifthQuestion(rs.getString("fifth_question"));
                aQuestionnaire.setSecondQuestion(rs.getString("second_question"));
                aQuestionnaire.setSixthQuestion(rs.getString("sixth_question"));
                aQuestionnaire.setSeventhQuestion(rs.getString("seventh_question"));
                aQuestionnaire.setStudentSSN(rs.getString("student_ssn"));
                aQuestionnaire.setThirdQuestion(rs.getString("third_question"));
                aQuestionnaire.setOrganizationType(rs.getString("typology_organization"));
                
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

    /**
     *
     * @return an ArrayList of Questionnaire containing all questionnaires if reading operation from Database is correct, null otherwise 
     */
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
                aQuestionnaire.setOrganizationName(rs.getString("company_name"));
                aQuestionnaire.setFirstQuestion(rs.getString("first_question"));
                aQuestionnaire.setFourthQuestion(rs.getString("fourth_question"));
                aQuestionnaire.setFifthQuestion(rs.getString("fifth_question"));
                aQuestionnaire.setSecondQuestion(rs.getString("second_question"));
                aQuestionnaire.setSixthQuestion(rs.getString("sixth_question"));
                aQuestionnaire.setSeventhQuestion(rs.getString("seventh_question"));
                aQuestionnaire.setStudentSSN(rs.getString("student_ssn"));
                aQuestionnaire.setThirdQuestion(rs.getString("third_question"));
                aQuestionnaire.setOrganizationType(rs.getString("typologt_organization"));
                
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
