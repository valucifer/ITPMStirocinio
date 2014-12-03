/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.interfaces;

import it.unisa.tirocinio.beans.OfferTraining;
import java.util.ArrayList;

/**
 *
 * @author johneisenheim
 */
public interface IOfferTraining {
    
    public boolean createOfferTraining( OfferTraining aOfferTraining );
    public boolean updateOfferTraining( OfferTraining aOfferTraining );
    public OfferTraining readOfferTraining( int idOfferTraining );
    
    public ArrayList<OfferTraining> getAllOffersTraining();
    
}
