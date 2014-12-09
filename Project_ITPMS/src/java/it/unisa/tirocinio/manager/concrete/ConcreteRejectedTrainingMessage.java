/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.RejectedTrainingMessage;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IRejectedTrainingMessage;
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
public class ConcreteRejectedTrainingMessage implements IRejectedTrainingMessage{

    
    private static ConcreteRejectedTrainingMessage instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteRejectedTrainingMessage(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createRejectedTrainingMessage(RejectedTrainingMessage aRejectedTrainingMessage) {
        initializeConnection();
        try {
            if( aRejectedTrainingMessage == null )
                throw new NullPointerException("RejectedMessage is null!");
            
            aCallableStatement = connector.prepareCall("{call insertRejectedTrainingMessage(?,?)}");       
            aCallableStatement.setString("message",aRejectedTrainingMessage.getDescription());
            aCallableStatement.setString("personSSN",aRejectedTrainingMessage.getPersonSSN());
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

    @Override
    public boolean deleteOrganization(int idRejectedTrainingMessage) {
        initializeConnection();
        try {
            aCallableStatement = connector.prepareCall("{call deleteRejectedTrainingMessage(?)}");       
            aCallableStatement.setInt("pkRejectedMessage",idRejectedTrainingMessage);
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
     * @param idRejectedTraingMessage
     * @return
     */
    @Override
    public RejectedTrainingMessage readTrainingMessage(int idRejectedTraingMessage) {
        initializeConnection();
        RejectedTrainingMessage aRejectedMessage = new RejectedTrainingMessage();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getRejectedTrainingMessage(?)}");
            aCallableStatement.setInt("pkRejectedTrainingMessage",idRejectedTraingMessage);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
            }
            rs.close();
            return aRejectedMessage;
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
    public ArrayList<RejectedTrainingMessage> getAllTrainingMessages() {
        initializeConnection();        
        ArrayList<RejectedTrainingMessage> rejectedMessages = new ArrayList<RejectedTrainingMessage>();
        RejectedTrainingMessage aRejectedMessage = null;
        try {
            ConcretePerson aPerson = ConcretePerson.getInstance();
            aCallableStatement = connector.prepareCall("{call getAllRejectedTrainingMessage()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while( rs.next() ){
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                rejectedMessages.add(aRejectedMessage);
            }
            rs.close();
            return rejectedMessages;
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
    
<<<<<<< Updated upstream
    public static synchronized ConcreteRejectedTrainingMessage getInstance(){
        if(instance == null)
=======
    public static ConcreteRejectedTrainingMessage getInstance(){
        if( instance == null )
>>>>>>> Stashed changes
            instance = new ConcreteRejectedTrainingMessage();
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
