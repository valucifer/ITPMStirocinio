/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.model.Cycle;
import it.unisa.tirocinio.manager.concrete.ConcreteOrganization;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gemmacatolino
 */
public class CycleManager {

    private static CycleManager instance;

    public static CycleManager getInstance() {

        if (instance == null) {
            instance = new CycleManager();
        }
        return instance;

    }

    public void add(Cycle pCycle) throws SQLException {
        Connection connect = DBConnection.getConnection();

        String sql = "INSERT INTO cycle (cycle_number, title) VALUES (" + pCycle.getCycleNumber() + ", '" + pCycle.getTitle() + "')";

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    public Cycle getCycleByCycleNumber(int pCycleNumber) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Cycle cycle = null;

        String query = "select * from cycle where cycle_number = " + pCycleNumber;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                cycle = new Cycle();
                cycle.setCycleNumber(rs.getInt("cycle_number"));
                cycle.setTitle(rs.getString("title"));
            }
        } finally {

            DBConnection.releaseConnection(connection);
        }

        return cycle;
    }

    /* --- --- */
    /**
     *
     * @param cycleNumber
     * @return a Cycle object if read operation from db is correct, null
     * otherwise
     */
    public Cycle readCycle(int cycleNumber) {
        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }
            
            Cycle aCycle = new Cycle();
            aCallableStatement = connection.prepareCall("{call getCycle(?)}");
            aCallableStatement.setInt("pkCycle", cycleNumber);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aCycle.setCycleNumber(rs.getInt("cycle_number"));
                aCycle.setTitle(rs.getString("title"));
            }
            rs.close();
            return aCycle;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(CycleManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                aCallableStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CycleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

    /**
     *
     * @return an ArrayList of Cycle if read operation from Database is correct,
     * null otherwise
     */
    public ArrayList<Cycle> getAllCycles() {
        ArrayList<Cycle> cycles = new ArrayList<Cycle>();
        Cycle aCycle = null;
        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }
            
            aCallableStatement = connection.prepareCall("{call getAllCycles()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aCycle = new Cycle();
                aCycle.setCycleNumber(rs.getInt("cycle_number"));
                aCycle.setTitle(rs.getString("title"));
                cycles.add(aCycle);
            }
            rs.close();
            return cycles;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(CycleManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                aCallableStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CycleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

}
