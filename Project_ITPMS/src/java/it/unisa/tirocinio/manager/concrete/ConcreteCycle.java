/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Cycle;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.ICycle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentino
 */
public class ConcreteCycle implements ICycle{
private static ConcreteCycle instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteCycle(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public Cycle readCycle(int cycleNumber) {
        initializeConnection();
        try {
            Cycle aCycle = new Cycle();
            aCallableStatement = connector.prepareCall("{call getCycle(?)}");
            aCallableStatement.setInt("pkCycle",cycleNumber);
            ResultSet rs = aCallableStatement.executeQuery();
           
            while( rs.next() ){
                aCycle.setCycleNumber(rs.getInt("cycle_number"));
                aCycle.setTitle(rs.getString("title"));
            }
            rs.close();
            return aCycle;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Cycle> getAllCycles() {
        initializeConnection();
        ArrayList<Cycle> cycles = new ArrayList<Cycle>();
        Cycle aCycle = null;
        try {
            aCallableStatement = connector.prepareCall("{call getAllCycles()}");
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
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
       }finally{
            try {
                aCallableStatement.close();
                connector.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConcretePerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
    public static synchronized ConcreteCycle getInstance(){
        if(instance == null)
            instance = new ConcreteCycle();
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