/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.List;
import tp3.GeneralTree;
import tp5.ejercicio2.Queue;

/**
 *
 * @author USUARIO
 */
public class RedDeAguaPotable {
    private GeneralTree<Character> red;
    
    public RedDeAguaPotable (GeneralTree<Character> ar){
        this.red = ar;
    }
    
    private void calculaMinimo(GeneralTree<Character> redAgua, double valorCaudal, double min){
        if(!redAgua.isLeaf()){
            valorCaudal = valorCaudal / redAgua.getChildren().size();                                  //divide el valor caudal en sus hijos
            if(valorCaudal < min){                                                                    //calcula el minimo
                min = valorCaudal;
            }
            List<GeneralTree<Character>> lista = redAgua.getChildren();
            for(GeneralTree<Character> child : lista){
                calculaMinimo(child,valorCaudal,min);
            }
        }
    }
    
    public double minimoCaudal(double caudal){
       if(this.red.isEmpty()){
           return -1;
       }else{
           double minimo = caudal;
           calculaMinimo(this.red,caudal,minimo);
           return minimo;
       }
    }
}
