/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;
import tp5.ejercicio2.Queue;

/**
 *
 * @author USUARIO
 */
public class Caminos {
    GeneralTree<Integer> arbol;
    
    public Caminos(GeneralTree<Integer> a){
        this.arbol = a;
    }
    
    private void recorreHastaHoja(GeneralTree<Integer> ar, List<Integer> lis,List<Integer> lmaximo){
        lis.add(ar.getData());
        if(!ar.isLeaf()){
            for(GeneralTree<Integer> child : ar.getChildren()){
                recorreHastaHoja(child,lis,lmaximo);
            }
        }else if(lis.size() > lmaximo.size()){
            lmaximo.removeAll(lis);
            lmaximo.addAll(lis);
        }
        lis.remove(lis.size()-1);
    }
    
    public List<Integer> caminoAHojaMasLejana (){
        if(this.arbol.isEmpty()){
            return null;
        }else{
            List<Integer> lista = new LinkedList<Integer>();
            List<Integer> lMax = new LinkedList<Integer>();
            recorreHastaHoja(this.arbol,lista,lMax);
            return lista;
        }
    }
}
