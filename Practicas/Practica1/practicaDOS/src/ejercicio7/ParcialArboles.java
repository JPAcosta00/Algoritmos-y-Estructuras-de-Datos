/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import ejercicio2.BinaryTree;

/**
 *
 * @author USUARIO
 */

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
   
    public ParcialArboles(BinaryTree<Integer> ar){
        this.arbol = ar;
    }
    
    private boolean unHijo(BinaryTree<Integer> x){                                   //evalua si solo es un hijo
        if((x.hasLeftChild())&&(!x.hasRightChild())){
            return true;
        }else if((x.hasRightChild())&&(!x.hasLeftChild())){
            return true;
        }else{
            return false;
        }
    }
    
    private void cuenta (int cant, BinaryTree<Integer> arbo){                          //recorre y cuenta los padres de un hijo
        if(arbo.isLeaf()){
           return;
        }else{
            if(arbo.hasLeftChild()){
                if(unHijo(arbo)){
                    cant++;
                }
                cuenta(cant,arbo.getLeftChild());
            }
            if(arbo.hasRightChild()){
                if(unHijo(arbo)){
                    cant++;
                }
                cuenta(cant,arbo.getRightChild());
            }
        }
    }
    
    private void condiciones(BinaryTree<Integer> arb, int izquierda, int derecha){         //cuenta los nodos con un hijo o -1
        if(arb.hasLeftChild()){
            cuenta(izquierda,arb.getLeftChild());
        }else{
            izquierda = -1;
        }
        if(arb.hasRightChild()){
            cuenta(derecha,arb.getRightChild());
        }else{
            izquierda = -1;
        }
    }
    
    private void recorre(int num,boolean con, BinaryTree<Integer> ar){                        //busca la raiz "num"
        if(ar.getData().hashCode() == num){
            int izq = 0;
            int der = 0;
            condiciones(ar,izq,der);
            if(izq > der){
                con = true;
            }
        }else if(ar.hasLeftChild()){
            recorre(num,con,ar.getLeftChild());
        }else if(ar.hasRightChild()){
            recorre(num,con,ar.getRightChild());
        }
    }
    
    public boolean isLeftTree(int num){
        boolean control = false;
        if(!this.arbol.isEmpty()){
            recorre(num,control,this.arbol);
        }
        return control;
    }
}
