/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.database;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.ConcreteDepartment;
import it.unisa.integrazione.manager.concrete.ConcreteOfferTraining;
import it.unisa.integrazione.manager.concrete.ConcreteOrganization;
import it.unisa.integrazione.manager.concrete.ConcreteProfessor;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Valentino
 */
public class OrganizationDBOperation {
    private Connection aConnection;

    public OrganizationDBOperation() throws ClassNotFoundException, SQLException, IOException{
        
    }
    
    public ConcreteOrganization getInformationForOrganizationByPrimaryKey(int primaryKey) throws SQLException, ClassNotFoundException, IOException{
        aConnection = DBConnection.connect();
        CallableStatement pcSelectOrganization = aConnection.prepareCall("{call getOrganizationForPrimaryKey(?)}");        
        ConcreteOrganization aOrga = new ConcreteOrganization();
        pcSelectOrganization.setInt("pKeyOrganization",primaryKey);
        ResultSet rs = pcSelectOrganization.executeQuery();
        while (rs.next()) {
            aOrga.setIdOrganization(rs.getInt(1));
            aOrga.setCompanyName(rs.getString(2));
            aOrga.setCity(rs.getString(3));
            aOrga.setAddres(rs.getString(4));
            aOrga.setPhone(rs.getString(5));
            aOrga.setMail(rs.getString(6));
            aOrga.setFK_Account(rs.getInt(7));
            aOrga.setFisicPerson(rs.getInt(8));
            aOrga.setProfesor(rs.getInt(9));
        }
        pcSelectOrganization.close();
        aConnection.close();
        return aOrga;
    }
    
    public ConcreteOrganization getInformationForOrganizationByFK_Account(int FKAccount) throws SQLException, ClassNotFoundException, IOException{
        aConnection = DBConnection.connect();
        CallableStatement pcSelectOrganization = aConnection.prepareCall("{call getOrganizationForFK_Account(?)}");        
        ConcreteOrganization aOrga = new ConcreteOrganization();
        pcSelectOrganization.setInt("fkOrganization",FKAccount);
        ResultSet rs = pcSelectOrganization.executeQuery();
        while (rs.next()) {
            aOrga.setIdOrganization(rs.getInt(1));
            aOrga.setCompanyName(rs.getString(2));
            aOrga.setCity(rs.getString(3));
            aOrga.setAddres(rs.getString(4));
            aOrga.setPhone(rs.getString(5));
            aOrga.setMail(rs.getString(6));
            aOrga.setFK_Account(rs.getInt(7));
            aOrga.setFisicPerson(rs.getInt(8));
            aOrga.setProfesor(rs.getInt(9));
        }
        pcSelectOrganization.close();
        aConnection.close();
        return aOrga;
    }
    
    public boolean setOfferTrainingByOrganizationByPrimaryKey(String description, int primaryKeyOrg) throws SQLException, ClassNotFoundException, IOException{
        ConcreteOrganization aOrga = getInformationForOrganizationByPrimaryKey(primaryKeyOrg);
        aConnection = DBConnection.connect();
        CallableStatement pcInsertTraining = aConnection.prepareCall("{call insertOuterTraining(?,?,?,?)}");        
        pcInsertTraining.setInt("pkOrganization", aOrga.getIdOrganization());
        pcInsertTraining.setInt("pkProfessor", aOrga.getFK_Professor());
       
        ProfessorDBOperation profDBOperation = new ProfessorDBOperation();
        ConcreteProfessor aProf = profDBOperation.getInformationForProfessorByPrimaryKey(aOrga.getFK_Professor());
        
        pcInsertTraining.setString("trainingDescription", aOrga.getCompanyName()+" - "+description);
        pcInsertTraining.setInt("pkDepartment", aProf.getFKDepartment());
        boolean result = pcInsertTraining.execute();
        pcInsertTraining.close();
        aConnection.close();
     
        return !result;
    }
    
    public boolean setOfferTrainingByOrganizationByFK_Account(String description, int fkAccountOrga) throws SQLException, ClassNotFoundException, IOException{
        ConcreteOrganization aOrga = getInformationForOrganizationByFK_Account(fkAccountOrga);
        aConnection = DBConnection.connect();
        CallableStatement pcInsertTraining = aConnection.prepareCall("{call insertOuterTraining(?,?,?,?)}");        
        pcInsertTraining.setInt("pkOrganization", aOrga.getIdOrganization());
        pcInsertTraining.setInt("pkProfessor", aOrga.getFK_Professor());
       
        ProfessorDBOperation profDBOperation = new ProfessorDBOperation();
        ConcreteProfessor aProf = profDBOperation.getInformationForProfessorByPrimaryKey(aOrga.getFK_Professor());
        
        pcInsertTraining.setString("trainingDescription", aOrga.getCompanyName()+" - "+description);
        pcInsertTraining.setInt("pkDepartment", aProf.getFKDepartment());
        boolean result = pcInsertTraining.execute();
        pcInsertTraining.close();
        aConnection.close();
     
        return !result;
    }
    
    public ArrayList<ConcreteOfferTraining> getOfferTrainingByProfessorByFK_Account(int FKAccount) throws SQLException, ClassNotFoundException, IOException{
        ConcreteOrganization aOrga = getInformationForOrganizationByFK_Account(FKAccount);
        aConnection = DBConnection.connect();
        ArrayList<ConcreteOfferTraining> arrayOfferTraining = new ArrayList<ConcreteOfferTraining>();
        CallableStatement pcSelectTraining = aConnection.prepareCall("{call getOfferTrainingByPrimaryKeyToTheProfessor(?)}");        
        pcSelectTraining.setInt("pkOrganization",aOrga.getIdOrganization());
        ResultSet rs = pcSelectTraining.executeQuery();
        while (rs.next()) {
            ConcreteOfferTraining aTrain = new ConcreteOfferTraining();
            aTrain.setidOfferTraining(rs.getInt(1));
            aTrain.setDescription(rs.getString(2));
            aTrain.setFKProfessor(rs.getInt(4));
            aTrain.setFKDepartment(rs.getInt(5));
            arrayOfferTraining.add(aTrain);
        }
        pcSelectTraining.close();
        aConnection.close();
        return arrayOfferTraining;    
    }
}
    
