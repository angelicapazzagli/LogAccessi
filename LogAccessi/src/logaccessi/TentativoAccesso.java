/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

import java.time.LocalDateTime;

/**
 *
 * @author 39333
 */

/**
 * Questa classe rappresenta un tentativo di accesso, con timeStamp, username, ip ed esito.
 * @author pazzagli.angelica
 */
public class TentativoAccesso {
    
    /**
     * La data ed il tempo in cui è stato effettuato il tentativo d'accesso.
     */
    private LocalDateTime timeStamp;
    /**
     * L'username e l'indirizzo ip del tentativo d'accesso.
     */
    private String username, ip;
    /**
     * L'esito del tentativo d'accesso.
     */
    private boolean esito;
    
    /**
     * Costruisce un nuovo tentativo di accesso.
     * 
     * @param timeStamp la data in cui è stato effettuato il tentativo d'accesso
     * @param user l'username con cui è stato effettuato il tentativo d'accesso
     * @param ip l'indirizzo IP del tentativo d'accesso
     * @param esito l'esito del tentativo d'accesso
     */
    public TentativoAccesso(LocalDateTime timeStamp, String user, String ip, boolean esito) {
        this.timeStamp = timeStamp;
        this.username = user;
        this.ip = ip;
        this.esito = esito;
    }
    
    /**
     * Restituisce la data del tentativo d'accesso.
     * 
     * @return la data del tentativo d'accesso
     */
    
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    
    /**
     * Restituisce l'username del tentativo d'accesso.
     * 
     * @return l'username del tentativo d'accesso
     */
    
    public String getUsername() {
        return username;
    }
    
    /**
     * Restituisce l'IP del tentativo d'accesso.
     * 
     * @return l'IP del tentativo d'accesso
     */
    
    public String getIp() {
        return ip;
    }
    
    /**
     * Restituisce l'esisto del tentativo d'accesso.
     * 
     * @return l'esito del tentativo d'accesso
     */
    
    public boolean getEsito() {
        return esito;
    }
    
    @Override
    public String toString() {
        return "TimeStamp: [" + timeStamp + "] Username: [" + username + "] IP: " + ip + "] Esito: [" + esito + "]\n";
    }
}
