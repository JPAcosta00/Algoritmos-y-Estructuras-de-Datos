/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import ejercicio2.BinaryTree;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ParcialArboles {
    
    public ParcialArboles(){
    
    }
    
    private void cargaArbol(BinaryTree<Integer> ar, BinaryTree<ArrayList<Integer>> re, int valorP, int sumaN){
        if(ar.isLeaf()){
            return;
        }else{
            ArrayList<Integer> lis = new ArrayList<Integer>();                             //crea la lista "nodo" del arbol
            valorP = ar.getData().hashCode() - valorP;
            sumaN = sumaN + ar.getData().hashCode();
            lis.add(0, sumaN);                                                             //guarda la suma hasta el momento
            lis.add(1, valorP);                                                            //guarda la diferencia con el padre
            re.setData(lis);
            if(ar.hasLeftChild()){
                re.addLeftChild(null);                                                     //crea rama incializada en null
                cargaArbol(ar.getLeftChild(),re,ar.getData(),sumaN);                             //recorre por izquierda y carga el nodo nuevo
            }
            if(ar.hasRightChild()){
                re.addRightChild(null);
                cargaArbol(ar.getRightChild(),re,ar.getData(),sumaN);
            }
        }
    }
    
    public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<ArrayList<Integer>> retorno = new BinaryTree<ArrayList<Integer>>();
        if(!arbol.isEmpty()){
            cargaArbol(arbol,retorno,0,0);
        }else{
            retorno = null;
        }
        return retorno;
    } 
}
