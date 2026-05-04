/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartwallet_silvia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Silvi
 */
public class UserDAO {
    public static int register(String username, String password) {

    String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

    try (Connection conn = DBConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, username.trim());
        ps.setString(2, password.trim());

        ps.executeUpdate();

        java.sql.ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1); 
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1; 
}

   public static int login(String username, String password) {

    String sql = "SELECT id FROM users WHERE username=? AND password=?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id"); // 👈 user id
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1;
}
    
    
}


