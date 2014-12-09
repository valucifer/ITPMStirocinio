/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.PendingAcceptance;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IPendingAcceptance;
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
public class ConcretePendingAcceptance implements IPendingAcceptance{
    
    private static ConcretePendingAcceptance instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcretePendingAcceptance(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    @Override
    public PendingAcceptance readStudentInPendingAcceptance(int idPendingAcceptance) {
        initializeConnection();
        PendingAcceptance aStudentInPendingAcceptance = new PendingAcceptance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getPendingStudents(?)}");
            aCallableStatement.setInt("pkPersonSSN",idPendingAcceptance);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aStudentInPendingAcceptance.setIdPendingAcceptance(rs.getInt("id_pending_acceptance"));
                aStudentInPendingAcceptance.setRequestDate(rs.getDate("request_date"));
                aStudentInPendingAcceptance.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
            }
            rs.close();
            return aStudentInPendingAcceptance;
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
    public ArrayList<PendingAcceptance> getAllStudentsInPendingAcceptance() {
        initializeConnection();
        ArrayList<PendingAcceptance> studentsInPendingAcceptance = new ArrayList<PendingAcceptance>();
        PendingAcceptance aStudentInPendingAcceptance = null;
        try {
           ConcretePerson aPerson = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllOrganizations()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aStudentInPendingAcceptance = new PendingAcceptance();
               aStudentInPendingAcceptance.setIdPendingAcceptance(rs.getInt("id_pending_acceptance"));
               aStudentInPendingAcceptance.setRequestDate(rs.getDate("request_date"));
                aStudentInPendingAcceptance.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
               studentsInPendingAcceptance.add(aStudentInPendingAcceptance);
           }
           rs.close();
           return studentsInPendingAcceptance;
           
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
    
    public static synchronized ConcretePendingAcceptance getInstance(){
        if(instance == null)
            instance = new ConcretePendingAcceptance();
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
