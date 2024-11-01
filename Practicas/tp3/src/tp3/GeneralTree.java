package tp3;

import tp5.ejercicio2.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
    
	private int calculaAltura(){
        if(this.isLeaf()){
            return 0;
        }else{
            int alturaMax = -1;
            List<GeneralTree<T>> children = this.getChildren();
            for(GeneralTree<T> child : children){
                alturaMax = Math.max(alturaMax, child.calculaAltura());
            } 
            return alturaMax +1;
        }
    }
    
	public int altura() {	 
	    if(this.isEmpty()){
            return -1;
        }else{
            if(!this.isLeaf()){
                return this.calculaAltura();
            }else{
                return 0;
            }
        }
	}
    
    private void devuelveNivel(T dato,int nivel, boolean control){
        if(control = true){                                                           //si ya lo encontro entonces corta el recorrido y devuelve el nivel
            return;
        }else if(!this.isLeaf()){                                                     //si no lo encontro y no termino de recorre el arbol
             if(this.getData() != dato){                                             //si el dato es distinto al que busco entonces incremento el nivel y sigo buscando
                 nivel++;
                 System.out.println("se incremento el nivel");
                 List<GeneralTree<T>> listaHijos = this.getChildren();                //cargo al lista de los nodos hijos
                 for(GeneralTree<T> child : listaHijos){                             //recorro la lista
                     child.devuelveNivel(dato,nivel,control); 
                 }
             }else {
                 control = true;                                                       //si el dato es igual al que busco entonces corto el recorrido con control = true
             }
         }
    }
	
	public int nivel(T dato){                                                         //el caso base para evaluar seria el dato que busco y despues que no se termine el arbol
        if(this.isEmpty()){
            return -1;
        }else{
            int nivel = 1;               
            this.devuelveNivel(dato,nivel,false);                                     //corregir
            return nivel;
        }
	}
    
    private int calculaAncho(){
        int cantActual = 0;
        int max = 0;
        GeneralTree<T> ab;
        Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);                                                             //encola la raiz
        cola.enqueue(null);                                                             //marca de nivel
        while(!cola.isEmpty()){
            ab = cola.dequeue();                                                        //desencola la raiz
            if(ab != null){                                                             //si no es null recorre el nivel
                List<GeneralTree<T>> listaHijos = ab.getChildren();                     //lista de los nodos hijos
                for(GeneralTree<T> child : listaHijos){                                 //recorre la lista con foreach
                    cola.enqueue(child);                                                //encola el nodo
                    cantActual++;                                                       //va contando la cantida de nodos que tiene el nivel
                }
            }else if(!cola.isEmpty()){                                                 //si se termino el arbol de ese nivel y la cola no esta vacia
                max = Math.max(max,cantActual);                                        //entonces calcula el maximo de nodos para saber el ancho
                cantActual = 0;                                                        //pone en cero el la variable que cuenta los nodos
                cola.enqueue(null);                                                    //pone la marca de fin de nivel
            }
        }
        return max;
    }

	public int ancho(){
		if(this.isEmpty()){
            return 0;
        }else{
            return (!this.isLeaf()) ? calculaAncho() : 1;
        }
	}
    
    private  void recorrePreOrden( Integer num, List<Integer> lis){
        if(!this.isLeaf()){
            int dato = (Integer) this.getData();
            if(((dato % 2) != 0)&&(dato > num)){
                lis.add(dato);
                 System.out.println("se agrego a la lista");
            }
            List<GeneralTree<T>> listaHijos = this.getChildren();
            for(GeneralTree<T> hijo: listaHijos){
                hijo.recorrePreOrden(num,lis);
            }
        }
    }
       
    public List<Integer> numerosImparesMayoresQuePreOrden (Integer n){                       //Inciso 2 a) FUNCIONA.
        List<Integer> retorno = new ArrayList<Integer>();
        if(this.isEmpty()){
             retorno = null;
        }else{
            this.recorrePreOrden(n,retorno);
            System.out.println("Se recorrio el arbol en PRE-ORDEN");
        }
        return retorno;
    }
    
    private void recorreInOrden(Integer num, List<Integer> lis){
        if(!this.isLeaf()){
            List<GeneralTree<T>> children = this.getChildren();
            if(this.hasChildren()){
               children.get(0).recorreInOrden(num,lis);
            }
            int dato = (Integer) this.getData();
            if(((dato % 2) != 0)&&(dato > num)){
              lis.add(dato);
             System.out.println("se agrego a la lista");
            }
             for(GeneralTree<T> child : children){
                 child.recorreInOrden(num,lis);
            }
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (Integer n){
        List<Integer> retorno = new ArrayList<Integer>();
        if(this.isEmpty()){
            retorno = null;
        }else{
            this.recorreInOrden(n,retorno);
            System.out.println("Se recorrio el arbol en IN-ORDEN");
        }
        return retorno;
    }
    
    private void recorrePostOrden( Integer num, List<Integer> lis){
        if(!this.isLeaf()){
             List<GeneralTree<T>> children = this.getChildren();
             for(GeneralTree<T> child : children){
                 child.recorrePostOrden(num,lis);
             }
             int dato = (Integer) this.getData();
            if(((dato% 2) != 0)&&(dato > num)){
                lis.add(dato);
                System.out.println("se agrego a la lista");
            }
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePostOrden (Integer n){
        List<Integer> listaRetorno = new ArrayList<Integer>();
        if(this.isEmpty()){
            listaRetorno = null;
        }else{
           this.recorrePostOrden(n,listaRetorno);
            System.out.println("Se recorrio el arbol POST-ORDEN");
        }
        return listaRetorno;
    }
    
    private void recorrePorNiveles(GeneralTree<T> ar ,Integer num, List<Integer> l){
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(ar);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            int dato = (Integer) ar.getData();
            if(((dato % 2) != 0)&&(dato > num)){
                l.add(dato);
                System.out.println("se agrego a la lista");
            }  
            List<GeneralTree<T>> childre = aux.getChildren();
            for(GeneralTree<T> child : childre){
                cola.enqueue(child);
            }
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n){
        List<Integer> li = new ArrayList<Integer>();
        if(this.isEmpty()){
            li = null;
        }else{
            recorrePorNiveles(this,n,li);
        }
        return li;
    }
    
    public void imprimirArbol(){
        if(!this.isLeaf()){
            T dato = this.getData();
            System.out.println(dato);
            List<GeneralTree<T>> hijos = this.getChildren();
            for(GeneralTree<T> child : hijos){
                System.out.println(child.getData());
                child.imprimirArbol();
            }
        }
    }
    
    private void buscaA(GeneralTree<T> arbol, T dato, GeneralTree<T> aRetorno){
        if(!arbol.isLeaf()){
            List<GeneralTree<T>> lista = arbol.getChildren();
              for(GeneralTree<T> child : lista){
                  buscaA(child,dato,aRetorno);
              }
            if(arbol.getData() == dato){
                System.out.println("Encontro A");
                aRetorno = arbol;
            }
        }
    }
    private void buscaB(GeneralTree<T> ar1, T datoB, boolean control){
        if(!ar1.isLeaf()){
            if(ar1.getData() == datoB){
                control = true;
                System.out.println("Encontro B");
            }
            List<GeneralTree<T>> lista = ar1.getChildren();
            for(GeneralTree<T> child : lista){
                buscaB(child, datoB, control);
            }
        }
    }
    
    public boolean esAncestro(T a, T b){
        if(this.isEmpty()){
            return false;
        }else{
            GeneralTree<T> arbol1 = new GeneralTree<T>();
            buscaA(this,a,arbol1);                                                      //me devuelve el arbol de a
            boolean retorno = false;
            buscaB(arbol1,b,retorno);                                                   //busca si llega a b
            return retorno;
        }
    }
}