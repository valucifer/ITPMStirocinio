package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.TrainingStatus;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.ITrainingStatus;
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
public class ConcreteTrainingStatus implements ITrainingStatus{
    
    private static ConcreteTrainingStatus instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteTrainingStatus(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    /**
     *
     * @param aStatus
     * @return true if a training status is successfully created, false otherwise
     */
    @Override
    public boolean createTrainingStatus(TrainingStatus aStatus) {
        initializeConnection();
        try {
            if( aStatus == null )
                throw new NullPointerException("TrainingStatus is null!");
            aCallableStatement = connector.prepareCall("{call insertTrainingStatus(?)}");       
            aCallableStatement.setString("description",aStatus.getDescription());
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
     * @return an ArrayList of TrainingStatus which contains all training status
     */
    @Override
    public ArrayList<TrainingStatus> getAllTrainingsStatus() {
        initializeConnection();
        ArrayList<TrainingStatus> trainingStatus = new ArrayList<TrainingStatus>();
        TrainingStatus aTrainingStatus = null;
        try {
           aCallableStatement = connector.prepareCall("{call getAllTrainingStatus()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aTrainingStatus = new TrainingStatus();
               aTrainingStatus.setIdTrainingStatus(rs.getInt("id_training_status"));
               aTrainingStatus.setDescription(rs.getString("description"));
               trainingStatus.add(aTrainingStatus);
           }
           rs.close();
           return trainingStatus;
           
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
     * @param idTrainingStatus
     * @return a TrainingStatus object if reading operation is correct, null otherwise
     */
    @Override
    public TrainingStatus readTrainingStatus(int idTrainingStatus) {
        initializeConnection();
        try {
            TrainingStatus aTrainingStatus = new TrainingStatus();
            aCallableStatement = connector.prepareCall("{call getTrainingStatus(?)}");
            aCallableStatement.setInt("pkTrainingStatus",idTrainingStatus);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingStatus.setIdTrainingStatus(rs.getInt("id_training_status"));
                aTrainingStatus.setDescription(rs.getString("description"));
            }
            rs.close();
            return aTrainingStatus;
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
     * @return a ConcreteTrainingStatus instance if there are no ConcreteTrainingStatus instances currently alive
     */
    public static synchronized ConcreteTrainingStatus getInstance(){
        if(instance == null)
            instance = new ConcreteTrainingStatus();
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
