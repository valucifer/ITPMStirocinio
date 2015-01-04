package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public  class Cycle {
    
    private int cycleNumber;
    private String title = null;

    /**
     *
     */
    public Cycle(){}

    /**
     *
     * @param cycleNumber
     * @param title
     */
    public Cycle(int cycleNumber, String title) {
        this.cycleNumber = cycleNumber;
        this.title = title;
    }

    /**
     *
     * @return the cycle number
     */
    public int getCycleNumber() {
        return cycleNumber;
    }

    /**
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param cycleNumber
     */
    public void setCycleNumber(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
