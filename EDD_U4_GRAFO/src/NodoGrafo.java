/**
 *
 * @author Manu Almejo
 */
public class NodoGrafo {
    Object value;
    NodoGrafo prev,next;
    NodoArista headerArista, endArista;
    
    public NodoGrafo(Object o){
        value=o;
        prev=next=null;
        headerArista=null;
        endArista=null;
    }
    
    public boolean createArista(NodoGrafo destino){
        if(searchNodo(destino)!=null)  //Se pregunta si hay un nodo con el mismo valor
            return false;
        NodoArista temp=new NodoArista(destino); //Superando esto se crea el nodo a insetar
        if(temp==null) //Se pregunta si esta lleno el grafo
            return false;
        if (headerArista==null && endArista==null) { //Si es el primer nodo se asigna a cabecera
            headerArista=endArista=temp;
            return true;
        }
        endArista.next=temp;//Si no, se enlaza al nodo anterior.
        temp.prev=endArista;//
        endArista=temp;//Se asigna como ultimo el nodo agregado.
        return true;
    }
    
    public NodoArista searchNodo(Object o){
        NodoArista temp=headerArista;
        while(temp!=null){
            if(temp.arista.equals(o))
                return temp;
            temp=temp.next;
        }
        return null;
    }
    
    public boolean deleteArista(NodoGrafo d){ //Eliminar arista de un origen
        if(headerArista ==null && endArista==null)
            return false;
        if (headerArista==endArista) { //Caso de un solo nodo 
            if(headerArista.arista==d){
                headerArista=null;
                endArista=null;
                return true;
            }
            return false;
        }
        NodoArista temp;
        if(headerArista.arista==d){ //Caso si esta en cabecera
            temp= headerArista;
            headerArista=temp.next;
            headerArista.prev=null;
            temp.next=null;
            return true;
        }
        if (endArista.arista==d) { //Caso si esta en final
            temp=endArista;
            endArista=temp.prev;
            temp.prev=null;
            endArista.next=null;
            return true;
        }
        
        temp=headerArista.next;
        while(temp!=endArista){ //Si el dato esta en medio
            if(temp.arista==d){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                temp.next=temp.prev=null;
                return true;
            }
            
            temp=temp.next;
        }
        return false;
    }
    
}
