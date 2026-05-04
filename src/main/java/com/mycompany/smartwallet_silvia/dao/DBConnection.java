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
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:sqlite:C:/Users/Silvi/OneDrive/Documents/NetBeansProjects/SmartWallet_Silvia/smartwallet.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
