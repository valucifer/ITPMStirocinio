package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.tirocinio.beans.RejectedTrainingMessage;
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
public class ConcreteRejectedTrainingMessage implements IRejectedTrainingMessage {

    private static ConcreteRejectedTrainingMessage instance = null;
    private CallableStatement aCallableStatement = null;

    /**
     *
     * @param aRejectedTrainingMessage
     * @return true if a RejectedTrainingMessage is created without errors,
     * false otherwise
     */
    @Override
    public boolean createRejectedTrainingMessage(RejectedTrainingMessage aRejectedTrainingMessage) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            if (aRejectedTrainingMessage == null) {
                throw new NullPointerException("RejectedMessage is null!");
            }

            aCallableStatement = connect.prepareCall("{call insertRejectedTrainingMessage(?,?)}");
            aCallableStatement.setString("message", aRejectedTrainingMessage.getDescription());
            aCallableStatement.setString("personSSN", aRejectedTrainingMessage.getPersonSSN());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param aRejectedTrainingMessage
     * @return true if a RejectedTrainingMessage object is correctly updated
     */
    @Override
    public boolean updateRejectedTrainingMessage(RejectedTrainingMessage aRejectedTrainingMessage) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            if (aRejectedTrainingMessage == null) {
                throw new NullPointerException("RejectedMessage is null!");
            }

            aCallableStatement = connect.prepareCall("{call updateRejectedTrainingMessage(?,?)}");
            aCallableStatement.setString("message", aRejectedTrainingMessage.getDescription());
            aCallableStatement.setString("personSSN", aRejectedTrainingMessage.getPersonSSN());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param idRejectedTrainingMessage
     * @return true if a certain RejectedTrainingMessage object is successfully
     * deleted, false otherwise
     */
    @Override
    public boolean deleteOrganization(int idRejectedTrainingMessage) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call deleteRejectedTrainingMessage(?)}");
            aCallableStatement.setInt("pkRejectedTraining", idRejectedTrainingMessage);
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param idRejectedTraingMessage
     * @return a RejectedTrainingMessage object if reading operation from
     * Database is correct, null otherwise
     */
    @Override
    public RejectedTrainingMessage readTrainingMessage(int idRejectedTraingMessage) {
        Connection connect = null;
        RejectedTrainingMessage aRejectedMessage = new RejectedTrainingMessage();
        PersonManager aPerson = PersonManager.getInstance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getRejectedTrainingMessage(?)}");
            aCallableStatement.setInt("pkRejectedTrainingMessage", idRejectedTraingMessage);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(rs.getString("fk_person"));
            }
            rs.close();
            return aRejectedMessage;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of RejectedTrainingMessage which contains all
     * rejected training messages
     */
    @Override
    public ArrayList<RejectedTrainingMessage> getAllTrainingMessages() {
        Connection connect = null;
        ArrayList<RejectedTrainingMessage> rejectedMessages = new ArrayList<RejectedTrainingMessage>();
        RejectedTrainingMessage aRejectedMessage = null;
        try {
            connect = DBConnection.getConnection();
            PersonManager aPerson = PersonManager.getInstance();
            aCallableStatement = connect.prepareCall("{call getAllRejectedTrainingMessage()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(rs.getString("fk_person"));
                rejectedMessages.add(aRejectedMessage);
            }
            rs.close();
            return rejectedMessages;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcreteRejectedTrainingMessage object if there are no
     * instances of ConcreteRejectedTrainingMessage currently alive
     */
    public static synchronized ConcreteRejectedTrainingMessage getInstance() {
        if (instance == null) {
            instance = new ConcreteRejectedTrainingMessage();
        }
        return instance;
    }

    /**
     *
     * @param ssn
     * @return a RejectedTrainingMessage if reading operation from Database is
     * correct, null otherwise
     */
    @Override
    public RejectedTrainingMessage readLastTrainingMessage(String ssn) {
        Connection connect = null;
        RejectedTrainingMessage aRejectedMessage = null;
        try {
            connect = DBConnection.getConnection();
            aRejectedMessage = new RejectedTrainingMessage();
            aCallableStatement = connect.prepareCall("{call getRejectedTrainingMessageBySSN(?)}");
            aCallableStatement.setString("ssn", ssn);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aRejectedMessage.setDescription(rs.getString("description"));
                aRejectedMessage.setIdRejectedTraingMessage(rs.getInt("id_rejected_training_message"));
                aRejectedMessage.setPersonSSN(ssn);
            }
            rs.close();
            return aRejectedMessage;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteRejectedTrainingMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
