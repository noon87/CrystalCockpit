/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class DeleteIndexTest {
    
    public DeleteIndexTest() {
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
     * Test of retriveTableFromDB method, of class DeleteIndex.
     */
    @Test
    public void testRetriveTableFromDB() {
        System.out.println("retriveTableFromDB");
        DeleteIndex instance = new DeleteIndex();
        instance.retriveTableFromDB();
    }

    /**
     * Test of retriveIndexFromDB method, of class DeleteIndex.
     */
    @Test
    public void testRetriveIndexFromDB() {
        System.out.println("retriveIndexFromDB");
        DeleteIndex instance = new DeleteIndex();
        instance.retriveIndexFromDB();
    }

    /**
     * Test of checkList method, of class DeleteIndex.
     */
    @Test
    public void testCheckList() {
        System.out.println("checkList");
        DeleteIndex instance = new DeleteIndex();
        instance.checkList();
    }
}