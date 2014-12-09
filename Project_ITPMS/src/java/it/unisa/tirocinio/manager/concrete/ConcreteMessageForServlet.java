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
public class ConcreteMessageForServlet {
    private Map<String, Object> messages = null;
    
    public ConcreteMessageForServlet(){
        messages = new HashMap<String, Object>();
    }

    public Object getMessage(String key) {
        return messages.get(key);
    }

    public void setMessage(String key, Object value) {
        messages.put(key, value);
    }

}
