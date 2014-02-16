/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.tree.TreeModel;
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
public class MainFrameTest {
    
    public MainFrameTest() {
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

    /**
     * Test of databaseTree method, of class MainFrame.
     */
    @Test(expected=NullPointerException.class)
    public void testDatabaseTree() {
        System.out.println("databaseTree");
        MainFrame instance = new MainFrame();
        TreeModel expResult = null;
        TreeModel result = instance.databaseTree();
        assertEquals(expResult, result);
    }
}