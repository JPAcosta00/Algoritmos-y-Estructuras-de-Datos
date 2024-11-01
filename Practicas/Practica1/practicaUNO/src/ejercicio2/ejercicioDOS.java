/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class ejercicioDOS {
    
    public static int[]  multiplos(int n){
        int[] arreglo = new int[n];
        for(int i=0; i<n;i++){
            int aux = n * (i+1);
            arreglo[i] = aux;
        }
        return arreglo;
    }
    public static void main(String[] args) {
        System.out.println("Ingrese el valor.");
        Scanner n = new Scanner(System.in);
        int numero = n.nextInt();
        int[] vec = multiplos(numero);
        System.out.println("---------");
        for(int i=0;i < numero ;i++){
           System.out.println(vec[i]);
        }
    }
    
}
