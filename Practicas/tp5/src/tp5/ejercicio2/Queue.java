/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio2;

import java.util.*;

/**
 *
 * @author USUARIO
 */
public class Queue <T>{
    public List<T> cola = new LinkedList<T>();
    
    public Queue (){
    
    }

    public List<T> getCola() {
        return cola;
    }
   
    
    public void enqueue(T valor){
        this.cola.add(this.cola.size(),valor);               //Agrega en el ultimo 
    }
    
    public T dequeue(){
        if(this.cola.isEmpty()){
            System.out.println("La cola esta vacia");
        }else{
            T num =(T)this.cola.get(0);
            this.cola.remove(0);
            return num;
        }
        return null;                                          //retorna -1 en modo de error.
    }
    
    public T head (){
        if(this.cola.isEmpty()){
            System.out.println("La cola esta vacia");
        }else{
            return ((T)this.cola.get(0));
        }
        return null;
    }
    
    public boolean isEmpty(){
        if(this.cola.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    
    public int size(){
        return this.cola.size();
    }
    
    public String toString(){
        int index = 0;
        String cadena = " ";
        while(index < this.cola.size()){
            T numero =(T) this.cola.get(index);
            cadena = cadena + numero + " - ";
            index++;
        }
        return cadena;
    }
}
