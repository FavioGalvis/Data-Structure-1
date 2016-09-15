/**
 *
 * @author Favio Galvis
 * favio.agg@gmail.com
 */
public class Multilista 
{
    public Nodo_Asignatura L; // apuntador al inicio de la miltilista

    public Multilista() // constructor nulo
    {
        L = null;
    }
    
// retorna la direccion del ultimo elemento de la lista padre
    public Nodo_Asignatura buscar_ultimo_nodo_padre(){
        Nodo_Asignatura p=L;
        if(L!=null){
            while(p!=null){
                if (p.sig==null) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// retorna la direccion del ultimo elemento de la lista padre
    public Nodo_Estudiante buscar_ultimo_nodo_hijo(Nodo_Estudiante L_hijo){
        Nodo_Estudiante p=L_hijo;
        if(L_hijo!=null){
            while(p!=null){
                if(p.sig==null) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// inserta una nodo padre al final de la lista de nodos padre
    public void insertar_nodo_padre_final(Nodo_Asignatura nodo){
        Nodo_Asignatura u=buscar_ultimo_nodo_padre();
        Nodo_Asignatura x=new Nodo_Asignatura(nodo);
        if(u!=null){
            u.sig=x;
            x.ant=u;
        } else {
            L=x;
        }
    }
    
// busca la direccion de un nodo especifico de la lista padre  
    public Nodo_Asignatura buscar_nodo_padre(Nodo_Asignatura nodo){
        Nodo_Asignatura p=L;
        if(L!=null){
            while(p!=null){
                if(p.cod==nodo.cod) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// busca la direccion de un nodo especifico de la lista hijo  
    public Nodo_Estudiante buscar_nodo_hijo(Nodo_Asignatura padre, Nodo_Estudiante hijo){
        Nodo_Estudiante p=padre.hijo;
        if(L!=null){
            while(p!=null){
                if(p.id==hijo.id) return p;
                p=p.sig;
            }
        }
        return null;
    }
    
// inserta un nodo hijo al final de la lista de nodos hijos de un nodo padre dado
    public void insertar_nodo_hijo_final(Nodo_Asignatura padre, Nodo_Estudiante hijo){
        Nodo_Asignatura p=buscar_nodo_padre(padre);
        if(p!=null){
            Nodo_Estudiante u=buscar_ultimo_nodo_hijo(p.hijo);
            Nodo_Estudiante x=new Nodo_Estudiante(hijo);
            if(u!=null){
                u.sig=x;
            } else {
                p.hijo=x;
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existe el nodo padre"+padre.cod);
        }
    }
    
// imprime todos los nodos padre con sus nodos hijos
    public void imprimir_padres_hijos()
    {
        Nodo_Asignatura p=L;
        Nodo_Estudiante q;
        String e="";
        if(L!=null){
            while(p!=null){ // ciclo de los nodos padre
                e+="Asignatura"+p.cod+"// Nombre:"+p.asignatura+"\n";
                e+="===========================================\n";
                q=p.hijo;
                if(q!=null){
                    while(q!=null) // ciclo de los nodos hijos
                    {
                        e+="Id:"+q.id+"// Nombre:"+q.nombre+"// Nota:"+q.nota+"\n";
                        q=q.sig;
                    }
                } else {
                    e+="-- No posee nodos Estudiantes --\n";
                }
                e+="===========================================\n";
                p=p.sig;
            }
            e+=("===========================================\n");
            javax.swing.JOptionPane.showMessageDialog(null,e);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existen nodos par imprimir");
        }
    }
    
// imprime todos los nodos padre con sus nodos hijos
    public void imprimir_hijos(Nodo_Asignatura padre)
    {
        Nodo_Asignatura p=buscar_nodo_padre(padre);
        Nodo_Estudiante q;
        String e="";
        if(p!=null){
            e+=("Cod:"+p.cod+"// Asignatura:"+p.asignatura+"\n");
            e+=("===========================================\n");
            q=p.hijo;
            if(q!=null){
                while(q!=null) // ciclo de los nodos hijos
                {
                    e+=("Cod:"+q.id+"// Nombre:"+q.nombre+"// Nota:"+q.nota+"\n");
                    q=q.sig;
                }
            } else {
                e+=("-- No posee Estudiantes --\n");
            }
            e+=("===========================================\n");
            javax.swing.JOptionPane.showMessageDialog(null,e);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existen nodos par imprimir");
        }
    }

// eliminar un nodo padre en especifico
    public void eliminar_nodo_padre(Nodo_Asignatura nodo){
        Nodo_Asignatura p=buscar_nodo_padre(nodo);
        if(p!=null){
            if(p.sig==null && p.ant==null){
                L=null;
            }else{
                if(p.sig==null && p.ant!=null){
                    (p.ant).sig=null;
                    p.sig=null;
                    p.ant=null;
                    p=null;
                }else{
                    if(p==L){
                        L=p.sig;
                        L.ant=null;
                        (p.sig).ant=L;
                        p.sig=null;
                        p.ant=null;
                        p=null;
                    }else{
                        (p.ant).sig = p.sig;
                        (p.sig).ant = p.ant;
                        p.sig=null;
                        p.ant=null;
                        p=null;
                    }
                }
            }
            javax.swing.JOptionPane.showMessageDialog(null,"Asignatura Eliminada");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Asignatura no encontrada.");
        }
    }

// setear el nodo anterior para realizar eliminacion
    public Nodo_Estudiante anterior(Nodo_Asignatura padre,Nodo_Estudiante hijo){
        Nodo_Estudiante p=padre.hijo;
        while(p!=null)
        {
            if(p.sig==hijo){
                return p;
            }
            p=p.sig;
        }
        return null;
    }    

// eliminar un nodo hijo en especifico
    public void eliminar_nodo_hijo(Nodo_Asignatura padre, Nodo_Estudiante hijo){
        Nodo_Asignatura u=buscar_nodo_padre(padre);
        if(u!=null){
            Nodo_Estudiante p=buscar_nodo_hijo(u,hijo);
            if(p!=null){
                if(p==u.hijo){
                    u.hijo=p.sig;
                }else{
                    Nodo_Estudiante a = anterior(u,p);
                    a.sig = p.sig;
                    p.sig=null;
                }
                javax.swing.JOptionPane.showMessageDialog(null,"Estudiante Eliminado");
            }else{
                javax.swing.JOptionPane.showMessageDialog(null,"Estudiante no encontrado.");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existe la asignatura");
        }
    }

// imprime el promedio de estudiantes (cantidad) de todos los nodos padre
    public void promedio_por_asignatura()
    {
        Nodo_Asignatura p=L;
        Nodo_Estudiante q;
        int asig=0;
        int estd=0;
        double prom=0;
        if(L!=null){
            while(p!=null){ // ciclo de los nodos padre
                asig+=1;
                q=p.hijo;
                if(q!=null){
                    while(q!=null) // ciclo de los nodos hijos
                    {
                        estd+=1;
                        q=q.sig;
                    }
                }
                p=p.sig;
            }
            prom=estd/asig;
            javax.swing.JOptionPane.showMessageDialog(null,"El promedio de estudiantes por Asignatura es:"+prom);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existen nodos para buscar promedio");
        }
    }
    
// imprime el promedio de estudiantes (cantidad) de todos los nodos padre
    public void promedio_general()
    {
        Nodo_Asignatura p=L;
        Nodo_Estudiante q;
        int asig=0;
        double prom_asignatura=0;
        double prom_general=0;
        int estd=0;
        String e="----------------------------\n";
        if(L!=null){
            while(p!=null){ // ciclo de los nodos padre
                asig+=1;
                q=p.hijo;
                if(q!=null){
                    while(q!=null) // ciclo de los nodos hijos
                    {
                        prom_asignatura=prom_asignatura+q.nota;
                        estd+=1;
                        q=q.sig;
                    }
                    prom_asignatura=prom_asignatura/estd;
                    e+=">> Asignatura:"+p.asignatura+"// Promedio:"+prom_asignatura+"\n";  
                }
                prom_general=prom_general+prom_asignatura;
                prom_asignatura=0;
                estd=0;
                p=p.sig;
            }
            prom_general=prom_general/asig;
            e+="----------------------------\n";
            e+="Promedio General de las Asignaturas:"+prom_general+"\n";
            e+="----------------------------\n";
            javax.swing.JOptionPane.showMessageDialog(null,e);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existen nodos para buscar promedio");
        }
    }
    
} // fin de la clase
