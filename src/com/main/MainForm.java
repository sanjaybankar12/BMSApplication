/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import com.bean.Employee;
import com.dao.DatabaseDao;
import com.dao.EmployeeDao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Sanjay
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    static String sector="";
    static long receipt_no=0;
    static int user_type=0;
    static HashMap<Long,Boolean> del_arl=new HashMap<>();
    public MainForm() {
        initComponents();
        
        addWindowListener(new WindowAdapter()
        {
             public void windowClosing(WindowEvent we)
             {
                 int ans=JOptionPane.showConfirmDialog(null,"Do want to close this Application?","Confirmation Message",JOptionPane.YES_NO_OPTION);
                 if(ans==0)
                 {
                     System.exit(0);
                 }
             }
        });
    }
    public MainForm(String sector,int user_type) {
        initComponents();
        this.sector=sector;
        this.user_type=user_type;
        jtb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel lsm=(ListSelectionModel)jtb.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                try{
                long idx=lsm.getMaxSelectionIndex();
                if(idx!=-1)
                {
                    DefaultTableModel dtm=(DefaultTableModel)jtb.getModel();
                    receipt_no=Long.parseLong(dtm.getValueAt((int)idx,3)+"");
                    
                    boolean isSel=(boolean)dtm.getValueAt((int)idx,0);
                    del_arl.put(receipt_no,isSel);
                    
                    System.out.println(isSel);

                }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }                                    
        });
        
        addWindowListener(new WindowAdapter()
        {
             public void windowClosing(WindowEvent we)
             {
                 int ans=JOptionPane.showConfirmDialog(null,"Do want to close this Application?","Confirmation Message",JOptionPane.YES_NO_OPTION);
                 if(ans==0)
                 {
                     System.exit(0);
                 }
             }
        });
       
        initData(sector);
    }
    public void initData(String sector)
    {
        try{
            
            if(user_type!=1)
            {
                receipt_menu.setEnabled(false);
                print_menu.setEnabled(false);
            }
            
            ArrayList<Employee> arl=EmployeeDao.getEmployeeDetails(sector);
            if(arl!=null)
            {
                DefaultTableModel dtm=(DefaultTableModel)jtb.getModel();                
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );   
                jtb.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
                jtb.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
                jtb.getColumnModel().getColumn(16).setCellRenderer( centerRenderer );

                while(dtm.getRowCount()>0)
                {
                    dtm.removeRow(0);
                }
                for(long i=0;i<arl.size();i++){
                    Employee emp=arl.get((int)i);
                    dtm.addRow(new Object[]{false,(i+1),emp.getName(),emp.getReceipt_no(),emp.getEntry_date(),emp.getSub_rate(),emp.getJan(),emp.getFeb(),emp.getMar(),emp.getApr(),emp.getMay(),emp.getJun(),emp.getJul(),emp.getAug(),emp.getSep(),emp.getOct(),emp.getNov(),emp.getDecb(),emp.getTotal()});
                }
            }
            receipt_no=0;
        }catch(Exception e){
            e.printStackTrace();
        }
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
        jtb = new javax.swing.JTable()
        {
            public Component prepareRenderer(TableCellRenderer render,int row,int col)
            {
                Component c=super.prepareRenderer(render,row,col);

                JComponent jc=(JComponent)c;
                jc.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                return c;
            }

        }
        ;
        jmenubar = new javax.swing.JMenuBar();
        add_menu = new javax.swing.JMenu();
        edit_menu = new javax.swing.JMenu();
        delete_menu = new javax.swing.JMenu();
        receipt_menu = new javax.swing.JMenu();
        print_menu = new javax.swing.JMenu();
        impdb_menu = new javax.swing.JMenu();
        expdb_menu = new javax.swing.JMenu();
        show_all_menu = new javax.swing.JMenu();
        search_menu = new javax.swing.JMenu();
        log_menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        mainpanel.setBackground(new java.awt.Color(255, 153, 153));

        jScrollPane.setSize(mainpanel.getSize());
        jScrollPane.setBackground(new java.awt.Color(255, 153, 153));

        jtb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jtb.setDefaultRenderer(Long.class, centerRenderer);
        jtb.setAutoCreateRowSorter(true);
        jtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X","Sr. No.", "Employee Name", "Receipt No.", "Entry Date", "Funds Rate", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec","Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class,java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true,false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,false
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
        if(jtb.getColumnModel().getColumnCount()>0)
        {
            jtb.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtb.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtb.getColumnModel().getColumn(2).setPreferredWidth(190);
            jtb.getColumnModel().getColumn(3).setPreferredWidth(85);
            jtb.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtb.getColumnModel().getColumn(5).setPreferredWidth(90);
            jtb.getColumnModel().getColumn(18).setPreferredWidth(120);
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
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jmenubar.setBackground(new java.awt.Color(153, 153, 255));
        jmenubar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jmenubar.setPreferredSize(new java.awt.Dimension(193, 30));

        add_menu.setText("Add");
        add_menu.setBorderPainted(true);
        add_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_menuMouseClicked(evt);
            }
        });
        jmenubar.add(add_menu);

        edit_menu.setText("Edit");
        edit_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_menuMouseClicked(evt);
            }
        });
        jmenubar.add(edit_menu);

        delete_menu.addSeparator();
        delete_menu.setText("Delete");
        delete_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_menuMouseClicked(evt);
            }
        });
        jmenubar.add(delete_menu);

        receipt_menu.setText("Receipt");
        receipt_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        receipt_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receipt_menuMouseClicked(evt);
            }
        });
        jmenubar.add(receipt_menu);

        print_menu.setText("Print");
        print_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        print_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                print_menuMouseClicked(evt);
            }
        });
        jmenubar.add(print_menu);

        impdb_menu.setText("Import");
        impdb_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        impdb_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                impdb_menuMouseClicked(evt);
            }
        });
        jmenubar.add(impdb_menu);

        expdb_menu.setText("Export ");
        expdb_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        expdb_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expdb_menuMouseClicked(evt);
            }
        });
        jmenubar.add(expdb_menu);

        JLabel tptext=new JLabel("                                                                                                                                              ");
        show_all_menu.setText("Show All");
        show_all_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        show_all_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_all_menuMouseClicked(evt);
            }
        });
        jmenubar.add(show_all_menu);
        jmenubar.add(tptext);

        serach_text=new JTextField();
        PromptSupport.setPrompt("Search By Receipt Id / Name",serach_text);
        search_menu.setText("Search");
        search_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_menuMouseClicked(evt);
            }
        });

        jmenubar.add(serach_text);

        jmenubar.add(search_menu);

        log_menu.setText("Logout");
        log_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        log_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                log_menuMouseClicked(evt);
            }
        });
        jmenubar.add(log_menu);

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
        Dimension d=this.getSize();
        mainpanel.setSize(this.getSize());
        jScrollPane.setSize(d.width-18,d.height);
        jtb.setSize(d.width-18,d.height);
    }//GEN-LAST:event_formComponentResized

    private void add_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_menuMouseClicked
        // TODO add your handling code here:
        
        try
        {
            if(!sector.equals(""))
            {                
                AddUser ad=new AddUser(this,true,sector);
                ad.setLocationRelativeTo(this);
                ad.setResizable(false);
                ad.setVisible(true);
                ad.setAutoRequestFocus(true);
                       
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sector of Employee not identify...!!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_add_menuMouseClicked

    private void edit_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_menuMouseClicked
        // TODO add your handling code here:
        try
        {
            if(!sector.equals("") && receipt_no!=0)
            {
                EditUser ed=new EditUser(this,true,sector,receipt_no);
                ed.setLocationRelativeTo(this);
                ed.setResizable(false);
                ed.setVisible(true);
                ed.setAutoRequestFocus(true);
                              
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Select Employee to Edit...!!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_edit_menuMouseClicked

    private void delete_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_menuMouseClicked
        // TODO add your handling code here:
        try
        {
            if(!sector.equals("") && receipt_no!=0)
            {
                Set<Map.Entry<Long, Boolean>> set=del_arl.entrySet();
                boolean isByCheck=false;
                for(Map.Entry<Long, Boolean> me:set)
                {
                     isByCheck=me.getValue();
                }
                System.out.println(isByCheck);
//                DeleteUser ed=new DeleteUser(this,true,sector,receipt_no);
//                ed.setLocationRelativeTo(this);
//                ed.setResizable(false);
//                ed.setVisible(true);
//                ed.setAutoRequestFocus(true);
                        
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Select Employee to Delete Record...!!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_delete_menuMouseClicked

    private void receipt_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receipt_menuMouseClicked
        // TODO add your handling code here:
        if(user_type==1)
        {
            int choice=JOptionPane.showConfirmDialog(null,"Do want to see Receipt?","Confirm",JOptionPane.YES_NO_OPTION);
            if(choice==0)
            {
                EmployeeDao.showReceipt(sector);
            }
        }
    }//GEN-LAST:event_receipt_menuMouseClicked

    private void print_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_print_menuMouseClicked
        // TODO add your handling code here:
        try
        {
            if(user_type==1)
            {
                if(!sector.equals(""))
                {
                    PrintDialog ad=new PrintDialog(this,true,sector);
                    ad.setLocationRelativeTo(this);
                    ad.setResizable(false);
                    ad.setVisible(true);
                    ad.setAutoRequestFocus(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Sector of Employee not identify...!!!","Warning Message",JOptionPane.WARNING_MESSAGE);
                }
            }
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_print_menuMouseClicked

    private void show_all_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_all_menuMouseClicked
        // TODO add your handling code here:
        serach_text.setText("");
        initData(sector);
    }//GEN-LAST:event_show_all_menuMouseClicked

    private void search_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_menuMouseClicked
        // TODO add your handling code here:
        
        try
        {
            String search_data=serach_text.getText();
            Pattern p=Pattern.compile("[0-9]+");
            if(search_data.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Search Field must not be Empty...!!","Warning Message",JOptionPane.WARNING_MESSAGE);
            }
            else if(!p.matcher(search_data).matches())
            {
                ArrayList<Employee> arl=EmployeeDao.getEmployeeDetails(sector,search_data.toUpperCase());
                
                DefaultTableModel dtm=(DefaultTableModel)jtb.getModel();
                while(dtm.getRowCount()>0)
                {
                    dtm.removeRow(0);
                }
                
                for(int i=0;i<arl.size();i++)
                {
                    dtm.addRow(new Object[]{false,(i+1),arl.get(i).getName(),arl.get(i).getReceipt_no(),arl.get(i).getEntry_date(),arl.get(i).getSub_rate(),arl.get(i).getJan(),arl.get(i).getFeb(),arl.get(i).getMar(),arl.get(i).getApr(),arl.get(i).getMay(),arl.get(i).getJun(),arl.get(i).getJul(),arl.get(i).getAug(),arl.get(i).getSep(),arl.get(i).getOct(),arl.get(i).getNov(),arl.get(i).getDecb()});
                }
                
                if(dtm.getRowCount()==0)
                    JOptionPane.showMessageDialog(null,"Records not found...!!");
                
            }
            else if(search_data.length()>18)
            {
                DefaultTableModel dtm=(DefaultTableModel)jtb.getModel();
                while(dtm.getRowCount()>0)
                {
                    dtm.removeRow(0);
                }
                JOptionPane.showMessageDialog(null,"Records not found...!!");
            }
            else
            {
                long rec_no=Long.parseLong(search_data);
                Employee emp=EmployeeDao.getEmployeeDetails(sector, rec_no);
                
                DefaultTableModel dtm=(DefaultTableModel)jtb.getModel();
                while(dtm.getRowCount()>0)
                {
                    dtm.removeRow(0);
                }
                if(emp.getReceipt_no()!=0)
                {
                    dtm.addRow(new Object[]{false,(1),emp.getName(),emp.getReceipt_no(),emp.getEntry_date(),emp.getSub_rate(),emp.getJan(),emp.getFeb(),emp.getMar(),emp.getApr(),emp.getMay(),emp.getJun(),emp.getJul(),emp.getAug(),emp.getSep(),emp.getOct(),emp.getNov(),emp.getDecb()});
                }
                
                if(dtm.getRowCount()==0)
                    JOptionPane.showMessageDialog(null,"Record not found...!!");
                
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_search_menuMouseClicked

    private void expdb_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expdb_menuMouseClicked
        // TODO add your handling code here:
        try{
           JFileChooser jfc=new JFileChooser();
           jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           int retval=jfc.showSaveDialog(this);
           if(retval==JFileChooser.APPROVE_OPTION)
           {
               File destdir=jfc.getSelectedFile();
               String destpath=destdir.getPath();
               
               DatabaseDao.exportDB(destpath);
               JOptionPane.showMessageDialog(null,"Database Export Successfully...!!");
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_expdb_menuMouseClicked

    private void log_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_menuMouseClicked
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
             
         }catch(Exception e){
             e.printStackTrace();
             System.exit(0);
         }
    }//GEN-LAST:event_log_menuMouseClicked

    private void impdb_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impdb_menuMouseClicked
        // TODO add your handling code here:
        try{
           JFileChooser jfc=new JFileChooser();
           jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
           int retval=jfc.showOpenDialog(this);
           if(retval==JFileChooser.APPROVE_OPTION)
           {
               File destdir=jfc.getSelectedFile();
               String destpath=destdir.getPath();
               String fname=destdir.getName();
               if(fname.endsWith(".xlsx") && fname.startsWith("BMSBackup"))
               {
                    DatabaseDao.importDB(this,sector,destpath,fname);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Only database files are Accepted...!!!","Warning Message",JOptionPane.WARNING_MESSAGE);
               }
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_impdb_menuMouseClicked

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
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainForm mf= new MainForm();
               mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               Dimension d=Toolkit.getDefaultToolkit().getScreenSize().getSize();
               mf.setSize(d);
               mf.setMaximumSize(d);
               mf.setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu add_menu;
    private javax.swing.JMenu delete_menu;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JMenu expdb_menu;
    private javax.swing.JMenu impdb_menu;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenuBar jmenubar;
    private javax.swing.JTable jtb;
    private javax.swing.JMenu log_menu;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JMenu print_menu;
    private javax.swing.JMenu receipt_menu;
    private javax.swing.JMenu search_menu;
    private javax.swing.JMenu show_all_menu;
    private javax.swing.JTextField serach_text;
    // End of variables declaration//GEN-END:variables
}
