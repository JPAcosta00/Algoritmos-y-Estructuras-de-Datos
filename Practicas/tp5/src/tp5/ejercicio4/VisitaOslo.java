/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author USUARIO
 */
public class VisitaOslo {
    
    
   public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
       List<String> listaRetorno = new LinkedList<String>();
       boolean[] marcas = new boolean[lugares.getSize()]; 
       Vertex<String> inicio= lugares.search("Ayuntamiento");                                      //busco el lugar "Ayuntamiento en el grafo"
       marcaLugaresRestringidos(marcas,lugares,lugaresRestringidos);                               //marco los lugares por donde no debe pasar
       if(dfsEnBici(inicio,lugares, destino, maxTiempo,marcas,listaRetorno)){               //si llego a destino y le alcanzo el tiempo
           return listaRetorno;                                                                   //retorna la lista con los lugares por donde paso
       }else{                               
           return listaRetorno = null;                                                                         //retorna la lista que estara vacia.
       }
    }
   private void marcaLugaresRestringidos(boolean[] marcador,Graph<String> grafo ,List<String> lista){
       for(String nombre : lista){
           Vertex<String> vertice = grafo.search(nombre);
           if(vertice != null){
               marcador[vertice.getPosition()] = true;
           }
       }
   }
   private boolean dfsEnBici(Vertex<String> origen,Graph<String> grafo, String destino, int tiempo, boolean [] visitados, List<String> lista){
       int pos = origen.getPosition();
       boolean encontre = false;                                    //me va a retornar si llegue a destino o no
       visitados[pos] = true;                                       //marca como visitado
       lista.add(origen.getData());                                 //agrega por donde paso a la lista del camino
       if(origen.getData().equals(destino)){
           return true;                                                        //si legue al destino retorna true
       }else{
            for(Edge<String> ady : grafo.getEdges(origen)){                       //por cada adyacencia la recorre
                if((!visitados[pos])&&(tiempo - ady.getWeight() >= 0)){             //si no visito el lugar todavia y le alcanza el tiempo
                    encontre = dfsEnBici(ady.getTarget(),grafo,destino,tiempo - ady.getWeight(),visitados,lista);       
                }
            }                                                            
       }
       if(!encontre){                                                      //Si no encontre el destino en ese camino
           lista.remove(lista.size()-1);                                  //borro de la lista el camino que hice dejando solo el lugar de inicio
           visitados[pos] = false;
       }                                                                         
       return encontre;
   }
}
