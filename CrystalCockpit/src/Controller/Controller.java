/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Noon, Ben, Andre, Shan
 * 
 * This function hold scripts, data, connections and other functions.
 * 
 */
import GUI.*;
import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.hyperic.sigar.FileSystemUsage;  
import org.hyperic.sigar.Sigar;  
import org.hyperic.sigar.SigarException;  

public class Controller {
    //Declare veriable
    public static String name,pass,host,port,db;
    public ArrayList<String> arrList = new ArrayList<String>();       
    public static Connection connection = null;
    public String method;
    public String errorMsg;
    public String script;
    public String dir;
    public String dirName;
    public String log = "temp";
    public String implog, explog;
    public String tempDir;
    public static long size;
    private static Sigar sigar = new Sigar();
    public boolean _checkSpace = false;
    public File file;
    public int colSizeOracle,colSizeMySQL;
    public int sid=0,serial=0;
    public int blockSize,emptyBlocks,nextFree;
    
    //End declaration
    
    
    
    //===============================Start Nan Code===========================//
    //set information from user Login by Nan
    public void setLoginInfo(){
            //set all necessary information for login to the database
            name = GUI.Login.username.getText().toLowerCase();
            pass = GUI.Login.password.getText();
            port = GUI.Login.port.getText();
            host = GUI.Login.url.getText();
            db = GUI.Login.dbName.getText();
    }//End set login information
    
    //get User to show on GUI interface by Nan
    public String getUser(){
        script = "SELECT username FROM dba_users";
        return script;
    }//End get User
    
    //get Tablespaces to show on GUI interface by Nan
    public String getTbs(){
        script = "SELECT TABLESPACE_NAME FROM USER_TABLESPACES";
        return script;
    }//End get Tablespace
    
    //get Table to show on GUI interface by Nan
    public String getTab(){
        script = "SELECT TNAME FROM TAB WHERE TABTYPE ='TABLE'";
        return script;
    }//End get Table
    
    //get directory to show on GUI interface by Nan
    public String getDir(){
        script = "SELECT DIRECTORY_NAME FROM ALL_DIRECTORIES\n"+
                " WHERE DIRECTORY_NAME != 'SUBDIR'";
        return script;
    }//End get Directory
    
    //get Database size by Nan
    public String getDBSize(){
        script= "SELECT SUM(BYTES)\n"+
                " FROM DBA_DATA_FILES";
        return script;
    }//End get Database size
    
    //Start script for getListof Privileges from user by Nan
    public String getListOfPrivs(){
        script = "SELECT PRIVILEGE FROM USER_SYS_PRIVS";
        return script;
    }//End getListOfPrivs
    
    
    //Start script for getListOfrole form user by Nan
    public String getListOfRoles(){
        script = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
        return script;
    }//End get list of roles
    
    //get directory location by Nan
    public String getDirLoc(){
        script = "SELECT DIRECTORY_PATH FROM ALL_DIRECTORIES\n"+
                " WHERE DIRECTORY_NAME='"+dirName.toUpperCase()+"'";
        return script;
    }//End get directory's location
    
    //get analysize location
    public String analyze(){
        script = "ANALYZE TABLE "+GUI.DefragmentationTable._tableName
                +" ESTIMATE STATISTICS";
        return script;
    }
    
    //get table size from database by Nan
    public String getTabSize(){
        script ="SELECT SUM(bytes)\n" +
                    " FROM USER_SEGMENTS\n" +
                    " WHERE SEGMENT_TYPE = 'TABLE'\n" +
                    " AND SEGMENT_NAME = '" + 
                    GUI.DefragmentationTable.tableList.getSelectedItem()+ "'\n"+
                    " GROUP BY SEGMENT_NAME";
        return script;
    }//End get Table Size
    
    //get tablespace size from database by Nan
    public String getTbsSize(){
        script ="SELECT SUM(BYTES)\n" +
                " FROM DBA_SEGMENTS\n" +
                " WHERE TABLESPACE_NAME = '"
                +GUI.DefragmentationTablespace.tbsList.getSelectedItem()+ "'\n" +
                " GROUP BY TABLESPACE_NAME";
        return script;
    }//End get Tablespace Size
     
    //get table block size
    public String getTableBlockSize(){
        script="SELECT ROUND((BLOCKS*8),2),EMPTY_BLOCKS\n" +
                "FROM USER_TABLES\n" +
                "WHERE TABLE_NAME='"+GUI.DefragmentationTable._tableName+"'";
        return script;
    }
    
    //get tablespace next free size
    public String getTbsNextFree(){
        script = "SELECT MAX(fs.bytes)/1024\n" +
                    "FROM sys.dba_free_space fs, sys.dba_data_files dd\n" +
                    "WHERE dd.tablespace_name = fs.tablespace_name\n" +
                    "AND dd.file_id = fs.file_id\n" +
                    "AND dd.tablespace_name = '"+GUI.DefragmentationTablespace._tbsName+"'\n" +
                    "GROUP BY dd.tablespace_name, dd.file_name, dd.bytes/1024\n" +
                    "ORDER BY dd.tablespace_name, dd.file_name";
        return script;
    }
    //Create User Script by Nan
    public String createUser(){
        script = "CREATE USER "+GUI.CreatUser.username.getText().toLowerCase()+"\n"+
                " IDENTIFIED BY " +GUI.CreatUser.pass1.getText()+"\n"+
                " DEFAULT TABLESPACE "+ GUI.CreatUser.defaultTbsList.getSelectedItem() +"\n"+
                " TEMPORARY TABLESPACE TEMP\n"+
                " QUOTA "+GUI.CreatUser.quotaOnDefTbs.getText()+"M ON "+
                GUI.CreatUser.defaultTbsList.getSelectedItem();
        return script;
    }//End Crate User Script
   
    //Delete User Script by Nan
    public String deleteUser(){
        script = "DROP USER "+GUI.DeleteUser._username.getSelectedItem()+" CASCADE";
        return script;
    } //End Delete User Script
    
    //Create Tablespaces  Script by Nan
    public String createTablespace(){
        script = "CREATE TABLESPACE "+GUI.CreateTablespaces.tbsName.getText()+"\n"+
                    " DATAFILE '" + GUI.CreateTablespaces.path.getText() +
                    "\\" +GUI.CreateTablespaces.tbsName.getText() +".DBF'" +"\n"+
                    " SIZE "+GUI.CreateTablespaces.size.getText()
                +GUI.CreateTablespaces.measureSize.getSelectedItem()+"\n"+
                " EXTENT MANAGEMENT LOCAL "+GUI.CreateTablespaces.method.getSelectedItem();
        return script;
    }//End create Tablespace
    
