/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager.concrete;

/**
 *
 * @author Valentino
 */
public class ConcreteMessageForServlet {
    private String message;
    private Object object;
    
    public ConcreteMessageForServlet(){}

    public ConcreteMessageForServlet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setObject(Object object) {
        this.object = object;
    }
     
}
