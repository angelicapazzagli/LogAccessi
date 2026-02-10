/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author 39333
 */
/**
 * Questa classe rapresenta un gestore di tutti i dati che contiene un file una volta trasferiti in una struttura dati.
 * @author pazzagli.angelica
 */
public class Gestore {
    private String file;
    protected ArrayList<TentativoAccesso> elencoAccessi;
    
    /**
     * Costruisce un nuovo gestore.
     * 
     * @param csv file csv da gestire
     * @throws IOException se si verifica un errore nella lettura
     */
    public Gestore(String csv) throws IOException {
        this.file = csv;
        elencoAccessi = new ArrayList();
    }
    
    /**
     * Legge il file.
     * 
     * @throws IOException se si verifica un errore nella lettura
     * @see FileManager
     */
    
    public void readFile() throws IOException {
        this.elencoAccessi = FileManager.readFile(file);
    }
    
    /**
     * Stampa l'elenco dei dati a disposizione.
     * 
     * @param elenco l'elenco da stampare
     */
    
    public void stampaElenco(ArrayList<TentativoAccesso> elenco) {
        for(TentativoAccesso t : elenco) {
            System.out.println("[" + t.getTimeStamp() + "] [" + t.getUsername() + "] [" + t.getIp() + "] [" + t.getEsito() + "]");
        }
    }
    
    /**
     * Conta il numero di fail di ogni tentativo d'accesso con un username.
     * 
     * @see Counter
     */
    
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
    
    /**
     * Controlla gli indirizzi IP sospetti.
     * 
     * @return una lista di stringhe con gli IP sospetti
     */
    
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
    
    /**
     * Controlla gli accessi effettuati in un intervallo di tempo.
     * 
     * @param inizio l'inizio dell'intervallo di tempo
     * @param fine la fine dell'intervallo di tempo
     * @return una lista di stringhe con gli accessi che rientrano nell'intervallo
     */
    
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
    
    /**
     * Mette in ordine temporale i tentativi d'accesso.
     */
    
    public void ordinamentoAccessi() {
        ArrayList<TentativoAccesso> ordinamento = elencoAccessi;
        ordinamento.sort(Comparator.comparing(TentativoAccesso::getTimeStamp));
        this.stampaElenco(ordinamento);
    }
}
