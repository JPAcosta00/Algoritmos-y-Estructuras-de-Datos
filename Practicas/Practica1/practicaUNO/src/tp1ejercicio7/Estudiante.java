/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ejercicio7;

import ejercicio3.*;

/**
 *
 * @author USUARIO
 */
public class Estudiante {
     private String nombre;
     private String apellido;
     private int comision;
     private String email;
     private String direccion;
     
    public Estudiante(String unNombre, String unApellido, int unaComision, String unEmail, String unaDireccion){
        this.setApellido(unApellido);
        this.setComision(unaComision);
        this.setDireccion(unaDireccion);
        this.setEmail(unEmail);
        this.setNombre(unNombre);
    }
     
    public String tusDatos(){
        return ("Nombre: " + this.getNombre() + 
                "\n Apellido: " + this.getApellido() +  
                " \n  Comision: " + this.getComision() +
                " \n Emali: " + this.getEmail() + 
                " \n Direccion: " + this.getDireccion());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     
             
}
