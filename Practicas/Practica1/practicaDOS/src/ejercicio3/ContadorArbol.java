/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import ejercicio2.BinaryTree;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class ContadorArbol <Integer>{
    private BinaryTree<Integer> arbol;
    
    public ContadorArbol(BinaryTree<Integer> unArbol){
        this.arbol = unArbol;
    }
    
    public boolean esPar(Integer num){
        if(num.hashCode() % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void nParesIN(List<Integer> li, BinaryTree<Integer> ar){
        if(ar.hasLeftChild()) nParesIN(li, ar.getLeftChild());
        if(esPar(ar.getData())) li.add(ar.getData());
        if(ar.hasRightChild()) nParesIN(li, ar.getRightChild());
    }
    
    public List<Integer> NumerosParesIN(){
        List<Integer> l = new ArrayList<Integer>();
        if(!this.arbol.isEmpty()){
            this.nParesIN(l, this.arbol);
        }
        return l;
    }
    
    public void nParesPOST(List<Integer> l, BinaryTree<Integer> arb){
        if(arb.hasLeftChild()) nParesPOST(l, arb.getLeftChild());
        if(arb.hasRightChild()) nParesPOST(l, arb.getRightChild());
        if(esPar(arb.getData())) l.add(arb.getData());
    }
    
    public List<Integer> NumerosParesPOST(){
        List<Integer> lis = new ArrayList<Integer>();
        if(!this.arbol.isEmpty()){
            this.nParesPOST(lis,this.arbol);
        }
        return lis;
    }
    
    public void nParesPRE(List<Integer> ele, BinaryTree<Integer> ar){
        if(esPar(ar.getData())) ele.add(ar.getData());
        if(ar.hasLeftChild()) nParesPRE(ele, ar.getLeftChild());
        if(ar.hasRightChild()) nParesPRE(ele, ar.getRightChild());
    }
    
    public List<Integer> NumerosParesPRE(){
        List<Integer> l = new ArrayList<Integer>();
        if(!this.arbol.isEmpty()){
            this.nParesPRE(l,this.arbol);
        }
        return l;
    }

}
