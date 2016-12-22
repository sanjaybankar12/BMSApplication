/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.bean.Employee;
import com.dbconnection.DB;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sanjay
 */
public class EmployeeDao {
    
    public static boolean checkReceiptNo(long rec_no,String sector)
    {
        try{
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE_INFO WHERE RECEIPT_NO="+rec_no+" AND SECTOR='"+sector+"'");
            
            return rs.next();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
           
    }
    public static boolean save(Employee emp)
    {
        try
        {
            java.sql.Date sd1=new java.sql.Date(emp.getEntry_date().getTime());
            
            DB db=new DB();
            Connection c=db.getConnection();
            
            PreparedStatement ps=c.prepareStatement("INSERT INTO EMPLOYEE_INFO(NAME,RECEIPT_NO,ENTRY_DATE,SUB_RATE,JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DECB,TOTAL,REMARK,SECTOR,SUB_FROM,SUB_TO,PLACE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,emp.getName().toUpperCase());
            ps.setLong(2,emp.getReceipt_no());
            ps.setDate(3,sd1);
            ps.setInt(4,emp.getSub_rate());
            ps.setInt(5,emp.getJan());
            ps.setInt(6,emp.getFeb());
            ps.setInt(7,emp.getMar());
            ps.setInt(8,emp.getApr());
            ps.setInt(9,emp.getMay());
            ps.setInt(10,emp.getJun());
            ps.setInt(11,emp.getJul());
            ps.setInt(12,emp.getAug());
            ps.setInt(13,emp.getSep());
            ps.setInt(14,emp.getOct());
            ps.setInt(15,emp.getNov());
            ps.setInt(16,emp.getDecb());
            ps.setLong(17,emp.getTotal());
            ps.setString(18,emp.getRemark());
            ps.setString(19,emp.getSector());
            ps.setString(20,emp.getSub_from());
            ps.setString(21,emp.getSub_to());
            ps.setString(22,emp.getPlace().toUpperCase());
            
            ps.execute();
            
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Employee emp)
    {
        try
        {
            java.sql.Date sd1=new java.sql.Date(emp.getEntry_date().getTime());
            
            DB db=new DB();
            Connection c=db.getConnection();
            
            PreparedStatement ps=c.prepareStatement("UPDATE EMPLOYEE_INFO set NAME=?,ENTRY_DATE=?,SUB_RATE=?,JAN=?,FEB=?,MAR=?,APR=?,MAY=?,JUN=?,JUL=?,AUG=?,SEP=?,OCT=?,NOV=?,DECB=?,TOTAL=?,REMARK=?,SUB_FROM=?,SUB_TO=?,PLACE=? WHERE RECEIPT_NO=? AND SECTOR=?");
            ps.setString(1,emp.getName().toUpperCase());
            ps.setDate(2,sd1);
            ps.setInt(3,emp.getSub_rate());
            ps.setInt(4,emp.getJan());
            ps.setInt(5,emp.getFeb());
            ps.setInt(6,emp.getMar());
            ps.setInt(7,emp.getApr());
            ps.setInt(8,emp.getMay());
            ps.setInt(9,emp.getJun());
            ps.setInt(10,emp.getJul());
            ps.setInt(11,emp.getAug());
            ps.setInt(12,emp.getSep());
            ps.setInt(13,emp.getOct());
            ps.setInt(14,emp.getNov());
            ps.setInt(15,emp.getDecb());
            ps.setLong(16,emp.getTotal());
            ps.setString(17,emp.getRemark());
            ps.setString(18,emp.getSub_from());
            ps.setString(19,emp.getSub_to());
            ps.setString(20,emp.getPlace().toUpperCase());
            ps.setLong(21,emp.getReceipt_no());
            ps.setString(22,emp.getSector());
            
            ps.executeUpdate();
            
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList getEmployeeDetails(String sector)
    {
        try
        {
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE_INFO WHERE SECTOR='"+sector+"'");
            
            ArrayList<Employee> arl=new ArrayList<>();
            while(rs.next())
            {
                Employee emp=new Employee();
                
                emp.setId(rs.getLong("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setReceipt_no(rs.getLong("RECEIPT_NO"));
                emp.setEntry_date(rs.getDate("ENTRY_DATE"));
                emp.setSub_rate(rs.getInt("SUB_RATE"));
                emp.setJan(rs.getInt("JAN"));
                emp.setFeb(rs.getInt("FEB"));
                emp.setMar(rs.getInt("MAR"));
                emp.setApr(rs.getInt("APR"));
                emp.setMay(rs.getInt("MAY"));
                emp.setJun(rs.getInt("JUN"));
                emp.setJul(rs.getInt("JUL"));
                emp.setAug(rs.getInt("AUG"));
                emp.setSep(rs.getInt("SEP"));
                emp.setOct(rs.getInt("OCT"));
                emp.setNov(rs.getInt("NOV"));
                emp.setDecb(rs.getInt("DECB"));
                emp.setTotal(rs.getLong("TOTAL"));
                emp.setRemark(rs.getString("REMARK"));
                emp.setSector(rs.getString("SECTOR"));
                emp.setSub_from(rs.getString("SUB_FROM"));
                emp.setSub_to(rs.getString("SUB_TO"));
                emp.setPlace(rs.getString("PLACE"));
                
                arl.add(emp);
            }
            
            return arl;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Employee getEmployeeDetails(String sector,long receipt_no)
    {
        try
        {
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE_INFO WHERE SECTOR='"+sector+"' AND RECEIPT_NO="+receipt_no);
            
            Employee emp=new Employee();
            while(rs.next())
            {
                emp.setId(rs.getLong("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setReceipt_no(rs.getLong("RECEIPT_NO"));
                emp.setEntry_date(rs.getDate("ENTRY_DATE"));
                emp.setSub_rate(rs.getInt("SUB_RATE"));
                emp.setJan(rs.getInt("JAN"));
                emp.setFeb(rs.getInt("FEB"));
                emp.setMar(rs.getInt("MAR"));
                emp.setApr(rs.getInt("APR"));
                emp.setMay(rs.getInt("MAY"));
                emp.setJun(rs.getInt("JUN"));
                emp.setJul(rs.getInt("JUL"));
                emp.setAug(rs.getInt("AUG"));
                emp.setSep(rs.getInt("SEP"));
                emp.setOct(rs.getInt("OCT"));
                emp.setNov(rs.getInt("NOV"));
                emp.setDecb(rs.getInt("DECB"));
                emp.setTotal(rs.getLong("TOTAL"));
                emp.setRemark(rs.getString("REMARK"));
                emp.setSector(rs.getString("SECTOR"));
                emp.setSub_from(rs.getString("SUB_FROM"));
                emp.setSub_to(rs.getString("SUB_TO"));
                emp.setPlace(rs.getString("PLACE"));
            }
            
            return emp;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList getEmployeeDetails(String sector,String emp_name)
    {
        try
        {
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE_INFO WHERE SECTOR='"+sector+"' AND NAME LIKE '"+emp_name+"%'");
            
            ArrayList<Employee> arl=new ArrayList<>();
            while(rs.next())
            {
                Employee emp=new Employee();
                
                emp.setId(rs.getLong("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setReceipt_no(rs.getLong("RECEIPT_NO"));
                emp.setEntry_date(rs.getDate("ENTRY_DATE"));
                emp.setSub_rate(rs.getInt("SUB_RATE"));
                emp.setJan(rs.getInt("JAN"));
                emp.setFeb(rs.getInt("FEB"));
                emp.setMar(rs.getInt("MAR"));
                emp.setApr(rs.getInt("APR"));
                emp.setMay(rs.getInt("MAY"));
                emp.setJun(rs.getInt("JUN"));
                emp.setJul(rs.getInt("JUL"));
                emp.setAug(rs.getInt("AUG"));
                emp.setSep(rs.getInt("SEP"));
                emp.setOct(rs.getInt("OCT"));
                emp.setNov(rs.getInt("NOV"));
                emp.setDecb(rs.getInt("DECB"));
                emp.setTotal(rs.getLong("TOTAL"));
                emp.setRemark(rs.getString("REMARK"));
                emp.setSector(rs.getString("SECTOR"));
                emp.setSub_from(rs.getString("SUB_FROM"));
                emp.setSub_to(rs.getString("SUB_TO"));
                emp.setPlace(rs.getString("PLACE"));
                
                arl.add(emp);
            }
            
            return arl;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean remove(long receipt_no,String sector)
    {
        try
        {
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            st.execute("DELETE FROM EMPLOYEE_INFO WHERE SECTOR='"+sector+"' AND RECEIPT_NO="+receipt_no);
            
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void showReceipt(String sector)
    {
        try{
            
            DB db=new DB();
            Connection c=db.getConnection();
            
            JasperReportBuilder jrb=DynamicReports.report();
            
            DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            DateFormat df2=new SimpleDateFormat("hh:mm:ss a");
            
            StyleBuilder rootStyle = stl.style().setPadding(2);
            StyleBuilder boldCenterStyle=stl.style().bold().setFontSize(8).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder dateStyle=stl.style().bold().setFontSize(6).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder headerStyle=stl.style().bold().setFontSize(12).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder smallHeaderStyle=stl.style(rootStyle).bold().setFontSize(8).setUnderline(Boolean.TRUE).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder columnStyle  = stl.style(rootStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5).setBorder(stl.penThin());
            StyleBuilder columnTitleStyle  = stl.style(columnStyle)
                    .setBorder(stl.pen1Point())
                    .setHorizontalAlignment(HorizontalAlignment.CENTER)
                    .setBackgroundColor(Color.LIGHT_GRAY).bold().setFontSize(6);

            
            jrb
            .setColumnTitleStyle(columnTitleStyle)
            .setColumnStyle(columnStyle)
            .title(cmp.horizontalList()
                    .add(cmp.text(sector).setStyle(headerStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setFixedHeight(20))
                    .newRow()
                    .add(cmp.text("EMPLOYEE LIST").setStyle(smallHeaderStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setFixedHeight(22))
                    .newRow()
                    .add(cmp.text("Date : "+df.format(new Date())).setStyle(dateStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).setFixedHeight(10))
                    .add(cmp.text("Time : "+df2.format(new Date())).setStyle(dateStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT).setFixedHeight(10))
                    .newRow()
                    .add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))                    
            .columns(
                    Columns.column("Rec No.","RECEIPT_NO",DataTypes.longType()),
                    Columns.column("Name","NAME",DataTypes.stringType()).setFixedWidth(120),
                    Columns.column("Date","ENTRY_DATE",DataTypes.dateType()).setFixedWidth(35),
                    Columns.column("Rate","SUB_RATE",DataTypes.integerType()),
                    Columns.column("Jan","JAN",DataTypes.integerType()),
                    Columns.column("Feb","FEB",DataTypes.integerType()),
                    Columns.column("Mar","MAR",DataTypes.integerType()),
                    Columns.column("Apr","APR",DataTypes.integerType()),
                    Columns.column("May","MAY",DataTypes.integerType()),
                    Columns.column("Jun","JUN",DataTypes.integerType()),
                    Columns.column("Jul","JUL",DataTypes.integerType()),
                    Columns.column("Aug","AUG",DataTypes.integerType()),
                    Columns.column("Sep","SEP",DataTypes.integerType()),
                    Columns.column("Oct","OCT",DataTypes.integerType()),
                    Columns.column("Nov","NOV",DataTypes.integerType()),
                    Columns.column("Dec","DECB",DataTypes.integerType()),
                    Columns.column("Total","TOTAL",DataTypes.longType()).setFixedWidth(40)
            )
            .pageFooter(cmp.horizontalList().add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))       
            .pageFooter(Components.pageXofY().setStyle(boldCenterStyle))
            .highlightDetailEvenRows()
            .setDataSource("SELECT * FROM EMPLOYEE_INFO WHERE SECTOR='"+sector+"'", c);
              
                String userprofile=System.getenv("USERPROFILE")+"/Desktop/BMS Pdf Files/BySector";
                File file=new File(userprofile);
                file.mkdirs();
                String pdf_file_path=file.getPath()+"/"+sector+".pdf";
                FileOutputStream fout=new FileOutputStream(pdf_file_path);
                jrb.toPdf(fout);
                fout.flush();
                fout.close();
                
                //jrb.show(false);
            JasperViewer jv=new JasperViewer(jrb.toJasperPrint(),false);
            jv.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            jv.setTitle(sector+" Report Details");
            jv.setLocation(0,0);
            jv.setVisible(true);
                //Desktop.getDesktop().open(new File(pdf_file_path));
            
        }        
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Report build failed..."+e.getMessage()+", try again...","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        catch(Error er)
        {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null,"Report build failed..."+er.getMessage()+", try again...","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void printReceiptRange(int from,int to,String sector)
    {
        try{
            
            DB db=new DB();
            Connection c=db.getConnection();
       
            JasperReportBuilder jrb=DynamicReports.report();
            
            DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            DateFormat df2=new SimpleDateFormat("hh:mm:ss a");
            
            StyleBuilder rootStyle = stl.style().setPadding(2);
            StyleBuilder boldCenterStyle=stl.style().bold().setFontSize(8).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder dateStyle=stl.style().bold().setFontSize(6).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder headerStyle=stl.style().bold().setFontSize(12).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder smallHeaderStyle=stl.style(rootStyle).bold().setFontSize(8).setUnderline(Boolean.TRUE).setHorizontalAlignment(HorizontalAlignment.CENTER);
            StyleBuilder columnStyle  = stl.style(rootStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(6).setBorder(stl.penThin());
            StyleBuilder columnTitleStyle  = stl.style(columnStyle)
                    .setBorder(stl.pen1Point())
                    .setHorizontalAlignment(HorizontalAlignment.CENTER)
                    .setBackgroundColor(Color.LIGHT_GRAY).bold().setFontSize(7);

            
            jrb
            .setColumnTitleStyle(columnTitleStyle)
            .setColumnStyle(columnStyle)
            .title(cmp.horizontalList()
                    .add(cmp.text(sector).setStyle(headerStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setFixedHeight(20))
                    .newRow()
                    .add(cmp.text("EMPLOYEE LIST").setStyle(smallHeaderStyle).setHorizontalAlignment(HorizontalAlignment.CENTER).setFixedHeight(22))
                    .newRow()
                    .add(cmp.text("Date : "+df.format(new Date())).setStyle(dateStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).setFixedHeight(10))
                    .add(cmp.text("Time : "+df2.format(new Date())).setStyle(dateStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT).setFixedHeight(10))
                    .newRow()
                    .add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))                    
            .columns(
                    Columns.column("Receipt No.","RECEIPT_NO",DataTypes.longType()).setFixedWidth(50),
                    Columns.column("Employee Name","NAME",DataTypes.stringType()),               
                    Columns.column("Sub. Rate","SUB_RATE",DataTypes.integerType()).setFixedWidth(40),
                    Columns.column("Entry Date","ENTRY_DATE",DataTypes.dateType()).setFixedWidth(50),
                    Columns.column("Sub. From","SUB_FROM",DataTypes.stringType()).setFixedWidth(50),
                    Columns.column("Sub. To","SUB_TO",DataTypes.stringType()).setFixedWidth(50),
                    Columns.column("Place","PLACE",DataTypes.stringType()).setFixedWidth(95),
                    Columns.column("Total","TOTAL",DataTypes.longType()).setFixedWidth(55)
            )
            .pageFooter(cmp.horizontalList().add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))       
            .pageFooter(Components.pageXofY().setStyle(boldCenterStyle))
            .highlightDetailEvenRows()
            .setDataSource("SELECT * FROM EMPLOYEE_INFO WHERE (RECEIPT_NO BETWEEN "+from+" AND "+to+") AND SECTOR='"+sector+"'", c);
              
            
                String userprofile=System.getenv("USERPROFILE")+"/Desktop/BMS Pdf Files/ByPrintReceiptNo";
                File file=new File(userprofile);
                file.mkdirs();
                String pdf_file_path=file.getPath()+"/"+sector+"_"+from+"_"+to+".pdf";
                FileOutputStream fout=new FileOutputStream(pdf_file_path);
                jrb.toPdf(fout);
                fout.flush();
                fout.close();
            
//                    Desktop.getDesktop().open(new File(pdf_file_path));
//
//                    Thread.sleep(600);
//                    Robot r=new Robot();
//                    r.keyPress(17);
//                    r.keyPress(80);
//
//                    r.keyRelease(17);
//                    r.keyRelease(80);
                    
                //jrb.show(false);
                JasperViewer jv=new JasperViewer(jrb.toJasperPrint(),false);
                jv.setLocation(0,0);
                jv.setTitle(sector+"_"+from+"_"+to+" Report Details");
                jv.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                jv.setVisible(true);
            
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Report build failed..."+e.getMessage()+", try again...","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        catch(Error er)
        {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null,"Report build failed..."+er.getMessage()+", try again...","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}
