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
        instance = new ConcreteTrainingOffer();
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createInnerTrainingOffer(TrainingOffer aTrainingOffer) {
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertInnerTraining(?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN().getSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment().getAbbreviation());
            boolean toReturn = aCallableStatement.execute();
            aCallableStatement.close();
            
            return toReturn;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean createOuterTrainingOffer(TrainingOffer aTrainingOffer) {
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call insertOuterTraining(?,?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization",aTrainingOffer.getOrganization().getVATNumber());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN().getSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment().getAbbreviation());
            boolean toReturn = aCallableStatement.execute();
            aCallableStatement.close();
            
            return toReturn;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    

    @Override
    public boolean updateTrainingOffer(TrainingOffer aTrainingOffer) {
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call updateTrainingOffer(?,?,?,?,?)}");       
            aCallableStatement.setInt("idTrainingOffer",aTrainingOffer.getIdOfferTraining());
            aCallableStatement.setString("description",aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization",aTrainingOffer.getOrganization().getVATNumber());
            aCallableStatement.setString("FK_PersonSSN",aTrainingOffer.getPersonSSN().getSSN());
            aCallableStatement.setString("FK_Department",aTrainingOffer.getDepartment().getAbbreviation());
            boolean toReturn = aCallableStatement.execute();
            aCallableStatement.close();
            
            return toReturn;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public TrainingOffer readTrainingOffer(int idTrainingOffer) {
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getTrainingOffer(?)}");
            aCallableStatement.setInt("pkTrainingOffer",idTrainingOffer);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                    aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                    aTrainingOffer.setDescription(rs.getString("description"));
                    aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")));
                    aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")));
                    aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
            }
            rs.close();
            return aTrainingOffer;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public TrainingOffer readInnerTrainingOffer(String personSSN) {
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getInnerTrainingOffer(?)}");
            aCallableStatement.setString("pkProfessor",personSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                    aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                    aTrainingOffer.setDescription(rs.getString("description"));
                    aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")));
                    aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")));
                    aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
            }
            rs.close();
            return aTrainingOffer;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public TrainingOffer readOuterTrainingOffer(String vatNumber) {
        TrainingOffer aTrainingOffer = new TrainingOffer();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOuterTrainingOffer(?)}");
            aCallableStatement.setString("pkOrganization",vatNumber);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                    aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                    aTrainingOffer.setDescription(rs.getString("description"));
                    aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")));
                    aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")));
                    aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
            }
            rs.close();
            return aTrainingOffer;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<TrainingOffer> getAllTrainingOffers() {
    
        ArrayList<TrainingOffer> trainingOffers = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        try {
           ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
           ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
           ConcretePerson aPerson = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllTrainingOffers()}");
           ResultSet rs = aCallableStatement.executeQuery();
           if ( rs.getFetchSize() == 0 )
               return null;
           while( rs.next() ){
               aTrainingOffer = new TrainingOffer();
               aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
               aTrainingOffer.setDescription(rs.getString("description"));
               aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")));
               aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")));
               aTrainingOffer.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
               trainingOffers.add(aTrainingOffer);
           }
           rs.close();
           return trainingOffers;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
    
    public static ConcreteTrainingOffer getInstance(){
        return instance;
    }

}
