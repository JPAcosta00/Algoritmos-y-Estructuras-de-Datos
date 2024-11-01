/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author USUARIO
 */
public class ParcialArboles {
    
    private static void caminoFiltrado(GeneralTree<Integer> ar, List<Integer> lisAct, List<Integer>lisMax, int max, int valorTotal, int nivel){
        int datoActual = ar.getData();                                                 //obtiene el dato 
        if(datoActual == 1){                                                           //si es true guarda en la lista el 1 y suma el valorTotal del camino 
            valorTotal += datoActual * nivel;                                          //se hace adentro del if sabiendo que es un UNO para no sumar innecesariamente un CERO.(ya que cero * nivel = cero)
            lisAct.add(datoActual);                                                    //el valor actual puede sumar directamente el nivel ya que el datoActual siempre va a ser 1 ya que es el unico dato que se va a guardar en la lista.
        }
        if(!ar.isLeaf()){                                                              //recorre el arbol
            for(GeneralTree<Integer> child : ar.getChildren()){
                caminoFiltrado(child,lisAct,lisMax,max,valorTotal,nivel+1);
            }
        }else{                                                                          //cuando termino de recorrer el primer camino hacia una hoja, compara los maximos
           if(valorTotal > max){                                                        //si el valor total es mayor a max
               max = valorTotal;                                                        //actualiza el maximo
               valorTotal = 0;                                                          //resetea el valor total 
               lisMax.removeAll(lisMax);                                                //vacia la lista maxima
               lisMax.addAll(lisAct);                                                   //actualiza la lista maxima 
               lisAct.removeAll(lisAct);                                                //vacia la lista que que se compara con el maximo
           }
        }
    }
    
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return null;
        }else{
            List<Integer> lAux = new LinkedList<Integer>();                          //lista de unos para comparar con lMaxima
            List<Integer> lMaxima = new LinkedList<Integer>();                       //lista de unos que va a retorna con el camino maximo por la suma de los valores multiplicado por su nivel
            caminoFiltrado(arbol,lAux,lMaxima,-1,0,0);
            return lMaxima;
        }      
    }
}
