/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import ejercicio2.BinaryTree;
import java.lang.Integer;
/**
 *
 * @author USUARIO
 */
public class RedBinariaLlena  {
    private BinaryTree<Integer> red;
    
    public RedBinariaLlena(BinaryTree<Integer> ar){
        this.red = ar;
    }
    
    public void calculaRetardo(int segundos, BinaryTree<Integer> ar){
        BinaryTree<Integer> iz = ar.getLeftChild();
        BinaryTree<Integer> de = ar.getRightChild();
        if(iz.getData().hashCode() >= de.getData().hashCode()){
            segundos = segundos + iz.getData().hashCode();
            calculaRetardo(segundos,ar.getLeftChild());
        }else {
            segundos = segundos + de.getData().hashCode();
            calculaRetardo(segundos,ar.getRightChild());
        }
    }
    
    public int RetardoReenvio(){
        int seg = 0;
        if(!this.red.isEmpty()){
            seg = this.red.getData().hashCode();                                      //recorrido en profundidad;
            calculaRetardo(seg,this.red);
        }else{
            if(this.red.isLeaf()){
                seg = this.red.getData().hashCode();                                  //si solo esta el nodo raiz, devuelve el dato.
            }
        }
        return seg;
    }
    
}
