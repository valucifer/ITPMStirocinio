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
    
    public boolean createPerson( Person person );
    public boolean deletePerson( String fiscalCode );
    public boolean updatePerson( Person person );
    public Person readPerson( String fiscalCode );
    public ArrayList<Person> getAllPeople();
    
}
