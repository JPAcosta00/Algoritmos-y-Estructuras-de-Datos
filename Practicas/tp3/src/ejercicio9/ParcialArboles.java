/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.util.Iterator;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author USUARIO
 */
public class ParcialArboles {
    
    private static void procesaSeleccion(GeneralTree<Integer> ar, boolean auxiliar){
        Integer raiz = ar.getData();                                                     //guarda la raiz.
        if(ar.isLeaf()){
            return;
        }else{
            Integer minimo = 99999;                                                      
            List<GeneralTree<Integer>> hijos = ar.getChildren();
            Iterator<GeneralTree<Integer>> iterador = hijos.iterator();
            while((iterador.hasNext())&&(auxiliar)){                                    //recorre los hijos 
                GeneralTree<Integer> child = iterador.next(); 
                if(child.getData() < minimo){                                           //se qeuda con el minimo de los dos hijos
                    minimo = child.getData();        
                }else{
                    auxiliar = false;                                                   
                }   
            }
            if(!raiz.equals(minimo)){                                                   //si el minimo no es igual a la raiz entonces no es de seleccion.
                auxiliar = false;
            }
        }
    }
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }else{
            boolean aux = true;
            procesaSeleccion(arbol,aux);
            return aux;
        }
    }
}
