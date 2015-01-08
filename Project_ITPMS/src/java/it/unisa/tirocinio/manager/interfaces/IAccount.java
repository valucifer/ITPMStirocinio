/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.interfaces;

import it.unisa.tirocinio.beans.Account;
import it.unisa.tirocinio.beans.Organization;
import java.util.ArrayList;

/**
 *
 * @author johneisenheim
 */
public interface IAccount {
    
    public Account readAccount( String email );
    public ArrayList<Account> getAllAccounts();
    public String getTypeOfAccount( String email );
        
}
