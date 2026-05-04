package com.mycompany.smartwallet_silvia;

import javax.swing.JFrame;
import com.mycompany.smartwallet_silvia.dao.DatabaseInitializer;

public class SmartWallet_Silvia {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }
}
