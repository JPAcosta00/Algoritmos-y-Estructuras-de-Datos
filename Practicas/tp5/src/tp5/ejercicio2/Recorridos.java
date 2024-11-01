/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author USUARIO
 */
public class Recorridos<T> {
    
    public List<T> dfs(Graph<T> grafo){
        List<T> lista = new LinkedList<T>();                                     //lista a retornar.
        boolean[] marca = new boolean[grafo.getSize()];                          //crea un vector del tamaño del grafo para marcar los nodos visitados.
        for(int i=0; i<grafo.getSize();i++){ 
            if(!marca[i]){                                                        //Si el punto de partida no tiene marca, entonces lo agrega y recorre el grafo
                lista.add(grafo.getVertex(i).getData());                          //Agrega el punto de partida a la lista a retornar
                this.dfs(i,grafo,marca,lista);                                         //recorre
            }
        }
        return lista;
    }
    
    private void dfs(int i,Graph<T> gra, boolean[] marcador,List<T> lis){        //i es la posicion de partida del recorrido, luego va tomando el valor de j que hace referencia a las adyacencias del vertice.
       marcador[i] = true;                                                       //marca que se visito el vertice
       Vertex<T> v = gra.getVertex(i);                                           //obtiene el vertices
       lis.add(v.getData());                                                     //agrega el dato del nodo(vertice) en la lista a retornar
       List<Edge<T>> adyacentes = gra.getEdges(v);                               //obtiene las adyacencias para recorrerlas
       for(Edge<T> e : adyacentes){                                              //por cada adyacencia obtiene la posicion 
           int j = e.getTarget().getPosition();
           if(!marcador[i]){                                                     //si en el marcador dice que no se visito
               dfs(j,gra,marcador,lis);                                          //recurrencia: recorre ese vertice con el mismo metodo.
           }
       }
    }
    
    public List<T> bfs(Graph<T> grafo) {
        List<T> listado = new LinkedList<T>();
        boolean[] marca = new boolean[grafo.getSize()];                          //crea un vector para marcar si se visito el nodo
        for (int i = 1; i <= marca.length; i++) {                                   
             if (!marca[i]){                                                      //si el nodo no tiene marca 
                  this.bfs(i, grafo, marca,listado);                             //las listas empiezan en la pos 1
            }
        }
        return listado;
    }
    private void bfs(int i, Graph<T> grafo, boolean[] marca,List<T> li) {                    
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();                              //crea una cola de vertices
        q.enqueue(grafo.getVertex(i));                                            //encola el vertice
        marca[i] = true;                                                          //marca como visitado el nodo
        while (!q.isEmpty()) {                                                    //mientras la cola no este vacia
            Vertex<T> w = q.dequeue();                                            //desencolo el vertice
            li.add(w.getData());                                                  //agrega el valor del nodo a la lista de retorno          
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(w);                         //obtiene los nodos adyacentes
            for (Edge<T> e: adyacentes) {                                         //se recorre con un for each cada nodo adyacente
                int j = e.getTarget().getPosition();                             //obtiene la posicion del vertice actual en evaluacion
                if (!marca[j]) {                                                 //si no tiene la marca de visitado
                    marca[j] = true;                                             //marca el vertice como visitado
                    //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());                                    //encola el nuevo vertice
                }
            }
        }
    }               
}
