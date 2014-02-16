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
public class CreatMaterializeViewTest {
    
    public CreatMaterializeViewTest() {
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
     * Test of getDBName method, of class CreatMaterializeView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetDBName() {
        System.out.println("getDBName");
        CreatMaterializeView instance = new CreatMaterializeView();
        String expResult = "SELECT sys_context('userenv','instance_name') from dual";
        String result = instance.getDBName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableNames method, of class CreatMaterializeView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableNames() {
        System.out.println("getTableNames");
        CreatMaterializeView instance = new CreatMaterializeView();
        ArrayList expResult = null;
        ArrayList result = instance.getTableNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableColumnNames method, of class CreatMaterializeView.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableColumnNames() {
        System.out.println("getTableColumnNames");
        String tableName = null;
        CreatMaterializeView instance = new CreatMaterializeView();
        String[] expResult = null;
        String[] result = instance.getTableColumnNames(tableName);
        assertArrayEquals(expResult, result);
    }
}