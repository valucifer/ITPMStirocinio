package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.beans.StudentStatus;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IStudentInformation;
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
public class ConcreteStudentInformation implements IStudentInformation{
    
    private static ConcreteStudentInformation instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteStudentInformation(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    /**
     *
     * @param aStudentInformation
     * @return true if a student's informations are updated, false otherwise
     */
    @Override
    public boolean updateStudentInformation(StudentInformation aStudentInformation) {
        initializeConnection();
        try {
            if( aStudentInformation == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call updateStudentInformation(?,?,?,?)}");       
            aCallableStatement.setString("ss",aStudentInformation.getStudentSSN());
            aCallableStatement.setString("CV",aStudentInformation.getCVPath());
            aCallableStatement.setString("AcT",aStudentInformation.getATPath());
            aCallableStatement.setInt("fk_status",aStudentInformation.getStudentStatus());
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
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     * @param studentSSN
     * @param CVPath
     * @param ATPath
     * @return true if a trining request is started successfully, false otherwise
     */
    @Override
    public boolean startTrainingRequest(String studentSSN, String CVPath, String ATPath) {
        initializeConnection();
        try {
            aCallableStatement = connector.prepareCall("{call storeUploadFile(?,?,?)}");
            aCallableStatement.setString("CVPath",CVPath);
            aCallableStatement.setString("ATPath",ATPath);
            aCallableStatement.setString("studentSSN",studentSSN);
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
     * @param aStudent
     * @return
     */
    @Override
    public boolean deleteStudentInformation(Person aStudent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param studentSSN
     * @param newStatus
     * @return true if a student status is successfully changed, false otherwise
     */
    @Override
    public boolean changeStudentStatus(String studentSSN, StudentStatus newStatus) {
        initializeConnection();
        try {
            aCallableStatement = connector.prepareCall("{call changeStudentStatus(?,?)}");
            aCallableStatement.setString("studentSSN",studentSSN);
            aCallableStatement.setInt("status",newStatus.getIdStudentStatus());
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
     * @param studentSSN
     * @return a StudentInformation object if there is a student represented by a certain student SSN
     */
    public StudentInformation readAStudentInformation (String studentSSN){
        initializeConnection();
        StudentInformation aStudentInformation = new StudentInformation();
        ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getStudentInformation(?)}");
            aCallableStatement.setString("ss",studentSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                Person person = aPerson.readPerson(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getSSN());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(rs.getInt("fk_student_status"));
            }
            rs.close();
            return aStudentInformation;
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
     * @param studentSSN
     * @return a StudentInformation object if there is a student with a student SSN into Database, null otherwise
     */
    @Override
    public StudentInformation readStudentInformation(String studentSSN) {
        initializeConnection();
        StudentInformation aStudentInformation = new StudentInformation();
        ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getStudentInformation(?)}");
            aCallableStatement.setString("ss",studentSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                Person person = aPerson.readPerson(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getName()+" "+person.getSurname());
                aStudentInformation.setMatricula(person.getMatricula());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(aStudentStatus.readStudentStatus(rs.getInt("fk_student_status")).getIdStudentStatus());
            }
            rs.close();
            return aStudentInformation;
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
     * @return an ArrayList of StudentInformation which contains all informations of a certain student
     */
    @Override
    public ArrayList<StudentInformation> getAllStudentInformations() {
        initializeConnection();
        ArrayList<StudentInformation> studentInformations = new ArrayList<StudentInformation>();
        StudentInformation aStudentInformation = null;
        try {
           ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
           ConcretePerson aPerson = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllStudentInformation()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
                aStudentInformation = new StudentInformation();
                Person person = aPerson.readPerson(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getName()+" "+person.getSurname());
                aStudentInformation.setMatricula(person.getMatricula());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(aStudentStatus.readStudentStatus(rs.getInt("fk_student_status")).getIdStudentStatus());
                Account account = person.getAccount();
                aStudentInformation.setEmailStudent(account.getEmail());
                studentInformations.add(aStudentInformation);
           }
           rs.close();
           return studentInformations;
           
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
     * @return a ConcreteStudentInformation object if no ConcreteStudentInformation object are alive
     */
    public static synchronized ConcreteStudentInformation getInstance(){
        if(instance == null)
            instance = new ConcreteStudentInformation();
        return instance;
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
