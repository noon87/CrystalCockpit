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
public class GrantPrivilegesTest {
    
    public GrantPrivilegesTest() {
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
     * Test of retriveRoleNameFromDB method, of class GrantPrivileges.
     */
    @Test
    public void testRetriveRoleNameFromDB() {
        System.out.println("retriveRoleNameFromDB");
        GrantPrivileges instance = new GrantPrivileges();
        instance.retriveRoleNameFromDB();
    }

    /**
     * Test of retrieveTblFromDB method, of class GrantPrivileges.
     */
    @Test
    public void testRetrieveTblFromDB() {
        System.out.println("retrieveTblFromDB");
        GrantPrivileges instance = new GrantPrivileges();
        instance.retrieveTblFromDB();
    }
    
    /**
     * Test of callTable method, of class GrantPrivileges.
     */
    @Test(expected=NullPointerException.class)
    public void testCallTable() {
        System.out.println("callTable");
        GrantPrivileges instance = new GrantPrivileges();
        instance.callTable();
    }

    /**
     * Test of callSPTable method, of class GrantPrivileges.
     */
    @Test
    public void testCallSPTable() {
        System.out.println("callSPTable");
        GrantPrivileges instance = new GrantPrivileges();
        instance.callSPTable();
    }

    /**
     * Test of showScript method, of class GrantPrivileges.
     */
    @Test
    public void testShowScript() {
        System.out.println("showScript");
        GrantPrivileges instance = new GrantPrivileges();
        instance.showScript();
    }

    /**
     * Test of showScriptRTP method, of class GrantPrivileges.
     */
    @Test
    public void testShowScriptRTP() {
        System.out.println("showScriptRTP");
        GrantPrivileges instance = new GrantPrivileges();
        instance.showScriptRTP();
    }

    /**
     * Test of RevokeSPtable method, of class GrantPrivileges.
     */
    @Test
    public void testRevokeSPtable() {
        System.out.println("RevokeSPtable");
        GrantPrivileges instance = new GrantPrivileges();
        instance.RevokeSPtable();
    }

    /**
     * Test of RevokeTPtable method, of class GrantPrivileges.
     */
    @Test(expected=NullPointerException.class)
    public void testRevokeTPtable() {
        System.out.println("RevokeTPtable");
        GrantPrivileges instance = new GrantPrivileges();
        instance.RevokeTPtable();
    }
}