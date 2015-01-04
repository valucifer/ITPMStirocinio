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

    /**
     *
     * @param organization
     * @return true if organization is created successfully, false otherwise
     */
    @Override
    public boolean createOrganization(Organization organization) {
        initializeConnection();
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
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
     * @param VATNumber
     * @return true if organization delete operation is correct, false otherwise
     */
    @Override
    public boolean deleteOrganization(String VATNumber) {
        initializeConnection();
       try {
            aCallableStatement = connector.prepareCall("{call deleteOrganization(?)}");       
            aCallableStatement.setString("vatNumber",VATNumber);
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
     * @param organization
     * @return true if organization update operation is correct, false otherwise
     */
    @Override
    public boolean updateOrganization(Organization organization) {
        initializeConnection();
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
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
     * @param VATNumber
     * @return an Organization object if reading operation from Database is correct, null otherwise
     */
    @Override
    public Organization readOrganization(String VATNumber) {
        initializeConnection();
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
     * @return an ArrayList of Organization if reading operation from Database is correct, null otherwise
     */
    @Override
    public ArrayList<Organization> getAllOrganizations() {
        initializeConnection();
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
               anOrganization.setAccount(rs.getString("fk_account"));
               anOrganization.setProfessor(rs.getString("fk_professor"));
               anOrganization.setExternalTutor(rs.getString("fk_external_tutor"));
               organizations.add(anOrganization);
           }
           rs.close();
           return organizations;
           
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
     * @param professorSSN
     * @return an ArrayList of Organization that contains every organization a professor handle
     */
    @Override
    public ArrayList<Organization> getOwnOrganizations(String professorSSN) {
        initializeConnection();
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
     * @param VATNumber
     * @return a Person object that contains informations about professor who handle a certain organization
     */
    @Override
    public Person getProfessorOrganization(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        ConcretePerson person = ConcretePerson.getInstance();
        return person.readPerson(anOrganization.getProfessor());
    }

    /**
     *
     * @param VATNumber
     * @return a Person object that contains informations about external tutor 
     */
    @Override
    public Person getExternalTutor(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        ConcretePerson person = ConcretePerson.getInstance();
        return person.readPerson(anOrganization.getExternalTutor());
    }

    /**
     *
     * @param accountEmail
     * @return an Organization object which contains informations about the organization through its email account
     */
    @Override
    public Organization getOrganizationByAccount(String accountEmail) {
        initializeConnection();
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
     * @return a ConcreteOrganization object if currently there is no ConcreteOrganization objects alive
     */
    public static synchronized ConcreteOrganization getInstance(){
        if(instance == null)
            instance = new ConcreteOrganization();
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
