/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import ejercicio2.BinaryTree;

/**
 *
 * @author USUARIO
 */
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;
    
    public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
        this.arbol = a;
    }
    
    public void recorreSumando(int auxiliar, int pro, int sumador, BinaryTree<Integer> ar){
        sumador = sumador + ar.getData().hashCode();
        if((ar.hasLeftChild())&&(auxiliar < pro)){
            auxiliar++;
            recorreSumando(auxiliar,pro,sumador,ar.getLeftChild());
        }
        if((ar.hasRightChild())&&(auxiliar < pro)){
            auxiliar++;
            recorreSumando(auxiliar,pro,sumador,ar.getRightChild());
        }
        auxiliar--;
    }
    
    public int sumaElementosProfundidad(int p){
        int aux = 0;
        int suma = 0;
        if(!this.arbol.isEmpty()){
            recorreSumando(aux,p,suma,this.arbol);
        }
        return suma;
    }
}
