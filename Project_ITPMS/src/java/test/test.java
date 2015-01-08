/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.tirocinio.beans.Department;
import it.unisa.tirocinio.beans.Organization;
import it.unisa.tirocinio.beans.Person;
import it.unisa.tirocinio.beans.TrainingOffer;
import it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet;
import it.unisa.tirocinio.manager.concrete.ConcreteOrganization;
import it.unisa.tirocinio.manager.concrete.ConcreteTrainingOffer;
import it.unisa.tirocinio.servlet.organizationInsertTrainingOffer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentino
 */
public class test {
    
    public static void main(String[] argv){
         try {
            
            ConcreteMessageForServlet message = new ConcreteMessageForServlet();
            String description = "ciao";
           
            String organizationEmail = "qweqwe@azienda.unisa.it";
            
            ConcreteOrganization aOrganization = ConcreteOrganization.getInstance();
            Organization organization = aOrganization.getOrganizationByAccount(organizationEmail);
            
            PersonManager aPerson = PersonManager.getInstance();
            Person person = aPerson.getPersonBySSN(organization.getProfessor());
            
            ConcreteTrainingOffer aTrainingOffer = ConcreteTrainingOffer.getInstance();
            TrainingOffer trainingOffer = new TrainingOffer();
            Department departmentAbb = person.getDepartment();
            
            trainingOffer.setDepartment(departmentAbb.getAbbreviation());
            trainingOffer.setDescription(organization.getCompanyName() + " - " + description);
            trainingOffer.setOrganization(organization.getVATNumber());
            trainingOffer.setPersonSSN(person.getSsn());
            
            if (aTrainingOffer.createOuterTrainingOffer(trainingOffer)) {
                message.setMessage("status", 1);
            } else {
                message.setMessage("status", 0);
            }
            System.out.println("MEssaggio "+message);
        } catch (SQLException ex) {
            Logger.getLogger(organizationInsertTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionException ex) {
            Logger.getLogger(organizationInsertTrainingOffer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
