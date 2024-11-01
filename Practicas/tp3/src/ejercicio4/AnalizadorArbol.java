/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.List;
import tp3.GeneralTree;
import tp5.ejercicio2.Queue;

/**
 *
 * @author USUARIO
 */
public class AnalizadorArbol {
    
    private void calculaPromedioMayor(GeneralTree<AreaEmpresa> ar, double maximo){
        int cantActual  = 0;
        int cant = 0;
        GeneralTree<AreaEmpresa> ab;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        cola.enqueue(ar);
        cola.enqueue(null); 
        while(!cola.isEmpty()){
            ab = cola.dequeue();
            if(ab != null){                                                                         //entonces recorre nivel 
                List<GeneralTree<AreaEmpresa>> lista = ab.getChildren();
                for(GeneralTree<AreaEmpresa> child : lista){
                    cola.enqueue(child);
                    cantActual = cantActual + child.getData().getTransmision();
                    cant++;
                }
            }else{                                                                                  //si recorrio todo el nivel entonces hace las operaciones de comparacion y pone la marca que termino el nivel
                double promedio = cantActual / cant;
                if(promedio > maximo){
                    maximo = promedio;
                }
                cola.enqueue(null);
            }
        }
    }
    
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        if(arbol.isEmpty()){
            return 0;
        }else{
            double max = 0;
            calculaPromedioMayor(arbol,max);
            return max;
        }
    }
}
