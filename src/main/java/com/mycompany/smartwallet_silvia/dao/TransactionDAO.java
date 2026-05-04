/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartwallet_silvia.dao;

/**
 *
 * @author Silvi
 */
import com.mycompany.smartwallet_silvia.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

   public static void add(Transaction t, int userId) {

    String sql = "INSERT INTO transactions(user_id, type, amount, description, date) VALUES(?,?,?,?,?)";

    System.out.println("INSERT START");
    System.out.println("userId = " + userId);
    System.out.println("type = " + t.getType());
    System.out.println("amount = " + t.getAmount());

    try (Connection conn = DBConnection.connect();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, userId);
        ps.setString(2, t.getType());
        ps.setDouble(3, t.getAmount());
        ps.setString(4, t.getDescription());
        ps.setString(5, t.getDate());

        int rows = ps.executeUpdate();

        System.out.println("ROWS INSERTED = " + rows);

    } catch (Exception e) {
        System.out.println("SQL ERROR:");
        e.printStackTrace();
    }
}

    public static List<Transaction> getAll(int userId) {

        List<Transaction> list = new ArrayList<>();

        String sql = "SELECT * FROM transactions WHERE user_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Transaction(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getString("date")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void delete(int id) {

        String sql = "DELETE FROM transactions WHERE id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}