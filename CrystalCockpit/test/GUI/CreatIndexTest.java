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
public class CreatIndexTest {
    
    public CreatIndexTest() {
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
     * Test of retriveTableFromDB method, of class CreatIndex.
     */
    @Test
    public void testRetriveTableFromDB() {
        System.out.println("retriveTableFromDB");
        CreatIndex instance = new CreatIndex();
        instance.retriveTableFromDB();
    }

    /**
     * Test of retriveColumnFromDB method, of class CreatIndex.
     */
    @Test
    public void testRetriveColumnFromDB() {
        System.out.println("retriveColumnFromDB");
        CreatIndex instance = new CreatIndex();
        instance.retriveColumnFromDB();
    }
}