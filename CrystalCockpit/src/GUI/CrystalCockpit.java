/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nan
 * @Write Program by Nan
 * 
 * CrystalCockpit Description/Function
 * ===================================
 * This function lod the login Screen when user start open the program.
 * 
 */
public class CrystalCockpit {

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
         try {
             //calling Login form from here
             new Login().setVisible(true);
         } catch (IOException ex) {
             Logger.getLogger(CrystalCockpit.class.getName()).log(Level.SEVERE, null, ex);
         }
     }         
}
