/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Tp3 {

    /**
     * @param args the command line arguments
     */
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
        
        Integer num = 543;
        System.out.println("Nivel del num " + num + " = " + a.nivel(num));
        System.out.println("Altura del arbol: " + a.altura());
        System.out.println("Anchura del arbol: " + a.ancho());
        
        System.out.println(" ");
        a.imprimirArbol();
        System.out.println(a.esAncestro(0,22));
    }
    
}


//REPASAR: recorridos de los arboles generales en profundidad y por niveles
