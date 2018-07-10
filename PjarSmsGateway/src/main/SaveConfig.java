/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Properties;

/**
 *
 * @author indraarianggi
 */
public class SaveConfig {
    public Hashtable<String, String> getConfig() throws FileNotFoundException, IOException {
        Hashtable<String, String> dataKonfigurasi = new Hashtable<String, String>();
        File configFile = new File("config.properties");
        FileReader reader = new FileReader(configFile);
        Properties props = new Properties();
        props.load(reader);
        
        String host_database = props.getProperty("host_database");
        String port_database = props.getProperty("port_database");
        String port_modem = props.getProperty("port_modem");
        String no_tlp_modem = props.getProperty("no_tlp_modem");
        String header = props.getProperty("header");
        
        dataKonfigurasi.put("host_database", host_database);
        dataKonfigurasi.put("port_database", port_database);
        dataKonfigurasi.put("port_modem", port_modem);
        dataKonfigurasi.put("no_tlp_modem", no_tlp_modem);
        dataKonfigurasi.put("header", header);
        
        System.out.println("Host name is: " + host_database);
        System.out.println("Port database is: " + port_database);
        System.out.println("Port modem is: " + port_modem);
        System.out.println("NO HP modem is: " + no_tlp_modem);
        System.out.println(header);
        
        reader.close();
        
        return dataKonfigurasi;
    }
    
    public void setConfig(String host_database, String port_database, String port_modem, String no_tlp_modem, String header) throws FileNotFoundException, IOException{
        File configFile = new File("config.properties");
        try {
            Properties props = new Properties();
            
            props.setProperty("host_database", host_database);
            props.setProperty("port_database", port_database);
            props.setProperty("port_modem", port_modem);
            props.setProperty("no_tlp_modem", no_tlp_modem);
            props.setProperty("header", header);
            
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "host settings");
            
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }
    }
}
