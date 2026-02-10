/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

/**
 *
 * @author 39333
 */
/**
 * Questa classe rappresenta un counter per tenere il conto del numero di fail effettuati con un username.
 * @author pazzagli.angelica
 */
public class Counter {
    /**
     * L'username del quale vengono contati il numero di fail.
     */
    private String username;
    
    /**
     * Il numero di fail effettuati con un username.
     */
    private int nFail;
    
    /**
     * Costruisce un nuovo counter.
     * 
     * @param user l'username del tentativo d'accesso
     */
    public Counter(String user) {
        this.username = user;
        nFail = 0;
    }
    
    /**
     * Metodo per incrementare il numero di fail.
     */
    public void aggiungiFail() {
        nFail++;
    }
    
    /**
     * Restituisce il numero di fail fatti con un username.
     * 
     * @return il numero di fail fatti con un username
     */
    public int getFail() {
        return nFail;
    }
    
    /**
     * Restituisce l'username che ha fatto tot fail.
     * 
     * @return l'username che ha fatto tot fail
     */
    public String getUsername() {
        return username;
    }
}
