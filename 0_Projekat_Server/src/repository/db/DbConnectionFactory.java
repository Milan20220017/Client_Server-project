                     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author s
 */
public class DbConnectionFactory {
 private static DbConnectionFactory instance;
    private Connection connection;
    private String url;
    private String user;
    private String password;
//
  public static DbConnectionFactory getInstance() {
      if (instance == null) {
           instance = new DbConnectionFactory();
      }
       return instance; }

    private DbConnectionFactory() {
        try {
            if (connection == null || connection.isClosed()) {
                url = configuration.Configuration.getInstance().getProperty("url");
                user = configuration.Configuration.getInstance().getProperty("username");
                password = configuration.Configuration.getInstance().getProperty("password");
                    connection = DriverManager.getConnection(url, user, password);
                    connection.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        }
        System.out.println("Connection is open");
    }

    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println("Connection is closed");
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
          if (connection != null && !connection.isClosed()) {
        connection.rollback();
        System.out.println("ROLLBACK → " + connection);
    } else {
        System.out.println("ROLLBACK skipped – connection already closed");
    }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    
}
