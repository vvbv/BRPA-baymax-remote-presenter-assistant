/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chr0;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jeison C.
 */
public class Funciones {
    
    private Robot BAYMAX;

    public Funciones() {
        try {
            this.BAYMAX = new Robot();
        } catch (AWTException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
    }
    
    public void prionarTeclaRight(){
        this.BAYMAX.keyPress(KeyEvent.VK_RIGHT);
        this.BAYMAX.keyRelease(KeyEvent.VK_RIGHT);
    }
    
    public void prionarTeclaLeft(){
        this.BAYMAX.keyPress(KeyEvent.VK_LEFT);
        this.BAYMAX.keyRelease(KeyEvent.VK_LEFT);
    }
    
}
