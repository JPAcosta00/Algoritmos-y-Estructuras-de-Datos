/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author USUARIO
 */
public class QuedateEnCasa {
    
    public List<Persona> AcercarSueldo(Graph<Persona> grafo,Persona Empleado, int GradoSeparacion ){
        List<Persona> listaRetorno = new LinkedList<Persona>();
        boolean[] marcas = new boolean[grafo.getSize()];
        Vertex<Persona> comienzo = grafo.search(Empleado);
        if(comienzo != null){
            dfsSueldo(comienzo,grafo, GradoSeparacion,0, marcas, listaRetorno);
        }
        return listaRetorno;
    }
    private void dfsSueldo(Vertex<Persona> vertice, Graph<Persona> grafo, int grado,int distancia, boolean[] visitados, List<Persona> lista){
        int pos = vertice.getPosition();
        if((distancia <= grado)&&(vertice.getData().getEstado().equals("JUBILADO"))){       //si estoy dentro de la distancia dada y la persona es un jubilado
             lista.add(vertice.getData());
             visitados[pos] = true;  
        }else{
            for(Edge<Persona> ady : grafo.getEdges(vertice)){
                 if((!visitados[pos])&&(distancia + ady.getWeight() <= grado)){
                    dfsSueldo(ady.getTarget(),grafo,grado,distancia + ady.getWeight(),visitados,lista);
                 }
            } 
        }
    }
}
