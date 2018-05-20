/**
 *
 * @author Manu Almejo
 */
public class Grafo {
    NodoGrafo header,end;
    
    public Grafo(){
        header=null;
        end=null;
    }
    
    public boolean insertNodo(Object o){
        if(searchNodo(o)!=null)  //Se pregunta si hay un nodo con el mismo valor
            return false;
        NodoGrafo temp=new NodoGrafo(o); //Superando esto se crea el nodo a insetar
        if(temp==null) //Se pregunta si esta lleno el grafo
            return false;
        if (header==null && end==null) { //Si es el primer nodo se asigna a cabecera
            header=end=temp;
            return true;
        }
        end.next=temp;//Si no, se enlaza al nodo anterior.
        temp.prev=end;//
        end=temp;//Se asigna como ultimo el nodo agregado.
        return true;
    }
    
    public NodoGrafo searchNodo(Object o){
        NodoGrafo temp=header;
        while(temp!=null){
            if(temp.value.equals(o))
                return temp;
            temp=temp.next;
        }
        return null;
    }
    
    public boolean createArista(Object origin, Object dest){
        //1. preguntar si grafo vacio, en cuyo caso no se puede crear aristas
        if(header==null && end == null)
            return false;
        NodoGrafo NodoOrigin = searchNodo(origin);
        NodoGrafo NodoDest = searchNodo(dest);
        
        if(NodoOrigin==null || NodoDest==null)
            return false;
        
        return NodoOrigin.createArista(NodoDest);
    }
    
    public boolean deleteArista(Object origin, Object dest){
        if(header==null && end==null)
            return false;
        NodoGrafo NodoOrigin =searchNodo(origin);
        NodoGrafo NodoDest = searchNodo(dest);
        
        if(NodoOrigin==null || NodoDest==null)
            return false;
        
        return NodoOrigin.deleteArista(NodoDest);
    }
    
    public boolean deleteNodo(Object d){
        NodoGrafo delete =new NodoGrafo(d);
        if(header==null && end ==null) //Revisar si el grafo esta vacio
            return false;
        if(searchNodo(d)!=null)  //Buscar el nodo a eliminar
            return false;
        if(header==end){ //Se pregunta si hay un solo nodo, en cuyo caso se desenlaza de el mismo 
            deleteArista(d,d);
            header=end=null;
            return true;
        }
        NodoGrafo temp=header;
        while(temp.value!=delete.value){
            
        }
        return true;
        
    }
    
}
