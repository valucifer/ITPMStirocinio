package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.database.DepartmentManager;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.TrainingOffer;
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
public class ConcreteTrainingOffer implements ITrainingOffer {

    private static ConcreteTrainingOffer instance = null;

    /**
     *
     * @param aTrainingOffer
     * @return true if creation of an inner training offer is correct, false
     * otherwise
     */
    @Override
    public boolean createInnerTrainingOffer(TrainingOffer aTrainingOffer) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            if (aTrainingOffer == null) {
                throw new NullPointerException("OfferTraining is null!");
            }

            aCallableStatement = connect.prepareCall("{call insertInnerTraining(?,?,?)}");
            aCallableStatement.setString("trainingDescription", aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_PersonSSN", aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department", aTrainingOffer.getDepartment());

            int check = aCallableStatement.executeUpdate();
            aCallableStatement.close();

            return check > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param aTrainingOffer
     * @return true if creation of an outer training offer is correct, false
     * otherwise
     */
    @Override
    public boolean createOuterTrainingOffer(TrainingOffer aTrainingOffer) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            if (aTrainingOffer == null) {
                throw new NullPointerException("OfferTraining is null!");
            }
            
            aCallableStatement = connect.prepareCall("{call insertOuterTraining(?,?,?,?)}");
            aCallableStatement.setString("trainingDescription", aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization", aTrainingOffer.getOrganization());
            aCallableStatement.setString("FK_PersonSSN", aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department", aTrainingOffer.getDepartment());
            int check = aCallableStatement.executeUpdate();

            return check > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param aTrainingOffer
     * @return true if a certain training offer is successfully updated, false
     * otherwise
     */
    @Override
    public boolean updateTrainingOffer(TrainingOffer aTrainingOffer) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            if (aTrainingOffer == null) {
                throw new NullPointerException("OfferTraining is null!");
            }

            aCallableStatement = connect.prepareCall("{call updateTrainingOffer(?,?,?,?,?)}");
            aCallableStatement.setInt("idTrainingOffer", aTrainingOffer.getIdTrainingOffer());
            aCallableStatement.setString("description", aTrainingOffer.getDescription());
            aCallableStatement.setString("FK_Organization", aTrainingOffer.getOrganization());
            aCallableStatement.setString("FK_PersonSSN", aTrainingOffer.getPersonSSN());
            aCallableStatement.setString("FK_Department", aTrainingOffer.getDepartment());
            int check = aCallableStatement.executeUpdate();
            return check > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param idTrainingOffer
     * @return a TrainingOffer object if reading operation from Database is
     * correct, null otherwise
     */
    @Override
    public TrainingOffer readTrainingOffer(int idTrainingOffer) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        TrainingOffer aTrainingOffer = new TrainingOffer();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getTrainingOffer(?)}");
            aCallableStatement.setInt("pkTrainingOffer", idTrainingOffer);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(rs.getString("fk_organization"));
                aTrainingOffer.setDepartment(rs.getString("fk_department"));
                aTrainingOffer.setPersonSSN(rs.getString("fk_person"));
                aTrainingOffer.setContact(rs.getString("fk_organization"));
            }
            rs.close();
            return aTrainingOffer;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param personSSN
     * @return an ArrayList of TrainingOffer which contains all inner training
     * offers published by a certain person, null otherwise
     */
    @Override
    public ArrayList<TrainingOffer> readInnerTrainingOffer(String personSSN) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;

        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        PersonManager aPerson = PersonManager.getInstance();

        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getInnerTrainingOffer(?)}");
            aCallableStatement.setString("pkProfessor", personSSN);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(rs.getString("fk_organization"));
                aTrainingOffer.setDepartment(rs.getString("fk_department"));
                String tmp = "";
                tmp += aPerson.getPersonBySSN(rs.getString("fk_person")).getName() + " ";
                tmp += aPerson.getPersonBySSN(rs.getString("fk_person")).getSurname();
                aTrainingOffer.setPersonSSN(tmp);
                aTrainingOffer.setContact(anOrganization.readOrganization(rs.getString("fk_organization")).getEmail());

                allTraining.add(aTrainingOffer);

            }
            rs.close();
            return allTraining;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param vatNumber
     * @return an ArrayList of TrainingOffer which contains all outer training
     * offers published by a certain person, null otherwise
     */
    @Override
    public ArrayList<TrainingOffer> readOuterTrainingOffer(String vatNumber) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
        PersonManager aPerson = PersonManager.getInstance();
        DepartmentManager aDepartment = DepartmentManager.getInstance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getOuterTrainingOffer(?)}");
            aCallableStatement.setString("pkOrganization", vatNumber);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getCompanyName());
                aTrainingOffer.setDepartment(aDepartment.getDepartmentByAbbreviation(rs.getString("fk_department")).getAbbreviation());
                String tmp = "";
                tmp += aPerson.getPersonBySSN(rs.getString("fk_person")).getName() + " ";
                tmp += aPerson.getPersonBySSN(rs.getString("fk_person")).getSurname();
                aTrainingOffer.setPersonSSN(tmp);
                aTrainingOffer.setContact(anOrganization.readOrganization(rs.getString("fk_organization")).getEmail());
                allTraining.add(aTrainingOffer);
            }
            rs.close();
            return allTraining;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of TrainingOffer which contains all training offers
     */
    @Override
    public ArrayList<TrainingOffer> getAllTrainingOffers() {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        ArrayList<TrainingOffer> allTraining = new ArrayList<TrainingOffer>();
        TrainingOffer aTrainingOffer = null;
        try {
            connect = DBConnection.getConnection();
            ConcreteOrganization anOrganization = ConcreteOrganization.getInstance();
            DepartmentManager aDepartment = DepartmentManager.getInstance();
            PersonManager aPerson = PersonManager.getInstance();
            Person professor = null;
            aCallableStatement = connect.prepareCall("{call getAllTrainingOffers()}");
            ResultSet rs = aCallableStatement.executeQuery();
            String innerTraining = null;

            while (rs.next()) {
                professor = new Person();
                aTrainingOffer = new TrainingOffer();
                aTrainingOffer.setIdOfferTraining(rs.getInt("id_training_offer"));
                aTrainingOffer.setDescription(rs.getString("description"));
                aTrainingOffer.setOrganization(anOrganization.readOrganization(rs.getString("fk_organization")).getCompanyName());
                aTrainingOffer.setDepartment(aDepartment.getDepartmentByAbbreviation(rs.getString("fk_department")).getAbbreviation());
                professor = aPerson.getPersonBySSN(rs.getString("fk_person"));

                aTrainingOffer.setPersonSSN(professor.getName() + " " + professor.getSurname());
                innerTraining = anOrganization.readOrganization(rs.getString("fk_organization")).getEmail();
                if (innerTraining == null) {
                    System.out.println("account: " + professor.getAccount().getEmail());
                    Account account = professor.getAccount();
                    aTrainingOffer.setContact(account.getEmail());
                } else {
                    aTrainingOffer.setContact(innerTraining);
                }

                System.out.println(aTrainingOffer.getContact());
                allTraining.add(aTrainingOffer);
            }
            rs.close();
            return allTraining;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcreteTrainingOffer instance if there are no
     * ConcreteTrainingOffer instances alive
     */
    public static synchronized ConcreteTrainingOffer getInstance() {
        if (instance == null) {
            instance = new ConcreteTrainingOffer();
        }
        return instance;
    }

    /**
     *
     * @param idTrainingOffer
     * @return
     */
    @Override
    public boolean deleteTrainingOffer(int idTrainingOffer) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call deleteTrainingOffer(?)}");
            aCallableStatement.setInt("pkTraining", idTrainingOffer);

            int check = aCallableStatement.executeUpdate();
            aCallableStatement.close();

            return check > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
