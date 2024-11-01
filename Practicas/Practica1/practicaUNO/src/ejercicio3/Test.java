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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estudiante primero = new Estudiante("Juan Pablo","Acosta",1,"juampyacosta5@gmail.com","richieri 226");
        Estudiante segundo = new Estudiante("Dylan","Molina",1,"tripero@gmail.com","Azcuenaga 234");
        
        Estudiante[] vecEstudiantes = new Estudiante[2];
        vecEstudiantes[0] = primero;
        vecEstudiantes[1] = segundo;
        
        Profesor pUno = new Profesor("Matias","lopez","jajaja@gmail.com","mate 2","Informatica");
        Profesor pDos = new Profesor("Roberto","marra","jeeeee@gmail.com","cadp","Informatica");
        Profesor pTres = new Profesor("lucrecio","mernes","nanana@gmail.com","introduccion","Medicina");
        
        Profesor[] vecProfesores = new Profesor[3];
                
        vecProfesores[0] = pUno;
        vecProfesores[1] = pDos;
        vecProfesores[2] = pTres;
        
        for(int i=0; i<3; i++){
            System.out.println("Profesor: ");
            System.out.println(vecProfesores[i].tusDatos());
            System.out.println(" ");
            if(i<2){
                System.out.println("Alumno: ");
                System.out.println(vecEstudiantes[i].tusDatos());
                System.out.println(" ");
            }
        }
    }
    
}
