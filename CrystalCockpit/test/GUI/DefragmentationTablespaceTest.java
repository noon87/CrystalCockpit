/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class DefragmentationTablespaceTest {
    
    public DefragmentationTablespaceTest() {
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
     * Test of addStatus method, of class DefragmentationTablespace.
     */
    @Test(expected=NullPointerException.class)
    public void testAddStatus() {
        System.out.println("addStatus");
        String status = null;
        DefragmentationTablespace.addStatus(status);
    }
}