/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IOrganization;
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
public class ConcreteOrganization implements IOrganization{
    
    private static ConcreteOrganization instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcreteOrganization(){
        instance = new ConcreteOrganization();
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createOrganization(Organization organization) {
        try {
            if( organization == null )
                throw new NullPointerException("Organization is null!");
            aCallableStatement = connector.prepareCall("{call insertOrganization(?,?,?,?,?,?,?,?,?,?)}");       
            aCallableStatement.setString("vat_number",organization.getVATNumber());
            aCallableStatement.setString("company_name",organization.getCompanyName());
            aCallableStatement.setString("city",organization.getCity());
            aCallableStatement.setString("address",organization.getAddress());
            aCallableStatement.setString("phone",organization.getPhone());
            aCallableStatement.setString("email",organization.getEmail());
            aCallableStatement.setString("phone",organization.getEmail());
            //Mancano le chiavi esterne!
            ResultSet rs = aCallableStatement.executeQuery();
            aCallableStatement.close();
            connector.close();
            return rs.getFetchSize() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deleteOrganization(String VATNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateOrganization(it.unisa.tirocinio.beans.Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization readOrganization(String VATNumber) {
        Organization toReturn = new Organization();
        
        return toReturn;
    }

    @Override
    public ArrayList<it.unisa.tirocinio.beans.Organization> searchOrganizationByVATNumber(String VATNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<it.unisa.tirocinio.beans.Organization> getAllOrganizations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ConcreteOrganization getInstance(){
        return instance;
    }
    
}
