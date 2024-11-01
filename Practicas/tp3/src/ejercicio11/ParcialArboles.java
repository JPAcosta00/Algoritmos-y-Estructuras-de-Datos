/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;
import tp5.ejercicio2.Queue;

/**
 *
 * @author USUARIO
 */
public class ParcialArboles {
    
    private static void esCreciente2(GeneralTree<Integer> ar,boolean controlador){      
        GeneralTree<Integer> ab;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(ar);
        cola.enqueue(null);
        int cantidadActual = 1;                                                               //1 la raiz
        int cantidadAnterior = 0;
        while((!cola.isEmpty())&&(controlador)){                                              //recorre por niveles
            ab = cola.dequeue(); 
            if(ab != null){                                                                     //si todavia el nivel no se termino 
               for(GeneralTree<Integer> child : ab.getChildren()){                             //recorre el nivel y cuenta los nodos
                   cantidadActual++;
                   cola.enqueue(child);
               } 
            }else{   
                cola.enqueue(null);                                                            //pone marca del fin del nivel
                if(cantidadActual == cantidadAnterior+1){                                     //si  la cantidad actual es igual a la anterior +1 entonces sigue, sino no es creciente
                     cantidadAnterior = cantidadActual;
                     cantidadActual = 0;
                }else{
                     controlador = false;                                                      //si el nivel que se evaluo no es creciente corte el recorrido con Controlador = false;
                }                
            }      
        }
    }
    
    private static boolean esCreciente(GeneralTree<Integer> ar){
        GeneralTree<Integer> ab;
        int cantidadActual = 1;
        int cantidadAnterior = 0;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(ar);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            if(cantidadActual != cantidadAnterior+1){                                    //si no es creciente retorna falso
                return false;
            }else{                                                                       //sino recorre los nodos
                for(int i=0; i<cantidadActual;i++){                                      //para cada nodo del nivel actual 
                     ab = cola.dequeue();                                                //desencola el arbol
                     for(GeneralTree<Integer> child : ab.getChildren()){                 //lo recorre 
                         cola.enqueue(child);
                     }
                }
            }
            cantidadAnterior = cantidadActual;                                           //la cantidad actual pasa a ser la anterior
            cantidadActual = cola.size();                                                //la cantidad actual es igual a la cantidad de nodos que se encolo en el anterior for
        }
        return true;
    }
    
    public static boolean Resolver(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }else{
            if(!arbol.isLeaf()){
               return esCreciente(arbol);
            }else{
               return false;
            }
        }
    }
    public static boolean Resolver2(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }else{
            if(!arbol.isLeaf()){
                boolean control = true;
                esCreciente2(arbol,control);
                return control;
            }else{
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        System.out.println("-------------------------");
        System.out.println("Es creciente = " + Resolver(a));
        
        
        List <GeneralTree<Integer>> arbol3 = new LinkedList <GeneralTree<Integer>>();
        arbol3.add(new GeneralTree<Integer>(1));
        arbol3.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(4, arbol3);
        System.out.println("-------------------------");
        System.out.println("Es creciente el arbol 3: " + Resolver(a3));
        
        List <GeneralTree<Integer>> subArb1 = new LinkedList <GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(1));
        subArb1.add(new GeneralTree<Integer>(2));
        subArb1.add(new GeneralTree<Integer>(99));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(4, subArb1);
        List <GeneralTree<Integer>> subArb2 = new LinkedList <GeneralTree<Integer>>();
        subArb2.add(new GeneralTree<Integer>(3));
        subArb2.add(subA3);
        GeneralTree<Integer> a5 = new GeneralTree<Integer>(6, subArb2);
        System.out.println("-------------------------");
        System.out.println("Es crecient a5 " + Resolver(a5));
    }
}
