package it.unisa.tirocinio.manager.concrete;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Cycle;
import it.unisa.tirocinio.beans.Department;
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

    /**
     *
     * @param SSN
     * @return a Person object if reading operation from Database is correct, null otherwise
     */
    @Override
    public Person readPerson(String SSN) {
        initializeConnection();
        Person aPerson = new Person();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPerson(?)}");
            aCallableStatement.setString("personSSN",SSN);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               ConcreteAccount anAccount = ConcreteAccount.getInstance();
               Account account = anAccount.readAccount(rs.getString("Account_email"));
               aPerson.setAccount(account);
               aPerson.setAddress(rs.getString("address"));
               aPerson.setCitizenship(rs.getString("citizenship"));
               aPerson.setCity(rs.getString("city"));
               ConcreteCycle aCycle = ConcreteCycle.getInstance();
               Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
               aPerson.setCycle(cycle);
               ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
               Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
               aPerson.setDepartment(department);
               aPerson.setGender(rs.getString("gender"));
               aPerson.setMatricula(rs.getString("matricula"));
               aPerson.setName(rs.getString("name"));
               aPerson.setPhone(rs.getString("phone"));
               aPerson.setPosition(rs.getString("position"));
               aPerson.setSSN(rs.getString("SSN"));
               aPerson.setSurname(rs.getString("surname"));
               aPerson.setUniversity(rs.getString("university"));
               aPerson.setWebPage(rs.getString("web_page"));
               aPerson.setZipCode(rs.getString("zip_code"));
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

    /**
     *
     * @return an ArrayList of Person if reading operation from Database is correct, null otherwise
     */
    @Override
    public ArrayList<Person> getAllPeople() {
        initializeConnection();
        ArrayList<Person> people = new ArrayList<Person>();
        Person aPerson = null;
        try {
           aCallableStatement = connector.prepareCall("{call getAllPeople()}");
           ResultSet rs = aCallableStatement.executeQuery();
           
           while( rs.next() ){
               aPerson = new Person();
               ConcreteAccount anAccount = ConcreteAccount.getInstance();
               Account account = anAccount.readAccount(rs.getString("Account_email"));
               aPerson.setAccount(account);
               aPerson.setAddress(rs.getString("address"));
               aPerson.setCitizenship(rs.getString("citizenship"));
               aPerson.setCity(rs.getString("city"));
               ConcreteCycle aCycle = ConcreteCycle.getInstance();
               Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
               aPerson.setCycle(cycle);
               ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
               Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
               aPerson.setDepartment(department);
               aPerson.setGender(rs.getString("gender"));
               aPerson.setMatricula(rs.getString("matricula"));
               aPerson.setName(rs.getString("name"));
               aPerson.setPhone(rs.getString("phone"));
               aPerson.setPosition(rs.getString("position"));
               aPerson.setSSN(rs.getString("SSN"));
               aPerson.setSurname(rs.getString("surname"));
               aPerson.setUniversity(rs.getString("university"));
               aPerson.setWebPage(rs.getString("web_page"));
               aPerson.setZipCode(rs.getString("zip_code"));
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

    /**
     *
     * @param email
     * @return type of account of a certain email address
     */
    @Override
    public String getTypeOfAccountPerson(String email) {
        ConcreteAccount account = ConcreteAccount.getInstance();
        return account.readAccount(email).getTypeOfAccount();
    }
    
    /**
     *
     * @param email
     * @return true if an email address belongs to a student, false otherwise
     */
    @Override
    public boolean isAStudent(String email) {
        String student = "student";
        String studente = "studente";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(student) || variable.equalsIgnoreCase(studente);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to a professor, false otherwise
     */
    @Override
    public boolean isAProfessor(String email) {
        String professor = "professor";
        String professore = "professore";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(professor) || variable.equalsIgnoreCase(professore);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to an organization, false otherwise
     */
    @Override
    public boolean isAnOrganization(String email) {
        String org = "organization";
        String orga = "organizzazione";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(org) || variable.equalsIgnoreCase(orga);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to an administrator, false otherwise
     */
    @Override
    public boolean isAnAdministrator(String email) {
        String adm = "administrator";
        String amm = "amministratore";
        
        String variable = this.getTypeOfAccountPerson(email);
        
        return variable.equalsIgnoreCase(adm) || variable.equalsIgnoreCase(amm);
    }
    
    /**
     *
     * @param email
     * @return a Person Object if there is a professor represented by a certain email address, null otherwise
     */
    @Override
    public Person getProfessor(String email) {
        if(this.isAProfessor(email))
            return this.readPersonByAccount(email);
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is a student represented by a certain email address, null otherwise
     */
    @Override
    public Person getStudent(String email) {
        if(this.isAStudent(email))
            return this.readPersonByAccount(email);
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is an organization represented by a certain email address, null otherwise
     */
    @Override
    public Person getOrganization(String email) {
        if(this.isAnOrganization(email))
            return this.readPersonByAccount(email);
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is an administrator represented by a certain email address, null otherwise
     */
    @Override
    public Person getAdministrator(String email) {
        if(this.isAnAdministrator(email))
            return this.readPersonByAccount(email);
        return null;
    }
    
    /**
     *
     * @param email
     * @return a Person object if there is a person into Database with the given email address
     */
    @Override
    public Person readPersonByAccount(String email) {
        initializeConnection();
        Person aPerson = new Person();
        ConcreteAccount anAccount = ConcreteAccount.getInstance();
        ConcreteCycle aCycle = ConcreteCycle.getInstance();
        ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPersonByAccount(?)}");
            aCallableStatement.setString("email",email);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               Account account = anAccount.readAccount(rs.getString("Account_email"));
               aPerson.setAccount(account);
               aPerson.setAddress(rs.getString("address"));
               aPerson.setCitizenship(rs.getString("citizenship"));
               aPerson.setCity(rs.getString("city"));
               Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
               aPerson.setCycle(cycle);
               Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
               aPerson.setDepartment(department);
               aPerson.setGender(rs.getString("gender"));
               aPerson.setMatricula(rs.getString("matricula"));
               aPerson.setName(rs.getString("name"));
               aPerson.setPhone(rs.getString("phone"));
               aPerson.setPosition(rs.getString("position"));
               aPerson.setSSN(rs.getString("SSN"));
               aPerson.setSurname(rs.getString("surname"));
               aPerson.setUniversity(rs.getString("university"));
               aPerson.setWebPage(rs.getString("web_page"));
               aPerson.setZipCode(rs.getString("zip_code"));
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
    
    /**
     *
     * @return a ConcretePerson instance if there are no ConcretePerson instances currently alive
     */
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

    /**
     *
     * @param matricula
     * @return
     */
    @Override
    public Person getPersonByMatricula(String matricula) {
        initializeConnection();
        Person aPerson = new Person();
        
        try {
            aCallableStatement = connector.prepareCall("{call getPersonByMatricula(?)}");
            aCallableStatement.setString("matric",matricula);
            ResultSet rs = aCallableStatement.executeQuery();
            
            while( rs.next() ){
               ConcreteAccount anAccount = ConcreteAccount.getInstance();
               Account account = anAccount.readAccount(rs.getString("Account_email"));
               aPerson.setAccount(account);
               aPerson.setAddress(rs.getString("address"));
               aPerson.setCitizenship(rs.getString("citizenship"));
               aPerson.setCity(rs.getString("city"));
               ConcreteCycle aCycle = ConcreteCycle.getInstance();
               Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
               aPerson.setCycle(cycle);
               ConcreteDepartment aDepartment = ConcreteDepartment.getInstance();
               Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
               aPerson.setDepartment(department);
               aPerson.setGender(rs.getString("gender"));
               aPerson.setMatricula(rs.getString("matricula"));
               aPerson.setName(rs.getString("name"));
               aPerson.setPhone(rs.getString("phone"));
               aPerson.setPosition(rs.getString("position"));
               aPerson.setSSN(rs.getString("SSN"));
               aPerson.setSurname(rs.getString("surname"));
               aPerson.setUniversity(rs.getString("university"));
               aPerson.setWebPage(rs.getString("web_page"));
               aPerson.setZipCode(rs.getString("zip_code"));
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
