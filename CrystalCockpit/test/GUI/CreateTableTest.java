/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Noon
 */
public class CreateTableTest {
    
    public CreateTableTest() {
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
     * Test of retriveData_TableName method, of class CreateTable.
     */
    @Test
    public void testRetriveData_TableName() {
        System.out.println("retriveData_TableName");
        CreateTable instance = new CreateTable();
        instance.retriveData_TableName();
    }

    /**
     * Test of getDBName method, of class CreateTable.
     */
    @Test(expected=NullPointerException.class)
    public void testGetDBName() {
        System.out.println("getDBName");
        CreateTable instance = new CreateTable();
        String expResult = null;
        String result = instance.getDBName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableNames method, of class CreateTable.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableNames() {
        System.out.println("getTableNames");
        CreateTable instance = new CreateTable();
        ArrayList expResult = null;
        ArrayList result = instance.getTableNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableColumnNames method, of class CreateTable.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableColumnNames() {
        System.out.println("getTableColumnNames");
        String tableName = "t1";
        CreateTable instance = new CreateTable();
        String[] expResult = null;
        String[] result = instance.getTableColumnNames(tableName);
        assertArrayEquals(expResult, result);
    }
}