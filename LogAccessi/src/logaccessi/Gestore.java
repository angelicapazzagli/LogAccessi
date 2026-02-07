/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author 39333
 */
public class Gestore {
    private String file;
    private ArrayList<TentativoAccesso> elencoAccessi;
    
    public Gestore(String csv) throws IOException {
        this.file = csv;
        elencoAccessi = new ArrayList();
    }
    
    public void readFile() throws IOException {
        this.elencoAccessi = FileManager.readFile(file);
    }
    
    public void stampaElenco() {
        for(int i = 0; i < elencoAccessi.size(); i++) {
            TentativoAccesso t = elencoAccessi.get(i);
            System.out.println("[" + t.getTimeStamp() + "] [" + t.getUsername() + "] [" + t.getIp() + "] [" + t.getEsito() + "]");
        }
    }
    
    public void checkFail() {
        ArrayList<Counter> fail = new ArrayList();
        for(TentativoAccesso t : elencoAccessi) {
            Counter c = new Counter(t.getUsername());
            boolean check = false;
            for(Counter counter : fail) {
                if(counter.getUsername().equals(c.getUsername())) {
                    if(!t.getEsito()) {
                        counter.aggiungiFail();
                    }                   
                    check = true;
                }
            }           
            if(!check) {
                fail.add(c);
                if(!t.getEsito()) {
                    c.aggiungiFail();
                }
            }           
        }
        for(Counter c : fail) {
            System.out.println("Username: " + c.getUsername() + " Fail: " + c.getFail());
        }
    }
    
    public ArrayList<String> segnalazioneIP() {
        ArrayList<String> IPsegnalati = new ArrayList();
        String ultimoIP = null;
        int nFail = 0;
        for(TentativoAccesso t : elencoAccessi) {
            String ip = t.getIp();
            if(!ip.equals(ultimoIP)) {
                nFail = 0;
                ultimoIP = ip;
            }
            if(!t.getEsito()) {
                nFail++;
            } 
            else {
                nFail = 0;
            }
            if(nFail > 2 && !IPsegnalati.contains(ip)) {
                IPsegnalati.add(ip);
            }
        }
        return IPsegnalati;
    }
    
    public ArrayList<String> controlloAccessi(LocalDateTime inizio, LocalDateTime fine) {
        ArrayList<String> accessiIP = new ArrayList();
        for(TentativoAccesso t : elencoAccessi) {
            if(!t.getTimeStamp().isBefore(inizio) && !t.getTimeStamp().isAfter(fine)) {
                if(t.getEsito() && !accessiIP.contains(t.getIp())) {
                    accessiIP.add(t.getIp());
                }
            }
        }
        return accessiIP;
    }
    
    public ArrayList<TentativoAccesso> ordinamentoAccessi() {
        ArrayList<TentativoAccesso> ordinamento = new ArrayList();
        TentativoAccesso ultimo = null;
        return ordinamento;
    }
}
