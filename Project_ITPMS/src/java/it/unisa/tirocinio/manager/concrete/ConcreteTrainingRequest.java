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
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    /**
     *
     * @param aTrainingRequest
     * @return true if a training request is successfully created, false otherwise 
     */
    @Override
    public boolean createTrainingRequest(TrainingRequest aTrainingRequest) {
        initializeConnection();
         try {
            if( aTrainingRequest == null )
                throw new NullPointerException("TrainingRequest is null!");
            
            aCallableStatement = connector.prepareCall("{call insertTrainingRequest(?,?,?,?,?,?)}");       
            aCallableStatement.setString("trainingDescription",aTrainingRequest.getDescription());
            aCallableStatement.setString("title",aTrainingRequest.getTitle());
            aCallableStatement.setInt("FK_TrainingStatus",aTrainingRequest.getTrainingStatus());
            aCallableStatement.setString("FK_Person",aTrainingRequest.getPersonSSN());
            aCallableStatement.setString("FK_Organization",aTrainingRequest.getOrganizationVATNumber());
            aCallableStatement.setString("FK_StudentInformationSSN",aTrainingRequest.getStudentSSN());
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
     * @param idTraininngRequest
     * @return true if a training request is successfully deleted, false otherwise
     */
    @Override
    public boolean deleteTrainingRequest(int idTraininngRequest) {
        initializeConnection();
        try {
            aCallableStatement = connector.prepareCall("{call deleteTrainingRequest(?)}");       
            aCallableStatement.setInt("idTrainingRequest",idTraininngRequest);
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
     * @param aTrainingRequest
     * @return true if a training request is successfully updated, false otherwise
     */
    @Override
    public boolean updateTrainingRequest(TrainingRequest aTrainingRequest) {
        initializeConnection();
        try {
            if( aTrainingRequest == null )
                throw new NullPointerException("TrainingRequest is null!");
            
            aCallableStatement = connector.prepareCall("{call updateTrainingRequest(?,?,?,?,?,?,?)}");       
            aCallableStatement.setInt("ID",aTrainingRequest.getIdTrainingRequest());      
            aCallableStatement.setString("trainingDescription",aTrainingRequest.getDescription());
            aCallableStatement.setString("titl",aTrainingRequest.getTitle());
            aCallableStatement.setInt("FK_TrainingStatus",aTrainingRequest.getTrainingStatus());
            aCallableStatement.setString("FK_Perso",aTrainingRequest.getPersonSSN());
            aCallableStatement.setString("FK_Organizatio",aTrainingRequest.getOrganizationVATNumber());
            aCallableStatement.setString("FK_StudentInformationSSN",aTrainingRequest.getStudentSSN());
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
     * @param aTrainingRequest
     * @return a TrainingRequest object if reading operation from Database is successfully done, null otherwise
     */
    @Override
    public TrainingRequest readTrainingRequest(int aTrainingRequest) {
        initializeConnection();
        TrainingRequest aTraining = new TrainingRequest();
        ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance().getInstance();
        ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getTrainingRequest(?)}");
            aCallableStatement.setInt("idTrainingRequest",aTrainingRequest);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTraining.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTraining.setDescription(rs.getString("description"));
                aTraining.setTitle(rs.getString("title"));
                
                aTraining.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTraining.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                aTraining.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")).getStudentSSN());//studentInformation
                aTraining.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")).getIdTrainingStatus());
                
            }
            rs.close();
            return aTraining;
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
     * @param VATNumber
     * @return an ArrayList of TrainingRequest which contains all training request pubblished by a certain organization
     */
    @Override
    public ArrayList<TrainingRequest> readTrainingRequestByOrganization(String VATNumber) {
        initializeConnection();
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance().getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            
            aCallableStatement = connector.prepareCall("{call getOwnTrainingRequests(?)}");
            aCallableStatement.setString("vatNumber", VATNumber);
            ResultSet rs = aCallableStatement.executeQuery();
           
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setTitle(rs.getString("title"));
                
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")).getStudentSSN());//studentInformation
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")).getIdTrainingStatus());
                
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;

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
     * @return an ArrayList of TrainingRequest which contains all training requestes
     */
    @Override
    public ArrayList<TrainingRequest> getAllTrainingRequests() {
        initializeConnection();
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance().getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            
            aCallableStatement = connector.prepareCall("{call getAllTrainingRequests()}");
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setTitle(rs.getString("title"));
                
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")).getStudentSSN());//studentInformation
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")).getIdTrainingStatus());
                
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;

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
     * @param idTrainingRequest
     * @param aStatus
     * @return true if a certain training request is successfully updated, false otherwise
     */
    @Override
    public boolean changeTrainingStatus(int idTrainingRequest, TrainingStatus aStatus) {
        initializeConnection();
        try {
            if( aStatus == null )
                throw new NullPointerException("Status is null!");
            
            aCallableStatement = connector.prepareCall("{call changeTrainingStatus(?,?)}");       
            aCallableStatement.setInt("ID",idTrainingRequest);      
            aCallableStatement.setInt("FK_TrainingStatus",aStatus.getIdTrainingStatus());
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
     * @param idTrainingRequest
     * @return return true if a certain training request is internship, false otherwise
     */
    @Override
    public boolean isInternship(int idTrainingRequest) {
        initializeConnection();
        boolean toReturn = false;
        try {
            aCallableStatement = connector.prepareCall("{call getIsInternships(?)}");
            aCallableStatement.setInt("idTrainingRequest", idTrainingRequest);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                toReturn = true;
                break;
            }
            rs.close();
            return toReturn;

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
     * @return an ArrayList of TrainingRequest which contains all internships
     */
    @Override
    public ArrayList<TrainingRequest> getAllInternships() {
        initializeConnection();
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance().getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            
            aCallableStatement = connector.prepareCall("{call getAllInternships()}");
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setTitle(rs.getString("title"));
                
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")).getStudentSSN());//studentInformation
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")).getIdTrainingStatus());
                
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;

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
     * @param SSN
     * @return an ArrayList of TrainingRequest which contains all training requestes pubblished by a professor
     */
    @Override
    public ArrayList<TrainingRequest> readTrainingRequestByProfessor(String SSN) {
        initializeConnection();
        ArrayList<TrainingRequest> trainingRequests = new ArrayList<TrainingRequest>();
        TrainingRequest aTrainingRequest = null;
        try {
            ConcreteTrainingStatus aTrainingStatus = ConcreteTrainingStatus.getInstance();
            ConcretePerson aPerson = ConcretePerson.getInstance();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance().getInstance();
            ConcreteStudentInformation aStudentInformation = ConcreteStudentInformation.getInstance();
            
            aCallableStatement = connector.prepareCall("{call getInnerTrainingRequests(?)}");
            aCallableStatement.setString("SSN", SSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingRequest = new TrainingRequest();
                aTrainingRequest.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTrainingRequest.setDescription(rs.getString("description"));
                aTrainingRequest.setTitle(rs.getString("title"));
                
                aTrainingRequest.setOrganizationVATNumber(anOrganization.readOrganization(rs.getString("fk_organization")).getVATNumber());
                aTrainingRequest.setPersonSSN(aPerson.readPerson(rs.getString("fk_person")).getSSN());
                aTrainingRequest.setStudentSSN(aStudentInformation.readStudentInformation(rs.getString("student_information_SSN")).getStudentSSN());//studentInformation
                aTrainingRequest.setTrainingStatus(aTrainingStatus.readTrainingStatus(rs.getInt("fk_training_status")).getIdTrainingStatus());
                
                trainingRequests.add(aTrainingRequest);
            }
            rs.close();
            return trainingRequests;

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
     * @param SSN
     * @return a TrainingRequest object if reading operation from Database is correct, null otherwise
     */
    @Override
    public TrainingRequest readTrainingRequestByStudent(String SSN) {
        initializeConnection();
        TrainingRequest aTraining = new TrainingRequest();
        try {
            aCallableStatement = connector.prepareCall("{call getStudentInformationTrainingRequests(?)}");
            aCallableStatement.setString("SSN",SSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTraining.setIdTrainingRequest(rs.getInt("id_training_request"));
                
                aTraining.setDescription(rs.getString("description"));
                aTraining.setTitle(rs.getString("title"));
                
                aTraining.setOrganizationVATNumber(rs.getString("fk_organization"));
                aTraining.setPersonSSN(rs.getString("fk_person"));
                aTraining.setStudentSSN(rs.getString("student_information_SSN"));//studentInformation
                aTraining.setTrainingStatus(rs.getInt("fk_training_status"));
                
            }
            rs.close();
            return aTraining;
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
     * @return a ConcreteTrainingRequest instance if there are no ConcreteTrainingRequest instances currently alive
     */
    public static synchronized ConcreteTrainingRequest getInstance(){
        if(instance == null)
            instance = new ConcreteTrainingRequest();
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
