/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author USUARIO
 */
public class MapaCiudades <T> {
    public Graph<String> mapaCiudades;
    
    
    //------------------------- INCISO 1 ---------------------------------
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> lista = new LinkedList<String>();                                     //lista a retornar.
        boolean[] marca = new boolean[mapaCiudades.getSize()];                          //crea un vector del tamaño del grafo para marcar los nodos visitados.
        Vertex<String> inicio = mapaCiudades.search(ciudad1);
        this.dfsCamino(inicio,ciudad2,marca,lista);
        return lista;
    }
    private void dfsCamino(Vertex<String> vertice, String destino, boolean[] visitados, List<String> listado){
        int pos = vertice.getPosition();
        if(vertice.getData().equals(destino)){                                            //Caso base, osea si llego al destino
            return;
        }else{                                                                            //Si no llego al destino:
            visitados[pos]= true;                                                         //marca la posicion que visito
            listado.add(vertice.getData());                                               //agrega la ciudad que visito al la lista de camino
            for(Edge<String> ady : mapaCiudades.getEdges(vertice)){                       //por cada adyacencia de la ciudad
                this.dfsCamino(ady.getTarget(),destino,visitados,listado);                //recorro cada adyacencia y repito el proceso
            }
            listado.remove(listado.size() - 1);                                           //si en ese camino no encontre el destino entonces borro el camino que no me sirvio de la lista de camino
            visitados[pos] = false;                                                       //marco la posicion que no me sirvio en falso
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    //------------------------------- INCISO 2 -------------------------------------------------------
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> listaCiudades){
        List<String> listaExceptuando = new LinkedList<String>();
        boolean[] marcas = new boolean[mapaCiudades.getSize()];
        Vertex<String> comienzo = mapaCiudades.search(ciudad1);
        this.dfsExceptuando(comienzo,ciudad2,marcas,listaCiudades,listaExceptuando);
        return listaExceptuando;
    }
    private boolean buscaExcepcion(String dato, List<String> lis){                     //Si el dato no existe en las excepciones puede seguir
        boolean control = false;
        for(String ciudad : lis){
            if(!ciudad.equals(dato)){
                control = true;
            }
        }
        return control;
    }
    private void dfsExceptuando(Vertex<String> vertice, String destino, boolean[] marcador, List<String> Excepciones, List<String> listaRetorno){
        int pos = vertice.getPosition();                                                                    //obtengo la posicion del vertice
        if(vertice.getData().equals(destino)){                                                              //caso base, si llego al destino
           return ;
        }else{                                                                                              //si no llego al destino
            marcador[pos] = true;                                                                           //marca como visitada la posicion
            if(buscaExcepcion(vertice.getData(),Excepciones)){                                              //Si la ciudad no hay que saltearla
                listaRetorno.add(vertice.getData());                                                        //agrega el nombre de la ciudad a la lista de recorridos
            }
            for(Edge<String> ady : mapaCiudades.getEdges(vertice)){                                         //recorre las adyacencias de cada vertice
                this.dfsExceptuando(ady.getTarget(), destino, marcador, Excepciones, listaRetorno);          
            }
            listaRetorno.remove(listaRetorno.size()-1);                                                     //si el camino no llego al destino entonces borra el camino incorrecto de la lista de retorno
            marcador[pos] = false;                                                                          //saca las marcas como visitados
        }   
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------- INCISO 3 ---CORREGIR--------------------------------------------
    public List<String> CaminoMasCorto(String ciudad1, String ciudad2){
        List<String> listaCorta = new LinkedList<String>();
        boolean[] marcador = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        if(origen != null){
            this.dfsCaminoMinimo(origen,ciudad2,marcador,listaCorta,0,0);
        }
        return listaCorta;
    }
    private void dfsCaminoMinimo(Vertex<String> vertice, String destino, boolean[] marcas, List<String> lista, int distanciaM, int contador){
        int pos = vertice.getPosition();                                                            //obtengo la posicion donde estoy
        if(vertice.getData().equals(destino)){                                                      //si llego a destino retorno
            if(contador < distanciaM){
                distanciaM = contador;
                contador = 0;
            }
            return;
        }else{                                                                                      //si no llegue a destino
            if(marcas[pos] == false){
              marcas[pos] = true;                                                                     //marco la posicion como visitada
              lista.add(vertice.getData());                                                           //agrego la ciudad al la lista del camino
              for(Edge<String> ady : mapaCiudades.getEdges(vertice)){                                 //Por cada adyacencia 
                contador += ady.getWeight();                                                        //Acumulo las distancias (El peso de la arista)
                this.dfsCaminoMinimo(ady.getTarget(),destino,marcas,lista,distanciaM,contador);     //y recorro cada adyacencia
              }
              lista.remove(lista.size()-1);                                                       //saco el camino que no es minimo de la lista
              marcas[pos] = false;                                                                //marco la posicion en false
              contador = 0;      
            }else{
                return;
            }
        }
    }
    //-----------------------------------------------------------------------------------------------
    //----------------------- INCISO 4 -------------------------------
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> listado = new LinkedList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> comienzo = mapaCiudades.search(ciudad1);
        if(comienzo != null){
            dfsCombustible(comienzo,ciudad2,visitados,tanqueAuto,listado);
        }
        return listado;
    }
    private void dfsCombustible(Vertex<String> vertice, String destino, boolean[] marcas, int tanque, List<String> lista){
        int pos = vertice.getPosition();
        if(vertice.getData().equals(destino)){                                                //Si estoy en el destino retorno
            return;
        }else{                                                                                //SINO
            if(tanque >= 0){                                                                  //Si hay combustible aun:
                marcas[pos] = true;                                                           //marca la posicion como visitada 
                lista.add(vertice.getData());                                                 //agrega la ciudad a la lista del camino
            }else{                                                                              
                return;                                                                       //Si no hay combustible retorna
            }
            for(Edge<String> ady : mapaCiudades.getEdges(vertice)){
                this.dfsCombustible(ady.getTarget(),destino,marcas,tanque - ady.getWeight(),lista);         //Por cada adyacencia hace el recorrido y disminuye el valor del tanque restandole el peso de la arista 
            }
            lista.remove(lista.size()-1);                                                   
            marcas[pos] = false;
        }
    }
    //--------------------------------------------------------------------------------------
    //-------------------------------- INCISO 5 -----------------------------------
    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> retorno = new LinkedList<String>();
        boolean[] marcas = new boolean[mapaCiudades.getSize()];
        Vertex<String> inicio = mapaCiudades.search(ciudad1);
        if(dfsMenorCargaCombustible(inicio, ciudad2,tanqueAuto,tanqueAuto,marcas,retorno)){
            return retorno;
        }else{
            return retorno = null;
        }
    }
    private boolean dfsMenorCargaCombustible(Vertex<String> vertice, String destino, int valorTanque,int valorCompleto ,boolean[] visitados, List<String> lista){
        int pos = vertice.getPosition();
        boolean encontre = false;
        visitados[pos] = true;                                                      //marca como visitado
        lista.add(vertice.getData());                                               //agrego la ciudad en la que estoy
        if(vertice.getData().equals(destino)){                                              //si llegue al destino retorna verdadero
            return true;
        }else{  
            if((valorTanque <= 1)&&(valorTanque > 0)){                                 //si me estoy quedando si combustible
                valorTanque = valorCompleto;                                           //recarga el tanque completo
            }
            for(Edge<String> ady : mapaCiudades.getEdges(vertice)){                                            
                if((!visitados[pos])&&(valorTanque - ady.getWeight() >= 0)){           //si todavia no visito el vertice y en caso de que lo visite le alcanze el combustible
                    encontre = dfsMenorCargaCombustible(ady.getTarget(),destino,valorTanque - ady.getWeight(),valorCompleto,visitados,lista);      
                }
            }                                   
        }
        if(!encontre){                                          //si no lo encontre en el camino evaluado 
            lista.remove(lista.size()-1);                       //elimina los vertices agregados dejando solo el punto de partida
            visitados[pos] = false;                             
        }
        return encontre;
    }
    //-------------------------------------------------------------------------------------------------------------
    //NOTAS
    //T(n) = 1 si n=1
    //       2 t(n/4) + raiz n 
    //Paso 1= 2t(n/4) + raiz n
    //Paso 2= 2(2 t(n/4/4) + raiz n/4) + raiz n
    //        2^2 t(n/4^2) + 2 raiz n/4 + raiz n
    //Paso 3= 2^2 (2 t(n/4^2/4) + raiz n/4^2) + 2 raiz n/4 + raiz n 
    //        2^3 t(n/4^3) + 2^2 raiz n/4^2 + 2 raiz n/4 + raiz n
    //Paso i= 2^i t(n/4^i) + E 2^j * raiz n/4^j
    //        2^i t(n/4^i) + i * raiz 
    //
    
}