/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import com.bean.User;
import com.dao.UserDao;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userjt = new javax.swing.JTextField();
        namejt = new javax.swing.JTextField();
        mobjt = new javax.swing.JTextField();
        passjt = new javax.swing.JPasswordField();
        reg_but = new javax.swing.JButton();
        rst_but = new javax.swing.JButton();
        log_but = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        usertypejcb = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(570, 638));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/bms2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("REGISTRATION DETAILS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NAME : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("USERNAME : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("MOBILE NO.: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PASSWORD : ");

        userjt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userjtActionPerformed(evt);
            }
        });

        passjt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passjtKeyPressed(evt);
            }
        });

        reg_but.setBackground(new java.awt.Color(255, 153, 153));
        reg_but.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reg_but.setText("REGISTER");
        reg_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_butActionPerformed(evt);
            }
        });

        rst_but.setBackground(new java.awt.Color(255, 153, 153));
        rst_but.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rst_but.setText("RESET");
        rst_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rst_butActionPerformed(evt);
            }
        });

        log_but.setBackground(new java.awt.Color(255, 255, 255));
        log_but.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        log_but.setText("Click to Login");
        log_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_butActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TYPE :");

        usertypejcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--  Select Type  --", "Admin", "Other" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(32, 32, 32))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(reg_but, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rst_but, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(namejt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(mobjt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(userjt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(passjt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(usertypejcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(log_but, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(log_but, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namejt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mobjt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usertypejcb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userjt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passjt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_but, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rst_but, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/soft.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userjtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userjtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userjtActionPerformed

    private void rst_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rst_butActionPerformed
        // TODO add your handling code here:
        
        namejt.setText("");
        userjt.setText("");
        passjt.setText("");
        mobjt.setText("");
        usertypejcb.setSelectedIndex(0);
    }//GEN-LAST:event_rst_butActionPerformed

    private void log_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_butActionPerformed
        // TODO add your handling code here:
        try
        {
            LoginForm lf=new LoginForm();
            lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lf.setTitle("Login Form");
            Image image=new ImageIcon(getClass().getResource("/com/images/bmslogo.jpg")).getImage();
            lf.setIconImage(image);
            int wd=Toolkit.getDefaultToolkit().getScreenSize().width;
            lf.setLocation((wd-lf.getWidth())/2,90);
            lf.setResizable(false);
            
            this.setVisible(false);
            
            lf.setVisible(true);
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Unable start application..."+e.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_log_butActionPerformed

    private void reg_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_butActionPerformed
        // TODO add your handling code here:
        try
        {
            String name=namejt.getText();
            String phone=mobjt.getText();
            int idx=usertypejcb.getSelectedIndex();
            String username=userjt.getText();
            String password=new String(passjt.getPassword());
            
            Pattern nmp=Pattern.compile("[a-zA-z ]+");
            Pattern p=Pattern.compile("[0-9]{10}");
            Matcher m=p.matcher(phone);
            
            if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Name must not be Empty...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(!nmp.matcher(name).matches())
            {
                JOptionPane.showMessageDialog(null,"Name not contains any number, Enter your NAME...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(phone.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Mobile number must not be Empty...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(!m.matches())
            {
                JOptionPane.showMessageDialog(null,"Mobile number must contain only 10 digits..!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(idx==0)
            {
                JOptionPane.showMessageDialog(null,"Select User Type..!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Username must not be Empty...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(password.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Password must not be Empty...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try{
                    
                    if(!UserDao.checkUserName(username))
                    {
                        User us=new User();
                        us.setName(name);
                        us.setPhone(phone);
                        us.setUsertype(idx);
                        us.setUsername(username);
                        us.setPassword(password);

                        boolean b=UserDao.save(us);

                        if(b)
                        {
                            JOptionPane.showMessageDialog(null,"Registration done successfully...!!");
                            namejt.setText("");
                            userjt.setText("");
                            passjt.setText("");
                            mobjt.setText("");
                            usertypejcb.setSelectedIndex(0);

                            this.setVisible(false);
                            LoginForm lf=new LoginForm();
                            lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            lf.setTitle("Login Form");
                            int wd=Toolkit.getDefaultToolkit().getScreenSize().width;
                            lf.setLocation((wd-lf.getWidth())/2,100);
                            lf.setResizable(false);
                            lf.setVisible(true);

                        }
                        else 
                            JOptionPane.showMessageDialog(null,"Error occur while inserting data...!!","Error Message",JOptionPane.ERROR_MESSAGE);
                    }
                    else 
                        JOptionPane.showMessageDialog(null,"Username already registered, try another...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
                
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_reg_butActionPerformed

    private void passjtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passjtKeyPressed
        // TODO add your handling code here:
        try
        {
            int kc=evt.getKeyCode();
            if(kc==32)
            {
                JOptionPane.showMessageDialog(null,"Spaces not allow in Password Field...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            String pass=new String(passjt.getPassword()).trim();
            passjt.setText(pass);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_passjtKeyPressed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    RegisterForm rf=new RegisterForm();
                    rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    rf.setTitle("Registration Form");
                    Image image=new ImageIcon(getClass().getResource("/com/images/bmslogo.jpg")).getImage();
                    rf.setIconImage(image);
                    int wd=Toolkit.getDefaultToolkit().getScreenSize().width;
                    rf.setLocation((wd-rf.getWidth())/2,50);
                    rf.setResizable(false);
                    rf.setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Unable start application...!!","Error Message",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton log_but;
    private javax.swing.JTextField mobjt;
    private javax.swing.JTextField namejt;
    private javax.swing.JPasswordField passjt;
    private javax.swing.JButton reg_but;
    private javax.swing.JButton rst_but;
    private javax.swing.JTextField userjt;
    private javax.swing.JComboBox usertypejcb;
    // End of variables declaration//GEN-END:variables
}
