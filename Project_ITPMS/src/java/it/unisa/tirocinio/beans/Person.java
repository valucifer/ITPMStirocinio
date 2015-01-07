package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public class Person {
    
    private String SSN = null;
    private String name = null;
    private String lastName = null;
    private String phone = null;
    private String city = null;
    private String address = null;
    private String zipCode = null;
    private String gender = null;
    private String citizenship = null;
    private String webPage = null;
    private String university = null;
    private String position = null;
    private String matricula = null;
    private String role = null;
    private Cycle cycle;
    private Department department;
    private Account account;
    private Degree degree;
    
    /**
     *
     */
    public Person(){}
    
    /**
     *
     * @param SSN
     * @param name
     * @param lastName
     * @param phone
     * @param city
     * @param address
     * @param zipCode
     * @param gender
     * @param citizenship
     * @param accountEmail
     * @param departmentAbbreviation
     * @param webPage
     * @param university
     * @param role
     * @param matricula
     * @param cycle
     */
    public Person(String SSN, String name, String lastName, String phone, String city, String address, String zipCode, String gender, Degree degree, String citizenship, Account accountEmail, Department departmentAbbreviation, String webPage, String university, String role, String matricula, Cycle cycle){
        this.SSN = SSN;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.gender = gender;
        this.citizenship = citizenship;
        this.account = accountEmail;
        this.department = departmentAbbreviation;
        this.webPage = webPage;
        this.university = university;
        this.role = role;
        this.matricula = matricula;
        this.cycle = cycle;
        this.degree = degree;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getLastName() {
        return lastName;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public Department getDepartment() {
        return department;
    }

    public Account getAccount() {
        return account;
    }

    public Degree getDegree() {
        return degree;
    }

    /**
     *
     * @return person SSN 
     */
    public String getSSN() {
        return SSN;
    }

    /**
     *
     * @return person name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return person last name
     */
    public String getSurname() {
        return lastName;
    }

    /**
     *
     * @return person phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return city where person lives
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return person address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return city zip code 
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *
     * @return person gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @return person citizenship
     */
    public String getCitizenship() {
        return citizenship;
    }
    
    /**
     *
     * @return person role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param SSN
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.lastName = surname;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @param citizenship
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     *
     * @return
     */
    public String getWebPage() {
        return webPage;
    }

    /**
     *
     * @return person university
     */
    public String getUniversity() {
        return university;
    }

    /**
     *
     * @return person position
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @return person matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param webPage
     */
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    /**
     *
     * @param university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     *
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
