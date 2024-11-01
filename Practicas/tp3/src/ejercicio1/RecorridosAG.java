/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio2.Queue;
import tp3.GeneralTree;

/**
 *
 * @author USUARIO
 */
public class RecorridosAG {
    
    private static void recorrePreOrden(GeneralTree<Integer> ar, Integer num, List<Integer> lis){
        if(!ar.isLeaf()){
            if(((ar.getData() % 2) != 0)&&(ar.getData() > num)){
                lis.add(ar.getData());
                 System.out.println("se agrego a la lista");
            }
            List<GeneralTree<Integer>> listaHijos = ar.getChildren();
            for(GeneralTree<Integer> hijo: listaHijos){
                recorrePreOrden(hijo,num,lis);
            }
        }
    }
    
    public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){                       //Inciso 2 a) FUNCIONA.
        List<Integer> retorno = new ArrayList<Integer>();
        if(a.isEmpty()){
             retorno = null;
        }else{
            recorrePreOrden(a,n,retorno);
            System.out.println("Se recorrio el arbol en PRE-ORDEN");
        }
        return retorno;
    }
    
    private static void recorreInOrden(GeneralTree<Integer> ar,Integer num, List<Integer> lis){
        if(!ar.isLeaf()){
            List<GeneralTree<Integer>> children = ar.getChildren();
            if(ar.hasChildren()){
               recorreInOrden(children.get(0),num,lis);
            }
            if(((ar.getData() % 2) != 0)&&(ar.getData() > num)){
              lis.add(ar.getData());
             System.out.println("se agrego a la lista");
            }
             for(GeneralTree<Integer> child : children){
                 recorreInOrden(child,num,lis);
            }
        }
    }
    
    public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> retorno = new ArrayList<Integer>();
        if(a.isEmpty()){
            retorno = null;
        }else{
            recorreInOrden(a,n,retorno);
            System.out.println("Se recorrio el arbol en IN-ORDEN");
        }
        return retorno;
    }
    
    private static void recorrePostOrden(GeneralTree<Integer> ar, Integer num, List<Integer> lis){
        if(!ar.isLeaf()){
             List<GeneralTree<Integer>> children = ar.getChildren();
             for(GeneralTree<Integer> child : children){
                 recorrePostOrden(child,num,lis);
             }
            if(((ar.getData() % 2) != 0)&&(ar.getData() > num)){
                lis.add(ar.getData());
                System.out.println("se agrego a la lista");
            }
        }
    }
    
    public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> listaRetorno = new ArrayList<Integer>();
        if(a.isEmpty()){
            listaRetorno = null;
        }else{
            recorrePostOrden(a,n,listaRetorno);
            System.out.println("Se recorrio el arbol POST-ORDEN");
        }
        return listaRetorno;
    }
    
    private static void recorrePorNiveles(GeneralTree<Integer> ar, Integer num, List<Integer> l){
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(ar);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(((ar.getData() % 2) != 0)&&(ar.getData() > num)){
                l.add(ar.getData());
                System.out.println("se agrego a la lista");
            }  
            List<GeneralTree<Integer>> childre = aux.getChildren();
            for(GeneralTree<Integer> child : childre){
                cola.enqueue(child);
            }
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
        List<Integer> li = new ArrayList<Integer>();
        if(a.isEmpty()){
            li = null;
        }else{
            recorrePorNiveles(a,n,li);
        }
        return li;
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22)); 
        children2.add(new GeneralTree<Integer>(23));
        children2.add(new GeneralTree<Integer>(45));
        children2.add(new GeneralTree<Integer>(2));
        children2.add(new GeneralTree<Integer>(87));
        children2.add(new GeneralTree<Integer>(34));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2); 
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>(); 
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        children3.add(new GeneralTree<Integer>(3));
        children3.add(new GeneralTree<Integer>(21));
        children3.add(new GeneralTree<Integer>(43));
        children3.add(new GeneralTree<Integer>(543));
        children3.add(new GeneralTree<Integer>(56));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>(); 
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
        
        List<Integer> li = numerosImparesMayoresQuePreOrden(a,21);
        System.out.println("retorno la lista PRE-ORDEN");
        
        int i = 0;
        while(i < li.size()){
            Integer numero = li.get(i);
            System.out.println("NUM " + numero);
            i++;
        }
        
        
        li =numerosImparesMayoresQueInOrden (a,21);
        System.out.println("retorno la lista IN-ORDEN");
        
        int in = 0;
        while(in < li.size()){
            Integer numero = li.get(in);
            System.out.println("NUM " + numero);
            in++;
        }
        
        li =numerosImparesMayoresQuePostOrden (a,21);
        System.out.println("retorno la lista POST-Orden");
        
        int ind = 0;
        while(ind < li.size()){
            Integer numero = li.get(ind);
            System.out.println("NUM " + numero);
            ind++;
        }
    }
}
