/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logaccessi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author 39333
 */
public class LogAccessi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Gestore g = new Gestore("LogAccessi.csv");
        g.readFile();
        
        g.stampaElenco(g.elencoAccessi);
        
        g.checkFail();
        
        System.out.println(g.segnalazioneIP());
        
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Inserisci l'inizio del periodo (yyyy-MM-dd HH:mm)");
        String inizio = scanner.nextLine();
        LocalDateTime inizioP = LocalDateTime.parse(inizio, formatter);
        System.out.println("Inserisci la fine del periodo (yyyy-MM-dd HH:mm)");
        String fine = scanner.nextLine();
        LocalDateTime fineP = LocalDateTime.parse(fine, formatter);
        scanner.close();
        System.out.println(g.controlloAccessi(inizioP, fineP));
        
        g.ordinamentoAccessi();
    }
    
}
