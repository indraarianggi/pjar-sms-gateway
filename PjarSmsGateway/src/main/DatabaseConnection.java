/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import main.SaveConfig;
import main.KeyConfiguration;

/**
 *
 * @author indraarianggi
 */
public class DatabaseConnection {
    private SaveConfig config = new SaveConfig();
    private KeyConfiguration key = new KeyConfiguration();
    private static Connection mysqlconnect;
    public Connection Connect() throws ClassNotFoundException, IOException{
        try {
            String url="jdbc:mysql://"+config.getConfig().get(key.host_database)+":"+config.getConfig().get(key.port_database)+"/db_pjar"; //url database
            String user="root"; //user database
            String pass=""; //password database
            Class.forName("com.mysql.jdbc.Driver");
            mysqlconnect = DriverManager.getConnection(url,user,pass);        
            return mysqlconnect;
        } catch (SQLException e) {
            System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error pada koneksi
        }
        return mysqlconnect;
    }
}
