/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.bean.Employee;
import com.dbconnection.DB;
import com.main.MainForm;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Sanjay
 */
public class DatabaseDao {
    public static void exportDB(String destpath)
    {
        try{
            
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE_INFO");
            
            XSSFWorkbook wb=new XSSFWorkbook();
            XSSFSheet sheet=wb.createSheet("EmployeeInfo");
            XSSFRow row=sheet.createRow(0);
                
            row.createCell(0, CellType.STRING).setCellValue("ID");
            row.createCell(1, CellType.STRING).setCellValue("NAME");
            row.createCell(2, CellType.STRING).setCellValue("RECEIPT_NO");
            row.createCell(3, CellType.STRING).setCellValue("ENTRY_DATE");
            row.createCell(4, CellType.STRING).setCellValue("SUB_RATE");
            row.createCell(5, CellType.STRING).setCellValue("JAN");
            row.createCell(6, CellType.STRING).setCellValue("FEB");
            row.createCell(7, CellType.STRING).setCellValue("MAR");
            row.createCell(8, CellType.STRING).setCellValue("APR");
            row.createCell(9, CellType.STRING).setCellValue("MAY");
            row.createCell(10, CellType.STRING).setCellValue("JUN");
            row.createCell(11, CellType.STRING).setCellValue("JUL");
            row.createCell(12, CellType.STRING).setCellValue("AUG");
            row.createCell(13, CellType.STRING).setCellValue("SEP");
            row.createCell(14, CellType.STRING).setCellValue("OCT");
            row.createCell(15, CellType.STRING).setCellValue("NOV");
            row.createCell(16, CellType.STRING).setCellValue("DECB");
            row.createCell(17, CellType.STRING).setCellValue("TOTAL");
            row.createCell(18, CellType.STRING).setCellValue("REMARK");
            row.createCell(19, CellType.STRING).setCellValue("SECTOR");
            row.createCell(20, CellType.STRING).setCellValue("SUB_FROM");
            row.createCell(21, CellType.STRING).setCellValue("SUB_TO");
            row.createCell(22, CellType.STRING).setCellValue("PLACE");
            
            int i=1;
            while(rs.next())
            {
                row=sheet.createRow(i);

                row.createCell(0, CellType.STRING).setCellValue(rs.getLong("ID"));
                row.createCell(1, CellType.STRING).setCellValue(rs.getString("NAME"));
                row.createCell(2, CellType.STRING).setCellValue(rs.getLong("RECEIPT_NO"));
                row.createCell(3,CellType.STRING).setCellValue(rs.getDate("ENTRY_DATE"));
                row.createCell(4, CellType.STRING).setCellValue(rs.getInt("SUB_RATE"));
                row.createCell(5, CellType.STRING).setCellValue(rs.getInt("JAN"));
                row.createCell(6, CellType.STRING).setCellValue(rs.getInt("FEB"));
                row.createCell(7, CellType.STRING).setCellValue(rs.getInt("MAR"));
                row.createCell(8, CellType.STRING).setCellValue(rs.getInt("APR"));
                row.createCell(9, CellType.STRING).setCellValue(rs.getInt("MAY"));
                row.createCell(10, CellType.STRING).setCellValue(rs.getInt("JUN"));
                row.createCell(11, CellType.STRING).setCellValue(rs.getInt("JUL"));
                row.createCell(12, CellType.STRING).setCellValue(rs.getInt("AUG"));
                row.createCell(13, CellType.STRING).setCellValue(rs.getInt("SEP"));
                row.createCell(14, CellType.STRING).setCellValue(rs.getInt("OCT"));
                row.createCell(15, CellType.STRING).setCellValue(rs.getInt("NOV"));
                row.createCell(16, CellType.STRING).setCellValue(rs.getInt("DECB"));
                row.createCell(17, CellType.STRING).setCellValue(rs.getLong("TOTAL"));
                row.createCell(18, CellType.STRING).setCellValue(rs.getString("REMARK"));
                row.createCell(19, CellType.STRING).setCellValue(rs.getString("SECTOR"));
                row.createCell(20, CellType.STRING).setCellValue(rs.getString("SUB_FROM"));
                row.createCell(21, CellType.STRING).setCellValue(rs.getString("SUB_TO"));
                row.createCell(22, CellType.STRING).setCellValue(rs.getString("PLACE"));

                i++;
            }
            
            Calendar cal=Calendar.getInstance();
            String filename="BMSBackup_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.YEAR)+".xlsx";
            FileOutputStream fout=new FileOutputStream(destpath+"\\"+filename);
            wb.write(fout);
            fout.flush();
            fout.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Database Exporting Error..."+e.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void importDB(MainForm mf,String sector,String destpath,String fname)
    {
        try{
            DB db=new DB();
            Connection c=db.getConnection();                        
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT RECEIPT_NO FROM EMPLOYEE_INFO");
            ArrayList<Long> arl=new ArrayList<>();
            while(rs.next())
            {
                arl.add(rs.getLong("RECEIPT_NO"));
            }
       
            st=c.createStatement();
            rs=st.executeQuery("SELECT MAX(RECEIPT_NO) FROM EMPLOYEE_INFO");
            
            long maxRecID=1;
            if(rs.next())
            {
                maxRecID=rs.getLong(1)+1;
            }
            
            st=c.createStatement();
            rs=st.executeQuery("SELECT NAME FROM IMPORTFILE_INFO");
            ArrayList<String> file_arl=new ArrayList<>();
            while(rs.next())
            {
                file_arl.add(rs.getString("NAME"));
            }
                        
            if(file_arl.contains(fname))
            {
                int val=JOptionPane.showConfirmDialog(null,fname+" file already imported, Importing again database may contains duplicate entries. Are you sure to IMPORT this file?","Confirmation Message", JOptionPane.YES_NO_OPTION);
                if(val==0)
                {
                    insertFromFile(mf,sector,destpath,fname,st,c,maxRecID,arl); 
                }
            }
            else
            {
                insertFromFile(mf,sector,destpath,fname,st,c,maxRecID,arl); 
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Database Importing Error..."+e.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void insertFromFile(MainForm mf,String sect,String destpath,String fname,Statement st,Connection c,long maxRecID,ArrayList<Long> arl) throws Exception
    {
        
            FileInputStream fin=new FileInputStream(destpath);
            XSSFWorkbook wb=new XSSFWorkbook(fin);
            XSSFSheet sheet=wb.getSheet("EmployeeInfo");
            long lastrowno=sheet.getLastRowNum();
            XSSFRow row;    

            long i=1;
            while(i<=lastrowno)
            {
                row=sheet.getRow((int)i);

                long id=(long)row.getCell(0).getNumericCellValue();//ID
                String name=row.getCell(1).getStringCellValue();//NAME
                long recp_no=(long)row.getCell(2).getNumericCellValue();//RECEIPT_NO
                Date edate=(Date)row.getCell(3).getDateCellValue();//ENTRY_DATE
                int subrate=(int)row.getCell(4).getNumericCellValue();//SUB_RATE
                int jan=(int)row.getCell(5).getNumericCellValue();//JAN
                int feb=(int)row.getCell(6).getNumericCellValue();//FEB
                int mar=(int)row.getCell(7).getNumericCellValue();//MAR
                int apr=(int)row.getCell(8).getNumericCellValue();//APR
                int may=(int)row.getCell(9).getNumericCellValue();//MAY
                int jun=(int)row.getCell(10).getNumericCellValue();//JUN
                int jul=(int)row.getCell(11).getNumericCellValue();//JUL
                int aug=(int)row.getCell(12).getNumericCellValue();//AUG
                int sep=(int)row.getCell(13).getNumericCellValue();//SEP
                int oct=(int)row.getCell(14).getNumericCellValue();//OCT
                int nov=(int)row.getCell(15).getNumericCellValue();//NOV
                int dec=(int)row.getCell(16).getNumericCellValue();//DECB
                long tot=(long)row.getCell(17).getNumericCellValue();//TOTAL
                String remark=row.getCell(18).getStringCellValue();//REMARK
                String sector=row.getCell(19).getStringCellValue();//SECTOR
                String sub_frm=row.getCell(20).getStringCellValue();//SUB_FROM
                String sub_to=row.getCell(21).getStringCellValue();//SUB_TO
                String place=row.getCell(22).getStringCellValue();//PLACE
                boolean isAlready=arl.contains(recp_no);

                Employee emp=new Employee();
                emp.setName(name);
                emp.setEntry_date(edate);
                emp.setSub_rate(subrate);
                emp.setJan(jan);
                emp.setFeb(feb);
                emp.setMar(mar);
                emp.setApr(apr);
                emp.setMay(may);
                emp.setJun(jun);
                emp.setJul(jul);
                emp.setAug(aug);
                emp.setSep(sep);
                emp.setOct(oct);
                emp.setNov(nov);
                emp.setDecb(dec);
                emp.setTotal(tot);
                emp.setRemark(remark);
                emp.setSector(sector);
                emp.setSub_from(sub_frm);
                emp.setSub_to(sub_to);
                emp.setPlace(place);
                if(isAlready)
                {
                    emp.setReceipt_no(maxRecID);
                    maxRecID++;
                }
                else
                {
                    emp.setReceipt_no(recp_no);
                }
                EmployeeDao.save(emp);

                i++;                
            }

            st=c.createStatement();
            st.execute("INSERT INTO IMPORTFILE_INFO(NAME) VALUES('"+fname+"')");

            mf.initData(sect);
            JOptionPane.showMessageDialog(null,"Database Import Successfully...!!");
    }
    
}
