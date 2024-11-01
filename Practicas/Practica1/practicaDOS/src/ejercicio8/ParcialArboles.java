/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import ejercicio2.BinaryTree;

/**
 *
 * @author USUARIO
 */
public class ParcialArboles {
    
    
    public ParcialArboles(){
    
    }
    
    private boolean EvaluaContenido (BinaryTree<Integer> ar1,BinaryTree<Integer> ar2){
        if(ar1.getData() == ar2.getData()){
            return true;
        }else{
            return false;
        }
    }
    
    private void recorreAmbos(BinaryTree<Integer> a1,BinaryTree<Integer> a2,boolean con){
        if(a1.isLeaf()){
            return;
        }else if((EvaluaContenido(a1,a2))&&(con == true)){                                        //Evalua si tienen el mismo contenido, de ser true entonces evalua la estructura.                                                                     //si tienen hijos izquierdos, los compara
            if((a1.hasLeftChild())&&(a2.hasLeftChild())){
                recorreAmbos(a1.getLeftChild(),a2.getLeftChild(),con);
            }else if((a1.hasLeftChild())&&(!a2.hasLeftChild())){
                con = false;
            }
            if((a1.hasRightChild())&&(a2.hasRightChild())){
                recorreAmbos(a1.getRightChild(),a2.getRightChild(),con);
            }else if((a1.hasRightChild())&&(!a2.hasRightChild())){
                con = false;
            }
        }else{
            con = false;
        }
    }
    
    public boolean esPreFijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean control = true;
        if((arbol1.isEmpty()) || (arbol2.isEmpty())){                                        //si alguno de los dos arboles esta vacio retorna falso.
            control = false;
        }else{
            recorreAmbos(arbol1,arbol2,control);
        }
        return control;
    }
}
