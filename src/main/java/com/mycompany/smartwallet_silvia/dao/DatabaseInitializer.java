/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartwallet_silvia.dao;

/**
 *
 * @author Silvi
 */
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        String sql = """
    CREATE TABLE IF NOT EXISTS transactions (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id INTEGER,
        type TEXT,
        amount REAL,
        description TEXT,
        date TEXT
    );
""";
        
        try (Connection conn = DBConnection.connect();
     Statement stmt = conn.createStatement()) {

    String sqlUsers =
        "CREATE TABLE IF NOT EXISTS users (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "username TEXT UNIQUE, " +
        "password TEXT" +
        ");";

    stmt.execute(sqlUsers);

} catch (Exception e) {
    e.printStackTrace();
}
        
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}