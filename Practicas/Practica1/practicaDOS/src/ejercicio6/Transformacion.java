/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import ejercicio2.BinaryTree;

/**
 *
 * @author USUARIO
 */
public class Transformacion {
    private BinaryTree<Integer> arbol;
    
    public Transformacion(BinaryTree<Integer> ar){
        this.arbol = ar;
    }
    
    private int recorreTransformando(BinaryTree<Integer> aRetorno, BinaryTree<Integer> ar){
       if(ar.isLeaf()){
           int aux = ar.getData();
           aRetorno.setData(aux);
           return aux;
       }else{
           int hi = 0;
           int hd = 0;
           if(ar.hasLeftChild()){
               hi = recorreTransformando(aRetorno.getLeftChild(),ar.getLeftChild());
           }
           if(ar.hasRightChild()){
               hd = recorreTransformando(aRetorno.getRightChild(),ar.getRightChild());
           }
           int aux = hi + hd;
           aRetorno.setData(aux);
           return ar.getData()+(hi + hd);
       }
    }
    
    public BinaryTree<Integer> suma (){
        BinaryTree<Integer> retorno = this.arbol;
        if(!this.arbol.isEmpty()){
            recorreTransformando(retorno, this.arbol);
        }
        return retorno;
    }
}




//corregir.
