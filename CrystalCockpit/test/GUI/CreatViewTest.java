/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
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
public class CreatViewTest {
    
    public CreatViewTest() {
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
     * Test of getDBName method, of class CreatView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetDBName() {
        System.out.println("getDBName");
        CreatView instance = new CreatView();
        String expResult = null;
        String result = instance.getDBName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableNames method, of class CreatView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableNames() {
        System.out.println("getTableNames");
        CreatView instance = new CreatView();
        ArrayList expResult = null;
        ArrayList result = instance.getTableNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableColumnNames method, of class CreatView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableColumnNames() {
        System.out.println("getTableColumnNames");
        String tableName = "t1";
        CreatView instance = new CreatView();
        String[] expResult = null;
        String[] result = instance.getTableColumnNames(tableName);
        assertArrayEquals(expResult, result);
    }
}