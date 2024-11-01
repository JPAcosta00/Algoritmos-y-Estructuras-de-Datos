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
public class DobleEndedQueue<T> extends Queue{
    
    public void EnqueueFirst(T unNumero){
        this.cola.add(0,unNumero);
    }
    
}
