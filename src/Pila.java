/**
 * Favio Galvis
 * @author 201521268405
 */
import javax.swing.*;
public class Pila {
    private Nodo tope;
    public String salida;
    
    public Pila(){
        tope=null;
    }
    //-------------Imprimir Pila-------------//
    public void imp_pila() {
        Nodo p = tope;
       salida="Elementos de la Pila: \n";
        while(p!=null){
            salida+=p.Dato+"\n";
            p=p.sig;
        }
    }
    //-------------Contar Pila-------------//
    public int cont_pila() {
        Nodo p = tope;
        int s=0;
        while(p!=null){
            s+=1;
            p=p.sig;
        }
        return s;
    }
    //-------------Eliminar primer nodo de la Pila-------------//
    public int desapilar(){
        int D=0;
        Nodo x;
        if(tope!=null){
            x=tope;
            D=tope.Dato;
            tope=tope.sig;
            x.sig=null;
        }
        return D;
    }
        //-------------Limpiar Pila-------------//
    public int limpiar_pila(){
        new Pila();
        return 0;
    }
    //-------------Apilar-------------//
    public void apilar(int dato){
        Nodo x=new Nodo(dato);
        x.sig=tope;
        tope=x;
    }
    //-------------Buscar un elemento en la pila para eliminacion-------------//
    public Nodo buscar_nodo(int a){
        Nodo p=tope;
        if(p!=null){
            while(p!=null){
                if(p.Dato==a) return p;
                p=p.sig;
            }
        }
        return null;
    }
    //-------------Setear el Elemento Anterior para eliminacion-------------//
    public Nodo anterior(Nodo d){
        Nodo p=tope;
        while(p!=null)
        {
            if(p.sig==d){
                return p;
            }
            p=p.sig;
        }
        return null;
    }
    //-------------Eliminar un nodo en especifico------------//
    public void eliminar_nodo(int b){
        Nodo u=tope;
        if(u!=null){
            Nodo p=buscar_nodo(b);
            if(p!=null){
                if(p==u){
                    desapilar();
                }else{
                    Nodo a = anterior(p);
                    a.sig = p.sig;
                    p.sig=null;
                }
                javax.swing.JOptionPane.showMessageDialog(null,"Nodo Eliminado");
            }else{
                javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,"No existe el Nodo");
        }
    }

    public int[] a_vector() {
        Nodo u=tope;
        int [] a = new int[cont_pila()];
        int s=0;
        while(u!=null){
            a[s]=u.Dato;
            u=u.sig;
            s+=1;
        }
        return a;
    }

    public String salida_vector(int[]a) {
        String s="Datos en el vector\n";
        for(int i=0;i<a.length;i++){
            s+=a[i]+"\n";
        }
        return s;
    }
    
}
