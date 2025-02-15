package com.example.oopproject;

import java.io.*;

public class SaveDataToFile {

    public static void writeDataToFile(String name,String email,String contact ,String password) {
        File file=new File("Customer.txt");
        FileWriter fw;

        {
            try {
                fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(name+","+email+","+contact+","+password);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
