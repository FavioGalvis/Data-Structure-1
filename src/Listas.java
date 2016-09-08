
import java.util.Arrays;
import java.util.Random;

public class Listas {
 private Nodo L;//inicio de la lista de nodos
 public Listas()
 {
     L=null; //lista vacia
 }       
//--------1. Insertar al inicio
 public void Ins_inicio(Nodo data)
 {
     Nodo x= new Nodo(data);
     if( L!=null ){
         x.ant=L.ant;
         x.sig=L;
         (L.ant).sig=x;
         L.ant=x;
     }
     L=x;
 }
 
//--------2. Insertar al final
 public void Ins_final(Nodo data)
 {
     Nodo x= new Nodo(data);
     if(L!=null) {
        x.ant=L.ant;
        x.sig=L;
        (L.ant).sig=x;
        L.ant=x;
     }
     else {
        L=x;
     }
 }
//-----3. Insertar antes de
 public boolean Ins_antes_de (int dato1, Nodo data){
     Nodo b= Buscar(dato1);
     Nodo x;
     if(b!=null){
         if(b==L){
             Ins_inicio(data);
         }else{
             x= new Nodo(data);
             x.sig=b;
             x.ant=b.ant;
             (b.ant).sig=x;
             b.ant=x;
         }
         return true;
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
         return false;
     }
 }
 
//-----4. Insertar despues de
 public boolean Ins_despues_de (int dato1, Nodo data){
     Nodo b=Buscar(dato1);
     Nodo x;
     if(b!=null){
        if(b.sig==L){
            Ins_final(data);
        } else {
            x= new Nodo(data);
            x.sig=b.sig;
            x.ant=b;
            (b.sig).ant=x;
            b.sig=x;
        }
        return true;
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
         return false;
     }
 }
 
 //------5. Buscar
 public Nodo Buscar(int dato)
 {
     Nodo p=L;
     if(L!=null){
        do{
         if(p.id==dato){
             return p;
         }   
         p=p.sig;
        }while(p!=L);
     }
     return null;
 }
 
 //-----6. Eliminar un nodo
 public boolean Eliminar(int dato1){
     Nodo b= Buscar(dato1);
     if(b!=null){
        if(L.sig==L){
            L=null;
        }else{
            if(b==L){
                (L.sig).ant=L.ant;
                (L.ant).sig=L.sig;
                L=L.sig;
            } else {
                if(b==L.ant){
                    L.ant=(L.ant).ant;
                    (L.ant).sig=L;
                } else {
                    (b.ant).sig=b.sig;
                    (b.sig).ant=b.ant;
                }
            }
        }
        b.ant=null;
        b.sig=null;
        b=null;
        return true;
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
         return false;
     }
 }
 
 //----- Aux.) Imprime todos los nodos
 public void Imprimir()
 {
   String cad;
   int bonoanual=0;
   cad="=======Lista de Usuarios====\n";
   cad+="============================\n";
   Nodo p=L;
   if(L!=null){
    do{
     bonoanual=(int) ((p.tservicio/12)*(p.salario*0.01));
     cad+=p.id+" - "+p.nombre+" - "+p.genero+" - "+p.ecivil+" - "+p.tservicio+" - $"+p.salario+" - $"+bonoanual+"\n";   
     p=p.sig;
    }while(p!=L);
   }
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
 
 public int Contar_nodos(){
   int cant = 0;
   Nodo p=L;
   if(L!=null){
    do{
     cant=cant+1;   
     p=p.sig;
    }while(p!=L);
   }
   return cant;
 }

 public void Ordenar_Nodos(){
     Nodo temp = new Nodo();
     Nodo p;
     Nodo q;
     p=L;
     if(L!=null){
         do{
             q=L;
             do{
                 if(q.id>p.id){
                     temp.id=p.id;
                     temp.nombre=p.nombre;
                     temp.ecivil=p.ecivil;
                     temp.genero=p.genero;
                     temp.salario=p.salario;
                     temp.tservicio=p.tservicio;
                     p.id=q.id;
                     p.nombre=q.nombre;
                     p.ecivil=q.ecivil;
                     p.genero=q.genero;
                     p.salario=q.salario;
                     p.tservicio=q.tservicio;
                     q.id=temp.id;
                     q.nombre=temp.nombre;
                     q.ecivil=temp.ecivil;
                     q.genero=temp.genero;
                     q.salario=temp.salario;
                     q.tservicio=temp.tservicio;        
                 }
                 q=q.sig;
             }while(q!=L);
             p=p.sig;
         }while(p!=L);

         }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
     }
         
}
 
 //-----6. Eliminar un nodo
 public boolean Eliminar(Nodo x){
     Nodo b= x;
     if(b!=null){
        if(L.sig==L){
            L=null;
        }else{
            if(b==L){
                (L.sig).ant=L.ant;
                (L.ant).sig=L.sig;
                L=L.sig;
            } else {
                if(b==L.ant){
                    L.ant=(L.ant).ant;
                    (L.ant).sig=L;
                } else {
                    (b.ant).sig=b.sig;
                    (b.sig).ant=b.ant;
                }
            }
        }
        b.ant=null;
        b.sig=null;
        b=null;
        return true;
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Usuario no encontrado.");
         return false;
     }
 }
 

 //end         
}//end class
