/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Department;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IDepartment;
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
public class ConcreteDepartment implements IDepartment{
    
    private static ConcreteDepartment instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteDepartment(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }
    
    @Override
    public Department readDepartment(String department) {
        initializeConnection();
        try {
            Department aDepartment = new Department();
            aCallableStatement = connector.prepareCall("{call getDepartment(?)}");
            aCallableStatement.setString("pkDepartment",department);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                aDepartment.setAbbreviation(rs.getString("abbreviation"));
                aDepartment.setTitle(rs.getString("title"));
            }
            rs.close();
            return aDepartment;
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
    public ArrayList<Department> getAllDepartments() {
        initializeConnection();
         ArrayList<Department> departments = new ArrayList<Department>();
        Department aDepartment = null;
        try {
           aCallableStatement = connector.prepareCall("{call getAllDepartment()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aDepartment = new Department();
               aDepartment.setAbbreviation(rs.getString("abbreviation"));
               aDepartment.setTitle(rs.getString("title"));
               departments.add(aDepartment);
           }
           rs.close();
           return departments;
           
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
    
    public static synchronized ConcreteDepartment getInstance(){
        if(instance == null)
            instance = new ConcreteDepartment();
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
