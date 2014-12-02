/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.db.interfaces;

import it.unisa.tirocinio.beans.TrainingStatus;
import java.util.ArrayList;

/**
 *
 * @author johneisenheim
 */
public interface ITrainingStatus {
    
    public boolean createTrainingStatus( TrainingStatus aStatus );
    public boolean updateTrainingStatus( TrainingStatus aStatus );
    public ArrayList<TrainingStatus> getAllTrainingsStatus();
    public TrainingStatus readTrainingStatus( int idTrainingStatus );
    
}
