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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lab Informatika
 */
public class ModelHewan {

    
public List<Animal> getAllAnimals() {
    List<Animal> animals = new ArrayList<>();
    String query = "SELECT * FROM zoo_hewan";
    
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Animal animal = new Animal(rs.getInt("id"),
                                       rs.getString("nama"),
                                       rs.getString("kelas"),
                                       rs.getString("jenis_makanan"));
            animals.add(iaAnimal);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return animals;
}


public void addAnimal(Animal animal) {
    String query = "INSERT INTO zoo_hewan (nama, kelas, jenis_makanan) VALUES (?,, ?)";
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, animal.getNama());
        stmt.setString(2, animal.getKelas());
        stmt.setString(3, animal.getJenisMakanan());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void updateAnimal(Animal animal) {
    String query = "UPDATE zoo_hewan SET nama = ?, kelas =, jenis_makanan =? WHERE id = ?";
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, animal.getNama());
        stmt.setString(2, animal.getKelas());
        stmt.setString(3, animal.getJenisMakanan());
        stmt.setInt(4, animal.getId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Delete an animal from the database
public void deleteAnimal(int id) {
    String query = "DELETE FROM zoo_hewan WHERE id = ?";
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Search for animals by name
public List<Animal> searchAnimals(String keyword) {
    List<Animal> animals = new ArrayList<>();
    String query = "SELECT * FROM zoo_hewan WHERE nama LIKE ?";
    
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, "%" + keyword + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Animal animal = new Animal(rs.getInt("id"),
                                       rs.getString("nama"),
                                       rs.getString("kelas"),
                                       rs.getString("jenis_makanan"));
            animals.add(animal);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return animals;
}
}
