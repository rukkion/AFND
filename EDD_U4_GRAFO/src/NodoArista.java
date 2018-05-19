/**
 *
 * @author Manu Almejo
 */
public class NodoArista {
    NodoGrafo arista;
    NodoArista prev,next;
    
    public NodoArista(NodoGrafo dirBrother){
        arista= dirBrother;
        prev=next=null;
    }
}
