/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author USUARIO
 */
public class ejercicioSEIS {
    public static void main(String[] args) {
        System.out.println("6 A: ArrayList ofrece un mayor rendimiento que LinkedList en el caso de la busqueda de un elemento."
                + "El array te facilita esa accion ya que usando un indice se puede acceder directamente al elemeno buscado."
                + "En cambio usando la LinkedList habria que recorrer toda la lista o hasta encontrar el elemento.");
        System.out.println("6 B: LinkedList es eficiente en comparacion con el ArrayList al momento de agregar/eliminar un elemento del la lista.");
        System.out.println("6 C: La diferencia que se encuentra en el uso de memoria de ArrayList y LikedList es que no es necesario "
                + "declarar su tamaño ya que puede no ser fijo como pasa en los Arrays simples.");
        System.out.println("6 D: Depende de las caracteristicas del problema a resolver, tener en cuenta los accesos indexados del ArrayList"
                + "o el aleatorio de la lista enlazada; o tambien la insercion o eliminacion de un elemento (las cuales son mas eficientes"
                + "usando una LinkedList.)");
    }  
}
