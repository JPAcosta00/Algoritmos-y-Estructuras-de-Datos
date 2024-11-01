/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ejercicio9;

import java.util.Stack;



/**
 *
 * @author USUARIO
 */
public class testBalanceo {

    public static boolean estaBalanceado(String unaCadena){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<unaCadena.length();i++){
            char car = unaCadena.charAt(i);
            if((car == '(')||(car == '[')||(car == '{')){
                stack.push(car);
            } else if(stack.isEmpty()){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        boolean control = estaBalanceado("(()[])");
        System.out.println(control);
    }
}
