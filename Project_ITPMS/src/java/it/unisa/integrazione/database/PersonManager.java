package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.database.exception.MissingDataException;
import it.unisa.integrazione.database.utility.Utilities;
import it.unisa.integrazione.model.Account;
import it.unisa.integrazione.model.Cycle;
import it.unisa.integrazione.model.Department;
import it.unisa.integrazione.model.Person;
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
public class PersonManager {

    private static PersonManager instance;

    public static PersonManager getInstance() {

        if (instance == null) {
            instance = new PersonManager();
        }
        return instance;

    }

    public void add(Person pPerson) throws SQLException, ConnectionException, MissingDataException {
        Connection connect = DBConnection.getConnection();

        if (CycleManager.getInstance().getCycleByCycleNumber(pPerson.getCycle().getCycleNumber()) == null) {
            throw new MissingDataException();
        }

        if (DepartmentManager.getInstance().getDepartmentByAbbreviation(pPerson.getDepartment().getAbbreviation()) == null) {
            DepartmentManager.getInstance().add(pPerson.getDepartment());
        }

        AccountManager.getInstance().add(pPerson.getAccount());

        String sql = "INSERT INTO person (SSN, person.name, surname, phone, "
                + "city, address, zip_code, gender, citizenship, Account_email, "
                + "Department_abbreviation, web_page, university, matricula, "
                + "position, cycle";

        if (pPerson.getDegree() != null) {
            sql += ",  degree_matricula) VALUES (";
        } else {
            sql += ") VALUES ( ";
        }

        sql += "\"" + pPerson.getSsn() + "\",\""
                + Utilities.emptyValue(pPerson.getName()) + "\",\"" + Utilities.emptyValue(pPerson.getSurname()) + "\",\""
                + Utilities.emptyValue(pPerson.getPhone()) + "\",\"" + Utilities.emptyValue(pPerson.getCity()) + "\",\""
                + Utilities.emptyValue(pPerson.getAddress()) + "\",\"" + Utilities.emptyValue(pPerson.getZipCode()) + "\",\""
                + Utilities.emptyValue(pPerson.getGender()) + "\",\"" + Utilities.emptyValue(pPerson.getCitizenship()) + "\",\""
                + pPerson.getAccount().getEmail() + "\",\""
                + Utilities.emptyValue(pPerson.getDepartment().getAbbreviation()) + "\",\""
                + Utilities.emptyValue(pPerson.getWebPage()) + "\",\"" + Utilities.emptyValue(pPerson.getUniversity()) + "\",\""
                + Utilities.emptyValue(pPerson.getMatricula()) + "\",\"" + Utilities.emptyValue(pPerson.getPosition()) + "\","
                + pPerson.getCycle().getCycleNumber();

        if (pPerson.getDegree() != null) {
            sql += ",\""
                    + Utilities.emptyValue(pPerson.getDegree().getMatricula()) + "\")";
        } else {
            sql += ")";
        }

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    public Person getPersonBySSN(String pSSN) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person person = null;

        String query = "select * from person where SSN = '" + pSSN + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setSsn(rs.getString("SSN"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPhone(rs.getString("phone"));
                person.setCity(rs.getString("city"));
                person.setAddress(rs.getString("address"));
                person.setZipCode(rs.getString("zip_code"));
                person.setGender(rs.getString("gender"));
                person.setCitizenship(rs.getString("citizenship"));
                person.setWebPage(rs.getString("web_page"));
                person.setUniversity(rs.getString("university"));
                person.setMatricula(rs.getString("matricula"));
                person.setPosition(rs.getString("position"));

                person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation("Department_abbreviation"));
                person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(rs.getInt("cycle")));

                if (rs.getString("degree_matricula") != null) {
                    person.setDegree(DegreeManager.getInstance().readDegree(person.getMatricula()));
                }

            }
        } finally {
            DBConnection.releaseConnection(connection);
        }

        return person;
    }

    public Person getPersonByEmail(String pEmail) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person person = null;

        String query = "select * from person where Account_email = '" + pEmail + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setSsn(rs.getString("SSN"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPhone(rs.getString("phone"));
                person.setCity(rs.getString("city"));
                person.setAddress(rs.getString("address"));
                person.setZipCode(rs.getString("zip_code"));
                person.setGender(rs.getString("gender"));
                person.setCitizenship(rs.getString("citizenship"));
                person.setWebPage(rs.getString("web_page"));
                person.setUniversity(rs.getString("university"));
                person.setMatricula(rs.getString("matricula"));
                person.setPosition(rs.getString("position"));

                person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation("Department_abbreviation"));
                person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(rs.getInt("cycle")));
                person.setAccount(AccountManager.getInstance().getAccoutnByEmail(pEmail));

                if (rs.getString("degree_matricula") != null) {
                    person.setDegree(DegreeManager.getInstance().readDegree(person.getMatricula()));
                }

            }
        } finally {

            DBConnection.releaseConnection(connection);
        }

        return person;
    }

    /* /// //// */
    /**
     *
     * @param SSN
     * @return a Person object if reading operation from Database is correct,
     * null otherwise
     */
    public Person readPerson(String SSN) {
        Person aPerson = new Person();

        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }
            aCallableStatement = connection.prepareCall("{call getPerson(?)}");
            aCallableStatement.setString("personSSN", SSN);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                AccountManager anAccount = AccountManager.getInstance();
                Account account = anAccount.readAccount(rs.getString("Account_email"));
                aPerson.setAccount(account);
                aPerson.setAddress(rs.getString("address"));
                aPerson.setCitizenship(rs.getString("citizenship"));
                aPerson.setCity(rs.getString("city"));
                CycleManager aCycle = CycleManager.getInstance();
                Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
                aPerson.setCycle(cycle);
                DepartmentManager aDepartment = DepartmentManager.getInstance();
                Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
                aPerson.setDepartment(department);
                aPerson.setGender(rs.getString("gender"));
                aPerson.setMatricula(rs.getString("matricula"));
                aPerson.setName(rs.getString("name"));
                aPerson.setPhone(rs.getString("phone"));
                aPerson.setPosition(rs.getString("position"));
                aPerson.setSsn(rs.getString("SSN"));
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
        } catch (ConnectionException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return an ArrayList of Person if reading operation from Database is
     * correct, null otherwise
     */
    public ArrayList<Person> getAllPeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        Person aPerson = null;
        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }
            aCallableStatement = connection.prepareCall("{call getAllPeople()}");
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                aPerson = new Person();
                AccountManager anAccount = AccountManager.getInstance();
                Account account = anAccount.readAccount(rs.getString("Account_email"));
                aPerson.setAccount(account);
                aPerson.setAddress(rs.getString("address"));
                aPerson.setCitizenship(rs.getString("citizenship"));
                aPerson.setCity(rs.getString("city"));
                CycleManager aCycle = CycleManager.getInstance();
                Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
                aPerson.setCycle(cycle);
                DepartmentManager aDepartment = DepartmentManager.getInstance();
                Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
                aPerson.setDepartment(department);
                aPerson.setGender(rs.getString("gender"));
                aPerson.setMatricula(rs.getString("matricula"));
                aPerson.setName(rs.getString("name"));
                aPerson.setPhone(rs.getString("phone"));
                aPerson.setPosition(rs.getString("position"));
                aPerson.setSsn(rs.getString("SSN"));
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
        } catch (ConnectionException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
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
     * @param email
     * @return type of account of a certain email address
     */
    public String getTypeOfAccountPerson(String email) {
        AccountManager account = AccountManager.getInstance();
        try {
            return account.readAccount(email).getTypeOfAccount();
        } catch (SQLException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to a student, false otherwise
     */
    public boolean isAStudent(String email) {
        String Bstudent = "Bstudent";
        String Mstudent = "Mstudent";
        String phd = "phd";

        String variable = this.getTypeOfAccountPerson(email);
        //Sys
        return variable.equalsIgnoreCase(Bstudent) || variable.equalsIgnoreCase(Mstudent) || variable.equalsIgnoreCase(phd);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to a professor, false otherwise
     */
    public boolean isAProfessor(String email) {
        String professor = "professor";
        String professore = "professore";

        String variable = this.getTypeOfAccountPerson(email);

        return variable.equalsIgnoreCase(professor) || variable.equalsIgnoreCase(professore);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to an organization, false
     * otherwise
     */
    public boolean isAnOrganization(String email) {
        String org = "organization";
        String orga = "company";

        String variable = this.getTypeOfAccountPerson(email);

        return variable.equalsIgnoreCase(org) || variable.equalsIgnoreCase(orga);
    }

    /**
     *
     * @param email
     * @return true if an email address belongs to an administrator, false
     * otherwise
     */
    public boolean isAnAdministrator(String email) {
        String adm = "administrator";
        String amm = "admin";

        String variable = this.getTypeOfAccountPerson(email);

        return variable.equalsIgnoreCase(adm) || variable.equalsIgnoreCase(amm);
    }

    /**
     *
     * @param email
     * @return a Person Object if there is a professor represented by a certain
     * email address, null otherwise
     */
    public Person getProfessor(String email) {
        if (this.isAProfessor(email)) {
            return this.readPersonByAccount(email);
        }
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is a student represented by a certain
     * email address, null otherwise
     */
    public Person getStudent(String email) {
        if (this.isAStudent(email)) {
            return this.readPersonByAccount(email);
        }
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is an organization represented by a
     * certain email address, null otherwise
     */
    public Person getOrganization(String email) {
        if (this.isAnOrganization(email)) {
            return this.readPersonByAccount(email);
        }
        return null;
    }

    /**
     *
     * @param email
     * @return a Person Object if there is an administrator represented by a
     * certain email address, null otherwise
     */
    public Person getAdministrator(String email) {
        if (this.isAnAdministrator(email)) {
            return this.readPersonByAccount(email);
        }
        return null;
    }

    /**
     *
     * @param email
     * @return a Person object if there is a person into Database with the given
     * email address
     */
    public Person readPersonByAccount(String email) {
        Person aPerson = new Person();
        AccountManager anAccount = AccountManager.getInstance();
        CycleManager aCycle = CycleManager.getInstance();
        DepartmentManager aDepartment = DepartmentManager.getInstance();
        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            aCallableStatement = connection.prepareCall("{call getPersonByAccount(?)}");
            aCallableStatement.setString("email", email);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
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
                aPerson.setSsn(rs.getString("SSN"));
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
        } catch (ConnectionException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
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
     * @param matricula
     * @return
     */
    public Person getPersonByMatricula(String matricula) {
        Person aPerson = new Person();
        Connection connection = null;
        CallableStatement aCallableStatement = null;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            aCallableStatement = connection.prepareCall("{call getPersonByMatricula(?)}");
            aCallableStatement.setString("matric", matricula);
            ResultSet rs = aCallableStatement.executeQuery();

            while (rs.next()) {
                AccountManager anAccount = AccountManager.getInstance();
                Account account = anAccount.readAccount(rs.getString("Account_email"));
                aPerson.setAccount(account);
                aPerson.setAddress(rs.getString("address"));
                aPerson.setCitizenship(rs.getString("citizenship"));
                aPerson.setCity(rs.getString("city"));
                CycleManager aCycle = CycleManager.getInstance();
                Cycle cycle = aCycle.readCycle(rs.getInt("cycle"));
                aPerson.setCycle(cycle);
                DepartmentManager aDepartment = DepartmentManager.getInstance();
                Department department = aDepartment.readDepartment(rs.getString("Department_abbreviation"));
                aPerson.setDepartment(department);
                aPerson.setGender(rs.getString("gender"));
                aPerson.setMatricula(rs.getString("matricula"));
                aPerson.setName(rs.getString("name"));
                aPerson.setPhone(rs.getString("phone"));
                aPerson.setPosition(rs.getString("position"));
                aPerson.setSsn(rs.getString("SSN"));
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
        } catch (ConnectionException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
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
