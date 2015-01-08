package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.tirocinio.beans.PendingAcceptance;
import it.unisa.tirocinio.manager.interfaces.IPendingAcceptance;
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
public class ConcretePendingAcceptance implements IPendingAcceptance {

    private static ConcretePendingAcceptance instance = null;
    private CallableStatement aCallableStatement = null;

    /**
     *
     * @param idPendingAcceptance
     * @return a PendingAcceptance object which contains informations about a
     * certain pending acceptance id
     */
    @Override
    public PendingAcceptance readStudentInPendingAcceptance(int idPendingAcceptance) {
        Connection connect = null;
        PendingAcceptance aStudentInPendingAcceptance = new PendingAcceptance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getPendingStudents(?)}");
            aCallableStatement.setInt("pkPersonSSN", idPendingAcceptance);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aStudentInPendingAcceptance.setIdPendingAcceptance(rs.getInt("id_pending_acceptance"));
                aStudentInPendingAcceptance.setRequestDate(rs.getDate("request_date"));
                aStudentInPendingAcceptance.setPersonSSN(rs.getString("fk_person"));
            }
            rs.close();
            return aStudentInPendingAcceptance;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePendingAcceptance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of PendingAcceptance which contains all students
     * that are in pending acceptance status
     */
    @Override
    public ArrayList<PendingAcceptance> getAllStudentsInPendingAcceptance() {
        Connection connect = null;
        ArrayList<PendingAcceptance> studentsInPendingAcceptance = new ArrayList<PendingAcceptance>();
        PendingAcceptance aStudentInPendingAcceptance = null;
        try {
            connect = DBConnection.getConnection();
            PersonManager aPerson = PersonManager.getInstance();
            aCallableStatement = connect.prepareCall("{call getAllOrganizations()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aStudentInPendingAcceptance = new PendingAcceptance();
                aStudentInPendingAcceptance.setIdPendingAcceptance(rs.getInt("id_pending_acceptance"));
                aStudentInPendingAcceptance.setRequestDate(rs.getDate("request_date"));
                aStudentInPendingAcceptance.setPersonSSN(rs.getString("fk_person"));
                studentsInPendingAcceptance.add(aStudentInPendingAcceptance);
            }
            rs.close();
            return studentsInPendingAcceptance;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePendingAcceptance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcretePendingAcceptance object if there are no currently
     * PendingAcceptance objects alive
     */
    public static synchronized ConcretePendingAcceptance getInstance() {
        if (instance == null) {
            instance = new ConcretePendingAcceptance();
        }
        return instance;
    }

}