    //Delete Tablespaces Script by Nan
    public String deleteTablespace(){
        script = "DROP TABLESPACE "+ GUI.DeleteTablespaces._tbsList.getSelectedItem()+"\n" +
                " INCLUDING " + GUI.DeleteTablespaces.deleteIncluding.getSelectedItem();
        return script;
    }//End delete Tablespace
    
    //Start Script for Manage Passwrod by Nan
    public String managePass(){
        script = "Alter user "+name+" identified by "+
                GUI.ManagePassword.newPass1.getText();
        return script;
    }//End script for Manage Password
    
    //Start get sid and serial by Nan
    public String getSidSerial(){
        script="SELECT S.SID,S.SERIAL#,S.STATUS,P.SPID\n" +
                "FROM V$SESSION S, V$PROCESS P\n" +
                "WHERE S.USERNAME = '"+GUI.DeleteUser._username.getSelectedItem()+"'\n" +
                "AND P.ADDR(+)=S.PADDR";
        return script;
    }//End get sid and serial 
   
    //Start kill session for delete user by Nan
    public String killSession(){
        script = "ALTER "+name + " KILL SESSION '"+
                sid+","+serial+"'";
        return script;
    }//End kill session
    
    //Start get open user by Nan
    public String getOpenUser(){
        script = "SELECT USERNAME FROM DBA_USERS"
                + " WHERE ACCOUNT_STATUS = 'OPEN'";
        return script;
    }
    
    //script to write on cmd for Export Table by Nan
    public String expTab(){
        script = "expdp " + name + "/" 
                + pass+"@"+db+
                " tables="+GUI.MigrationTable.tabName+ 
                " directory="+GUI.MigrationTable.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTable.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTable.expLog.getText()+".log";
        dirName = (String) GUI.MigrationTable.dir.getSelectedItem();
        return script;
    }//End Export Table
    
    //script to write on cmd for Import Table by Nan
    public String impTab(){
        script = "impdp " + GUI.MigrationTable.usernameImp.getText() + "/" + 
                GUI.MigrationTable.passImp.getText()+"@"+
                GUI.MigrationTable.dbImp.getText()+
                " tables="+GUI.MigrationTable.tabName+ 
                " directory="+GUI.MigrationTable.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTable.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTable.impLog.getText()+".log";
        dirName = (String) GUI.MigrationTable.dir.getSelectedItem();
        return script;
    }//End import Table

    //script to write on cmd for Export tablespace by Nan
    public String expTbs(){
        script = "expdp " + name + "/" 
                + pass+"@"+db+
                " tablespaces="+GUI.MigrationTablespace.tbsName+ 
                " directory="+GUI.MigrationTablespace.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTablespace.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTablespace.expLog.getText()+".log";
        dirName = (String) GUI.MigrationTablespace.dir.getSelectedItem();
        return script;
    }//End export tablespace
    
    //script to write on cmd for Import tablespace by Nan
    public String impTbs(){
        script = "impdp " + GUI.MigrationTablespace.usernameImp.getText() + "/" + 
                GUI.MigrationTablespace.passImp.getText()+"@"+
                GUI.MigrationTablespace.dbImp.getText()+
                " tablespaces="+GUI.MigrationTablespace.tbsName+ 
                " directory="+GUI.MigrationTablespace.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationTablespace.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationTablespace.impLog.getText()+".log";
        dirName = (String) GUI.MigrationTablespace.dir.getSelectedItem();
        return script;
    }//End import tablespace

    //script to write on cmd for Export schema by Nan
    public String expSchema(){
        script = "expdp " + name + "/" 
                + pass+"@"+db+
                " schemas="+GUI.MigrationSchema.schemaName+ 
                " directory="+GUI.MigrationSchema.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationSchema.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationSchema.expLog.getText()+".log";
        dirName = (String) GUI.MigrationSchema.dir.getSelectedItem();
        return script;
    }//End export Schema
    
    //script to write on cmd for Import schema by Nan
    public String impSchema(){        
        script = "impdp " + GUI.MigrationSchema.usernameImp.getText() + "/" + 
                GUI.MigrationSchema.passImp.getText()+"@"+
                GUI.MigrationSchema.dbImp.getText()+
                " schemas="+GUI.MigrationSchema.schemaName+ 
                " directory="+GUI.MigrationSchema.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationSchema.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationSchema.impLog.getText()+".log";
        dirName = (String) GUI.MigrationSchema.dir.getSelectedItem();
        return script;
    }//End import Schema

    //script to write on cmd for Export DB by Nan
    public String expDB(){
        script = "expdp " + name + "/" 
                + pass+"@"+db+
                " full = y"+ 
                " directory="+GUI.MigrationDatabase.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationDatabase.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationDatabase.expLog.getText()+".log";
        dirName = (String) GUI.MigrationDatabase.dir.getSelectedItem();
        return script;
    }//End export DB
    
    //script to write on cmd for Import DB by Nan
    public String impDB(){
        script = "impdp " + GUI.MigrationDatabase.usernameImp.getText() + "/" + 
                GUI.MigrationDatabase.passImp.getText()+"@"+
                GUI.MigrationDatabase.dbImp.getText()+
                " full = y"+ 
                " directory="+GUI.MigrationDatabase.dir.getSelectedItem()+
                " dumpfile="+GUI.MigrationDatabase.dumpFile.getText() +".dmp" +
                " logfile="+GUI.MigrationDatabase.impLog.getText()+".log";
        dirName = (String) GUI.MigrationDatabase.dir.getSelectedItem();
        return script;
    }//End import DB
    
    //checking space before defragmentation by Nan
    public void checkSpace() {  
        String dirName = "C:\\";  
        FileSystemUsage f = null;  
        try{  
            f = sigar.getFileSystemUsage(dirName);     
        } catch (SigarException se) { 
            errorMsg = se.getMessage();
            se.printStackTrace();
            _checkSpace= false;
        }  
        //Avaliable space  
        long fAvail = f.getAvail();    
        long divisor = 1024 * 1000;
        //Convert to bytes
        long availableHD = (fAvail/divisor)*(1073741824);

        //check avalable space from dirve is grather than size(table/tablespace/database)
        if(availableHD > size){
            _checkSpace = true;
        }else{
            _checkSpace = false;
        }   
    }//End checking space
    
