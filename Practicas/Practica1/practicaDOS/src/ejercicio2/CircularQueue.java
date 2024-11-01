/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import tp3.Queue;

/**
 *
 * @author USUARIO
 */
public class CircularQueue <T> extends Queue {
    
    public void shift(){
        T nume = (T)this.cola.get(0);
        this.cola.remove(0);
        this.cola.add(this.cola.size()+1,nume);
    }
}
