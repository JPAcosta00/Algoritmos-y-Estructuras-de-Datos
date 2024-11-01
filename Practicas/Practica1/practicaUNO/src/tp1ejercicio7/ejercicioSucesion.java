/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ejercicio7;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ejercicioSucesion {
    private List<Integer> lista = new LinkedList();
    
    public List<Integer> calcularSucesion(int n){
        lista.add(n);
        if(n > 1){
            if(n/ 2 == 0){
                n = n/2;
            } else {
                n = (3 * n)+1;
            }
            calcularSucesion(n);
        }
       return this.lista;
    }
    
}
