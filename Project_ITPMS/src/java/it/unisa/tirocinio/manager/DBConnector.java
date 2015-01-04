package it.unisa.tirocinio.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream stream = null;
        try {
            Properties prop = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();  
            stream = loader.getResourceAsStream("properties/dbconfiguration.properties");
            prop.load(stream);
            Class.forName("com.mysql.jdbc.Driver");
            aConnection = DriverManager.getConnection(prop.getProperty("serverConn"), prop.getProperty("username"), prop.getProperty("password"));
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
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
