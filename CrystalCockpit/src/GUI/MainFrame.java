/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.*;
import static Controller.Controller.connection;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;


/**
 *
 * @author Nan and Andre
 */
@SuppressWarnings("serial")
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public MainFrame() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents();
        additionalComp();
        welcomeUser.setText("Welcome: "+ Login.username.getText() );
        visibleAll(false);
        getPrivsList();
        getListRoles();
        checkPrivs();  
        checkRoles();
    }

    public ArrayList<String> privsList=new ArrayList<String>();
    public ArrayList<String> rolesList = new ArrayList<String>();
    public Controller thisController = new Controller();
    
    public TreeModel databaseTree() {
        TreeModel tm;
        
        javax.swing.tree.DefaultMutableTreeNode database = new javax.swing.tree.DefaultMutableTreeNode(Controller.db);
        javax.swing.tree.DefaultMutableTreeNode tablespaces = new javax.swing.tree.DefaultMutableTreeNode("Tablespaces");
        javax.swing.tree.DefaultMutableTreeNode tables = new javax.swing.tree.DefaultMutableTreeNode("Tables");
        javax.swing.tree.DefaultMutableTreeNode views = new javax.swing.tree.DefaultMutableTreeNode("Views");
        javax.swing.tree.DefaultMutableTreeNode mViews = new javax.swing.tree.DefaultMutableTreeNode("Materialzed Views");
        javax.swing.tree.DefaultMutableTreeNode indexes = new javax.swing.tree.DefaultMutableTreeNode("Indexes");
        javax.swing.tree.DefaultMutableTreeNode sequences = new javax.swing.tree.DefaultMutableTreeNode("Sequences");
        javax.swing.tree.DefaultMutableTreeNode tablespace;
        javax.swing.tree.DefaultMutableTreeNode table;
        javax.swing.tree.DefaultMutableTreeNode view;
        javax.swing.tree.DefaultMutableTreeNode mView;
        javax.swing.tree.DefaultMutableTreeNode index;
        javax.swing.tree.DefaultMutableTreeNode sequence;

        thisController.connectiontoDB("getTbs");
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.addAll(thisController.arrList);
        
        boolean j = thisController.connectiontoDB("OpenConn");
        
        try {     
            for(int i = 0; i<arrList.size();i++){
                tablespace = new javax.swing.tree.DefaultMutableTreeNode(arrList.get(i));
                tables = new javax.swing.tree.DefaultMutableTreeNode("Tables");
                indexes = new javax.swing.tree.DefaultMutableTreeNode("Indexes");  

                String script = "SELECT TABLE_NAME FROM USER_TABLES WHERE TABLESPACE_NAME = \'"
                        + arrList.get(i) + "\'";
                Statement stmQuery = connection.createStatement();
                ResultSet rsQuery = stmQuery.executeQuery (script);
                while(rsQuery.next()){
                    table = new javax.swing.tree.DefaultMutableTreeNode(rsQuery.getString(1));
                    tables.add(table);
                }
                tablespace.add(tables);
                script = "SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLESPACE_NAME = \'" + arrList.get(i) + "\'";
                stmQuery = connection.createStatement();
                rsQuery = stmQuery.executeQuery (script);
                while(rsQuery.next()){
                    index = new javax.swing.tree.DefaultMutableTreeNode(rsQuery.getString(1));
                    indexes.add(index);
                }
                tablespace.add(indexes);
                tablespaces.add(tablespace);
            }
            database.add(tablespaces);
            String script = "SELECT VIEW_NAME FROM USER_VIEWS";
            Statement stmQuery = connection.createStatement();
            ResultSet rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                view = new javax.swing.tree.DefaultMutableTreeNode(rsQuery.getString(1));
                views.add(view);
            }
            database.add(views);
            script = "SELECT MVIEW_NAME FROM USER_MVIEWS";
            stmQuery = connection.createStatement();
            rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                mView = new javax.swing.tree.DefaultMutableTreeNode(rsQuery.getString(1));
                mViews.add(mView);
            }
            database.add(mViews);
            script = "SELECT SEQUENCE_NAME FROM USER_SEQUENCES";
            stmQuery = connection.createStatement();
            rsQuery = stmQuery.executeQuery (script);
            while(rsQuery.next()){
                sequence = new javax.swing.tree.DefaultMutableTreeNode(rsQuery.getString(1));
                sequences.add(sequence);
            }
            database.add(sequences);
        } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        tm = new javax.swing.tree.DefaultTreeModel(database);

        try {   
           connection.close();
       } catch (SQLException ex1) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
       }
        return tm;
    }
    
    public Image Crystal() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/Crystal Cockpit.png"));
        Image img = icon.getImage() ;
        return img;    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeUser = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        mainPanel = new javax.swing.JPanel();
        welcome1 = new GUI.Welcome();
        createTablespaces1 = new GUI.CreateTablespaces();
        assignRoleToUser1 = new GUI.AssignRoleToUser();
        creatIndex1 = new GUI.CreatIndex();
        creatSequence1 = new GUI.CreatSequence();
        defragnmentationDatabase1 = new GUI.DefragmentationDatabase();
        defragnmentationTable = new GUI.DefragmentationTable();
        defragnmentationTablespace1 = new GUI.DefragmentationTablespace();
        deleteIndex1 = new GUI.DeleteIndex();
        deleteMaterializeView1 = new GUI.DeleteMaterializeView();
        deleteSequence1 = new GUI.DeleteSequence();
        deleteUser1 = new GUI.DeleteUser();
        migrationCrossPlatform1 = new GUI.MigrationToMySQL();
        migrationDatabase1 = new GUI.MigrationDatabase();
        migrationSchema1 = new GUI.MigrationSchema();
        migrationTablespace1 = new GUI.MigrationTablespace();
        managePassword1 = new GUI.ManagePassword();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        update = new javax.swing.JButton();
        Hide = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        LogOutMenu = new javax.swing.JMenu();
        logOut = new javax.swing.JMenuItem();
        welcomeItem = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        createTablespacePanel = new javax.swing.JMenu();
        createTableItem = new javax.swing.JMenuItem();
        createIndexItem = new javax.swing.JMenuItem();
        createViewItem = new javax.swing.JMenuItem();
        createSequenceItem = new javax.swing.JMenuItem();
        createTablespaceItem = new javax.swing.JMenuItem();
        createMaterializeViewItem = new javax.swing.JMenuItem();
        createDirectoryItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        deleteTableItem = new javax.swing.JMenuItem();
        deleteIndexItem = new javax.swing.JMenuItem();
        deleteViewItem = new javax.swing.JMenuItem();
        deleteSequenceItem = new javax.swing.JMenuItem();
        deleteTablespaceItem = new javax.swing.JMenuItem();
        deleteMaterializeViewItem = new javax.swing.JMenuItem();
        deleteDirItem = new javax.swing.JMenuItem();
        defragmentation = new javax.swing.JMenu();
        defragmentationDatabaseItem = new javax.swing.JMenuItem();
        defragmentationTablespaceItem = new javax.swing.JMenuItem();
        defragmentationSegmentItem = new javax.swing.JMenuItem();
        migration = new javax.swing.JMenu();
        migrationSchemaItem = new javax.swing.JMenuItem();
        migrationTableItem = new javax.swing.JMenuItem();
        migrationTablespaceItem = new javax.swing.JMenuItem();
        migrationDatabaseItem = new javax.swing.JMenuItem();
        migrationToMySQL = new javax.swing.JMenuItem();
        userControl = new javax.swing.JMenu();
        deleteUserItem = new javax.swing.JMenuItem();
        createUserItem = new javax.swing.JMenuItem();
        assignRoleToUserItem = new javax.swing.JMenuItem();
        grantPrivileges = new javax.swing.JMenuItem();
        managePasswordItem = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        onlineHelp = new javax.swing.JMenuItem();
        checkForUpdate = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Crystal Cockpit");
        setIconImage(Crystal());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(74, 322));

        jTree1.setModel(databaseTree());
        jTree1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jSplitPane2.setLeftComponent(jScrollPane2);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane2.setToolTipText("");
        jLayeredPane2.setRequestFocusEnabled(false);

        mainPanel.setMinimumSize(new java.awt.Dimension(1200, 900));
        mainPanel.setPreferredSize(new java.awt.Dimension(1200, 900));
        mainPanel.setLayout(new java.awt.CardLayout());

        welcome1.setMinimumSize(new java.awt.Dimension(2145, 818));
        mainPanel.add(welcome1, "card2");
        mainPanel.add(createTablespaces1, "card4");
        mainPanel.add(assignRoleToUser1, "card5");
        mainPanel.add(creatIndex1, "card6");
        mainPanel.add(creatSequence1, "card7");
        mainPanel.add(defragnmentationDatabase1, "card11");
        mainPanel.add(defragnmentationTable, "card12");
        mainPanel.add(defragnmentationTablespace1, "card13");
        mainPanel.add(deleteIndex1, "card14");
        mainPanel.add(deleteMaterializeView1, "card16");
        mainPanel.add(deleteSequence1, "card17");
        mainPanel.add(deleteUser1, "card20");
        mainPanel.add(migrationCrossPlatform1, "card22");
        mainPanel.add(migrationDatabase1, "card23");
        mainPanel.add(migrationSchema1, "card24");
        mainPanel.add(migrationTablespace1, "card26");
        mainPanel.add(managePassword1, "card28");

        mainPanel.setBounds(0, 0, 800, 480);
        jLayeredPane2.add(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSplitPane2.setRightComponent(jLayeredPane2);

        update.setIcon(thisController.refreshIcon(15));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateMouseReleased(evt);
            }
        });
        update.setBounds(60, 0, 20, 20);
        jLayeredPane1.add(update, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Hide.setText("<<");
        Hide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HideLeftPane(evt);
            }
        });
        Hide.setBounds(0, 0, 49, 20);
        jLayeredPane1.add(Hide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Show.setText(">>");
        Show.setMaximumSize(new java.awt.Dimension(37, 23));
        Show.setMinimumSize(new java.awt.Dimension(37, 23));
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonPerformed(evt);
            }
        });
        Show.setBounds(0, 0, 49, 20);
        jLayeredPane1.add(Show, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setAutoscrolls(true);

        LogOutMenu.setMnemonic('F');
        LogOutMenu.setText("File");

        logOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        logOut.setMnemonic('L');
        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutPerformed(evt);
            }
        });
        LogOutMenu.add(logOut);

        welcomeItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        welcomeItem.setMnemonic('W');
        welcomeItem.setText("Welcome");
        welcomeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeItemPerformed(evt);
            }
        });
        LogOutMenu.add(welcomeItem);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        Exit.setMnemonic('x');
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitexitPerformed(evt);
            }
        });
        LogOutMenu.add(Exit);

        jMenuBar1.add(LogOutMenu);

        createTablespacePanel.setMnemonic('C');
        createTablespacePanel.setText("Create");

        createTableItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        createTableItem.setMnemonic('T');
        createTableItem.setText("Table");
        createTableItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTableItemcreateTablePerformed(evt);
            }
        });
        createTablespacePanel.add(createTableItem);

        createIndexItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        createIndexItem.setMnemonic('I');
        createIndexItem.setText("Index");
        createIndexItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createIndexItemActionPerformed(evt);
            }
        });
        createTablespacePanel.add(createIndexItem);

        createViewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        createViewItem.setMnemonic('V');
        createViewItem.setText("View");
        createViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createViewItemcreateViewPerformed(evt);
            }
        });
        createTablespacePanel.add(createViewItem);

        createSequenceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        createSequenceItem.setMnemonic('S');
        createSequenceItem.setText("Sequence");
        createSequenceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSequenceItemcreateSequencePerformed(evt);
            }
        });
        createTablespacePanel.add(createSequenceItem);

        createTablespaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        createTablespaceItem.setMnemonic('b');
        createTablespaceItem.setText("Tablespace");
        createTablespaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTablespaceItemcreateTableSpacePerformed(evt);
            }
        });
        createTablespacePanel.add(createTablespaceItem);

        createMaterializeViewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        createMaterializeViewItem.setMnemonic('M');
        createMaterializeViewItem.setText("Materialize View");
        createMaterializeViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMaterializeViewItemcreateMaterializeViewPerformed(evt);
            }
        });
        createTablespacePanel.add(createMaterializeViewItem);

        createDirectoryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        createDirectoryItem.setMnemonic('D');
        createDirectoryItem.setText("Directory");
        createDirectoryItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDirectoryItemActionPerformed(evt);
            }
        });
        createTablespacePanel.add(createDirectoryItem);

        jMenuBar1.add(createTablespacePanel);

        jMenu2.setMnemonic('D');
        jMenu2.setText("Delete");

        deleteTableItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        deleteTableItem.setMnemonic('T');
        deleteTableItem.setText("Table");
        deleteTableItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTableItemdeleteTablePerformed(evt);
            }
        });
        jMenu2.add(deleteTableItem);

        deleteIndexItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        deleteIndexItem.setMnemonic('I');
        deleteIndexItem.setText("Index");
        deleteIndexItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIndexItemdeleteIndexPerformed(evt);
            }
        });
        jMenu2.add(deleteIndexItem);

        deleteViewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        deleteViewItem.setMnemonic('V');
        deleteViewItem.setText("View");
        deleteViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteViewItemdeleteViewPerformed(evt);
            }
        });
        jMenu2.add(deleteViewItem);

        deleteSequenceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        deleteSequenceItem.setMnemonic('S');
        deleteSequenceItem.setText("Sequence");
        deleteSequenceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSequenceItemdeleteSequencePerformed(evt);
            }
        });
        jMenu2.add(deleteSequenceItem);

        deleteTablespaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        deleteTablespaceItem.setMnemonic('b');
        deleteTablespaceItem.setText("Tablespace");
        deleteTablespaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTablespaceItemdeleteTablespacePerformed(evt);
            }
        });
        jMenu2.add(deleteTablespaceItem);

        deleteMaterializeViewItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        deleteMaterializeViewItem.setMnemonic('M');
        deleteMaterializeViewItem.setText("Materialize View");
        deleteMaterializeViewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMaterializeViewItemdeleteMaterializeViewPerformed(evt);
            }
        });
        jMenu2.add(deleteMaterializeViewItem);

        deleteDirItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        deleteDirItem.setMnemonic('D');
        deleteDirItem.setText("Directory");
        deleteDirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDirItemActionPerformed(evt);
            }
        });
        jMenu2.add(deleteDirItem);

        jMenuBar1.add(jMenu2);

        defragmentation.setMnemonic('g');
        defragmentation.setText("Defragmentation");

        defragmentationDatabaseItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        defragmentationDatabaseItem.setMnemonic('D');
        defragmentationDatabaseItem.setText("Database");
        defragmentationDatabaseItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defragmentationDatabaseItemdefragnmentationDatabasePerformed(evt);
            }
        });
        defragmentation.add(defragmentationDatabaseItem);

        defragmentationTablespaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        defragmentationTablespaceItem.setMnemonic('b');
        defragmentationTablespaceItem.setText("Tablespace");
        defragmentationTablespaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defragmentationTablespaceItemdefragnmentationTablespacePerformed(evt);
            }
        });
        defragmentation.add(defragmentationTablespaceItem);

        defragmentationSegmentItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        defragmentationSegmentItem.setMnemonic('T');
        defragmentationSegmentItem.setText("Table");
        defragmentationSegmentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defragmentationSegmentItemdefragnmentationSegmentPerformed(evt);
            }
        });
        defragmentation.add(defragmentationSegmentItem);

        jMenuBar1.add(defragmentation);

        migration.setMnemonic('M');
        migration.setText("Migration");

        migrationSchemaItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        migrationSchemaItem.setMnemonic('S');
        migrationSchemaItem.setText("Exp/Imp Schema");
        migrationSchemaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrationSchemaItemPressed(evt);
            }
        });
        migration.add(migrationSchemaItem);

        migrationTableItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        migrationTableItem.setMnemonic('T');
        migrationTableItem.setText("Exp/Imp Table");
        migrationTableItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrationTableItemexpImptablePerformed(evt);
            }
        });
        migration.add(migrationTableItem);

        migrationTablespaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        migrationTablespaceItem.setMnemonic('b');
        migrationTablespaceItem.setText("Exp/Imp Tablespace");
        migrationTablespaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrationTablespaceItemPerformed(evt);
            }
        });
        migration.add(migrationTablespaceItem);

        migrationDatabaseItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        migrationDatabaseItem.setMnemonic('D');
        migrationDatabaseItem.setText("Exp/Imp Database");
        migrationDatabaseItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrationDatabaseItemPerformed(evt);
            }
        });
        migration.add(migrationDatabaseItem);

        migrationToMySQL.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        migrationToMySQL.setMnemonic('Q');
        migrationToMySQL.setText("Migration To MySQL");
        migrationToMySQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrationToMySQLmigrationCrossPlatformPerformed(evt);
            }
        });
        migration.add(migrationToMySQL);

        jMenuBar1.add(migration);

        userControl.setMnemonic('U');
        userControl.setText("User Control");

        deleteUserItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        deleteUserItem.setMnemonic('D');
        deleteUserItem.setText("Delete User");
        deleteUserItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserItemdeleteUserPerformed(evt);
            }
        });
        userControl.add(deleteUserItem);

        createUserItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        createUserItem.setMnemonic('C');
        createUserItem.setText("Create User");
        createUserItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserItemcreateUserPerformed(evt);
            }
        });
        userControl.add(createUserItem);

        assignRoleToUserItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        assignRoleToUserItem.setMnemonic('A');
        assignRoleToUserItem.setText("Assign Role to User");
        assignRoleToUserItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignRoleToUserItemassignRoleToUserPerformed(evt);
            }
        });
        userControl.add(assignRoleToUserItem);

        grantPrivileges.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        grantPrivileges.setMnemonic('G');
        grantPrivileges.setText("GrantPrivileges");
        grantPrivileges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grantPrivilegesActionPerformed(evt);
            }
        });
        userControl.add(grantPrivileges);

        managePasswordItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        managePasswordItem.setMnemonic('M');
        managePasswordItem.setText("Manage Password");
        managePasswordItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePasswordItemactionPerformedMangePass(evt);
            }
        });
        userControl.add(managePasswordItem);

        jMenuBar1.add(userControl);

        Help.setMnemonic('H');
        Help.setText("Help");

        onlineHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        onlineHelp.setMnemonic('O');
        onlineHelp.setText("Online Docs and Support");
        onlineHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlineHelpActionPerformed(evt);
            }
        });
        Help.add(onlineHelp);

        checkForUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        checkForUpdate.setMnemonic('U');
        checkForUpdate.setText("Check for Update");
        checkForUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkForUpdateActionPerformed(evt);
            }
        });
        Help.add(checkForUpdate);

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        about.setMnemonic('A');
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        Help.add(about);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(welcomeUser)
                        .addGap(205, 205, 205))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(966, 588));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HideLeftPane(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HideLeftPane

        jSplitPane2.remove(jScrollPane2);
        Hide.setVisible(false);  
        Show.setVisible(true);
    }//GEN-LAST:event_HideLeftPane

    private void showButtonPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonPerformed

        Hide.setVisible(true);
        Show.setVisible(false);
        jSplitPane2.setLeftComponent(jScrollPane2);
    }//GEN-LAST:event_showButtonPerformed

    private void logOutPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutPerformed

        this.setVisible(false);
        try {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Login().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_logOutPerformed

    private void welcomeItemPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeItemPerformed
        setTitle("Crystal Cockpit");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel,"card2");  
    }//GEN-LAST:event_welcomeItemPerformed

    private void ExitexitPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitexitPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitexitPerformed

    private void createTableItemcreateTablePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTableItemcreateTablePerformed
        setTitle("Create Table");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card3");
    }//GEN-LAST:event_createTableItemcreateTablePerformed

    private void createViewItemcreateViewPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createViewItemcreateViewPerformed
        setTitle("Create View");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card10");
    }//GEN-LAST:event_createViewItemcreateViewPerformed

    private void createSequenceItemcreateSequencePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSequenceItemcreateSequencePerformed
        setTitle("Create Sequence");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card7");
    }//GEN-LAST:event_createSequenceItemcreateSequencePerformed

    private void createTablespaceItemcreateTableSpacePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTablespaceItemcreateTableSpacePerformed
        setTitle("Create Tablespace");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card4");
    }//GEN-LAST:event_createTablespaceItemcreateTableSpacePerformed

    private void createMaterializeViewItemcreateMaterializeViewPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMaterializeViewItemcreateMaterializeViewPerformed
        setTitle("Create Materialize View");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card8");
    }//GEN-LAST:event_createMaterializeViewItemcreateMaterializeViewPerformed

    private void deleteTableItemdeleteTablePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTableItemdeleteTablePerformed
        setTitle("Delete Table");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card18");
    }//GEN-LAST:event_deleteTableItemdeleteTablePerformed

    private void deleteIndexItemdeleteIndexPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIndexItemdeleteIndexPerformed
        setTitle("Delete Index");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card14");
    }//GEN-LAST:event_deleteIndexItemdeleteIndexPerformed

    private void deleteViewItemdeleteViewPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteViewItemdeleteViewPerformed
        setTitle("Delete View");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card15");
    }//GEN-LAST:event_deleteViewItemdeleteViewPerformed

    private void deleteSequenceItemdeleteSequencePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSequenceItemdeleteSequencePerformed
        setTitle("Delete Sequence");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card17");
    }//GEN-LAST:event_deleteSequenceItemdeleteSequencePerformed

    private void deleteTablespaceItemdeleteTablespacePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTablespaceItemdeleteTablespacePerformed
        setTitle("Delete Tablespace");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card19");
    }//GEN-LAST:event_deleteTablespaceItemdeleteTablespacePerformed

    private void deleteMaterializeViewItemdeleteMaterializeViewPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMaterializeViewItemdeleteMaterializeViewPerformed
        setTitle("Delete Materialize View");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card16");
    }//GEN-LAST:event_deleteMaterializeViewItemdeleteMaterializeViewPerformed

    private void defragmentationDatabaseItemdefragnmentationDatabasePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defragmentationDatabaseItemdefragnmentationDatabasePerformed
        setTitle("Defragnment Database");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card11");
    }//GEN-LAST:event_defragmentationDatabaseItemdefragnmentationDatabasePerformed

    private void defragmentationTablespaceItemdefragnmentationTablespacePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defragmentationTablespaceItemdefragnmentationTablespacePerformed
        setTitle("Defragnment Tablespace");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card13");
    }//GEN-LAST:event_defragmentationTablespaceItemdefragnmentationTablespacePerformed

    private void defragmentationSegmentItemdefragnmentationSegmentPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defragmentationSegmentItemdefragnmentationSegmentPerformed
        setTitle("Defragnment Table");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card12");
    }//GEN-LAST:event_defragmentationSegmentItemdefragnmentationSegmentPerformed

    private void migrationSchemaItemPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrationSchemaItemPressed
        setTitle("Migration Schema");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card24");
    }//GEN-LAST:event_migrationSchemaItemPressed

    private void migrationTableItemexpImptablePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrationTableItemexpImptablePerformed
        setTitle("Migration Table");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card25");
    }//GEN-LAST:event_migrationTableItemexpImptablePerformed

    private void migrationTablespaceItemPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrationTablespaceItemPerformed
        setTitle("Migration Tablesapce");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card26");
    }//GEN-LAST:event_migrationTablespaceItemPerformed

    private void migrationDatabaseItemPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrationDatabaseItemPerformed
        setTitle("Migration Database");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card23");
    }//GEN-LAST:event_migrationDatabaseItemPerformed

    private void migrationToMySQLmigrationCrossPlatformPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrationToMySQLmigrationCrossPlatformPerformed
        setTitle("Migration To MySQL");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card22");
    }//GEN-LAST:event_migrationToMySQLmigrationCrossPlatformPerformed

    private void deleteUserItemdeleteUserPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserItemdeleteUserPerformed
        setTitle("Delete User");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        revalidate();
        card.show(mainPanel, "card20");
        
    }//GEN-LAST:event_deleteUserItemdeleteUserPerformed

    private void createUserItemcreateUserPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserItemcreateUserPerformed
        setTitle("Create User");
        
        CardLayout card = (CardLayout) mainPanel.getLayout();
        
        card.show(mainPanel, "card9");
    }//GEN-LAST:event_createUserItemcreateUserPerformed

    private void assignRoleToUserItemassignRoleToUserPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignRoleToUserItemassignRoleToUserPerformed
        setTitle("Assign Role to User");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card5");
    }//GEN-LAST:event_assignRoleToUserItemassignRoleToUserPerformed

    private void managePasswordItemactionPerformedMangePass(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePasswordItemactionPerformedMangePass
        setTitle("Manage Password");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card28");
    }//GEN-LAST:event_managePasswordItemactionPerformedMangePass

    private void createIndexItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createIndexItemActionPerformed
        setTitle("Create Index");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card6");
    }//GEN-LAST:event_createIndexItemActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();

    }//GEN-LAST:event_jTree1MouseClicked

    private void updateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseReleased
        jTree1.setModel(databaseTree());
    }//GEN-LAST:event_updateMouseReleased

    private void onlineHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineHelpActionPerformed
        try {
            URI url = new URI("http://zim.cs.uow.edu.au:50321/~cs321jg1a/documentation.html");
            java.awt.Desktop.getDesktop().browse(url);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_onlineHelpActionPerformed

    private void checkForUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkForUpdateActionPerformed
        try {
            URI url = new URI("http://zim.cs.uow.edu.au:50321/~cs321jg1a/files.html");
            java.awt.Desktop.getDesktop().browse(url);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkForUpdateActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JLabel label = new JLabel();
        final ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/Crystal Cockpit.png"));
        String about = "<html><font size=\"20\" face" +
            "=\"Segoe UI\" color=blue>Crystal Cockpit</font><br>"
                + "<font face =\"Segoe UI\"> Version: 0.9<br>"
                + "For more information go to:<br><br>"
                + "<a href=\"http://zim.cs.uow.edu.au:50321/~cs321jg1a/\">"
                + "http://zim.cs.uow.edu.au:50321/~cs321jg1a/</a></font></html>";
        JEditorPane ep = new JEditorPane("text/html", about);
        ep.addHyperlinkListener(new HyperlinkListener()
        {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e)
            {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                    try {
                        URI uri = new URI(e.getURL().toString()); 
                        java.awt.Desktop.getDesktop().browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        ep.setEditable(false);
        ep.setBackground(label.getBackground());
        JOptionPane.showMessageDialog(null, ep,
                "About", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_aboutActionPerformed

    private void grantPrivilegesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grantPrivilegesActionPerformed
        setTitle("Grant Privileges");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card30");
    }//GEN-LAST:event_grantPrivilegesActionPerformed

    private void createDirectoryItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDirectoryItemActionPerformed
        setTitle("Create Directory");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "card32");
    }//GEN-LAST:event_createDirectoryItemActionPerformed

    private void deleteDirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDirItemActionPerformed
        setTitle("Delete Directory");
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel,"card31");
    }//GEN-LAST:event_deleteDirItemActionPerformed
   
    private void additionalComp(){
        creatUser = new GUI.CreatUser();
        deleteTbs = new GUI.DeleteTablespaces();
        migTbs = new GUI.MigrationTable();
        grantPvl = new GUI.GrantPrivileges();
        createTable1 = new GUI.CreateTable();
        creatView1 = new GUI.CreatView();
        creatMaterializeView1 = new GUI.CreatMaterializeView();
        deleteTable1 = new GUI.DeleteTable();
        deleteView1 = new GUI.DeleteView();
        delDir = new GUI.DeleteDir();
        createDir = new GUI.CreateDir();
        mainPanel.add(creatUser,"card9");
        mainPanel.add(deleteTbs, "card19");
        mainPanel.add(migTbs, "card25");
        mainPanel.add(grantPvl, "card30");
        mainPanel.add(createTable1, "card3");
        mainPanel.add(creatView1, "card10");
        mainPanel.add(creatMaterializeView1, "card8");
        mainPanel.add(deleteTable1,"card18");
        mainPanel.add(deleteView1,"card15");
        mainPanel.add(delDir, "card31");
        mainPanel.add(createDir,"card32");
    }
    
    private void getPrivsList(){
       
        privsList.clear();
        //get the list of User's priveleges
        thisController.connectiontoDB("getListOfPrivs");
  
        //set the list of users into array
        privsList.addAll(thisController.arrList);   
    }
       
    private void getListRoles(){
        rolesList.clear();
        //get the list of roles
        thisController.connectiontoDB("getListOfRoles");
        
        //set the list of role into array
        rolesList.addAll(thisController.arrList);
    }
    
    //check user's priv and disable unnessary function by Nan
    private void checkPrivs(){
        for(int i = 0; i<privsList.size();i++){
            switch (privsList.get(i)) {
                case "CREATE TABLE":
                case "CREATE ANY TABLE":
                    createTableItem.setVisible(true);
                    break;
                case "DROP TABLE":
                case "DROP ANY TABLE":   
                    deleteTableItem.setVisible(true);
                    break;
                case "CREATE TABLESPACE":
                case "CREATE ANY TABLESPACE":
                    createTablespaceItem.setVisible(true);
                    break;
                case "DROP TABLESPACE":
                case "DROP ANY TABLESPACE":
                    deleteTablespaceItem.setVisible(true);
                    break;
                case "CREATE INDEX":    
                case "CREATE ANY INDEX":
                    createIndexItem.setVisible(true);
                    break;
                case "DROP INDEX":
                case "DROP ANY INDEX":
                    deleteIndexItem.setVisible(true);
                    break;
                case "CREATE VIEW":
                case "CREATE ANY VIEW":
                    createViewItem.setVisible(true);
                    break;
                case "DROP ANY VIEW":
                    deleteViewItem.setVisible(true);
                    break;
                case "CREATE SEQUENCE":
                case "CREATE ANY SEQUENCE":
                    createSequenceItem.setVisible(true);
                    break;
                case "DROP SEQUENCE":
                case "DROP ANY SEQUENCE":
                    deleteSequenceItem.setVisible(true);
                    break;
                case "CREATE MATERIALIZE VIEW":
                case "CREATE ANY MATERIALIZE VIEW":
                    createMaterializeViewItem.setVisible(true);
                    break;
                case "DROP MATERIALIZE VIEW":
                case "DROP ANY MATERIALIZE VIEW":
                    deleteMaterializeViewItem.setVisible(true);
                    break;
                case "CREATE USER":
                case "CREATE ANY USER":
                    createUserItem.setVisible(true);
                    break;
                case "DROP USER":
                case "DROP ANY USER":
                    deleteUserItem.setVisible(true);
                    break;
                case "CREATE ROLE":
                case "CREATE ANY ROLE":
                case "DROP ROLE":
                case "DROP ANY ROLE":
                    assignRoleToUserItem.setVisible(true);                  
                    break;
                case "UNLIMITED TABLESPACE":
                    visibleAllCreat(true);
                    visibleAllDelet(true);
                    break;
                case "CREATE ANY DIRECTORY":
                    createDirectoryItem.setVisible(true);
                    break;
                case "DROP ANY DIRECTORY":
                    deleteDirItem.setVisible(true);
                    break;
            }
        }
    }//End check user's privs
    
    //Start check user's roless disable unnessary function by Nan
    private void checkRoles(){
        for(int i = 0; i<rolesList.size();i++){
            switch (rolesList.get(i)) {
                case "DBA":
                    visibleAll(true);
                    break;
                case "EXP_FULL_DATABASE":
                    for(int j = 0; j < rolesList.size();j++){
                        if(rolesList.get(j).equals("IMP_FULL_DATABASE")){
                            defragmentation.setVisible(true);
                            migration.setVisible(true);
                        }
                    }                   
                    break;
                case "MGMT_USER":
                    visibleUC(true);
                    break;
                case "RESOURCE":
                    createTableItem.setVisible(true);
                    deleteTableItem.setVisible(true);
                    createIndexItem.setVisible(true);
                    deleteIndexItem.setVisible(true);
                    break;
                
            }
        }
    }
    
    private void visibleAll(boolean b){

        visibleAllCreat(b);
        
        visibleAllDelet(b);  
        
        visibleUC(b);
        defragmentation.setVisible(b);
        migration.setVisible(b);
        createDirectoryItem.setVisible(b);
        deleteDirItem.setVisible(b);
    }
    
    private void visibleAllCreat(boolean b){
        createTableItem.setVisible(b);
        createTablespaceItem.setVisible(b);
        createIndexItem.setVisible(b);
        createViewItem.setVisible(b);
        createSequenceItem.setVisible(b);
        createMaterializeViewItem.setVisible(b);
    }
    
    private void visibleAllDelet(boolean b){
        deleteTableItem.setVisible(b);
        deleteTablespaceItem.setVisible(b);
        deleteIndexItem.setVisible(b);
        deleteViewItem.setVisible(b);
        deleteSequenceItem.setVisible(b);
        deleteMaterializeViewItem.setVisible(b);
    }
    
    private void visibleUC(boolean b){
        createUserItem.setVisible(b);
        deleteUserItem.setVisible(b);
        assignRoleToUserItem.setVisible(b);
        grantPrivileges.setVisible(b);
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu Help;
    private javax.swing.JButton Hide;
    private javax.swing.JMenu LogOutMenu;
    private javax.swing.JButton Show;
    private javax.swing.JMenuItem about;
    private GUI.AssignRoleToUser assignRoleToUser1;
    private javax.swing.JMenuItem assignRoleToUserItem;
    private javax.swing.JMenuItem checkForUpdate;
    private GUI.CreatIndex creatIndex1;
    private GUI.CreatSequence creatSequence1;
    public static javax.swing.JMenuItem createDirectoryItem;
    private javax.swing.JMenuItem createIndexItem;
    private javax.swing.JMenuItem createMaterializeViewItem;
    private javax.swing.JMenuItem createSequenceItem;
    private javax.swing.JMenuItem createTableItem;
    private javax.swing.JMenuItem createTablespaceItem;
    private javax.swing.JMenu createTablespacePanel;
    private GUI.CreateTablespaces createTablespaces1;
    public javax.swing.JMenuItem createUserItem;
    private javax.swing.JMenuItem createViewItem;
    private javax.swing.JMenu defragmentation;
    private javax.swing.JMenuItem defragmentationDatabaseItem;
    private javax.swing.JMenuItem defragmentationSegmentItem;
    private javax.swing.JMenuItem defragmentationTablespaceItem;
    private GUI.DefragmentationDatabase defragnmentationDatabase1;
    private GUI.DefragmentationTable defragnmentationTable;
    private GUI.DefragmentationTablespace defragnmentationTablespace1;
    private javax.swing.JMenuItem deleteDirItem;
    private GUI.DeleteIndex deleteIndex1;
    private javax.swing.JMenuItem deleteIndexItem;
    private GUI.DeleteMaterializeView deleteMaterializeView1;
    private javax.swing.JMenuItem deleteMaterializeViewItem;
    private GUI.DeleteSequence deleteSequence1;
    private javax.swing.JMenuItem deleteSequenceItem;
    public static javax.swing.JMenuItem deleteTableItem;
    public static javax.swing.JMenuItem deleteTablespaceItem;
    private GUI.DeleteUser deleteUser1;
    public static javax.swing.JMenuItem deleteUserItem;
    private javax.swing.JMenuItem deleteViewItem;
    private javax.swing.JMenuItem grantPrivileges;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JPanel mainPanel;
    private GUI.ManagePassword managePassword1;
    private javax.swing.JMenuItem managePasswordItem;
    private javax.swing.JMenu migration;
    private GUI.MigrationToMySQL migrationCrossPlatform1;
    private GUI.MigrationDatabase migrationDatabase1;
    private javax.swing.JMenuItem migrationDatabaseItem;
    private GUI.MigrationSchema migrationSchema1;
    private javax.swing.JMenuItem migrationSchemaItem;
    private javax.swing.JMenuItem migrationTableItem;
    private GUI.MigrationTablespace migrationTablespace1;
    private javax.swing.JMenuItem migrationTablespaceItem;
    private javax.swing.JMenuItem migrationToMySQL;
    private javax.swing.JMenuItem onlineHelp;
    private javax.swing.JButton update;
    private javax.swing.JMenu userControl;
    private GUI.Welcome welcome1;
    public javax.swing.JMenuItem welcomeItem;
    public static javax.swing.JLabel welcomeUser;
    // End of variables declaration//GEN-END:variables
    private GUI.CreatUser creatUser;
    private GUI.DeleteTablespaces deleteTbs;
    private GUI.MigrationTable migTbs;
    private GUI.GrantPrivileges grantPvl;
    private GUI.CreateTable createTable1;
    private GUI.CreatView creatView1;
    private GUI.CreatMaterializeView creatMaterializeView1;
    private GUI.DeleteTable deleteTable1;
    private GUI.DeleteView deleteView1;
    private GUI.DeleteDir delDir;
    private GUI.CreateDir createDir;
    String JTree1Var;
}
