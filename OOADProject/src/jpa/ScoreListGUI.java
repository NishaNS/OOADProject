package jpa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nisha
 */
public class ScoreListGUI extends javax.swing.JFrame {

   
	/**
     * Creates new form ScoreListGUI
     */
    public ScoreListGUI() {
        initComponents();
        scoreTableController = new ScoreTableController(this);
        addJTable();
    }

    private void addJTable() {
    	// add the data and column names to a JTable
    	tblScoreTable = new JTable(scoreTableController.getTableModel());
    	
    	// add a ListSelectionListener to the table
    	tblScoreTable.getSelectionModel().addListSelectionListener(scoreTableController);
    	
    	// add the table to a scrollpane
    	JScrollPane scrollPane = new JScrollPane(tblScoreTable);
    	
    	// create a window
    	pnlTable.setLayout(new BorderLayout());
    	pnlTable.add(scrollPane, BorderLayout.CENTER);
	}
    
 /////////////////%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% UPDATE TABLE ??
    
    public void setGameID(String gameID) {
    	txtGameID.setText(gameID);
    }
    
    public String getGameID() {
    	return txtGameID.getText();
    }    
    
    public void setFirstName(String firstname) {
    	txtFirstName.setText(firstname);
    }
    
    public String getFirstName() {
    	return txtFirstName.getText();
    }
    
    public void setLastName(String lastname) {
    	txtLastName.setText(lastname);
    }
    
    public String getLastName() {
    	return txtLastName.getText();
    }
    
    public void setGameTheme(String theme) {
    	txtGameTheme.setText(theme);
    }
    
    public String getGameTheme() {
    	return txtGameTheme.getText();
    }
    
    public void setGameLevel(String level) {
    	txtGameLevel.setText(level);
    }
    
    public String getGameLevel() {
    	return txtGameLevel.getText();
    }
    
    public void setGameScore(String score) {
    	txtGameScore.setText(score);
    }
    
    public String getGameScore() {
    	return txtGameScore.getText();
    }
    
    public void setGameTime(String time) {
    	txtGameTime.setText(time);
    }
    
    public String getGameTime() {
    	return txtGameTime.getText();
    }


    //updating JTable
    public void updateTable() {
    	tblScoreTable.setModel(scoreTableController.getTableModel());
    }
    

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contentPane = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        pnlTable = new javax.swing.JPanel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        testAdd = new javax.swing.JButton();
        testUpdate = new javax.swing.JButton();
        testDelete = new javax.swing.JButton();
        lblGameTheme = new javax.swing.JLabel();
        lblGameLevel = new javax.swing.JLabel();
        txtGameTheme = new javax.swing.JTextField();
        txtGameLevel = new javax.swing.JTextField();
        lblGameScore = new javax.swing.JLabel();
        lblGameTime = new javax.swing.JLabel();
        txtGameScore = new javax.swing.JTextField();
        txtGameTime = new javax.swing.JTextField();
        lblGameID = new javax.swing.JLabel();
        txtGameID = new javax.swing.JTextField();
        lblCreatedTime = new javax.swing.JLabel();
        txtCreatedTime = new javax.swing.JTextField();
        
        testAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButtonActionPerformed(e);
			}
		});

        testUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addUpdateActionPerformed(e);
				
			}
		});
        
        testDelete.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent e) {
        		addDeleteActionPerformed(e);

        	}
        });
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("scoreFrame"); // NOI18N

        contentPane.setName("contentPanel"); // NOI18N

        lblBanner.setText("lblBanner");
        lblBanner.setName("lblBanner"); // NOI18N

        lblFirstName.setText("lblFirstName");
        lblFirstName.setToolTipText("Enter First Name");
        lblFirstName.setName("lblFirstName"); // NOI18N

        txtFirstName.setText("txtFirstName");
        txtFirstName.setToolTipText("");
        txtFirstName.setName("txtFirstName"); // NOI18N
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        pnlTable.setName("pnlTable"); // NOI18N

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        lblLastName.setText("lblLastName");
        lblLastName.setName("lblLastName"); // NOI18N

        txtLastName.setText("txtLastName");
        txtLastName.setName("txtLastName"); // NOI18N
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        testAdd.setText("testAdd");
        testAdd.setToolTipText("");
        testAdd.setName("testAdd"); // NOI18N

        testUpdate.setText("testUpdate");
        testUpdate.setName("testUpdate"); // NOI18N

        testDelete.setText("testDelete");
        testDelete.setName("testDelete"); // NOI18N

        lblGameTheme.setText("lblGameTheme");
        lblGameTheme.setName("lblGameTheme"); // NOI18N

        lblGameLevel.setText("lblGameLevel");
        lblGameLevel.setName("lblGameLevel"); // NOI18N

        txtGameTheme.setText("jTextField1");
        txtGameTheme.setName("txtGameTheme"); // NOI18N

        txtGameLevel.setText("jTextField2");
        txtGameLevel.setName("txtGameLevel"); // NOI18N

        lblGameScore.setText("lblGameScore");
        lblGameScore.setName("lblGameScore"); // NOI18N

        lblGameTime.setText("lblGameTime");
        lblGameTime.setName("lblGameTime"); // NOI18N

        txtGameScore.setText("jTextField3");
        txtGameScore.setName("txtGameScore"); // NOI18N
        txtGameScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGameScoreActionPerformed(evt);
            }
        });

        txtGameTime.setText("jTextField4");
        txtGameTime.setName("txtGameTime"); // NOI18N

        lblGameID.setText("lblGameID");
        lblGameID.setEnabled(false);
        lblGameID.setName("lblGameID"); // NOI18N

        txtGameID.setText("jTextField1");
        txtGameID.setEnabled(false);
        txtGameID.setName("txtGameID"); // NOI18N

        lblCreatedTime.setText("lblCreatedTime");
        lblCreatedTime.setEnabled(false);
        lblCreatedTime.setName("lblCreatedTime"); // NOI18N

        txtCreatedTime.setText("jTextField2");
        txtCreatedTime.setEnabled(false);
        txtCreatedTime.setName("txtCreatedTime"); // NOI18N

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblGameTheme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLastName)
                                    .addComponent(txtGameTheme)))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(lblGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(139, 139, 139)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGameScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGameTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGameID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCreatedTime, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGameTime, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtGameScore)
                            .addComponent(txtGameID)
                            .addComponent(txtCreatedTime))
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(testUpdate)
                        .addGap(43, 43, 43)
                        .addComponent(testDelete)
                        .addGap(269, 269, 269)))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(lblBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGameScore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtGameScore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGameID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGameID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblGameTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGameTheme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCreatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCreatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testAdd)
                    .addComponent(testUpdate)
                    .addComponent(testDelete))
                .addGap(40, 40, 40)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtFirstName.getAccessibleContext().setAccessibleName("txtFirstName");
        pnlTable.getAccessibleContext().setAccessibleName("pnlTable");
        txtLastName.getAccessibleContext().setAccessibleName("txtLastName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("scoreFrame");

        pack();
    }// </editor-fold>                        

   

	private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtGameScoreActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    //TEST ADD BUTTON
    private void addButtonActionPerformed(ActionEvent evt) {
		//add row
    	String[] data_array = new String[8];
    	data_array[0] = "default";		//autoincrement Primary key
    	data_array[1] = getFirstName();
    	data_array[2] = getLastName();
    	data_array[3] = getGameTheme();
    	data_array[4] = getGameLevel();
    	data_array[5] = getGameScore();
    	data_array[6] = getGameTime();
    	data_array[7] = "NOW()";		//insert current time in DB
    	
    	/*data_array[1] = "John";
    	data_array[2] = "Doe";
    	data_array[3] = "Farm";
    	data_array[4] = "2";
    	data_array[5] = "99";
    	data_array[6] = "5:12";*/
    	
    	//send all data to table controller
    	scoreTableController.addRow(data_array);
	}
    
    //Update button action
    private void addUpdateActionPerformed(ActionEvent e) {
    	String[] data_array = new String[7];
    	data_array[0] = getGameID();
    	data_array[1] = getFirstName();
    	data_array[2] = getLastName();
    	data_array[3] = getGameTheme();
    	data_array[4] = getGameLevel();
    	data_array[5] = getGameScore();
    	data_array[6] = getGameTime();
    	
    	//send all data to table controller
    	scoreTableController.updateRow(data_array);
	}

    
    //delete row
    private void addDeleteActionPerformed(ActionEvent e) {
		String gameid = getGameID();	
		
		//send all data to table controller
    	scoreTableController.deleteRow(gameid);
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScoreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreListGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel contentPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCreatedTime;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGameID;
    private javax.swing.JLabel lblGameLevel;
    private javax.swing.JLabel lblGameScore;
    private javax.swing.JLabel lblGameTheme;
    private javax.swing.JLabel lblGameTime;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JButton testAdd;
    private javax.swing.JButton testDelete;
    private javax.swing.JButton testUpdate;
    private javax.swing.JTextField txtCreatedTime;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGameID;
    private javax.swing.JTextField txtGameLevel;
    private javax.swing.JTextField txtGameScore;
    private javax.swing.JTextField txtGameTheme;
    private javax.swing.JTextField txtGameTime;
    private javax.swing.JTextField txtLastName;
    private ScoreTableController scoreTableController;
    private JTable tblScoreTable;
    // End of variables declaration                   
}
