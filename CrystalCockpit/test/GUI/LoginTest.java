/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Noon
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCrystal() throws IOException {
        System.out.println("Crystal");
        Login instance = new Login();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/Crystal Cockpit.png"));
        Image img = icon.getImage() ;
        Image expResult = img;
        Image result = instance.Crystal();
        assertEquals(expResult, result);
    }
}