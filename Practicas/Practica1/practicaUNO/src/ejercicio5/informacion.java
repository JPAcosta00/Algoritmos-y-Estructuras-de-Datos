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
public class informacion {
    private int maximo;
    private int minimo;
    private double promedio;
    
    public informacion(){
    
    }
    
    public informacion(int unMaximo,int unMinimo, double unPromedio){
        this.setMaximo(unMaximo);
        this.setMinimo(unMinimo);
        this.setPromedio(unPromedio);
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
}
