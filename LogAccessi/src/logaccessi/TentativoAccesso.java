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
public class TentativoAccesso {
    private LocalDateTime timeStamp;
    private String username, ip;
    private boolean esito;
    
    public TentativoAccesso(LocalDateTime timeStamp, String user, String ip, boolean esito) {
        this.timeStamp = timeStamp;
        this.username = user;
        this.ip = ip;
        this.esito = esito;
    }
    
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getIp() {
        return ip;
    }
    
    public boolean getEsito() {
        return esito;
    }
    
    @Override
    public String toString() {
        return "TimeStamp: [" + timeStamp + "] Username: [" + username + "] IP: " + ip + "] Esito: [" + esito + "]\n";
    }
}
