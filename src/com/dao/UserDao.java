/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.bean.User;
import com.dbconnection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sanjay
 */
public class UserDao {
    
    public static boolean checkUserName(String user)
    {
        try{
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM REGISTER_INFO WHERE USERNAME='"+user+"'");
            
            return rs.next();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean save(User u)
    {
        try{
            DB db=new DB();
            Connection c=db.getConnection();
            
            PreparedStatement ps=c.prepareStatement("INSERT INTO REGISTER_INFO(NAME,USERNAME,PASSWORD,PHONE,USER_TYPE)VALUES(?,?,?,?,?)");
            ps.setString(1,u.getName());
            ps.setString(2,u.getUsername());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getPhone());
            ps.setInt(5,u.getUsertype());
            
            ps.execute();
            
            return true;
            
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public static int isValidUser(String user,String pass)
    {
        try{
            DB db=new DB();
            Connection c=db.getConnection();
            
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM REGISTER_INFO WHERE USERNAME='"+user+"' AND PASSWORD ='"+pass+"'");
            int us_type=0;
            if(rs.next())
            {
                us_type=rs.getInt("USER_TYPE");
            }
            return us_type;
                        
        }catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
