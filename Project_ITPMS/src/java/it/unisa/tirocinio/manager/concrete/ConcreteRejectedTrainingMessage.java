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

    /**
     *
     * @param aRejectedTrainingMessage
     * @return true if a RejectedTrainingMessage is created without errors, false otherwise
     */
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
    
    /**
     *
     * @param aRejectedTrainingMessage
     * @return true if a RejectedTrainingMessage object is correctly updated
     */
    @Override
    public boolean updateRejectedTrainingMessage( RejectedTrainingMessage aRejectedTrainingMessage ){
        initializeConnection();
        try {
            if( aRejectedTrainingMessage == null )
                throw new NullPointerException("RejectedMessage is null!");
            
            aCallableStatement = connector.prepareCall("{call updateRejectedTrainingMessage(?,?)}");       
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

    /**
     *
     * @param idRejectedTrainingMessage
     * @return true if a certain RejectedTrainingMessage object is successfully deleted, false otherwise
     */
    @Override
    public boolean deleteOrganization(int idRejectedTrainingMessage) {
        initializeConnection();
        try {
            aCallableStatement = connector.prepareCall("{call deleteRejectedTrainingMessage(?)}");       
            aCallableStatement.setInt("pkRejectedTraining",idRejectedTrainingMessage);
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
     * @return a RejectedTrainingMessage object if reading operation from Database is correct, null otherwise
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

    /**
     *
     * @return an ArrayList of RejectedTrainingMessage which contains all rejected training messages
     */
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
    
    /**
     *
     * @return a ConcreteRejectedTrainingMessage object if there are no instances of ConcreteRejectedTrainingMessage currently alive
     */
    public static synchronized ConcreteRejectedTrainingMessage getInstance(){
        if(instance == null)
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

    /**
     *
     * @param ssn
     * @return a RejectedTrainingMessage if reading operation from Database is correct, null otherwise
     */
    @Override
    public RejectedTrainingMessage readLastTrainingMessage(String ssn) {
        initializeConnection();
        RejectedTrainingMessage aRejectedMessage = null;
        try {
            aRejectedMessage = new RejectedTrainingMessage();
            aCallableStatement = connector.prepareCall("{call getRejectedTrainingMessageBySSN(?)}");
            aCallableStatement.setString("ssn",ssn);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(ssn);
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
}
