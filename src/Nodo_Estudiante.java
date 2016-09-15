/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Nodo_Estudiante {
    public int id; // id del nodo hijo
    public String nombre; // nombre del estudiante
    public double nota; // nota final del estudiante
    public Nodo_Estudiante sig; // apuntator al nodo sig
    
    public Nodo_Estudiante() // constructor vacio
    {
        sig=null;
    }   
    
    public Nodo_Estudiante( Nodo_Estudiante nodo ) // constructor con datos sobrecargado
    {
        id=nodo.id;
        nombre=nodo.nombre;
        nota=nodo.nota;
        sig=null;
    }        
}
