/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Nodo_Hijo {
    public int dato; // dato del nodo hijo
    public Nodo_Hijo sig; // apuntator al nodo sig
    
    public Nodo_Hijo() // constructor vacio
    {
        sig=null;
    }   
    
    public Nodo_Hijo( Nodo_Hijo nodo ) // constructor con datos sobrecargado
    {
        dato=nodo.dato;
        sig=null;
    }        
}
