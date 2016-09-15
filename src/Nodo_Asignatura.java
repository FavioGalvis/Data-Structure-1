/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Nodo_Asignatura {
    public Nodo_Asignatura ant; // apuntador al nodo anterior
    public int cod; // cod del nodo padre
    public String asignatura; // asignatura del nodo padre
    public Nodo_Estudiante hijo; // apuntador al nodo hijo
    public Nodo_Asignatura sig; // apuntador al nodo sig
    
    public Nodo_Asignatura() // constructor vacio
    {
        hijo=null;
        ant=null;
        sig=null;
    }         
    
    public Nodo_Asignatura( Nodo_Asignatura nodo ) // constructor con datos sobrecargado
    {
        cod=nodo.cod;
        asignatura=nodo.asignatura;
        hijo=null;
        ant=null;
        sig=null;
    }         
}
