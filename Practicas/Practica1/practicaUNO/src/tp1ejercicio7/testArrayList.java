/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ejercicio7;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class testArrayList {

    
    public static void IncisoD(Estudiante primero, Estudiante segundo, Estudiante tercero){
        List<Estudiante> listado = new LinkedList();                                              // D i
        listado.add(primero);
        listado.add(segundo);
        listado.add(tercero);
        List<Estudiante> nueva = new LinkedList();                                                //D ii
        int index = 0;
        while(index < listado.size()){
           Estudiante info = listado.get(index);
           nueva.add(info);
           index++;
        }
        System.out.println("Imprime lista original");
        index = 0;
        while(index < listado.size()){                                                            //D iii (imprime lista original)
            Estudiante infor = listado.get(index);
            System.out.println(infor.tusDatos());
            System.out.println(" ");
            index++;
        }
        System.out.println("Imprime copia");
        index = 0;
        while(index < nueva.size()){
            Estudiante informacion = nueva.get(index);
            System.out.println(informacion.tusDatos());
            System.out.println(" ");
            index++;
        }
        System.out.println("Modifica un Estudiante de la lista.");             //D  iv
        index = 0;
        boolean control = true;
        while((index < listado.size())&&(control == true)){
            Estudiante viejo = listado.get(index);
            if(viejo.getApellido().equals("Acosta")){
                viejo.setDireccion("6 y 55");                                   //modifica la direcccion por ejemplo
                listado.add(index,viejo);                                        //guarda el dato en el lugar que estaba
                control = false;                                                 //sale del bucle ya que modifico un dato.
            }else{
                index++;
            }
        }
        System.out.println("Imprime lista original por segunda vez");            //D v
        index = 0;
        while(index < listado.size()){                                                           
            Estudiante infor = listado.get(index);
            System.out.println(infor.tusDatos());
            System.out.println(" ");
            index++;
        }
        System.out.println("Imprime copia por segunda vez");
        index = 0;
        while(index < nueva.size()){
            Estudiante informacion = nueva.get(index);
            System.out.println(informacion.tusDatos());
            System.out.println(" ");
            index++;
        }
        System.out.println("Inciso 7 E (Agrega un estudiante a la lista)");
        Estudiante nuevoPibe = new Estudiante("Eduardo","lezama",3,"jsjaj@gmail.com","6 y 55");
        if(listado.contains(nuevoPibe) == false ){
             listado.add(nuevoPibe);
        }else{
            System.out.println("El estudiante ya esta en la lista");
        }
    }
    
    public boolean esCapicua (List<Integer> lista){
        String cadena;
        boolean esCapi = true;
        while(!lista.isEmpty()){
            Integer num = lista.get(0);
            cadena = String.valueOf(num);
            int inicio = 0;
            int fin = cadena.length()-1;
            while(inicio < fin){
                if(cadena.charAt(inicio) != cadena.charAt(fin)){
                     esCapi = false;
                     break;
                }
            }
            lista.remove(0);
        }
        if(esCapi == true){
             return true;
        }else {       
             return false;
        }
    }
    
    public void invertirArrayList(List<Integer> lista,int comienzo, int fin){
        if(comienzo < fin){
           int temp = lista.get(comienzo);
           lista.set(comienzo,lista.get(fin));
           lista.set(fin,temp);
           
           invertirArrayList(lista,comienzo+1,fin-1);
        }
    }
    
    public int sumaLinkedList(List<Integer> linked, int index){
        if(index < linked.size()){
            return (linked.get(index) + sumaLinkedList(linked,index++));
        }
        return 0;
    }
    
  
    
    public static void main(String[] args) {
        System.out.println("Usando ArrayList");
        List lista_numeros = new ArrayList();
        lista_numeros.add(4);
        lista_numeros.add(5);
        lista_numeros.add(9);
        lista_numeros.add(12);
        lista_numeros.add(34);
        lista_numeros.add(67);
        while(!lista_numeros.isEmpty()){
            int numero = (int)lista_numeros.get(0);                      //castea el objeto de la lista en entero.
            System.out.println(numero);
            lista_numeros.remove(0);
        }
        
        System.out.println("Usando LinkedList");
        List lista = new LinkedList();
        lista.add(4);
        lista.add(5);
        lista.add(9);
        lista.add(12);
        lista.add(34);
        lista.add(67);
        while(!lista.isEmpty()){
            int numero = (int)lista.get(0);                               //castea el objeto de la lista en entero.
            System.out.println(numero);
            lista.remove(0);
        }
        
    }
}
