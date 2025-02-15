package com.example.oopproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Authentication {
    public boolean login(String username, String password) {
        try (BufferedReader bw = new BufferedReader(new FileReader("Customer.txt"))) {
            String line="";
            while ((line = bw.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(username) && parts[3].equals(password)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}