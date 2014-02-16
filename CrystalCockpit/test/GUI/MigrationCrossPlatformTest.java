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
public class MigrationCrossPlatformTest {
    
    public MigrationCrossPlatformTest() {
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
     * Test of clean method, of class MigrationToMySQL.
     */
    @Test
    public void testClean() {
        System.out.println("clean");
        MigrationToMySQL instance = new MigrationToMySQL();
        instance.clean();
    }
}