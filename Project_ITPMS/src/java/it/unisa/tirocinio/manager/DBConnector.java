/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johneisenheim
 */
public class DBConnector {
    
    private static Connection aConnection = null;
    
    public static Connection getConnection(){
        InputStream cfg = null;
        try {
            String userPath = System.getProperty("user.home");
            String fileSeparator = System.getProperty("file.separator");
            cfg = new FileInputStream(userPath+fileSeparator+"TPConfig"+fileSeparator+"config.cfg");
            Properties configFile = new java.util.Properties();
            configFile.load(cfg);
            Class.forName("com.mysql.jdbc.Driver");
            aConnection = DriverManager.getConnection(configFile.getProperty("serverConn"), configFile.getProperty("userName"), configFile.getProperty("password"));
            return aConnection;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cfg.close();
            } catch (IOException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
