package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.StudentInformation;
import it.unisa.tirocinio.beans.StudentStatus;
import it.unisa.tirocinio.manager.interfaces.IStudentInformation;
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
public class ConcreteStudentInformation implements IStudentInformation {

    private static ConcreteStudentInformation instance = null;
    private CallableStatement aCallableStatement = null;

    /**
     *
     * @param aStudentInformation
     * @return true if a student's informations are updated, false otherwise
     */
    @Override
    public boolean updateStudentInformation(StudentInformation aStudentInformation) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            if (aStudentInformation == null) {
                throw new NullPointerException("OfferTraining is null!");
            }

            aCallableStatement = connect.prepareCall("{call updateStudentInformation(?,?,?,?)}");
            aCallableStatement.setString("ss", aStudentInformation.getStudentSSN());
            aCallableStatement.setString("CV", aStudentInformation.getCVPath());
            aCallableStatement.setString("AcT", aStudentInformation.getATPath());
            aCallableStatement.setInt("fk_status", aStudentInformation.getStudentStatus());
            int check = aCallableStatement.executeUpdate();
            return check > 0;

        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
            }
        }
    }

    /**
     *
     * @param studentSSN
     * @param CVPath
     * @param ATPath
     * @return true if a trining request is started successfully, false
     * otherwise
     */
    @Override
    public boolean startTrainingRequest(String studentSSN, String CVPath, String ATPath) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call storeUploadFile(?,?,?)}");
            aCallableStatement.setString("CVPath", CVPath);
            aCallableStatement.setString("ATPath", ATPath);
            aCallableStatement.setString("studentSSN", studentSSN);
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
            }
        }
    }

    /**
     *
     * @param studentSSN
     * @param newStatus
     * @return true if a student status is successfully changed, false otherwise
     */
    @Override
    public boolean changeStudentStatus(String studentSSN, StudentStatus newStatus) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call changeStudentStatus(?,?)}");
            aCallableStatement.setString("studentSSN", studentSSN);
            aCallableStatement.setInt("status", newStatus.getIdStudentStatus());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param studentSSN
     * @return a StudentInformation object if there is a student represented by
     * a certain student SSN
     */
    public StudentInformation readAStudentInformation(String studentSSN) {
        Connection connect = null;
        StudentInformation aStudentInformation = new StudentInformation();
        PersonManager aPerson = PersonManager.getInstance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getStudentInformation(?)}");
            aCallableStatement.setString("ss", studentSSN);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                Person person = aPerson.getPersonBySSN(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getSsn());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(rs.getInt("fk_student_status"));
            }
            rs.close();
            return aStudentInformation;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param studentSSN
     * @return a StudentInformation object if there is a student with a student
     * SSN into Database, null otherwise
     */
    @Override
    public StudentInformation readStudentInformation(String studentSSN) {
        Connection connect = null;
        StudentInformation aStudentInformation = new StudentInformation();
        ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
        PersonManager aPerson = PersonManager.getInstance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getStudentInformation(?)}");
            aCallableStatement.setString("ss", studentSSN);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                Person person = aPerson.getPersonBySSN(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getName() + " " + person.getSurname());
                aStudentInformation.setMatricula(person.getMatricula());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(rs.getInt("fk_student_status"));
            }
            rs.close();
            return aStudentInformation;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of StudentInformation which contains all
     * informations of a certain student
     */
    @Override
    public ArrayList<StudentInformation> getAllStudentInformations() {
        Connection connect = null;
        ArrayList<StudentInformation> studentInformations = new ArrayList<StudentInformation>();
        StudentInformation aStudentInformation = null;
        try {
            connect = DBConnection.getConnection();
            ConcreteStudentStatus aStudentStatus = ConcreteStudentStatus.getInstance();
            PersonManager aPerson = PersonManager.getInstance();
            aCallableStatement = connect.prepareCall("{call getAllStudentInformation()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aStudentInformation = new StudentInformation();
                Person person = aPerson.getPersonBySSN(rs.getString("SSN"));
                aStudentInformation.setStudentSSN(person.getName() + " " + person.getSurname());
                aStudentInformation.setMatricula(person.getMatricula());
                aStudentInformation.setCVPath(rs.getString("curriculum_vitae_path"));
                aStudentInformation.setATPath(rs.getString("accademic_transcript_path"));
                aStudentInformation.setStudentStatus(rs.getInt("fk_student_status"));
                Account account = person.getAccount();
                aStudentInformation.setEmailStudent(account.getEmail());
                studentInformations.add(aStudentInformation);
            }
            rs.close();
            return studentInformations;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcreteStudentInformation object if no
     * ConcreteStudentInformation object are alive
     */
    public static synchronized ConcreteStudentInformation getInstance() {
        if (instance == null) {
            instance = new ConcreteStudentInformation();
        }
        return instance;
    }

}
