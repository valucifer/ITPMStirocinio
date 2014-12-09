/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Valentino
 */
public class ConcreteServletMessage {
    
    private Map<String, String> messages = null;
    
    public ConcreteServletMessage(){
        messages = new HashMap<String, String>();
    }

    public String getMessage(String keyMessage) {
        return messages.get(keyMessage);
    }

    public void setMessage(String message, String key) {
        messages.put(key, message);
    }
    
    public Map<String,String> getMessages(){
        return messages;
    }
     
}
