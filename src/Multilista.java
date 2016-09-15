/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Multilista 
{
    public Nodo_Padre L; // apuntador al inicio de la miltilista

    public Multilista() // constructor nulo
    {
        L = null;
    }
    
// retorna la direccion del ultimo elemento de la lista padre
    public Nodo_Padre buscar_ultimo_nodo_padre(){
        Nodo_Padre p=L;
        if(L!=null){
            while(p!=null){
                if (p.sig==null) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// retorna la direccion del ultimo elemento de la lista padre
    public Nodo_Hijo buscar_ultimo_nodo_hijo(Nodo_Hijo L_hijo){
        Nodo_Hijo p=L_hijo;
        if(L_hijo!=null){
            while(p!=null){
                if(p.sig==null) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// inserta una nodo padre al final de la lista de nodos padre
    public void insertar_nodo_padre_final(Nodo_Padre nodo){
        Nodo_Padre u=buscar_ultimo_nodo_padre();
        Nodo_Padre x=new Nodo_Padre(nodo);
        if(u!=null){
            u.sig=x;
            x.ant=u;
        } else {
            L=x;
        }
    }
    
// busca la direccion de un nodo especifico de la lista padre  
    public Nodo_Padre buscar_nodo_padre(Nodo_Padre nodo){
        Nodo_Padre p=L;
        if(L!=null){
            while(p!=null){
                if(p.dato==nodo.dato) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// inserta un nodo hijo al final de la lista de nodos hijos de un nodo padre dado
    public void insertar_nodo_hijo_final(Nodo_Padre padre, Nodo_Hijo hijo){
        Nodo_Padre p=buscar_nodo_padre(padre);
        if(p!=null){
            Nodo_Hijo u=buscar_ultimo_nodo_hijo(p.hijo);
            Nodo_Hijo x=new Nodo_Hijo(hijo);
            if(u!=null){
                u.sig=x;
            } else {
                p.hijo=x;
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existe el nodo padre"+padre.dato);
        }
    }
    
// imprime todos los nodos padre con sus nodos hijos
    public void imprimir_padres_hijos()
    {
        Nodo_Padre p=L;
        Nodo_Hijo q;
        if(L!=null){
            while(p!=null){ // ciclo de los nodos padre
                System.out.println("Padre "+p.dato+" Nombre Nodo -- Hijos:");
                System.out.println("===========================================");
                q=p.hijo;
                if(q!=null){
                    while(q!=null) // ciclo de los nodos hijos
                    {
                        System.out.println("Hijo "+q.dato+" Marca");
                        q=q.sig;
                    }
                } else {
                    System.out.println("-- No posee nodos Hijo --");
                }
                System.out.println("===========================================");
                p=p.sig;
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existen nodos par imprimir");
        }
    }     

} // fin de la clase
