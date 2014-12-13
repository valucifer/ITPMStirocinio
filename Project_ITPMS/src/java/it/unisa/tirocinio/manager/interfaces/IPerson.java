/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.interfaces;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Person;
import java.util.ArrayList;

/**
 *
 * @author johneisenheim
 */
public interface IPerson {
    
    public Person readPerson( String SSN );
    public Person readPersonForAccount( String email );
    public ArrayList<Person> getAllPeople();
    public String getTypeOfAccountPerson ( String email );
    public boolean isAStudent(String email);
    public boolean isAProfessor(String email);
    public boolean isAnOrganization(String email);
    public boolean isAnAdministrator(String email);
    public Person getProfessor (String email);
    public Person getStudent (String email);
    public Person getOrganization (String email);
    public Person getAdministrator (String email);
    public Person getPersonToMatricula(String matricula);
    
}
