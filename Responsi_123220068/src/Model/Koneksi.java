/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
       
/**
 *
 * @author Lab Informatika
 */
public class Koneksi {
private static final String URL = "jbdc:mysql://localhost:3306/zoo";
private static final String USER = "root";
private static final String PASSWORD = "";
    
public static Connection getConnection() throws SQLException{
    return DriverManager.getConnection(URL,USER,PASSWORD);
}
}