    //Start create Temp Folder by Nan
    public void createTempFolder() {
        int i =0;
        tempDir = "C:\\temp"+i;
        file = new File(tempDir);
        
        //checking file exists or not
        while(file.exists()){
            i++;
            tempDir = "C:\\temp"+i;
            file = new File(tempDir);
        }

        //create the file
        file.mkdir();
        file.setWritable(true);
    }//End createTempFolder
    
    //Create temporary directory by Nan
    public String createTempDir(){
        script = "CREATE DIRECTORY TEMPDIR"
                +" AS '"+tempDir+"'";
        return script;
    }//End create temporary directory
    
    //delete temporary directory by Nan
    public String deleteTempDir(){
        script ="DROP DIRECTORY TEMPDIR";
        return script;
    }//End delete temporary directory
    
    //create directory by Nan
    public String createDir(){
        script = "CREATE DIRECTORY "+GUI.CreateDir.dirName.getText()+
                " \nAS '"+GUI.CreateDir.path.getText()+"'";
        return script;
    }//end create Dir
    
    //delete directory by Nan
    public String deleteDir(){
        script = "DROP DIRECTORY "+GUI.DeleteDir._dirList.getSelectedItem();
        return script;
    }
    //check file exist or not by Nan
    public boolean checkFileExist(String _path){
        //convert to file type
       final File file = new File(_path);
       if(file.exists()){
           return true;
       }else{
           return false;
       }
    }//End check file exist
    
    //Delete table for defragmentation by Nan
    public String deleteTableForDefrag(){
        script = "Drop Table "+GUI.DefragmentationTable.tableList.getSelectedItem();
        return script;
    }//End delete table
       
