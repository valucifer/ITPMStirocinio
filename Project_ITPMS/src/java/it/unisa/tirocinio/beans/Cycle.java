/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public final class Cycle {
    
    private int cycleNumber;
    private String title = null;

    public Cycle(){}
    public Cycle(int cycle_number, String title) {
        setCycleNumber(cycleNumber);
        setTitle(title);
    }

    public int getCycleNumber() {
        return cycleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setCycleNumber(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
