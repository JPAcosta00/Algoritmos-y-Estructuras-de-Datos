/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;
/**
 *
 * @author USUARIO
 */
public class ejercicioUNO {

    public static void imprimeNumeros(int A, int B){
        System.out.println("Usando el for");
        imprimeFor(A,B);
        System.out.println("Usando el while");
        imprimeWhile(A,B);
        System.out.println("Sin usar estructuras iterativas.");
        imprime(A,B);
    }
    
    public static void imprimeFor(int primero,int segundo){
        for(int i = primero; i <= segundo; i++ ){
            System.out.println(i);
            System.out.println("---------");
        }
    }
    
    public static void imprimeWhile(int unA, int unB){ 
        while(unA <= unB){
            System.out.println(unA);
            System.out.println("-----------");
            unA++;
        }
    }
    
    public static void imprime(int valorA, int valorB){
        if(valorA <= valorB){
            System.out.println(valorA);
            System.out.println("---------");
            valorA++;
            imprime(valorA,valorB);
        }
    }
    public static void main(String[] args) {
        int valorA = 3;
        int valorB = 14;
        imprimeNumeros(valorA,valorB);
    }
}
