/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.manager.DBConnector;
import it.unisa.tirocinio.manager.interfaces.IPerson;
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
public class ConcretePerson implements IPerson{
    
    private static ConcretePerson instance = null;
    private Connection connector = null;
    private CallableStatement aCallableStatement = null;
    
    private ConcretePerson(){
        connector = DBConnector.getConnection();
        if( connector == null )
            throw new RuntimeException("Unable to connect to Database.");
    }

    @Override
    public Person readPerson(String SSN) {
        initializeConnection();
        Person aPerson = new Person();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcreteCycle aCycle = ConcreteCycle.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPerson(?)}");
            aCallableStatement.setString("personSSN",SSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               aPerson.setAccountEmail(anAccount.readAccount(rs.getString(10)).getEmail());
               aPerson.setAddress(rs.getString(6));
               aPerson.setCitizenship(rs.getString(9));
               aPerson.setCity(rs.getString(5));
               aPerson.setCycle(aCycle.readCycle(rs.getInt(16)).getCycleNumber());
               aPerson.setDepartmentAbbreviation(aDepartment.readDepartment(rs.getString(11)).getAbbreviation());
               aPerson.setGender(rs.getString(8));
               aPerson.setMatricula(rs.getString(14));
               aPerson.setName(rs.getString(2));
               aPerson.setPhone(rs.getString(4));
               aPerson.setPosition(rs.getString(15));
               aPerson.setSSN(rs.getString(1));
               aPerson.setSurname(rs.getString(3));
               aPerson.setUniversity(rs.getString(13));
               aPerson.setWebPage(rs.getString(12));
               aPerson.setZipCode(rs.getString(7));
            }
            rs.close();
            return aPerson;
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
    public ArrayList<Person> getAllPeople() {
        initializeConnection();
        ArrayList<Person> people = new ArrayList<Person>();
        Person aPerson = null;
        try {
           ConcreteAccount anAccount = ConcreteAccount.getInstance();
           ConcreteCycle aCycle = ConcreteCycle.getInstance();
           ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
           
           aCallableStatement = connector.prepareCall("{call getAllPeople()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aPerson = new Person();
               aPerson.setAccountEmail(anAccount.readAccount(rs.getString(10)).getEmail());
               aPerson.setAddress(rs.getString(6));
               aPerson.setCitizenship(rs.getString(9));
               aPerson.setCity(rs.getString(5));
               aPerson.setCycle(aCycle.readCycle(rs.getInt(16)).getCycleNumber());
               aPerson.setDepartmentAbbreviation(aDepartment.readDepartment(rs.getString(11)).getAbbreviation());
               aPerson.setGender(rs.getString(8));
               aPerson.setMatricula(rs.getString(14));
               aPerson.setName(rs.getString(2));
               aPerson.setPhone(rs.getString(4));
               aPerson.setPosition(rs.getString(15));
               aPerson.setSSN(rs.getString(1));
               aPerson.setSurname(rs.getString(3));
               aPerson.setUniversity(rs.getString(13));
               aPerson.setWebPage(rs.getString(12));
               aPerson.setZipCode(rs.getString(7));
               people.add(aPerson);
           }
           rs.close();
           return people;
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
    public String getTypeOfAccountPerson(String email) {
        ConcreteAccount account = ConcreteAccount.getInstance();
        return account.readAccount(email).getTypeOfAccount();
    }
    
     @Override
    public boolean isAStudent(String email) {
        String student = "student";
        String studente = "studente";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(student) || variable.equalsIgnoreCase(studente);
    }

    @Override
    public boolean isAProfessor(String email) {
        String professor = "professor";
        String professore = "professore";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(professor) || variable.equalsIgnoreCase(professore);
    }

    @Override
    public boolean isAnOrganization(String email) {
        String org = "organization";
        String orga = "organizzazione";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(org) || variable.equalsIgnoreCase(orga);
    }

    @Override
    public boolean isAnAdministrator(String email) {
        String adm = "administrator";
        String amm = "amministratore";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(adm) || variable.equalsIgnoreCase(amm);
    }
    
    @Override
    public Person getProfessor(String email) {
        if(this.isAProfessor(email))
            return this.readPersonForAccount(email);
        return null;
    }

    @Override
    public Person getStudent(String email) {
        if(this.isAStudent(email))
            return this.readPersonForAccount(email);
        return null;
    }

    @Override
    public Person getOrganization(String email) {
        if(this.isAnOrganization(email))
            return this.readPersonForAccount(email);
        return null;
    }

    @Override
    public Person getAdministrator(String email) {
        if(this.isAnAdministrator(email))
            return this.readPersonForAccount(email);
        return null;
    }
    
    @Override
    public Person readPersonForAccount(String email) {
        initializeConnection();
        Person aPerson = new Person();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcreteCycle aCycle = ConcreteCycle.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPersonForAccount(?)}");
            aCallableStatement.setString("email",email);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               aPerson.setAccountEmail(anAccount.readAccount(rs.getString(10)).getEmail());
               aPerson.setAddress(rs.getString(6));
               aPerson.setCitizenship(rs.getString(9));
               aPerson.setCity(rs.getString(5));
               aPerson.setCycle(aCycle.readCycle(rs.getInt(16)).getCycleNumber());
               aPerson.setDepartmentAbbreviation(aDepartment.readDepartment(rs.getString(11)).getAbbreviation());
               aPerson.setGender(rs.getString(8));
               aPerson.setMatricula(rs.getString(14));
               aPerson.setName(rs.getString(2));
               aPerson.setPhone(rs.getString(4));
               aPerson.setPosition(rs.getString(15));
               aPerson.setSSN(rs.getString(1));
               aPerson.setSurname(rs.getString(3));
               aPerson.setUniversity(rs.getString(13));
               aPerson.setWebPage(rs.getString(12));
               aPerson.setZipCode(rs.getString(7));
            }
            rs.close();
            return aPerson;
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
    
    public static synchronized ConcretePerson getInstance(){ 
        if(instance == null)
            instance = new ConcretePerson();
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

    @Override
    public Person getPersonToMatricula(String matricula) {
        initializeConnection();
        Person aPerson = new Person();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcreteCycle aCycle = ConcreteCycle.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPersonForMatricula(?)}");
            aCallableStatement.setString("matricula",matricula);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               aPerson.setAccountEmail(anAccount.readAccount(rs.getString(10)).getEmail());
               aPerson.setAddress(rs.getString(6));
               aPerson.setCitizenship(rs.getString(9));
               aPerson.setCity(rs.getString(5));
               aPerson.setCycle(aCycle.readCycle(rs.getInt(16)).getCycleNumber());
               aPerson.setDepartmentAbbreviation(aDepartment.readDepartment(rs.getString(11)).getAbbreviation());
               aPerson.setGender(rs.getString(8));
               aPerson.setMatricula(rs.getString(14));
               aPerson.setName(rs.getString(2));
               aPerson.setPhone(rs.getString(4));
               aPerson.setPosition(rs.getString(15));
               aPerson.setSSN(rs.getString(1));
               aPerson.setSurname(rs.getString(3));
               aPerson.setUniversity(rs.getString(13));
               aPerson.setWebPage(rs.getString(12));
               aPerson.setZipCode(rs.getString(7));
            }
            rs.close();
            return aPerson;
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
}
