/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author 39333
 */
public class FileManager {
    public static ArrayList<TentativoAccesso> readFile(String file) throws FileNotFoundException, IOException {
        ArrayList<TentativoAccesso> elencoAccessi = new ArrayList();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                if(i != 0) {
                    String[] colonne = line.split(",");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");
                    LocalDateTime timeStamp = LocalDateTime.parse(colonne[0], formatter);
                    boolean esito;
                    if("OK".equals(colonne[3])) {
                        esito = true;
                    }
                    else {
                        esito = false;
                    }
                    TentativoAccesso s = new TentativoAccesso(timeStamp, colonne[1], colonne[2], esito);
                    elencoAccessi.add(s);
                }
                i++;
            }
        }
        return elencoAccessi;
    }
}
