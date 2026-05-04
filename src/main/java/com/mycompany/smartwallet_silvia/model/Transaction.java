/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartwallet_silvia.model;

/**
 *
 * @author Silvi
 */
public class Transaction {

    private int id;
    private String type;
    private double amount;
    private String description;
    private String date;

    public Transaction(
            int id,
            String type,
            double amount,
            String description,
            String date
    ) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Transaction(
            String type,
            double amount,
            String description,
            String date
    ) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}