/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanjay
 */
public class DB 
{
    Connection c;
    public DB()
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connection to Database failed due to driver not found...!!","Error Message",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public Connection getConnection()
    {
        try{
           c=DriverManager.getConnection("jdbc:derby://localhost:1527/bmsdb","root","root");
           return c;
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connection to Database failed...!!","Error Message",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
}
