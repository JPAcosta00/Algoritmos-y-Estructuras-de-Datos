/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class prRecursividad {
    
    public static void imprimeAlReves(List<Integer> lista){
        if(!lista.isEmpty()){
            Integer dato = lista.get(0);
            lista.remove(0);
            imprimeAlReves(lista);
            System.out.println("Numero => " + dato);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> listado = new LinkedList<Integer>();
        
        listado.add(1);
        listado.add(4);
        listado.add(8);
        listado.add(13);
        listado.add(22);
        imprimeAlReves(listado);
    }
    
}

//imprimir una lista al reves usando un modulo recursivo
