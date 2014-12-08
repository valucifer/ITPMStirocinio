/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.beans.Person;
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
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public boolean createOrganization(Organization organization) {
        try {
            if( organization == null )
                throw new NullPointerException("Organization is null!");
            
            aCallableStatement = connector.prepareCall("{call insertOrganization(?,?,?,?,?,?,?,?,?)}");       
            aCallableStatement.setString("vatNumber",organization.getVATNumber());
            aCallableStatement.setString("companyName",organization.getCompanyName());
            aCallableStatement.setString("city",organization.getCity());
            aCallableStatement.setString("address",organization.getAddress());
            aCallableStatement.setString("phone",organization.getPhone());
            aCallableStatement.setString("email",organization.getEmail());
            aCallableStatement.setString("personSSN",organization.getProfessor());
            aCallableStatement.setString("accountEmail",organization.getAccount());
            aCallableStatement.setString("tutorSSN",organization.getExternalTutor());
            boolean toReturn = aCallableStatement.execute();
           // connector.close();
            
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deleteOrganization(String VATNumber) {
        try {
            aCallableStatement = connector.prepareCall("{call deleteOrganization(?)}");       
            aCallableStatement.setString("vatNumber",VATNumber);
            boolean toReturn = aCallableStatement.execute();
            connector.close();
            
            return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateOrganization(Organization organization) {
        try {
            if( organization == null )
                throw new NullPointerException("Organization is null!");
            
            aCallableStatement = connector.prepareCall("{call updateOrganization(?,?,?,?,?,?,?,?,?)}");       
            aCallableStatement.setString("vatNumber",organization.getVATNumber());
            aCallableStatement.setString("companyName",organization.getCompanyName());
            aCallableStatement.setString("city",organization.getCity());
            aCallableStatement.setString("address",organization.getAddress());
            aCallableStatement.setString("phone",organization.getPhone());
            aCallableStatement.setString("email",organization.getEmail());
            aCallableStatement.setString("personSSN",organization.getProfessor());
            aCallableStatement.setString("accountEmail",organization.getAccount());
            aCallableStatement.setString("tutorSSN",organization.getExternalTutor());
            boolean toReturn = aCallableStatement.execute();
            aCallableStatement.close();
            //connector.close();
            
            return toReturn;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Organization readOrganization(String VATNumber) {
        Organization anOrganization = new Organization();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcretePerson aProfessor = ConcretePerson.getInstance();
        ConcretePerson aTutor = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOrganizationByPrimaryKey(?)}");
            aCallableStatement.setString("vatNumber",VATNumber);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                anOrganization.setVATNumber(rs.getString("vat_number"));
                anOrganization.setCompanyName(rs.getString("company_name"));
                anOrganization.setCity(rs.getString("city"));
                anOrganization.setAddress(rs.getString("address"));
                anOrganization.setPhone(rs.getString("phone"));
                anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(anAccount.readAccount(rs.getString("fk_account")).getEmail());
                anOrganization.setProfessor(aProfessor.readPerson(rs.getString("fk_professor")).getSSN());
                anOrganization.setExternalTutor(aTutor.readPerson(rs.getString("fk_external_tutor")).getSSN());
            }
            rs.close();
            return anOrganization;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Organization> getAllOrganizations() {
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        Organization anOrganization = null;
        try {
           ConcreteAccount anAccount = ConcreteAccount.getInstance();
           ConcretePerson aProfessor = ConcretePerson.getInstance();
           ConcretePerson aTutor = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getAllOrganizations()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               anOrganization = new Organization();
               anOrganization.setVATNumber(rs.getString("vat_number"));
               anOrganization.setCompanyName(rs.getString("company_name"));
               anOrganization.setCity(rs.getString("city"));
               anOrganization.setAddress(rs.getString("address"));
               anOrganization.setPhone(rs.getString("phone"));
               anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(anAccount.readAccount(rs.getString("fk_account")).getEmail());
                anOrganization.setProfessor(aProfessor.readPerson(rs.getString("fk_professor")).getSSN());
                anOrganization.setExternalTutor(aTutor.readPerson(rs.getString("fk_external_tutor")).getSSN());
               organizations.add(anOrganization);
           }
           rs.close();
           return organizations;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
    
    @Override
    public ArrayList<Organization> getOwnOrganizations(String professorSSN) {
        
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        Organization anOrganization = null;
        try {
           ConcreteAccount anAccount = ConcreteAccount.getInstance();
           ConcretePerson aProfessor = ConcretePerson.getInstance();
           ConcretePerson aTutor = ConcretePerson.getInstance();
           aCallableStatement = connector.prepareCall("{call getOwnOrganizations(?)}");
           aCallableStatement.setString("professorSSN",professorSSN);
           ResultSet rs = aCallableStatement.executeQuery();
          
           while( rs.next() ){
               anOrganization = new Organization();
               anOrganization.setVATNumber(rs.getString("vat_number"));
               anOrganization.setCompanyName(rs.getString("company_name"));
               anOrganization.setCity(rs.getString("city"));
               anOrganization.setAddress(rs.getString("address"));
               anOrganization.setPhone(rs.getString("phone"));
               anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(anAccount.readAccount(rs.getString("fk_account")).getEmail());
                anOrganization.setProfessor(aProfessor.readPerson(rs.getString("fk_professor")).getSSN());
                anOrganization.setExternalTutor(aTutor.readPerson(rs.getString("fk_external_tutor")).getSSN());
               organizations.add(anOrganization);
           }
           rs.close();
           return organizations;
           
       } catch (SQLException ex) {
           Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
    
    @Override
    public Person getProfessorOrganization(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        ConcretePerson person = ConcretePerson.getInstance();
        return person.readPerson(anOrganization.getProfessor());
    }

    @Override
    public Person getExternalTutor(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        ConcretePerson person = ConcretePerson.getInstance();
        return person.readPerson(anOrganization.getExternalTutor());
    }

    @Override
    public Organization getOrganizationByAccount(String accountEmail) {
        Organization anOrganization = new Organization();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcretePerson aProfessor = ConcretePerson.getInstance();
        ConcretePerson aTutor = ConcretePerson.getInstance();
        try {
            aCallableStatement = connector.prepareCall("{call getOrganizationByAccount(?)}");
            aCallableStatement.setString("fkAccount",accountEmail);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
                anOrganization.setVATNumber(rs.getString("vat_number"));
                anOrganization.setCompanyName(rs.getString("company_name"));
                anOrganization.setCity(rs.getString("city"));
                anOrganization.setAddress(rs.getString("address"));
                anOrganization.setPhone(rs.getString("phone"));
                anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(anAccount.readAccount(rs.getString("fk_account")).getEmail());
                anOrganization.setProfessor(aProfessor.readPerson(rs.getString("fk_professor")).getSSN());
                anOrganization.setExternalTutor(aTutor.readPerson(rs.getString("fk_external_tutor")).getSSN());
            }
            rs.close();
            return anOrganization;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ConcreteOrganization getInstance(){
        instance = new ConcreteOrganization();
        return instance;
    }
    
}
