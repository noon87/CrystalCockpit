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
public class AssignRoleToUserTest {
    
    public AssignRoleToUserTest() {
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
     * Test of retriveRoleNameFromDB method, of class AssignRoleToUser.
     */
    @Test
    public void testRetriveRoleNameFromDB() {
        System.out.println("retriveRoleNameFromDB");
        AssignRoleToUser instance = new AssignRoleToUser();
        instance.retriveRoleNameFromDB();
    }

    /**
     * Test of retriveUserFromDB method, of class AssignRoleToUser.
     */
    @Test
    public void testRetriveUserFromDB() {
        System.out.println("retriveUserFromDB");
        AssignRoleToUser instance = new AssignRoleToUser();
        instance.retriveUserFromDB();
    }
}