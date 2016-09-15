/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Nodo_Padre {
    public Nodo_Padre ant; // apuntador al nodo anterior
    public int dato; // dato del nodo padre
    public Nodo_Hijo hijo; // apuntador al nodo hijo
    public Nodo_Padre sig; // apuntador al nodo sig
    
    public Nodo_Padre() // constructor vacio
    {
        hijo=null;
        ant=null;
        sig=null;
    }         
    
    public Nodo_Padre( Nodo_Padre nodo ) // constructor con datos sobrecargado
    {
        dato=nodo.dato;
        hijo=null;
        ant=null;
        sig=null;
    }         
}
