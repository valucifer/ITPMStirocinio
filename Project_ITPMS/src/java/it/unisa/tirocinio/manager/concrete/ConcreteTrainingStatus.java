/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @Override
    public boolean createTrainingStatus(TrainingStatus aStatus) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            if( aStatus == null )
                throw new NullPointerException("TrainingStatus is null!");
            aCallableStatement = connector.prepareCall("{call insertTrainingStatus(?)}");       
            aCallableStatement.setString("description",aStatus.getDescription());
            boolean toReturn = aCallableStatement.execute();
            //connector.close();
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<TrainingStatus> getAllTrainingsStatus() {
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
       }
    }

    @Override
    public TrainingStatus readTrainingStatus(int idTrainingStatus) {
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
        }
    }
    
    public static ConcreteTrainingStatus getInstance(){
        instance = new ConcreteTrainingStatus();
        return instance;
    }
}
