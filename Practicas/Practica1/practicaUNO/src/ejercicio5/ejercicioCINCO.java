/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author USUARIO
 */
public class ejercicioCINCO {

    public static informacion calculaDatosA(int[] vector){
        informacion aux = new informacion();
        int max = -1;
        int min = 9999;
        int sumaPromedio = 0;
        for(int i=1; i<10; i++){
           sumaPromedio = sumaPromedio + vector[i];
           if(vector[i] < min){
               min = vector[i];
           }
           if(vector[i] > max){
               max = vector[i];
           }
        }
        sumaPromedio = sumaPromedio / 10;
        aux.setMaximo(max);
        aux.setMinimo(min);
        aux.setPromedio(sumaPromedio);
        return aux;
    }
    
    public static void calculaDatosB(int[] unVec, informacion info){
        double prome = 0;
        int mini = 9999;
        int maxi = -1;
        for(int i=1; i<10; i++){
           prome = prome + unVec[i];
           if(unVec[i] < mini){
               mini = unVec[i];
           }
           if(unVec[i] > maxi){
               maxi = unVec[i];
           }
        }
        prome = prome / 10;
        info.setMaximo(maxi);
        info.setMinimo(mini);
        info.setPromedio(prome);
    }
    
    public static int devuelveMaximo(int[] ve){
        int max = -1;
        for(int i=1; i<10; i++){
           if(ve[i] > max){
               max = ve[i];
           }
        }
        return max;
    }
    
    public static int devuelveMinimo(int[] vet){
        int min = 9999;
        for(int i=1; i<10; i++){
           if(vet[i] < min){
               min = vet[i];
           }
        }
        return min;
    }
    
    public static double devuelvePromedio(int[] v){
        double promedio = 0;
        for(int i=1; i<10; i++){
             promedio = promedio + v[i];
        }
        return (promedio/10);
    }
    
    
    public static void main(String[] args) {
        System.out.println("INCISO A");
        int[] nuevoVector = new int[10];
        for(int i=0; i<10;i++){
            nuevoVector[i] = i+27;
        }
        int maximoNumero = devuelveMaximo(nuevoVector);
        System.out.println("\n Maximo: " + maximoNumero);
        int minimoNumero = devuelveMinimo(nuevoVector);
        System.out.println("\n Minimo: " + minimoNumero);
        double elPromedio = devuelvePromedio(nuevoVector);
        System.out.println("\n Promedio: " + elPromedio);
        
        System.out.println("  ");
        System.out.println("INCISO B");
        int[] unVector = new int[10];
        for(int i=0; i<10;i++){
            unVector[i] = i+23;
        }
        informacion nuevaInfo = calculaDatosA(unVector);
        System.out.println("\n Maximo: " + nuevaInfo.getMaximo() + "\n Minimo: " + nuevaInfo.getMinimo() + "\n Promedio: " + nuevaInfo.getPromedio());
        
        System.out.println(" ");
        System.out.println("INCISO C");
        int[] otroVector = new int[10];
        for(int i=0; i<10;i++){
            otroVector[i] = i+54;
        }   
        informacion datos = new informacion();
        calculaDatosB(otroVector,datos);
        System.out.println("\n Maximo: " + datos.getMaximo() + "\n Minimo: " + datos.getMinimo() + "\n Promedio: " + datos.getPromedio());
        
    }
    
}
