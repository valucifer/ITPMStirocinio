package it.unisa.tirocinio.manager.concrete;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.beans.Person;
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
public class ConcreteOrganization implements IOrganization {

    private static ConcreteOrganization instance = null;

    /**
     *
     * @param organization
     * @return true if organization is created successfully, false otherwise
     */
    @Override
    public boolean createOrganization(Organization organization) {
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            if (organization == null) {
                throw new NullPointerException("Organization is null!");
            }

            aCallableStatement = connect.prepareCall("{call insertOrganization(?,?,?,?,?,?,?,?,?)}");
            aCallableStatement.setString("vatNumber", organization.getVATNumber());
            aCallableStatement.setString("companyName", organization.getCompanyName());
            aCallableStatement.setString("city", organization.getCity());
            aCallableStatement.setString("address", organization.getAddress());
            aCallableStatement.setString("phone", organization.getPhone());
            aCallableStatement.setString("email", organization.getEmail());
            aCallableStatement.setString("personSSN", organization.getProfessor());
            aCallableStatement.setString("accountEmail", organization.getAccount());
            aCallableStatement.setString("tutorSSN", organization.getExternalTutor());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
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
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call deleteOrganization(?)}");
            aCallableStatement.setString("vatNumber", VATNumber);
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
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
        Connection connect = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            if (organization == null) {
                throw new NullPointerException("Organization is null!");
            }

            aCallableStatement = connect.prepareCall("{call updateOrganization(?,?,?,?,?,?,?,?,?)}");
            aCallableStatement.setString("vatNumber", organization.getVATNumber());
            aCallableStatement.setString("companyName", organization.getCompanyName());
            aCallableStatement.setString("city", organization.getCity());
            aCallableStatement.setString("address", organization.getAddress());
            aCallableStatement.setString("phone", organization.getPhone());
            aCallableStatement.setString("email", organization.getEmail());
            aCallableStatement.setString("personSSN", organization.getProfessor());
            aCallableStatement.setString("accountEmail", organization.getAccount());
            aCallableStatement.setString("tutorSSN", organization.getExternalTutor());
            int check = aCallableStatement.executeUpdate();
            return check > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param VATNumber
     * @return an Organization object if reading operation from Database is
     * correct, null otherwise
     */
    @Override
    public Organization readOrganization(String VATNumber) {
        Connection connect = null;
        Organization anOrganization = new Organization();
        CallableStatement aCallableStatement = null;
        PersonManager aPerson = PersonManager.getInstance();
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getOrganizationByPrimaryKey(?)}");
            aCallableStatement.setString("vatNumber", VATNumber);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                anOrganization.setVATNumber(rs.getString("vat_number"));
                anOrganization.setCompanyName(rs.getString("company_name"));
                anOrganization.setCity(rs.getString("city"));
                anOrganization.setAddress(rs.getString("address"));
                anOrganization.setPhone(rs.getString("phone"));
                anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(rs.getString("fk_account"));
                anOrganization.setProfessor(aPerson.getPersonBySSN(rs.getString("fk_professor")).getSsn());
                anOrganization.setExternalTutor(aPerson.getPersonBySSN(rs.getString("fk_external_tutor")).getSsn());
            }
            rs.close();
            return anOrganization;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return an ArrayList of Organization if reading operation from Database
     * is correct, null otherwise
     */
    @Override
    public ArrayList<Organization> getAllOrganizations() {
        Connection connect = null;
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        Organization anOrganization = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getAllOrganizations()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
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
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param professorSSN
     * @return an ArrayList of Organization that contains every organization a
     * professor handle
     */
    @Override
    public ArrayList<Organization> getOwnOrganizations(String professorSSN) {
        Connection connect = null;
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        Organization anOrganization = null;
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            PersonManager aPerson = PersonManager.getInstance();
            aCallableStatement = connect.prepareCall("{call getOwnOrganizations(?)}");
            aCallableStatement.setString("professorSSN", professorSSN);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                anOrganization = new Organization();
                anOrganization.setVATNumber(rs.getString("vat_number"));
                anOrganization.setCompanyName(rs.getString("company_name"));
                anOrganization.setCity(rs.getString("city"));
                anOrganization.setAddress(rs.getString("address"));
                anOrganization.setPhone(rs.getString("phone"));
                anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(rs.getString("fk_account"));
                anOrganization.setProfessor(aPerson.getPersonBySSN(rs.getString("fk_professor")).getSsn());
                anOrganization.setExternalTutor(aPerson.getPersonBySSN(rs.getString("fk_external_tutor")).getSsn());
                organizations.add(anOrganization);
            }
            rs.close();
            return organizations;

        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param VATNumber
     * @return a Person object that contains informations about professor who
     * handle a certain organization
     */
    @Override
    public Person getProfessorOrganization(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        PersonManager person = PersonManager.getInstance();
        try {
            return person.getPersonBySSN(anOrganization.getProfessor());
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param VATNumber
     * @return a Person object that contains informations about external tutor
     */
    @Override
    public Person getExternalTutor(String VATNumber) {
        Organization anOrganization = this.readOrganization(VATNumber);
        PersonManager person = PersonManager.getInstance();
        try {
            return person.getPersonBySSN(anOrganization.getExternalTutor());
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param accountEmail
     * @return an Organization object which contains informations about the
     * organization through its email account
     */
    @Override
    public Organization getOrganizationByAccount(String accountEmail) {
        Connection connect = null;
        Organization anOrganization = new Organization();
        PersonManager aPerson = PersonManager.getInstance();
        CallableStatement aCallableStatement = null;
        try {
            connect = DBConnection.getConnection();
            aCallableStatement = connect.prepareCall("{call getOrganizationByAccount(?)}");
            aCallableStatement.setString("fkAccount", accountEmail);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                anOrganization.setVATNumber(rs.getString("vat_number"));
                anOrganization.setCompanyName(rs.getString("company_name"));
                anOrganization.setCity(rs.getString("city"));
                anOrganization.setAddress(rs.getString("address"));
                anOrganization.setPhone(rs.getString("phone"));
                anOrganization.setEmail(rs.getString("email"));
                anOrganization.setAccount(rs.getString("fk_account"));
                anOrganization.setProfessor(aPerson.getPersonBySSN(rs.getString("fk_professor")).getSsn());
                anOrganization.setExternalTutor(aPerson.getPersonBySSN(rs.getString("fk_external_tutor")).getSsn());
            }
            rs.close();
            return anOrganization;
        } catch (SQLException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ConnectionException ex) {
            Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                aCallableStatement.close();
                DBConnection.releaseConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ConcreteOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @return a ConcreteOrganization object if currently there is no
     * ConcreteOrganization objects alive
     */
    public static synchronized ConcreteOrganization getInstance() {
        if (instance == null) {
            instance = new ConcreteOrganization();
        }
        return instance;
    }

}
