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
        try {
            if( aRejectedTrainingMessage == null )
                throw new NullPointerException("RejectedMessage is null!");
            
            aCallableStatement = connector.prepareCall("{call insertRejectedTrainingMessage(?,?)}");       
            aCallableStatement.setString("message",aRejectedTrainingMessage.getDescription());
            aCallableStatement.setString("personSSN",aRejectedTrainingMessage.getPersonSSN());
            boolean toReturn = aCallableStatement.execute();
            //connector.close();
            
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deleteOrganization(int idRejectedTrainingMessage) {
        try {
            aCallableStatement = connector.prepareCall("{call deleteRejectedTrainingMessage(?)}");       
            aCallableStatement.setInt("pkRejectedMessage",idRejectedTrainingMessage);
            boolean toReturn = aCallableStatement.execute();
            //connector.close();
            
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param idRejectedTraingMessage
     * @return
     */
    @Override
    public RejectedTrainingMessage readTrainingMessage(int idRejectedTraingMessage) {
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
        }
    }

    @Override
    public ArrayList<RejectedTrainingMessage> getAllTrainingMessages() {
        
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
       }
    }
    
    public static ConcreteRejectedTrainingMessage getInstance(){
        instance = new ConcreteRejectedTrainingMessage();
        return instance;
    }
    
}
