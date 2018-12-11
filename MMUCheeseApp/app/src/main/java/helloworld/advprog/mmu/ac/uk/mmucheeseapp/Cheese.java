package helloworld.advprog.mmu.ac.uk.mmucheeseapp;

import java.io.Serializable;

/**
 * Created by Pugs on 02/03/2017.
 */

public class Cheese implements Serializable {
    private String name;
    private String details;
    public Cheese(String name, String details) {
        this.name = name;
        this.details = details;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getDetails() {
        return details;
    }

}
