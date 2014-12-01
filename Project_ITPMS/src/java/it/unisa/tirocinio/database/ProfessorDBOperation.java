/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.database;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.ConcreteDepartment;
import it.unisa.integrazione.manager.concrete.ConcreteOfferTraining;
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
public class ProfessorDBOperation {
    private Connection aConnection;

    public ProfessorDBOperation() throws ClassNotFoundException, SQLException, IOException{
        
    }
    
    public ConcreteProfessor getInformationForProfessorByPrimaryKey(int primaryKey) throws SQLException, ClassNotFoundException, IOException{
        aConnection = DBConnection.connect();
        CallableStatement pcSelect = aConnection.prepareCall("{call getProfessorInformationByPrimaryKey(?)}");        
        ConcreteProfessor aProf = new ConcreteProfessor();
        pcSelect.setInt("pkProfessor",primaryKey);
        ResultSet rs = pcSelect.executeQuery();
        while (rs.next()) {
            aProf.setIdProfessor(rs.getInt(1));
            aProf.setPosition(rs.getString(2));
            aProf.setOfficePhoneNum(rs.getString(3));
            aProf.setOfficeHours(rs.getString(4));
            aProf.setOfficeEmail(rs.getString(5));
            aProf.setFKAccount(rs.getInt(6));
            aProf.setFKFisicPerson(rs.getInt(7));
            aProf.setFKDepartment(rs.getInt(8));
        }
        
        pcSelect.close();
        aConnection.close();
        return aProf;
    }
    
    public ConcreteProfessor getInformationForProfessorByFK_Account(int FKAccount) throws SQLException, ClassNotFoundException, IOException{
        aConnection = DBConnection.connect();
        CallableStatement pcSelect = aConnection.prepareCall("{call getProfessorInformationByFK_Account(?)}");        
        ConcreteProfessor aProf = new ConcreteProfessor();
        pcSelect.setInt("pkFKAccount",FKAccount);
        ResultSet rs = pcSelect.executeQuery();
        while (rs.next()) {
            aProf.setIdProfessor(rs.getInt(1));
            aProf.setPosition(rs.getString(2));
            aProf.setOfficePhoneNum(rs.getString(3));
            aProf.setOfficeHours(rs.getString(4));
            aProf.setOfficeEmail(rs.getString(5));
            aProf.setFKAccount(rs.getInt(6));
            aProf.setFKFisicPerson(rs.getInt(7));
            aProf.setFKDepartment(rs.getInt(8));
        }
        
        pcSelect.close();
        aConnection.close();
        return aProf;
    }
    
    public boolean setOfferTrainingByProfessorByPrimaryKey(String description, int primaryKeyProf) throws SQLException, ClassNotFoundException, IOException{
        ConcreteProfessor aProf = getInformationForProfessorByPrimaryKey(primaryKeyProf);
        ConcreteDepartment department = new ConcreteDepartment();
        aConnection = DBConnection.connect();
        CallableStatement pcInsertTraining = aConnection.prepareCall("{call insertInnerTraining(?,?,?)}");    
        CallableStatement pcSelectDepartment = aConnection.prepareCall("{call getDepartment(?)}");
        pcSelectDepartment.setInt("pkDepartment",aProf.getFKDepartment());
        ResultSet rs = pcSelectDepartment.executeQuery();
        while(rs.next()){
            department.setIdDepartment(rs.getInt(1));
            department.setDescription(rs.getString(2));
        }
        pcInsertTraining.setString("trainingDescription",department.getDescription()+" - "+description);
        pcInsertTraining.setInt("FK_Professor", aProf.getIdProfessor());
        pcInsertTraining.setInt("FK_Department", aProf.getFKDepartment());
        boolean result = pcInsertTraining.execute();
        pcInsertTraining.close();
        aConnection.close();
       
        return !result;
    }
    
    public boolean setOfferTrainingByProfessorByFK_Account(String description, int FKAccount) throws SQLException, ClassNotFoundException, IOException{
        ConcreteProfessor aProf = getInformationForProfessorByFK_Account(FKAccount);
        ConcreteDepartment department = new ConcreteDepartment();
        aConnection = DBConnection.connect();
        CallableStatement pcInsertTraining = aConnection.prepareCall("{call insertInnerTraining(?,?,?)}");    
        CallableStatement pcSelectDepartment = aConnection.prepareCall("{call getDepartment(?)}");
        pcSelectDepartment.setInt("pkDepartment",aProf.getFKDepartment());
        ResultSet rs = pcSelectDepartment.executeQuery();
        while(rs.next()){
            department.setIdDepartment(rs.getInt(1));
            department.setDescription(rs.getString(2));
        }
        pcInsertTraining.setString("trainingDescription",department.getDescription()+" - "+description);
        pcInsertTraining.setInt("FK_Professor", aProf.getIdProfessor());
        pcInsertTraining.setInt("FK_Department", aProf.getFKDepartment());
        boolean result = pcInsertTraining.execute();
        pcInsertTraining.close();
        aConnection.close();
       
        return !result;
    }
    
    public ArrayList<ConcreteOfferTraining> getOfferTrainingByProfessorByFK_Account(int FKAccount) throws SQLException, ClassNotFoundException, IOException{
        ConcreteProfessor aProf = getInformationForProfessorByFK_Account(FKAccount);
        aConnection = DBConnection.connect();
        ArrayList<ConcreteOfferTraining> arrayOfferTraining = new ArrayList<ConcreteOfferTraining>();
        CallableStatement pcSelectTraining = aConnection.prepareCall("{call getOfferTrainingByPrimaryKeyToTheProfessor(?)}");        
        pcSelectTraining.setInt("pkProfessor",aProf.getIdProfessor());
        ResultSet rs = pcSelectTraining.executeQuery();
        while (rs.next()) {
            ConcreteOfferTraining aTrain = new ConcreteOfferTraining();
            aTrain.setidOfferTraining(rs.getInt(1));
            aTrain.setDescription(rs.getString(2));
            arrayOfferTraining.add(aTrain);
        }
        pcSelectTraining.close();
        aConnection.close();
        return arrayOfferTraining;    
    }
}
    
