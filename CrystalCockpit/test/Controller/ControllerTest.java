/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.util.ArrayList;
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
public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of setLoginInfo method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testSetLoginInfo() {
        System.out.println("setLoginInfo");
        Controller instance = new Controller();
        instance.setLoginInfo();
    }

    /**
     * Test of getUser method, of class Controller.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Controller instance = new Controller();
        String expResult = "SELECT username FROM dba_users";
        String result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTbs method, of class Controller.
     */
    @Test
    public void testGetTbs() {
        System.out.println("getTbs");
        Controller instance = new Controller();
        String expResult = "SELECT TABLESPACE_NAME FROM USER_TABLESPACES";
        String result = instance.getTbs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTab method, of class Controller.
     */
    @Test
    public void testGetTab() {
        System.out.println("getTab");
        Controller instance = new Controller();
        String expResult = "SELECT TNAME FROM TAB WHERE TABTYPE ='TABLE'";
        String result = instance.getTab();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDir method, of class Controller.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");
        Controller instance = new Controller();
        String expResult = "SELECT DIRECTORY_NAME FROM ALL_DIRECTORIES\n"+
                " WHERE DIRECTORY_NAME != 'SUBDIR'";
        String result = instance.getDir();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDBSize method, of class Controller.
     */
    @Test
    public void testGetDBSize() {
        System.out.println("getDBSize");
        Controller instance = new Controller();
        String expResult = "SELECT SUM(BYTES)\n"+
                " FROM DBA_DATA_FILES";
        String result = instance.getDBSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfPrivs method, of class Controller.
     */
    @Test
    public void testGetListOfPrivs() {
        System.out.println("getListOfPrivs");
        Controller instance = new Controller();
        String expResult = "SELECT PRIVILEGE FROM USER_SYS_PRIVS";
        String result = instance.getListOfPrivs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfRoles method, of class Controller.
     */
    @Test
    public void testGetListOfRoles() {
        System.out.println("getListOfRoles");
        Controller instance = new Controller();
        String expResult = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
        String result = instance.getListOfRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirLoc method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetDirLoc() {
        System.out.println("getDirLoc");
        Controller instance = new Controller();
        String expResult = "SELECT DIRECTORY_PATH FROM ALL_DIRECTORIES\n"+
                " WHERE DIRECTORY_NAME='"+instance.dirName.toUpperCase()+"'";
        String result = instance.getDirLoc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTabSize method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTabSize() {
        System.out.println("getTabSize");
        Controller instance = new Controller();
        String expResult = "SELECT SUM(bytes)\n" +
                    " FROM USER_SEGMENTS\n" +
                    " WHERE SEGMENT_TYPE = 'TABLE'\n" +
                    " AND SEGMENT_NAME = '" + 
                    GUI.DefragmentationTable.tableList.getSelectedItem()+ "'\n"+
                    " GROUP BY SEGMENT_NAME";
        String result = instance.getTabSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTbsSize method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTbsSize() {
        System.out.println("getTbsSize");
        Controller instance = new Controller();
        String expResult = "SELECT SUM(BYTES)\n" +
                " FROM DBA_SEGMENTS\n" +
                " WHERE TABLESPACE_NAME = '"
                +GUI.DefragmentationTablespace.tbsList.getSelectedItem()+ "'\n" +
                " GROUP BY TABLESPACE_NAME";
        String result = instance.getTbsSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of createUser method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testCreateUser() {
        System.out.println("createUser");
        Controller instance = new Controller();
        String expResult = "CREATE USER "+GUI.CreatUser.username.getText().toLowerCase()+"\n"+
                " IDENTIFIED BY " +GUI.CreatUser.pass1.getText()+"\n"+
                " DEFAULT TABLESPACE "+ GUI.CreatUser.defaultTbsList.getSelectedItem() +"\n"+
                " TEMPORARY TABLESPACE TEMP\n"+
                " QUOTA "+GUI.CreatUser.quotaOnDefTbs.getText()+"M ON "+
                GUI.CreatUser.defaultTbsList.getSelectedItem();
        String result = instance.createUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteUser method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Controller instance = new Controller();
        String expResult = "DROP USER "+GUI.DeleteUser._username.getSelectedItem()+" CASCADE";
        String result = instance.deleteUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of createTablespace method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testCreateTablespace() {
        System.out.println("createTablespace");
        Controller instance = new Controller();
        String expResult = "CREATE TABLESPACE "+GUI.CreateTablespaces.tbsName.getText()+"\n"+
                    " DATAFILE '" + GUI.CreateTablespaces.path.getText() +
                    "\\" +GUI.CreateTablespaces.tbsName.getText() +".DBF'" +"\n"+
                    " SIZE "+GUI.CreateTablespaces.size.getText()
                +GUI.CreateTablespaces.measureSize.getSelectedItem()+"\n"+
                " EXTENT MANAGEMENT LOCAL "+GUI.CreateTablespaces.method.getSelectedItem();
        String result = instance.createTablespace();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteTablespace method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDeleteTablespace() {
        System.out.println("deleteTablespace");
        Controller instance = new Controller();
        String expResult = "DROP TABLESPACE "+ GUI.DeleteTablespaces._tbsList.getSelectedItem()+"\n" +
                " INCLUDING " + GUI.DeleteTablespaces.deleteIncluding.getSelectedItem();
        String result = instance.deleteTablespace();
        assertEquals(expResult, result);
    }

    /**
     * Test of managePass method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testManagePass() {
        System.out.println("managePass");
        Controller instance = new Controller();
        String expResult = "Alter user "+instance.name+" identified by "+
                GUI.ManagePassword.newPass1.getText();
        String result = instance.managePass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSidSerial method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetSidSerial() {
        System.out.println("getSidSerial");
        Controller instance = new Controller();
        String expResult = "SELECT S.SID,S.SERIAL#,S.STATUS,P.SPID\n" +
                "FROM V$SESSION S, V$PROCESS P\n" +
                "WHERE S.USERNAME = '"+GUI.DeleteUser._username.getSelectedItem()+"'\n" +
                "AND P.ADDR(+)=S.PADDR";
        String result = instance.getSidSerial();
        assertEquals(expResult, result);
    }

    /**
     * Test of killSession method, of class Controller.
     */
    @Test
    public void testKillSession() {
        System.out.println("killSession");
        Controller instance = new Controller();
        String expResult = "ALTER "+instance.name + " KILL SESSION '"+
                instance.sid+","+instance.serial+"'";
        String result = instance.killSession();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOpenUser method, of class Controller.
     */
    @Test
    public void testGetOpenUser() {
        System.out.println("getOpenUser");
        Controller instance = new Controller();
        String expResult = "SELECT USERNAME FROM DBA_USERS"
                + " WHERE ACCOUNT_STATUS = 'OPEN'";
        String result = instance.getOpenUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of expTab method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testExpTab() {
        System.out.println("expTab");
        Controller instance = new Controller();
        String expResult = "expdp " + instance.name + "/" 
                + instance.pass+"@"+instance.db+
                " tables="+GUI.MigrationTable.tabName+ 
                " directory="+GUI.MigrationTable.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTable.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTable.expLog.getText()+".log";
        String result = instance.expTab();
        assertEquals(expResult, result);
    }

    /**
     * Test of impTab method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testImpTab() {
        System.out.println("impTab");
        Controller instance = new Controller();
        String expResult = "impdp " + GUI.MigrationTable.usernameImp.getText() + "/" + 
                GUI.MigrationTable.passImp.getText()+"@"+
                GUI.MigrationTable.dbImp.getText()+
                " tables="+GUI.MigrationTable.tabName+ 
                " directory="+GUI.MigrationTable.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTable.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTable.impLog.getText()+".log";
        String result = instance.impTab();
        assertEquals(expResult, result);
    }

    /**
     * Test of expTbs method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testExpTbs() {
        System.out.println("expTbs");
        Controller instance = new Controller();
        String expResult = "expdp " + instance.name + "/" 
                + instance.pass+"@"+instance.db+
                " tablespaces="+GUI.MigrationTablespace.tbsName+ 
                " directory="+GUI.MigrationTablespace.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTablespace.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTablespace.expLog.getText()+".log";
        String result = instance.expTbs();
        assertEquals(expResult, result);
    }

    /**
     * Test of impTbs method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testImpTbs() {
        System.out.println("impTbs");
        Controller instance = new Controller();
        String expResult = "impdp " + GUI.MigrationTablespace.usernameImp.getText() + "/" + 
                GUI.MigrationTablespace.passImp.getText()+"@"+
                GUI.MigrationTablespace.dbImp.getText()+
                " tablespaces="+GUI.MigrationTablespace.tbsName+ 
                " directory="+GUI.MigrationTablespace.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTablespace.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTablespace.impLog.getText()+".log";
        String result = instance.impTbs();
        assertEquals(expResult, result);
    }

    /**
     * Test of expSchema method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testExpSchema() {
        System.out.println("expSchema");
        Controller instance = new Controller();
        String expResult = "expdp " + instance.name + "/" 
                + instance.pass+"@"+instance.db+
                " schemas="+GUI.MigrationSchema.schemaName+ 
                " directory="+GUI.MigrationSchema.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationSchema.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationSchema.expLog.getText()+".log";
        String result = instance.expSchema();
        assertEquals(expResult, result);
    }

    /**
     * Test of impSchema method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testImpSchema() {
        System.out.println("impSchema");
        Controller instance = new Controller();
        String expResult = "impdp " + GUI.MigrationSchema.usernameImp.getText() + "/" + 
                GUI.MigrationSchema.passImp.getText()+"@"+
                GUI.MigrationSchema.dbImp.getText()+
                " schemas="+GUI.MigrationSchema.schemaName+ 
                " directory="+GUI.MigrationSchema.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationSchema.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationSchema.impLog.getText()+".log";
        String result = instance.impSchema();
        assertEquals(expResult, result);
    }

    /**
     * Test of expDB method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testExpDB() {
        System.out.println("expDB");
        Controller instance = new Controller();
        String expResult = "expdp " + instance.name + "/" 
                + instance.pass+"@"+instance.db+
                " full = y"+ 
                " directory="+GUI.MigrationDatabase.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationDatabase.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationDatabase.expLog.getText()+".log";
        String result = instance.expDB();
        assertEquals(expResult, result);
    }

    /**
     * Test of impDB method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testImpDB() {
        System.out.println("impDB");
        Controller instance = new Controller();
        String expResult = "impdp " + GUI.MigrationDatabase.usernameImp.getText() + "/" + 
                GUI.MigrationDatabase.passImp.getText()+"@"+
                GUI.MigrationDatabase.dbImp.getText()+
                " full = y"+ 
                " directory="+GUI.MigrationDatabase.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationDatabase.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationDatabase.impLog.getText()+".log";
        String result = instance.impDB();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkSpace method, of class Controller.
     */
    @Test
    public void testCheckSpace() {
        System.out.println("checkSpace");
        Controller instance = new Controller();
        instance.checkSpace();
    }

    /**
     * Test of createTempDir method, of class Controller.
     */
    @Test
    public void testCreateTempDir() {
        System.out.println("createTempDir");
        Controller instance = new Controller();
        String expResult = "CREATE DIRECTORY TEMPDIR"
                +" AS '"+instance.tempDir+"'";
        String result = instance.createTempDir();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteTempDir method, of class Controller.
     */
    @Test
    public void testDeleteTempDir() {
        System.out.println("deleteTempDir");
        Controller instance = new Controller();
        String expResult = "DROP DIRECTORY TEMPDIR";
        String result = instance.deleteTempDir();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkFileExist method, of class Controller.
     */
    @Test
    public void testCheckFileExist() {
        System.out.println("checkFileExist");
        String _path = "C:\\";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.checkFileExist(_path);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckFileExist2() {
        System.out.println("checkFileExist");
        String _path = "C";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.checkFileExist(_path);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of deleteTableForDefrag method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDeleteTableForDefrag() {
        System.out.println("deleteTableForDefrag");
        Controller instance = new Controller();
        String expResult = "Drop Table "+GUI.DefragmentationTable.tableList.getSelectedItem();
        String result = instance.deleteTableForDefrag();
        assertEquals(expResult, result);
    }

    /**
     * Test of connectCmd method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testConnectCmd() {
        System.out.println("connectCmd");
        String method = "expTab";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    }
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd2() {
        System.out.println("connectCmd");
        String method = "impTab";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    }
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd3() {
        System.out.println("connectCmd");
        String method = "expTbs";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    }

    @Test(expected=NullPointerException.class)
    public void testConnectCmd4() {
        System.out.println("connectCmd");
        String method = "impTbs";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    }   
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd5() {
        System.out.println("connectCmd");
        String method = "expSchema";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    } 
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd6() {
        System.out.println("connectCmd");
        String method = "impSchema";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    } 
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd7() {
        System.out.println("connectCmd");
        String method = "expDB";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    } 
    
    @Test(expected=NullPointerException.class)
    public void testConnectCmd8() {
        System.out.println("connectCmd");
        String method = "impDB";
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.connectCmd(method);
        assertEquals(expResult, result);
    } 
    
    /**
     * Test of showImpFile method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testShowImpFile() {
        System.out.println("showImpFile");
        Controller instance = new Controller();
        instance.showImpFile();
    }

    /**
     * Test of showExpFile method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testShowExpFile() {
        System.out.println("showExpFile");
        Controller instance = new Controller();
        instance.showExpFile();
    }

    /**
     * Test of generateCsvFile method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGenerateCsvFile() {
        System.out.println("generateCsvFile");
        String filename = "";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.generateCsvFile(filename);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeScrpitForSave method, of class Controller.
     */
    @Test
    public void testWriteScrpitForSave() {
        System.out.println("writeScrpitForSave");
        String file = getClass().getResource("/test/test.txt").toString();
        file = file.substring(6);
        String s = "test";
        Controller instance = new Controller();
        instance.writeScrpitForSave(file, s);
    }
    
    /**
     * Test of readFromFile method, of class Controller.
     */
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        String file = getClass().getResource("/test/test.txt").toString();
        file = file.substring(6);
        Controller instance = new Controller();
        String expResult = "test";
        String result = instance.readFromFile(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkImpInfo method, of class Controller.
     */
    @Test
    public void testCheckImpInfo() {
        System.out.println("checkImpInfo");
        String _username = "username";
        String _pass = "pass";
        String _db = "db";
        String _host = "host";
        String _port = "111";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.checkImpInfo(_username, _pass, _db, _host, _port);
        assertEquals(expResult, result);
    }

    /**
     * Test of connectionMySQL method, of class Controller.
     */
    @Test
    public void testConnectionMySQL() {
        System.out.println("connectionMySQL");
        String method = "getSQLTab";
        Controller instance = new Controller();
        Boolean expResult = false;
        Boolean result = instance.connectionMySQL(method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectionMySQL2() {
        System.out.println("connectionMySQL");
        String method = "import";
        Controller instance = new Controller();
        Boolean expResult = false;
        Boolean result = instance.connectionMySQL(method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectionMySQL3() {
        System.out.println("connectionMySQL");
        String method = "countCol";
        Controller instance = new Controller();
        Boolean expResult = false;
        Boolean result = instance.connectionMySQL(method);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getDBName method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetDBName() {
        System.out.println("getDBName");
        String expResult = null;
        String result = Controller.getDBName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableNames method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableNames() {
        System.out.println("getTableNames");
        ArrayList expResult = null;
        ArrayList result = Controller.getTableNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableColumnNames method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetTableColumnNames() {
        System.out.println("getTableColumnNames");
        String tableName = "t1";
        String[] expResult = null;
        String[] result = Controller.getTableColumnNames(tableName);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of history method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testHistory() {
        System.out.println("history");
        String s = "script";
        Controller instance = new Controller();
        instance.history(s);
    }

    /**
     * Test of getRole method, of class Controller.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Controller instance = new Controller();
        String expResult = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignRoleToUser method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testAssignRoleToUser() {
        System.out.println("assignRoleToUser");
        Controller instance = new Controller();
        String expResult = "CREATE ROLE "+GUI.AssignRoleToUser.roleNameText.getText()+
                " IDENTIFIED BY " +GUI.AssignRoleToUser.r_password.getText();
        String result = instance.assignRoleToUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignRoleToUserNoPassword method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testAssignRoleToUserNoPassword() {
        System.out.println("assignRoleToUserNoPassword");
        Controller instance = new Controller();
        String expResult = "CREATE ROLE "+GUI.AssignRoleToUser.roleNameText.getText();
        String result = instance.assignRoleToUserNoPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of delete_Role method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDelete_Role() {
        System.out.println("delete_Role");
        Controller instance = new Controller();
        String expResult = "DROP ROLE "+GUI.AssignRoleToUser.list_role_name.getSelectedItem();
        String result = instance.delete_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of defaultOneRole method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDefaultOneRole() {
        System.out.println("defaultOneRole");
        Controller instance = new Controller();
        String expResult = "ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem();
        String result = instance.defaultOneRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of default_All_Role method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDefault_All_Role() {
        System.out.println("default_All_Role");
        Controller instance = new Controller();
        String expResult = "ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE ALL";
        String result = instance.default_All_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of default_Except_Role method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDefault_Except_Role() {
        System.out.println("default_Except_Role");
        Controller instance = new Controller();
        String expResult = "ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE ALL EXCEPT "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem();
        String result = instance.default_Except_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeRoleID method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testChangeRoleID() {
        System.out.println("changeRoleID");
        Controller instance = new Controller();
        String expResult = "Alter Role "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem()
                   +" Not Identified";
        String result = instance.changeRoleID();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeRolePass method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testChangeRolePass() {
        System.out.println("changeRolePass");
        Controller instance = new Controller();
        String expResult = "Alter Role "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem()
                   +" Identified By "+GUI.AssignRoleToUser.password_Ar.getText();
        String result = instance.changeRolePass();
        assertEquals(expResult, result);
    }

    /**
     * Test of enable_All_Role method, of class Controller.
     */
    @Test
    public void testEnable_All_Role() {
        System.out.println("enable_All_Role");
        Controller instance = new Controller();
        String expResult = "SET ROLE ALL";
        String result = instance.enable_All_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of disable_All_Role method, of class Controller.
     */
    @Test
    public void testDisable_All_Role() {
        System.out.println("disable_All_Role");
        Controller instance = new Controller();
        String expResult = "SET ROLE NONE";
        String result = instance.disable_All_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoleWithPassword method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testSetRoleWithPassword() {
        System.out.println("setRoleWithPassword");
        Controller instance = new Controller();
        String expResult = "SET ROLE "+GUI.AssignRoleToUser.Role_Name_SR.getSelectedItem()+
                    " IDENTIFIED BY "+GUI.AssignRoleToUser.password_SR.getText();
        String result = instance.setRoleWithPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of except_Role method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testExcept_Role() {
        System.out.println("except_Role");
        Controller instance = new Controller();
        String expResult = "SET ROLE ALL EXCEPT "+GUI.AssignRoleToUser.Role_Name_SR.getSelectedItem();
        String result = instance.except_Role();
        assertEquals(expResult, result);
    }

    /**
     * Test of grantRole method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGrantRole() {
        System.out.println("grantRole");
        Controller instance = new Controller();
        String expResult = "Grant "+GUI.GrantPrivileges.list_roleAR.getSelectedItem() +" To "
               +GUI.GrantPrivileges.list_user_role_AR.getSelectedItem();
        String result = instance.grantRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of revokeRole method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testRevokeRole() {
        System.out.println("revokeRole");
        Controller instance = new Controller();
        String expResult = "Revoke "+GUI.GrantPrivileges.list_roleAR1.getSelectedItem()+" From "
               +GUI.GrantPrivileges.list_user_role_AR1.getSelectedItem();
        String result = instance.revokeRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_User method, of class Controller.
     */
    @Test
    public void testGet_User() {
        System.out.println("get_User");
        Controller instance = new Controller();
        String expResult = "SELECT USERNAME FROM ALL_USERS";
        String result = instance.get_User();
        assertEquals(expResult, result);
    }

    /**
     * Test of createIndex method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testCreateIndex() {
        System.out.println("createIndex");
        Controller instance = new Controller();
        String expResult = "CREATE INDEX "+GUI.CreatIndex.indexName.getText()+"\n"+" ON "
                 +GUI.CreatIndex.list_table_name.getSelectedItem()
                 +" ("+GUI.CreatIndex.show_columnName.getSelectedItem()+")";
        String result = instance.createIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of createUniqueIndex method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testCreateUniqueIndex() {
        System.out.println("createUniqueIndex");
        Controller instance = new Controller();
        String expResult = "CREATE UNIQUE INDEX "+GUI.CreatIndex.indexName.getText()+"\n"+" ON "
                 +GUI.CreatIndex.list_table_name.getSelectedItem()+" ("
                +GUI.CreatIndex.show_columnName.getSelectedItem()+")";
        String result = instance.createUniqueIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumn method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetColumn() {
        System.out.println("getColumn");
        Controller instance = new Controller();
        String expResult = "select column_name from user_tab_columns where table_name ='"
                 +GUI.CreatIndex.list_table_name.getSelectedItem()+"'";
        String result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTabName method, of class Controller.
     */
    @Test
    public void testGetTabName() {
        System.out.println("getTabName");
        Controller instance = new Controller();
        String expResult = "SELECT * FROM CAT";
        String result = instance.getTabName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIndexName method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testGetIndexName() {
        System.out.println("getIndexName");
        Controller instance = new Controller();
        String expResult = "Select index_name from user_indexes where table_name ='"
                 +GUI.DeleteIndex.indTabName.getSelectedItem()+"'";
        String result = instance.getIndexName();
        assertEquals(expResult, result);
    }

    /**
     * Test of dropIndex method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testDropIndex() {
        System.out.println("dropIndex");
        Controller instance = new Controller();
        String expResult = "DROP INDEX "+GUI.DeleteIndex.indexName.getSelectedItem();
        String result = instance.dropIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of connectiontoDB method, of class Controller.
     */
    @Test
    public void testConnectiontoDB() {
        System.out.println("connectiontoDB");
        String _method = "Login";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB2() {
        System.out.println("connectiontoDB");
        String _method = "OpenConn";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB3() {
        System.out.println("connectiontoDB");
        String _method = "CreateUser";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB4() {
        System.out.println("connectiontoDB");
        String _method = "CreateTablespace";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB5() {
        System.out.println("connectiontoDB");
        String _method = "DeleteTablespace";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB6() {
        System.out.println("connectiontoDB");
        String _method = "DeleteUser";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB7() {
        System.out.println("connectiontoDB");
        String _method = "getUser";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB8() {
        System.out.println("connectiontoDB");
        String _method = "OpenConn";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB9() {
        System.out.println("connectiontoDB");
        String _method = "getTbs";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB10() {
        System.out.println("connectiontoDB");
        String _method = "ManagePass";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB11() {
        System.out.println("connectiontoDB");
        String _method = "ShowScript";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB12() {
        System.out.println("connectiontoDB");
        String _method = "getTab";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB13() {
        System.out.println("connectiontoDB");
        String _method = "getDir";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB14() {
        System.out.println("connectiontoDB");
        String _method = "getDirLoc";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB15() {
        System.out.println("connectiontoDB");
        String _method = "script";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB16() {
        System.out.println("connectiontoDB");
        String _method = "getTbsLoc";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB17() {
        System.out.println("connectiontoDB");
        String _method = "getTabSize";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB18() {
        System.out.println("connectiontoDB");
        String _method = "getTbsSize";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB19() {
        System.out.println("connectiontoDB");
        String _method = "getDBSize";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB20() {
        System.out.println("connectiontoDB");
        String _method = "createTempDir";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB21() {
        System.out.println("connectiontoDB");
        String _method = "deleteTempDir";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB22() {
        System.out.println("connectiontoDB");
        String _method = "deleteTab";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB23() {
        System.out.println("connectiontoDB");
        String _method = "getDataType";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB24() {
        System.out.println("connectiontoDB");
        String _method = "getListOfPrivs";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB25() {
        System.out.println("connectiontoDB");
        String _method = "getListOfRoles";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB26() {
        System.out.println("connectiontoDB");
        String _method = "getSidSerial";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB27() {
        System.out.println("connectiontoDB");
        String _method = "killSession";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB28() {
        System.out.println("connectiontoDB");
        String _method = "getOpenUser";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB29() {
        System.out.println("connectiontoDB");
        String _method = "getRole";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB30() {
        System.out.println("connectiontoDB");
        String _method = "get_User";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB31() {
        System.out.println("connectiontoDB");
        String _method = "AssignRoleToUser";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB32() {
        System.out.println("connectiontoDB");
        String _method = "AssignRoleToUserNoPassword";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB33() {
        System.out.println("connectiontoDB");
        String _method = "Delete_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB34() {
        System.out.println("connectiontoDB");
        String _method = "Enable_All_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    @Test
    public void testConnectiontoDB35() {
        System.out.println("connectiontoDB");
        String _method = "Disable_All_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB36() {
        System.out.println("connectiontoDB");
        String _method = "SetRoleWithPassword";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB37() {
        System.out.println("connectiontoDB");
        String _method = "Except_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB38() {
        System.out.println("connectiontoDB");
        String _method = "DefaultOneRole";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB39() {
        System.out.println("connectiontoDB");
        String _method = "Default_All_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB40() {
        System.out.println("connectiontoDB");
        String _method = "Default_Except_Role";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB41() {
        System.out.println("connectiontoDB");
        String _method = "changeRoleID";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB42() {
        System.out.println("connectiontoDB");
        String _method = "changeRolePass";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB43() {
        System.out.println("connectiontoDB");
        String _method = "GrantRole";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB44() {
        System.out.println("connectiontoDB");
        String _method = "RevokeRole";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB45() {
        System.out.println("connectiontoDB");
        String _method = "CreateIndex";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB46() {
        System.out.println("connectiontoDB");
        String _method = "CreateUniqueIndex";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB47() {
        System.out.println("connectiontoDB");
        String _method = "getColumn";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB48() {
        System.out.println("connectiontoDB");
        String _method = "getTabName";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB49() {
        System.out.println("connectiontoDB");
        String _method = "getIndexName";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectiontoDB50() {
        System.out.println("connectiontoDB");
        String _method = "dropIndex";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.connectiontoDB(_method);
        assertEquals(expResult, result);
    }

    /**
     * Test of statement method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testStatement() {
        System.out.println("statement");
        String s = "test";
        Controller instance = new Controller();
        Boolean expResult = false;
        Boolean result = instance.statement(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of createDir method, of class Controller.
     */
    @Test(expected=NullPointerException.class)
    public void testCreateDir() {
        System.out.println("createDir");
        Controller instance = new Controller();
        String expResult = "CREATE DIRECTORY "+GUI.CreateDir.dirName.getText()+
                " \nAS '"+GUI.CreateDir.path.getText()+"'";
        String result = instance.createDir();
        assertEquals(expResult, result);
    }
}