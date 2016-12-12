/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jtb = new javax.swing.JTable();
        jmenubar = new javax.swing.JMenuBar();
        add_menu = new javax.swing.JMenu();
        edit_menu = new javax.swing.JMenu();
        delete_menu = new javax.swing.JMenu();
        receipt_menu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jScrollPane.setSize(mainpanel.getSize());

        jtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No.", "Employee Name", "Receipt No.", "Entry Date", "Funds Rate", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtb.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jtb);
        if (jtb.getColumnModel().getColumnCount() > 0) {
            jtb.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtb.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jmenubar.setPreferredSize(new java.awt.Dimension(193, 30));

        add_menu.setText("Add");
        add_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_menuMouseClicked(evt);
            }
        });
        jmenubar.add(add_menu);

        edit_menu.setText("Edit");
        edit_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmenubar.add(edit_menu);

        delete_menu.setText("Delete");
        delete_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmenubar.add(delete_menu);

        receipt_menu.setText("Receipt");
        receipt_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmenubar.add(receipt_menu);

        jMenu1.setText("Print");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmenubar.add(jMenu1);

        setJMenuBar(jmenubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        mainpanel.setSize(this.getSize());
        jScrollPane.setSize(this.getSize());
        jtb.setSize(this.getSize());
    }//GEN-LAST:event_formComponentResized

    private void add_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_menuMouseClicked
        // TODO add your handling code here:
        AddUser ad=new AddUser(this,true);
        ad.setLocationRelativeTo(this);
        ad.setVisible(true);
    }//GEN-LAST:event_add_menuMouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainForm mf= new MainForm();
               mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               Dimension d=Toolkit.getDefaultToolkit().getScreenSize().getSize();
               mf.setSize(d);
               mf.setMaximumSize(d);
               mf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu add_menu;
    private javax.swing.JMenu delete_menu;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenuBar jmenubar;
    private javax.swing.JTable jtb;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JMenu receipt_menu;
    // End of variables declaration//GEN-END:variables
}