/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

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

    @Override
    public boolean updateStudentInformation(StudentInformation aStudentInformation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean startTrainingRequest(String studentSSN, String CVPath, String ATPath) {
        try {
            aCallableStatement = connector.prepareCall("{call storeUploadFile(?,?,?)}");
            aCallableStatement.setString("CVPath",CVPath);
            aCallableStatement.setString("ATPath",ATPath);
            aCallableStatement.setString("studentSSN",studentSSN);
            boolean toReturn = aCallableStatement.execute();
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean deleteStudentInformation(Person aStudent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changeStudentStatus(String studentSSN, StudentStatus newStatus) {
        try {
            aCallableStatement = connector.prepareCall("{call changeStudentStatus(?,?)}");
            aCallableStatement.setString("studentSSN",studentSSN);
            aCallableStatement.setInt("status",newStatus.getIdStudentStatus());
            boolean toReturn = aCallableStatement.execute();
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public StudentInformation readStudentInformation(String studentSSN) {
        StudentInformation aStudentInformation = new StudentInformation();
        ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getStudentInformation(?)}");
            aCallableStatement.setString("ssn",studentSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aStudentInformation.setStudentSSN(studentSSN);
                aStudentInformation.setATPath(rs.getString(1));
                aStudentInformation.setATPath(rs.getString(2));
                aStudentInformation.setStudentStatus(aStudentStatus.readStudentStatus(rs.getInt(4)).getIdStudentStatus());
            }
            rs.close();
            return aStudentInformation;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<StudentInformation> getAllStudentInformations() {
        ArrayList<StudentInformation> studentInformations = new ArrayList<StudentInformation>();
        StudentInformation aStudentInformation = null;
        try {
           ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
           ConcretePerson aPerson = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllStudentInformation()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aStudentInformation = new StudentInformation();
               aStudentInformation.setStudentSSN(aPerson.readPerson(rs.getString("SSN")).getSSN());
               aStudentInformation.setATPath(rs.getString("curriculum_vitae_path"));
               aStudentInformation.setATPath(rs.getString("accademic_transcription_path"));
               aStudentInformation.setStudentStatus(aStudentStatus.readStudentStatus(rs.getInt("fk_student_status")).getIdStudentStatus());
               studentInformations.add(aStudentInformation);
           }
           rs.close();
           return studentInformations;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
    
    public static ConcreteStudentInformation getInstance(){
        instance = new ConcreteStudentInformation();
        return instance;
    }
}