    //Start Defragmentation Table by Nan
    public void defgTable(){
        //Create temporary dir
        GUI.DefragmentationTable.addStatus("Create temporary directory...");
        connectiontoDB("createTempDir");
        GUI.DefragmentationTable.progressBar.setValue(20);
        GUI.DefragmentationTable.addStatus("Temporary Directory is created.");
        
        //export table script
        GUI.DefragmentationTable.addStatus("Exporting file to temporary directory....");
        script = "expdp " + name + "/" + pass+"@"+db+
                " tables="+GUI.DefragmentationTable.tableList.getSelectedItem()+ 
                " directory=tempdir"+
                " dumpfile=tempTab.dmp" +
                " logfile=tempExplog.log";
        
        //write script on cmd
        connectCmd("temp");
       
        //get location (directory) from database
        dirName = "tempdir";
       connectiontoDB("getDirLoc");
       
       //set directory part
       String path = dir + "\\" + "tempExplog.log";
       
       //convert to file type
       final File file = new File(path);
       int i = 0;
       int j = 20;
       //check file is still written or not
       boolean check = file.renameTo(file);
      
        while(check==false){
            i++;
           try {
               //wait 1 second to finish log file
               Thread.sleep(1000);
               check=file.renameTo(file);
               if(j<50){
                    //write % on porgress bar
                    GUI.DefragmentationTablespace.progressBar.setValue(j);
                    j++;
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        GUI.DefragmentationTable.progressBar.setValue(50);
        GUI.DefragmentationTable.addStatus("Exported file to temporary directory.");
             
        //drop table from database
        GUI.DefragmentationTable.addStatus("Removing table...."); 
        connectiontoDB("deleteTab");     
        GUI.DefragmentationTable.progressBar.setValue(60);
        GUI.DefragmentationTable.addStatus("Table is removed.");     
     
        //import table
        GUI.DefragmentationTable.addStatus("Importing file back.....");  
        script = "impdp " + name + "/" + pass+"@"+db+
                " tables="+GUI.DefragmentationTable.tableList.getSelectedItem()+ 
                " directory=tempdir"+
                " dumpfile=tempTab.dmp" +
                " logfile=tempImplog.log";
        
        //Write Script on cmd
        connectCmd("temp");
        GUI.DefragmentationTable.progressBar.setValue(70);
        
        //get location (directory) from database
        dirName = "tempdir";
       connectiontoDB("getDirLoc");

       //set directory part
       path = dir + "\\tempImplog.log";
       
       //convert to file type
       final File file1 = new File(path);
       i = 0;
       //check file is still written or not
       check = file1.renameTo(file1);

        while(check==false){
            i++;
           try {
               //wait 1 second to finish log file
               Thread.sleep(1000);
               check=file1.renameTo(file1);
               GUI.DefragmentationTablespace.progressBar.setValue(j);
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
      
        GUI.DefragmentationTable.progressBar.setValue(80);
        GUI.DefragmentationTable.addStatus("File is imported to database.");
        
        //drop temp directory
        GUI.DefragmentationTable.addStatus("Removing temporary directory....");
        connectiontoDB("deleteTempDir");
        GUI.DefragmentationTable.addStatus("Temporary Directory is deleted.");
        
        //Delete temporary folder
        GUI.DefragmentationTable.addStatus("Removing temporary folder....");
        final File file2 = new File(dir);
        try {
            deleteFile(file2);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        GUI.DefragmentationTable.progressBar.setValue(90);
        GUI.DefragmentationTable.addStatus("Temporary Folder is deleted.");
    }//End defragmentation Table
    
    //Start Defragmentation Tablespace by Nan
    public void defgTbs(){
        //Create temporary dir
        GUI.DefragmentationTablespace.addStatus("Create temporary directory...");
        connectiontoDB("createTempDir");
        GUI.DefragmentationTablespace.progressBar.setValue(20);
        GUI.DefragmentationTablespace.addStatus("Temporary Directory is created.");
        
        //export tablespace script
        GUI.DefragmentationTablespace.addStatus("Exporting file to temporary directory....");
        script = "expdp " + name + "/" + pass+"@"+db+
                " tablespaces="+GUI.DefragmentationTablespace.tbsList.getSelectedItem()+ 
                " directory=tempdir"+
                " dumpfile=tempTbs.dmp" +
                " logfile=tempExplog.log";
        
       //write script on cmd
       connectCmd("temp");
       GUI.DefragmentationTablespace.progressBar.setValue(30);
       //get location (directory) from database
       dirName = "tempdir";
       connectiontoDB("getDirLoc");
       
       //set directory part
       String path = dir + "\\" + "tempExplog.log";
       
       //convert to file type
       final File file = new File(path);
       int i = 0;
       //check file is still written or not
       boolean check = file.renameTo(file);
        int j = 30;
        while(check==false){
            i++;
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file.renameTo(file);
               if(j<50 && i%4==0){
                   
                    GUI.DefragmentationTablespace.progressBar.setValue(j);
                    j++;
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        GUI.DefragmentationTablespace.addStatus("Exported file to temporary directory.");
        String tbsName = (String) GUI.DefragmentationTablespace.tbsList.getSelectedItem();
        
        //get tablespace loaction
        method = "getTbsLoc";
        script = "SELECT FILE_NAME\n" +
                " FROM DBA_DATA_FILES\n" +
                " WHERE TABLESPACE_NAME = '"+tbsName+"'";
        connectiontoDB("getTbsLoc");
        String currentTbsLoc = dir;

        File tempFile = new File(dir);
        //removing tablespace form data
        GUI.DefragmentationTablespace.addStatus("Removing tablespace...."); 
        script = "DROP TABLESPACE "+ tbsName+"\n" +
                " INCLUDING CONTENTS AND DATAFILES";
        connectiontoDB("script");
        
        try {
            //wait to finish delete tablespace
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tempFile.exists()){
            try {
                deleteFile(tempFile);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        GUI.DefragmentationTablespace.addStatus("Tablespace is removed.");     


        //Create New empty tablespace
        script = "CREATE TABLESPACE "+tbsName+"\n"+
                    " DATAFILE '" + currentTbsLoc +"'\n"+
                    " SIZE 10M\n"+
                    " EXTENT MANAGEMENT LOCAL AUTOALLOCATE";
        connectiontoDB("script");
        try {
            j = j+10;
            //wait to finish create new tablespace
            Thread.sleep(10000);
            GUI.DefragmentationTablespace.progressBar.setValue(j);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //import tablespace
        GUI.DefragmentationTablespace.addStatus("Importing file back.....");  
        script = "impdp " + name + "/" + pass+"@"+db+
                " tablespaces="+tbsName+ 
                " directory=tempdir"+
                " dumpfile=tempTbs.dmp" +
                " logfile=tempImplog.log";
        //Write Script on cmd
        connectCmd("temp");
        
        //get location (directory) from database
        dirName = "tempdir";
       connectiontoDB("getDirLoc");

       //set directory part
       path = dir + "\\tempImplog.log";
       
       //convert to file type
       final File file1 = new File(path);
       i = 0;
       //check file is still written or not
       check = file1.renameTo(file1);

        while(check==false){
            i++;
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file1.renameTo(file1);
               if(j<90 && i%4==0){
                   GUI.DefragmentationTablespace.progressBar.setValue(j);
                   j++;
               }
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
      
        GUI.DefragmentationTablespace.progressBar.setValue(80);
        GUI.DefragmentationTablespace.addStatus("File is imported to database.");

        //drop temp directory
        GUI.DefragmentationTablespace.addStatus("Removing temporary directory....");
        connectiontoDB("deleteTempDir");
        GUI.DefragmentationTablespace.addStatus("Temporary Directory is deleted.");

        //Delete temporary folder
        GUI.DefragmentationTablespace.addStatus("Removing temporary folder....");
        final File file2 = new File(dir);
        try {
            deleteFile(file2);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        GUI.DefragmentationTablespace.progressBar.setValue(90);
        GUI.DefragmentationTable.addStatus("Temporary Folder is deleted.");
    }//End defragmentation Tablespace
    
    //Start defragnmentation Database by Nan
    public void defgDB(){
        //Create temporary dir
        GUI.DefragmentationDatabase.addStatus("Create temporary directory...");
        connectiontoDB("createTempDir");
        GUI.DefragmentationDatabase.progressBar.setValue(20);
        GUI.DefragmentationDatabase.addStatus("Temporary Directory is created.");

        //export database script
        GUI.DefragmentationDatabase.addStatus("Exporting file to temporary directory....");        
        script = "expdp " + name + "/" + pass+"@"+db+
                " full = y"+ 
                " directory=tempdir"+
                " dumpfile=tempDB.dmp" +
                " logfile=tempExplog.log";
        
       //write script on cmd
       connectCmd("temp");
       GUI.DefragmentationDatabase.progressBar.setValue(30);
       //get location (directory) from database
       dirName = "tempdir";
       connectiontoDB("getDirLoc");
       
       //set directory part
       String path = dir + "\\" + "tempExplog.log";
       
       //convert to file type
       final File file = new File(path);
       int i = 0;
       //check file is still written or not
       boolean check = file.renameTo(file);

        int j = 30;
        while(check==false){
            i++;
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file.renameTo(file);
               if(i%50==0 && j<50){
                   j++;
                   GUI.DefragmentationDatabase.progressBar.setValue(j);
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        GUI.DefragmentationDatabase.addStatus("Exported file to temporary directory.");

        //removing database
        GUI.DefragmentationDatabase.addStatus("Removing database...."); 
        script = "SELECT 'DROP USER' ||USERNAME|| 'CASCADE;'\n"+
                " FROM DBA_USERS\n"+
                " WHERE USERNAME NOT IN\n"+
                " ('SYS','SYSTEM')";
                
        connectiontoDB("script");
        
        try {
            j = j +10;
            //wait to finish delete tablespace
            GUI.DefragmentationDatabase.progressBar.setValue(j);
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        GUI.DefragmentationDatabase.addStatus("Database is removed.");     

        //import database
        GUI.DefragmentationDatabase.addStatus("Importing database back.....");
        
        script = "impdp " + name + "/" + pass+"@"+db+
                " full = y"+ 
                " directory=tempdir"+
                " dumpfile=tempTbs.dmp" +
                " logfile=tempImplog.log";
        //Write Script on cmd
        connectCmd("temp");
        
        //get location (directory) from database
        dirName = "tempdir";
       connectiontoDB("getDirLoc");
       //set directory part
       path = dir + "\\tempImplog.log";
       
       //convert to file type
       final File file1 = new File(path);
       i = 0;
       //check file is still written or not
       check = file1.renameTo(file1);
        while(check==false){
            i++;
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file1.renameTo(file1);
               if(i%50==0 && j<90){
                   j++;
                   GUI.DefragmentationDatabase.progressBar.setValue(j);
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
      
        GUI.DefragmentationDatabase.progressBar.setValue(80);
        GUI.DefragmentationDatabase.addStatus("Database is imported.");

        //drop temp directory
        GUI.DefragmentationDatabase.addStatus("Removing temporary directory....");
        connectiontoDB("deleteTempDir");
        GUI.DefragmentationDatabase.addStatus("Temporary Directory is deleted.");

        //Delete temporary folder
        GUI.DefragmentationDatabase.addStatus("Removing temporary folder....");
        final File file2 = new File(dir);
        try {
            deleteFile(file2);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        GUI.DefragmentationDatabase.progressBar.setValue(90);
        GUI.DefragmentationDatabase.addStatus("Temporary Folder is deleted.");
    }//End Defragmentation Database

   //connect to command line for migration and defragmentation functions by Nan
    public Boolean connectCmd(String method){
       
        try {
            //generate script depend on exp or imp
            switch (method) {
                case "expTab":                    
                    script=expTab();
                    explog = GUI.MigrationTable.expLog.getText();
                    break;
                case "impTab":
                    script=impTab();
                    implog= GUI.MigrationTable.impLog.getText();
                    break;
                case "expTbs":
                    script=expTbs();
                    explog=GUI.MigrationTablespace.expLog.getText();
                    break;
                case "impTbs":
                    script=impTbs();
                    implog=GUI.MigrationTablespace.impLog.getText();
                    break;
                case "expSchema":
                    script=expSchema();
                    explog=GUI.MigrationSchema.expLog.getText();
                    break;
                case "impSchema":
                    script=impSchema();
                    implog=GUI.MigrationSchema.impLog.getText();
                    break;
                case "expDB":
                    script = expDB();
                    explog=GUI.MigrationDatabase.expLog.getText();
                    break;
                case "impDB":
                    script = impDB();
                    implog = GUI.MigrationDatabase.impLog.getText();
                    break;
            }
            
            //run script into command line
            Runtime.getRuntime().exec(script);
            if(method != "temp"){
                //show log file on user interface
                switch(method){
                    case "expTab":
                    case "expTbs":
                    case "expSchema":
                    case "expDB":
                        showExpFile();
                        break;
                    case "impTab":
                    case "impTbs":
                    case "impSchema":
                    case "impDB":
                        showImpFile();
                        break;
                }
            } 
            return true;
        } catch (IOException ex) {
            errorMsg = ex.getMessage();
            return false;
        }
    }//End connect cmd
    
   //Start show import log file by Nan
   // show Log file to user interface to check wheather import is successful or not
   public void showImpFile(){
       //get location (directory) from database
       connectiontoDB("getDirLoc");
       
       //set directory part
       String path = dir + "\\" + implog +".log";
       
       //convert to file type
       final File file = new File(path);
       int i = 0;
       int j = 20;
       int k = 10;
       //check file is still written or not
       boolean check = file.renameTo(file);
        while(check==false){
            i++;
            if(i<=90){
                GUI.MigrationSchema.progressBar.setValue(j);
                GUI.MigrationTable.progressBar.setValue(j);
                GUI.MigrationTablespace.progressBar.setValue(j);
                j++;
            }
            if(i%50==0){
                k++;
                GUI.MigrationDatabase.progressBar.setValue(k);
            }
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file.renameTo(file);
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

       if(check==true){
           //get the desktop to open log file
           final Desktop desktop = Desktop.getDesktop();

           //access privilege to open log file
           AccessController.doPrivileged(new PrivilegedAction() {
               public Object run() {
                   try {
                       desktop.open(file);
                   } catch(Exception ex) {
                       errorMsg = ex.getMessage();
                   }
                   return null;
               }
           }); 
       }
   }//End open imp logfile 
   
  //Start show export log file by Nan
  // show Log file to user interface to check wheather export is successful or not 
   public void showExpFile(){
       int j=20;
       //get location (directory) from database
       connectiontoDB("getDirLoc");
       
       //set directory part
       String path = dir + "\\" + explog +".log";
       
       //convert to file type
       final File file = new File(path);
       int i = 0;
       int k = 10;
       //check file is still written or not
       boolean check = file.renameTo(file);
 
        while(check==false){
            i++;
            if(j<=90){
                GUI.MigrationSchema.progressBar.setValue(j);
                GUI.MigrationTable.progressBar.setValue(j);
                GUI.MigrationTablespace.progressBar.setValue(j);
                j++;
            }
            if(i%50==0){
                if(k<=90){
                    GUI.MigrationDatabase.progressBar.setValue(k);
                    k++;
                }
            }
           try {
               //wait 1 second to write log file
               Thread.sleep(1000);
               check=file.renameTo(file);
           } catch (InterruptedException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
       if(check==true){
           //get the desktop to open log file
           final Desktop desktop = Desktop.getDesktop();
     
           //access privilege to open log file
           AccessController.doPrivileged(new PrivilegedAction() {
               public Object run() {
                   try {
                        desktop.open(file);
                    } catch(Exception ex) {
                        errorMsg = ex.getMessage();
                    }
                   return null;
               }
           });
       } 
   }//End open exp logfile 
   
   //Start Delete File by Nan
   public void deleteFile(File file)
    	throws IOException{
 
    	if(file.isDirectory()){
 
    		//directory is empty, then delete it
    		if(file.list().length==0){
                    file.setWritable(true);
                    System.gc();
    		   file.delete();
                   GUI.DefragmentationTable.addStatus("Directory is deleted : " 
                                                 + file.getAbsolutePath());
 
    		}else{
 
    		   //list all the directory contents
        	   String files[] = file.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
 
        	      //recursive delete
        	     deleteFile(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
                       file.setWritable(true);
                        System.gc();
           	     file.delete();
                     GUI.DefragmentationTable.addStatus("Directory is deleted : "
                             + file.getAbsolutePath());
        	   }
    		}
 
    	}else{
    		//if file, then delete it
                file.setWritable(true);
                System.gc();
    		file.delete();
                GUI.DefragmentationTable.addStatus("File is deleted : "
                        + file.getAbsolutePath());
    	}
    }//End Delete File
           
   //Start export csv file by Nan
   public boolean generateCsvFile(String filename) {  
       arrList.clear();
       
       // get data type
        script = "SELECT DATA_TYPE\n"+
                " FROM USER_TAB_COLUMNS\n"+
                " WHERE TABLE_NAME='"+GUI.MigrationToMySQL.tableList.getSelectedItem()+"'";
        connectiontoDB("getDataType");

        colSizeOracle = arrList.size();
        String tmpName = "";              
       
       try {
           try {
               //Load Oracle JDBC driver
               Class.forName("oracle.jdbc.driver.OracleDriver");
           } catch (ClassNotFoundException e) {
               //set error message to show to user interface
               errorMsg = e.getMessage();
               return false;
           }
            try{
                //connect to database with user information
                connection = DriverManager.getConnection("jdbc:oracle:thin:@"+
                        host + ":" + port + ":" + db,name,pass);

            } catch (SQLException e) {
                //set error message to show to user interface
                errorMsg = e.getMessage();
                return false;
            }
            //if connection is successful, do scripting upon user request
            //Send the script to generate information
            if (connection != null) {
 
                connection.setAutoCommit(false);  
                Statement stmt = connection.createStatement();  
                ResultSet rset = stmt.executeQuery("select * from "+
                        GUI.MigrationToMySQL.tableList.getSelectedItem());
                
                //call file writer
                FileWriter fname = new FileWriter(filename);  
                BufferedWriter bwOutFile = new BufferedWriter(fname);  
                
                while (rset.next()) {
                    for(int i = 0; i<arrList.size();i++){
                        if(arrList.get(i)=="NUMBER" || arrList.get(i) == "LONG"){
                        tmpName = tmpName.concat(rset.getInt(i+1) + ",");
                        }else{
                            tmpName = tmpName.concat(rset.getString(i+1) + ",");
                        }
                    }

                    //remove last string of ','
                    int j = tmpName.lastIndexOf(',');
                    tmpName = tmpName.substring(0,j);

                    bwOutFile.append(tmpName);
                    bwOutFile.append(System.getProperty("line.separator"));  
                    bwOutFile.flush();  
                    tmpName="";

                }  
                bwOutFile.close();  
                stmt.close();  
                return true;
            }else
            {
                errorMsg = "connection is null";
                return false;
            }
        }  
  
        catch (Exception e) {  
            System.err.println("Unable to connect to database: " + e);  
            errorMsg = e.getMessage();
            return false;
        } 
   }//End export csv file
   
   //Start write Script to save in drive by Nan
   public void writeScrpitForSave(String file,String s){
       //call file writer
       FileWriter fname; 
        try {            
            fname = new FileWriter(file);
            BufferedWriter bwOutFile = new BufferedWriter(fname);
 
            if(s.charAt(s.length()-1)==';'){
                //write into file
                bwOutFile.write(s);
                bwOutFile.close();
            }
            else{
                //write into file
                s=s+";";
                bwOutFile.write(s);
                bwOutFile.close();
            }
                    
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }     
   }//End write Script for save
   
   //Start read from saved file by Nan
   public String readFromFile(String file){
       String content = null;
       //set the file
       File _file = new File(file);
       //read from file
       try {
           FileReader reader = new FileReader(_file);
           char[] chars = new char[(int) _file.length()];
           reader.read(chars);
           content = new String(chars);
           if(content.charAt(content.length()-1)==';'){
               int j = content.lastIndexOf(';');
               content = content.substring(0,j);
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return content;
   }//End read from file
   
   //checking connection for migration by Nan
   public boolean checkImpInfo(String _username,String _pass,String _db,String _host,String _port){     
       try {
            //Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        try{
            //connect to database with user information
            connection = DriverManager.getConnection("jdbc:oracle:thin:@"+
                    _host + ":" + _port + ":" + _db,_username,_pass);
            
        } catch (SQLException e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        //if connection is successful, do scripting upon user request
        //Send the script to generate information
        if (connection != null) {
             return true;
        }else{
            return false;
        }
   }//End checking uset connection
    
   //Start connection to MySQl by Nan
   public Boolean connectionMySQL(String method){
 
        arrList.clear();
        try {
            //Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        try{
            //connect to database with user information
            connection = DriverManager.getConnection("jdbc:mysql://"+
                    GUI.MigrationToMySQL.host.getText() + "/" 
                    + GUI.MigrationToMySQL.db.getText() + "?" 
                    + "user=" + GUI.MigrationToMySQL.user.getText()+
                    "&password="+GUI.MigrationToMySQL.password.getText());
            
        } catch (Exception e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        //if connection is successful, do scripting upon user request
        //Send the script to generate information
        if (connection != null) {
            try {
                ///statements allow to issue sql queries to the database
                Statement statement = connection.createStatement();
                switch (method) {
                    case "getSQLTab":
                    {
                        script = "show tables";
                        ResultSet rs = statement.executeQuery(script);
                        int i = 0;
                        while(rs.next()){ 
                            arrList.add(i, rs.getString(1));
                            i++;
                        }
                        break;
                    }
                    case "import":
                    {
                        //replace all \ to /
                        String path=GUI.MigrationToMySQL.path.getText()+"\\"+
                                GUI.MigrationToMySQL.csvFileName.getText()+".CSV";

                        path = path.replaceAll("\\\\", "/");

                        script = "LOAD DATA INFILE "+
                                "'"+path+"' "+
                                "INTO TABLE "+
                                GUI.MigrationToMySQL.tabListSQL.getSelectedItem()+
                                " FIELDS TERMINATED BY ','";

                        ResultSet rs = statement.executeQuery(script);
                        statement.close();
                        break;
                    }
                    case "countCol":
                    {
                        script = "SELECT COUNT(*)\n"+
                                " FROM INFORMATION_SCHEMA.COLUMNS\n"
                                + " WHERE TABLE_NAME = '"
                                + GUI.MigrationToMySQL.tabListSQL.getSelectedItem()+"'";
                        ResultSet rs = statement.executeQuery(script);
                        while(rs.next()){
                            colSizeMySQL = rs.getInt(1);
                        }
                        statement.close();
                        break;
                    }   
                }
                
            } catch (SQLException ex) {
                errorMsg = ex.getMessage();
                return false;
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                errorMsg = ex.getMessage();
                return false;
            }
            return true;
            
        }else{
            errorMsg = "Connection is null.";
            return false;
        }
    }//End Connection to MySQl
//=======================End Nan Code========================================//    
    
    
    
//======================Start Ben Code ===================================//    
    //Return name of the database by Ben
    public static String getDBName(){
        String dbNameTmp = null;
        String script = "SELECT sys_context('userenv','instance_name') from dual"; 
        try {
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            rsQuery.next();
            dbNameTmp = rsQuery.getString(1);
                    
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbNameTmp;
    }    
    
    //Return name of the all the tables and views user can access by Ben
        public static ArrayList<String> getTableNames(){
            ArrayList<String> Table_List = new ArrayList<String>();
        try {
            
            String script = "SELECT VIEW_NAME from ALL_VIEWS where owner = '"+ name+"'";
            String script2 = "SELECT table_name from dba_tables where owner = '"+ name+"'";

            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            
            while(rsQuery.next())
            {             
                Table_List.add( rsQuery.getString(1));;
            }  
            
            Statement stmQuery2 = connection.createStatement();
            ResultSet rsQuery2 = stmQuery2.executeQuery (script2);
            while(rsQuery2.next())
            {
                Table_List.add( rsQuery2.getString(1));;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Table_List;
    }
        
    //Return name of all the columns in the table in arguments by Ben
    public static String[] getTableColumnNames(String tableName){
           int sizeTable;
           String[] Table_List = null;
           try {
            
            String script = "select count(*)  from all_tab_cols  where table_name = '"+ tableName +"'";            
            String script2 = ""
                    + "SELECT COLUMN_NAME "
                    + " FROM ALL_TAB_COLS "
                    + " WHERE TABLE_NAME = '"+ tableName +"'"; 
                   
            
             Statement stmQuery = connection.createStatement();
             ResultSet rsQuery = stmQuery.executeQuery (script);
             rsQuery.next();
             sizeTable = rsQuery.getInt(1);

            int i=0;
            Table_List = new String[sizeTable];
            Statement stmQuery2 = connection.createStatement();
            ResultSet rsQuery2 = stmQuery2.executeQuery (script2);
            while(rsQuery2.next())
            {
                
                Table_List[i] = rsQuery2.getString(1);
                i++;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Table_List;
     }        
        
    //History by Ben
    public void history(String s){
            
                    //ADD TO HISTORY TABLE             
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    //get current date time with Date()
                    java.util.Date date = new java.util.Date();
                    String computername = null;
                    try {
                        computername=InetAddress.getLocalHost().getHostName();
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                    connectiontoDB("OpenConn");
                    s=s.replace("'", "''n");
                    String savedScript = s;
                String dataBaseScript = "INSERT INTO SYSTEM.HISTORY VALUES ('"
                        + savedScript 
                        +"', '"
                        + dateFormat.format(date) 
                        +"', '"
                        + computername
                        +"', '"
                        +Controller.name
                        +"') ";

                        PreparedStatement st;
                    try {
                        st = connection.prepareStatement(dataBaseScript);
                        st.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                            try {
           connection.close();
        } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }  

}
//=============================End Ben Code===================================//         
        
        
//============================Start Shan Code=================================//        
      //Assign role by Shan       
   public String getRole(){
        String script = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
        return script;
   }
   
   //assign role to user by Shan
    public String assignRoleToUser(){
        String script = "CREATE ROLE "+GUI.AssignRoleToUser.roleNameText.getText()+
                " IDENTIFIED BY " +GUI.AssignRoleToUser.r_password.getText();
        return script;
    }
    
    //assign Role to user password by Shan
    public String assignRoleToUserNoPassword(){
        String script= "CREATE ROLE "+GUI.AssignRoleToUser.roleNameText.getText();
       
        return script;
    }
    
     //Delete Role by Shan
    public String delete_Role(){
        
        String script="DROP ROLE "+GUI.AssignRoleToUser.list_role_name.getSelectedItem();
        return script;
    }
    
     //Alter Role by Shan
    public String defaultOneRole(){
        String script="ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem();
        return script;
    }
    
    //defaul_all_role by Shan
    public String default_All_Role(){
        String script="ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE ALL";
        return script;
    }
    
    //default expect role by Shan
    public String default_Except_Role(){
        String script="ALTER USER "+GUI.AssignRoleToUser.userName_AR.getSelectedItem()+
                " DEFAULT ROLE ALL EXCEPT "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem();
        return script;
    }
    
    //change role id by shan
    public String changeRoleID(){
        String script="Alter Role "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem()
                   +" Not Identified";
        return script;
    }
    
    //change fole pass by shan
    public String changeRolePass(){
        String script="Alter Role "+GUI.AssignRoleToUser.roleName_AR.getSelectedItem()
                   +" Identified By "+GUI.AssignRoleToUser.password_Ar.getText();
        return script;
    }
    
    //Set Role by Shan
    public String enable_All_Role(){
        String script="SET ROLE ALL";
        return script;
    }
    
    //disable all role by shan
    public String disable_All_Role(){
        String script="SET ROLE NONE";
        return script;
    }
    
    //set role with password by shan
    public String setRoleWithPassword(){
      String script="SET ROLE "+GUI.AssignRoleToUser.Role_Name_SR.getSelectedItem()+
                    " IDENTIFIED BY "+GUI.AssignRoleToUser.password_SR.getText();
        return script;
    }
    
    //expect role by shan
    public String except_Role(){
        String script="SET ROLE ALL EXCEPT "+GUI.AssignRoleToUser.Role_Name_SR.getSelectedItem();
        return script;
    }
    
    //grant role by shan
    public String grantRole(){
        String script="Grant "+GUI.GrantPrivileges.list_roleAR.getSelectedItem() +" To "
               +GUI.GrantPrivileges.list_user_role_AR.getSelectedItem();
        return script;
    }
    
    //Revoke by shan
    public String revokeRole(){
         String script="Revoke "+GUI.GrantPrivileges.list_roleAR1.getSelectedItem()+" From "
               +GUI.GrantPrivileges.list_user_role_AR1.getSelectedItem();
        return script;
    }
    
    //Get User by shan
    public String get_User(){
        String script="SELECT USERNAME FROM ALL_USERS";
        return script;
    }
    
    //Create Index by SHan
     public String createIndex(){
         String script="CREATE INDEX "+GUI.CreatIndex.indexName.getText()+"\n"+" ON "
                 +GUI.CreatIndex.list_table_name.getSelectedItem()
                 +" ("+GUI.CreatIndex.show_columnName.getSelectedItem()+")";
         return script;
     }
     
     //create uni que index by shan
    public String createUniqueIndex(){
        String script="CREATE UNIQUE INDEX "+GUI.CreatIndex.indexName.getText()+"\n"+" ON "
                 +GUI.CreatIndex.list_table_name.getSelectedItem()+" ("
                +GUI.CreatIndex.show_columnName.getSelectedItem()+")";
         return script;
    }
    
    //create get column by shan
     public String getColumn(){
         String script = "select column_name from user_tab_columns where table_name ='"
                 +GUI.CreatIndex.list_table_name.getSelectedItem()+"'";
         return script;
     }
         
     //get tab name by shan
     public String getTabName(){
         String script= "SELECT * FROM CAT";
         return script;
     }
     
    //Delete Index by Shan 
     public String getIndexName(){
         String script="Select index_name from user_indexes where table_name ='"
                 +GUI.DeleteIndex.indTabName.getSelectedItem()+"'";
         return script;
     }  
     
     //drop index by shan
     public String dropIndex(){
         String script="DROP INDEX "+GUI.DeleteIndex.indexName.getSelectedItem();
         return script;
     }
     
//==============================End Shan Code==================================//

              
      
//=============================Start Andre Code=============================//     
     public ImageIcon refreshIcon(int size) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/Refresh.png"));
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance( size, size,  java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon( newimg );
   
        return icon;    
    }

 //=============================End Andre Code=============================//   
     

//==============================Start Common Code============================//
    //Start connect to Oracle and input necessary method to get information from database
    public boolean connectiontoDB(String _method){
        method = _method;
        try {
            //Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        try{
            //connect to database with user information
            connection = DriverManager.getConnection("jdbc:oracle:thin:@"+
                    host + ":" + port + ":" + db,name,pass);
            
        } catch (SQLException e) {
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
        //if connection is successful, do scripting upon user request
        //Send the script to generate information
        if (connection != null) {
            switch (method) {
                //======Start Nan's Part======//
                case "Login":
                    return true;
                case "OpenConn":
                    return true;
                case "CreateUser":
                    return statement(createUser());
                case "CreateTablespace":
                    return statement(createTablespace());
                case "DeleteTablespace":
                    return statement(deleteTablespace());
                case "DeleteUser":
                    return statement(deleteUser());
                case "getUser":
                    return statement(getUser());
                case "getTbs":
                    return statement(getTbs());
                case "ManagePass":
                    return statement(managePass());
                case "ShowScript":
                    return true;
                case "getTab":
                    return statement(getTab());
                case "getDir":
                    return statement(getDir());
                case "getDirLoc":
                    return statement(getDirLoc());
                case "script":
                    return statement(script);
                case "getTbsLoc":
                    return statement(script);
                case "getTabSize":
                    return statement(getTabSize());
                case "getTbsSize":
                    return statement(getTbsSize());
                case "getDBSize":
                    return statement (getDBSize());
                case "createTempDir":
                    return statement(createTempDir());
                case "deleteTempDir":
                    return statement(deleteTempDir());
                case "deleteTab":
                    return statement(deleteTableForDefrag());
                case "getDataType":
                    return statement(script);
                case "getListOfPrivs":
                    return statement(getListOfPrivs());
                case "getListOfRoles":
                    return statement(getListOfRoles());
                case "getSidSerial":
                    return statement(getSidSerial());
                case "killSession":
                    return statement(killSession());
                case "getOpenUser":
                    return statement(getOpenUser());
                case "createDir":
                    return statement(createDir());
                case "deleteDir":
                    return statement(deleteDir());
                case "getTableBlockSize":
                    return statement(getTableBlockSize());
                case "analyze":
                    return statement(analyze());
                case "getTbsNextFree":
                    return statement(getTbsNextFree());
               //=====End Nan's part===//    
                    
               //=====shan====//
                case "getRole":
                    return statement (getRole());
                case "get_User":
                    return statement(get_User());
                case "AssignRoleToUser":
                    return statement (assignRoleToUser());
                case "AssignRoleToUserNoPassword":
                    return statement(assignRoleToUserNoPassword());
                case "Delete_Role":
                    return statement(delete_Role());
                case "Enable_All_Role":
                    return statement (enable_All_Role());
                case "Disable_All_Role":
                    return statement (disable_All_Role());
                case "SetRoleWithPassword":
                    return statement (setRoleWithPassword());
                    case "Except_Role":
                    return statement (except_Role());
                case "DefaultOneRole":
                    return statement (defaultOneRole());
                case "Default_All_Role":
                    return statement (default_All_Role());
                case "Default_Except_Role":
                    return statement (default_Except_Role());
                case "changeRoleID":
                    return statement (changeRoleID());
                case "changeRolePass":
                    return statement (changeRolePass());
                case "GrantRole":
                       return statement (grantRole());
                case "RevokeRole":
                    return statement (revokeRole());
                case "CreateIndex":
                    return statement(createIndex());
                case "CreateUniqueIndex":
                    return statement (createUniqueIndex());  
                case "getColumn":
                    return statement(getColumn());
                case "getTabName":
                    return statement (getTabName()); 
                case "getIndexName":
                    return statement(getIndexName());
                case "dropIndex":
                    return statement(dropIndex());
                //====End Shan's Part===//
                    
                default:
                    return false;
            }
        }else{
            return false;
        }
    }
    //End Connection

    //Generate the data from database upon input scripts
    public Boolean statement (String s){
        
        try{
            //set the statement to execute query
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            arrList.clear();
            switch (method) { 
                case "getUser":
                case "getTbs":
                case "getDir":
                case "getTab":
                case "getRole":
                case "get_User":
                case "getColumn":
                case "getTabName":
                case "getIndexName":
                case "getDataType":
                case "getListOfPrivs":
                case "getListOfRoles":
                case "getOpenUser":
                    int i = 0;
                    while(rs.next()){ 
                        arrList.add(i, rs.getString(1));
                        i++;
                    }
                    break;
                case "getDirLoc":
                case "getTbsLoc":
                    rs.next();
                    dir = rs.getString(1);
                    break;
                case "getTabSize":
                case "getTbsSize":
                case "getDBSize":
                    rs.next();
                    size = rs.getLong(1);
                    break;
                case "getSidSerial":
                    rs.next();
                    sid = rs.getInt(1);
                    serial = rs.getInt(2);
                    break;
                case "getTableBlockSize":
                    rs.next();
                    blockSize=rs.getInt(1);
                    emptyBlocks = rs.getInt(2);
                    break;
                case "getTbsNextFree":
                    rs.next();
                    nextFree = rs.getInt(1);
                    break;
            } 
            stmt.close();
            try {
                connection.close();
            } catch (SQLException ex) {
                errorMsg = ex.getMessage();
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }catch (SQLException e){
            //set error message to show to user interface
            errorMsg = e.getMessage();
            return false;
        }
    }
    //End Statement
//================================End Common Code=============================//    
}