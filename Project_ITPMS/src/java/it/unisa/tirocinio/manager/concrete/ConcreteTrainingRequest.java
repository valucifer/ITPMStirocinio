/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.TrainingRequest;
import it.unisa.tirocinio.beans.TrainingStatus;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.ITrainingRequest;
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
public class ConcreteTrainingRequest implements ITrainingRequest{
    
    private static ConcreteTrainingRequest instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteTrainingRequest(){
        instance = new ConcreteTrainingRequest();
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createTrainingRequest(TrainingRequest aTrainingRequest) {
        try {
            if( aTrainingRequest == null )
                throw new NullPointerException("TrainingRequest is null!");
            aCallableStatement = connector.prepareCall("{call insertTrainingRequest(?,?,?,?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingRequest.getDescription());
            aCallableStatement.setString("title",aTrainingRequest.getTitle());
            aCallableStatement.setInt("FK_TrainingStatus",aTrainingRequest.getTrainingStatus().getIdTrainingStatus());
            aCallableStatement.setString("FK_Person",aTrainingRequest.getPersonSSN().getSSN());
            aCallableStatement.setString("FK_Organization",aTrainingRequest.getOrganizationVATNumber().getVATNumber());
            aCallableStatement.setString("FK_StudentInformationSSN",aTrainingRequest.getStudentSSN().getStudentSSN().getSSN());
            boolean toReturn = aCallableStatement.execute();
            connector.close();
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deleteTrainingRequest(int idTraininngRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTrainingRequest(TrainingRequest aTrainingRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    *Questo metodo dovrebbe prendere tutte le offerte di tirocinio per una determinata azienda. Non 
    *dovrebbe ritornare un arrayList?
    */
    @Override
    public TrainingRequest readTrainingRequest(String VATNumber) {
        TrainingRequest aTrainingRequest = new TrainingRequest();
        ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOwnTrainingRequests(?)}");
            aCallableStatement.setString("vatNumber",VATNumber);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                aTrainingRequest.setTitle(rs.getString("title"));
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")));
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")));
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")));
            }
            rs.close();
            return aTrainingRequest;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*
    *Questo metodo dovrebbe prendere tutte le offerte di tirocinio per un determinato id. Visto
    *che l'id è chiave primaria, non dovrebbe ritornare un singolo oggetto TrainingRequest?
    */
    @Override
    public ArrayList<TrainingRequest> searchTrainingRequestById(int idTraininngRequest) {
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            aCallableStatement = connector.prepareCall("{call getTrainingRequest(?)}");
            aCallableStatement.setInt("idTrainingRequest",idTraininngRequest);
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                aTrainingRequest.setTitle(rs.getString("title"));
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")));
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")));
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")));
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }

    @Override
    public ArrayList<TrainingRequest> getAllTrainingRequests() {
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            aCallableStatement = connector.prepareCall("{call getAllTrainingRequests()}");
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                aTrainingRequest.setTitle(rs.getString("title"));
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")));
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")));
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")));
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }

    @Override
    public boolean changeTrainingStatus(TrainingStatus aStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternship(int idTrainingStatus) {
        ArrayList<TrainingRequest> trainings = this.searchTrainingRequestById(idTrainingStatus);
        for (TrainingRequest training : trainings) {
            if (training.getOrganizationVATNumber() == null) {
                return true;
            }
        }
        return false;
    }
    
    //Ho aggiunto questo...ci può essere utile! Forse. 
    @Override
    public ArrayList<TrainingRequest> getAllInternships() {
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            aCallableStatement = connector.prepareCall("{call getInternships()}");
            ResultSet rs = aCallableStatement.executeQuery();
            if ( rs.getFetchSize() == 0 )
                return null;
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                aTrainingRequest.setTitle(rs.getString("title"));
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")));
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")));
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")));
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")));
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
    
    public static ConcreteTrainingRequest getInstance(){
        return instance;
    }
    
}
