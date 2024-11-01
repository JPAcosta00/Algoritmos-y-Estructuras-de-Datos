/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ejercicio7;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class incisoJ {

    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
       ArrayList<Integer> nueva = new ArrayList();
       int indiceUNO = 0;
       int indiceDOS = 0;
       int indiceNUEVO = 0;
       while((indiceUNO < lista1.size())&&(indiceDOS < lista2.size())){
            int nodo1 = lista1.get(indiceUNO);
            int nodo2 = lista2.get(indiceDOS);
            if(nodo1 < nodo2){
                nueva.add(indiceNUEVO,nodo1);                                    //Agrega el mas chico
                indiceNUEVO++;
                indiceUNO++;
            } else if(nodo2 < nodo1){
                nueva.add(indiceNUEVO,nodo2);                                    //Agrega el mas chico 
                indiceNUEVO++;
                indiceDOS++;
            }
        }
       return nueva;
    }
    public static void main(String[] args) {
       ArrayList<Integer> lista1 = new ArrayList();
       lista1.add(3);
       lista1.add(5);
       lista1.add(6);
       lista1.add(7);
       ArrayList<Integer> lista2 = new ArrayList();
       lista2.add(1);
       lista2.add(2);
       lista2.add(4);
       lista2.add(8);
       ArrayList<Integer> nueva = combinarOrdenado(lista1,lista2);
       int index = 0;
       while(index < nueva.size()){
          System.out.println(nueva.get(index));
          System.out.println(" ");
          index++;
       }
    }
}
