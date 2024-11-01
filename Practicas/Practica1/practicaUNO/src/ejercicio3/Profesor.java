/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author USUARIO
 */
public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private String catedra;
    private String facultad;
    
    public Profesor(String unNombre, String unApellido, String unEmail, String unaCatedra, String unaFacultad){
        this.setApellido(unApellido);
        this.setNombre(unNombre);
        this.setEmail(unEmail);
        this.setFacultad(unaFacultad);
        this.setCatedra(unaCatedra);
    }
    

    public String tusDatos(){
      return ("Nombre: " + this.getNombre() +
              " \n Apellido. " + this.getApellido() +
              "\n Email: " + this.getEmail() + 
              "\n Catedra: " + this.getCatedra() +
              "\n Facultad: " + this.getFacultad());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    
            
}
