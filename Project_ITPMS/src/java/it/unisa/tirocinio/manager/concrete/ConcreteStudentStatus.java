package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.tirocinio.beans.StudentStatus;
import it.unisa.tirocinio.manager.interfaces.IStudentStatus;
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
public class ConcreteStudentStatus implements IStudentStatus {

    private static ConcreteStudentStatus instance = null;
    private CallableStatement aCallableStatement = null;

    /**
     *
     * @param aStudentStatus
     * @return true if a StudentStatus object is successfully created, false
     * otherwise
     */
    @Override
    public boolean createStudentStatus(StudentStatus aStudentStatus) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            if (aStudentStatus == null) {
                throw new NullPointerException("StudentStatus is null!");
            }

            aCallableStatement = connect.prepareCall("{call insertStudentTrainingStatus(?)}");
            aCallableStatement.setString("description", aStudentStatus.getDescription());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param idStudentStatus
     * @return a StudentStatus object if reading operation from Database is
     * correct, null otherwise
     */
    @Override
    public StudentStatus readStudentStatus(int idStudentStatus) {
        Connection connect = null;
        try {
            connect = DBConnection.getConnection();
            StudentStatus aStudentStatus = new StudentStatus();
            aCallableStatement = connect.prepareCall("{call getStudentTrainingStatus(?)}");
            aCallableStatement.setInt("pkStudentStatus", idStudentStatus);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aStudentStatus.setIdStudentStatus(rs.getInt("id_student_status"));
                aStudentStatus.setDescription(rs.getString("description"));
            }
            rs.close();
            return aStudentStatus;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of StudentStatus which contains every student's
     * status
     */
    @Override
    public ArrayList<StudentStatus> getAllStudentStatus() {
        Connection connect = null;
        ArrayList<StudentStatus> studentStatus = new ArrayList<StudentStatus>();
        StudentStatus aStudentStatus = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getAllStudentTrainingStatus()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aStudentStatus = new StudentStatus();
                aStudentStatus.setIdStudentStatus(rs.getInt("id_student_status"));
                aStudentStatus.setDescription(rs.getString("description"));
                studentStatus.add(aStudentStatus);
            }
            rs.close();
            return studentStatus;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcreteStudentStatus instace if there are no
     * ConcreteStudentStatus instances alive
     */
    public static synchronized ConcreteStudentStatus getInstance() {
        if (instance == null) {
            instance = new ConcreteStudentStatus();
        }
        return instance;
    }

}
