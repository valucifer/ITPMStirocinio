package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
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

    /**
     *
     * @param aTrainingOffer
     * @return true if creation of an inner training offer is correct, false otherwise
     */
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
    
    /**
     *
     * @param aTrainingOffer
     * @return true if creation of an outer training offer is correct, false otherwise
     */
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
    
    /**
     *
     * @param aTrainingOffer
     * @return true if a certain training offer is successfully updated, false otherwise
     */
    @Override
    public boolean updateTrainingOffer(TrainingOffer aTrainingOffer) {
        initializeConnection();
        try {
            if( aTrainingOffer == null )
                throw new NullPointerException("OfferTraining is null!");
            
            aCallableStatement = connector.prepareCall("{call updateTrainingOffer(?,?,?,?,?)}");       
            aCallableStatement.setInt("idTrainingOffer",aTrainingOffer.getIdTrainingOffer());
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

    /**
     *
     * @param idTrainingOffer
     * @return a TrainingOffer object if reading operation from Database is correct, null otherwise
     */
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
                aTrainingOffer.setContact(anOrganization.readOrganization(rs.getString("fk_organization")).getEmail());
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
    
    /**
     *
     * @param personSSN
     * @return an ArrayList of TrainingOffer which contains all inner training offers pubblished by a certain person, null otherwise
     */
    @Override
    public ArrayList<TrainingOffer> readInnerTrainingOffer(String personSSN) {
        initializeConnection();
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getInnerTrainingOffer(?)}");
            aCallableStatement.setString("pkProfessor",personSSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getCompanyName());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                String tmp = "";
                       tmp += aPerson.readPerson(rs.getString("fk_person")).getName()+" ";
                       tmp += aPerson.readPerson(rs.getString("fk_person")).getSurname();
                aTrainingOffer.setPersonSSN(tmp);   
                aTrainingOffer.setContact(anOrganization.readOrganization(rs.getString("fk_organization")).getEmail());
            
                allTraining.add(aTrainingOffer);
                
            }
            rs.close();
            return allTraining;
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
     * @param vatNumber
     * @return an ArrayList of TrainingOffer which contains all outer training offers pubblished by a certain person, null otherwise
     */
    @Override
    public ArrayList<TrainingOffer> readOuterTrainingOffer(String vatNumber) {
        initializeConnection();
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        ConcretePerson aPerson = ConcretePerson.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOuterTrainingOffer(?)}");
            aCallableStatement.setString("pkOrganization",vatNumber);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getCompanyName());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                String tmp = "";
                       tmp += aPerson.readPerson(rs.getString("fk_person")).getName()+" ";
                       tmp += aPerson.readPerson(rs.getString("fk_person")).getSurname();
                aTrainingOffer.setPersonSSN(tmp);
                aTrainingOffer.setContact(anOrganization.readOrganization(rs.getString("fk_organization")).getEmail());
                allTraining.add(aTrainingOffer);
            }
            rs.close();
            return allTraining;
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
     * @return an ArrayList of TrainingOffer which contains all training offers
     */
    @Override
    public ArrayList<TrainingOffer> getAllTrainingOffers() {
        initializeConnection();
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        try {
           ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
           ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
           ConcretePerson aPerson = ConcretePerson.getInstance();
           Person externalTutor = null;
           aCallableStatement = connector.prepareCall("{call getAllTrainingOffers()}");
           ResultSet rs = aCallableStatement.executeQuery();
           String innerTraining = null;
           
           while( rs.next() ){
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getCompanyName());
                aTrainingOffer.setDepartment(aDepartment.readDepartment(rs.getString("fk_department")).getAbbreviation());
                externalTutor = aPerson.readPerson(rs.getString("fk_person"));
                aTrainingOffer.setPersonSSN(externalTutor.getName()+" "+externalTutor.getSurname());
                innerTraining = anOrganization.readOrganization(rs.getString("fk_organization")).getEmail();
                if ( innerTraining == null ){
                    Account account = externalTutor.getAccount();
                    aTrainingOffer.setContact(account.getEmail());
                }else aTrainingOffer.setContact(innerTraining);
                
                System.out.println(aTrainingOffer.getContact());
                allTraining.add(aTrainingOffer);
           }
           rs.close();
           return allTraining;
           
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
     * @return a ConcreteTrainingOffer instance if there are no ConcreteTrainingOffer instances alive
     */
    public static synchronized ConcreteTrainingOffer getInstance(){
        if(instance == null)
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

    /**
     *
     * @param idTrainingOffer
     * @return
     */
    @Override
    public boolean deleteTrainingOffer(int idTrainingOffer) {
        initializeConnection();
        try {
            
            aCallableStatement = connector.prepareCall("{call deleteTrainingOffer(?)}");       
            aCallableStatement.setInt("pkTraining",idTrainingOffer);
            
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

}
