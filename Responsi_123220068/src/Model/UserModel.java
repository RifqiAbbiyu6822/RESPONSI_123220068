/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class UserModel {
 
    public boolean login(String username, String password) {
       String query = "SELECT * FROM zoo_pegawai WHERE nama = ? AND password = ?";
       try (Connection conn = Koneksi.getConnection();
               PreparedStatement stmt = conn.prepareStatement(query)) {
           stmt.setString(1, username);
           stmt.setString(2, password);
           ResultSet rs = stmt.executeQuery();
           return rs.next();
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
    }
    
}
