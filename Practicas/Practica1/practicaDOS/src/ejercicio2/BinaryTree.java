/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import tp3.Queue;
import java.util.LinkedList;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
        if(this.isLeaf()){
            return 1; 
        }else{
            return this.getLeftChild().contarHojas() + this.getRightChild().contarHojas();
        }
	}
		
    public BinaryTree<T> espejo(){
       BinaryTree<T> ar = new BinaryTree<T>();
       if(this.hasLeftChild()){
           ar.addRightChild(this.getLeftChild().espejo());
       }    
       if(this.hasRightChild()){
           ar.addLeftChild(this.getRightChild().espejo());
       }
       return ar;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
        BinaryTree<T> aux = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);                                            //marca de que guarde la raiz.
        int nivel = 0;
        while((!this.isEmpty())&&(nivel <= m)){
            aux = cola.dequeue();
            if(aux != null){                                           //es un arbol.
                if((nivel >= n)&&(nivel <= m)){
                    System.out.println(aux.getData());
                }
                if(this.hasLeftChild()){
                     cola.enqueue(aux.getLeftChild());
                }
                if(this.hasRightChild()){
                     cola.enqueue(aux.getRightChild());
                }
            }else{
                nivel++;
                if(!cola.isEmpty())
                    cola.enqueue(null);                              //marca de fin de nivel.
            }
        }
    }	
}

