/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logaccessi;

/**
 *
 * @author 39333
 */
public class Counter {
    private String username;
    private int nFail;
    
    public Counter(String user) {
        this.username = user;
        nFail = 0;
    }
    
    public void aggiungiFail() {
        nFail++;
    }
    
    public int getFail() {
        return nFail;
    }
    
    public String getUsername() {
        return username;
    }
}
