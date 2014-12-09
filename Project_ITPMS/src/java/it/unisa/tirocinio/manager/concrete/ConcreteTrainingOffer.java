/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.TrainingOffer;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.ITrainingOffer;
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
public class ConcreteTrainingOffer implements ITrainingOffer{
    
    private static ConcreteTrainingOffer instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteTrainingOffer(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createInnerTrainingOffer(TrainingOffer aTrainingOffer) {
        initializeConnection();
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertInnerTraining(?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment());
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
    
    @Override
    public boolean createOuterTrainingOffer(TrainingOffer aTrainingOffer) {
        initializeConnection();
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertOuterTraining(?,?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization",aTrainingOffer.getOrganization());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment());
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
    

    @Override
    public boolean updateTrainingOffer(TrainingOffer aTrainingOffer) {
        initializeConnection();
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call updateTrainingOffer(?,?,?,?,?)}");       
            aCallableStatement.setInt("idTrainingOffer",aTrainingOffer.getIdOfferTraining());
            aCallableStatement.setString("description",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization",aTrainingOffer.getOrganization());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment());
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

    @Override
    public TrainingOffer readTrainingOffer(int idTrainingOffer) {
        initializeConnection();
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getTrainingOffer(?)}");
            aCallableStatement.setInt("pkTrainingOffer",idTrainingOffer);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
            }
            rs.close();
            return aTrainingOffer;
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
    
    @Override
    public TrainingOffer readInnerTrainingOffer(String personSSN) {
        initializeConnection();
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getInnerTrainingOffer(?)}");
            aCallableStatement.setString("pkProfessor",personSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
            }
            rs.close();
            return aTrainingOffer;
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

    @Override
    public TrainingOffer readOuterTrainingOffer(String vatNumber) {
        initializeConnection();
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOuterTrainingOffer(?)}");
            aCallableStatement.setString("pkOrganization",vatNumber);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
            }
            rs.close();
            return aTrainingOffer;
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

    @Override
    public ArrayList<TrainingOffer> getAllTrainingOffers() {
        initializeConnection();
        ArrayList<TrainingOffer> trainingOffers = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        try {
           ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
           ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
           ConcretePerson aPerson = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllTrainingOffers()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aTrainingOffer = new TrainingOffer();
               aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
               aTrainingOffer.setDescription(rs.getString("description"));
               aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
               aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
               aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
               trainingOffers.add(aTrainingOffer);
           }
           rs.close();
           return trainingOffers;
           
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
    
<<<<<<< Updated upstream
    public static synchronized ConcreteTrainingOffer getInstance(){
        if(instance == null)
=======
    public static ConcreteTrainingOffer getInstance(){
        if( instance == null )
>>>>>>> Stashed changes
            instance = new ConcreteTrainingOffer();
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
