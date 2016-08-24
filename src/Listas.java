
import java.util.Arrays;
import java.util.Random;

public class Listas {
 private Nodo L;//inicio de la lista
 public Listas()
 {
     L=null; //lista vacia
 }       
//-------------imprimir
 public void Imprimir()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Lista de Estudiantes====\n";
   cad+="===============================\n";
   Nodo p=L;
   if(L!=null){
    do{
     cad+=p.id+" - "+p.nombre+" - "+p.genero+" - "+p.programa+" - "+p.valor+"\n";   
     p=p.sig;
    }while(p!=L);
   }
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
//-------------imprimir inverso
 public void Imprimir_inverso()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Datos de la lista======\n";
   cad+="===============================\n";
   Nodo p=Ultimo();
   if(L!=null){
    do{
     cad+=p.id+" - "+p.nombre+" - "+p.genero+" - "+p.programa+" - "+p.valor+"\n";   
     p=p.ant;
    }while(p!=L.ant);
   }
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
//---- ultimo
 public Nodo Ultimo()
 {
     Nodo p=L;
     if(L!=null){
        p=p.ant;
        return p;
     }
     return null;
 }//end Ultimo        
//------buscar
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
 }//end Buscar 
//--------elementos posiciones pares
 public void Pares()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Datos en pos pares======\n";
   cad+="===============================\n";
   Nodo p=L;
   int c=1;
   if(L!=null){
    do{
     if(c % 2 == 0){
     cad+=p.id+" - "+p.nombre+" - "+p.genero+" - "+p.programa+" - "+p.valor+"\n";
     }
     p=p.sig;
     c++;
    }while(p!=L);
   }   
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }      
//--------insertar al inicio
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
//--------insertar al final
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
 //-----insertar despues de
 public void Ins_despues_de (int dato1, Nodo data){
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
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----insertar antes de
 public void Ins_antes_de (int dato1, Nodo data){
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
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----Eliminar un nodo
 public void Eliminar(int dato1){
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
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----insertar N aleatorios
 public void Ins_aleatorios(int dato)
 {
    int limite=9999;
    Random rand = new Random();
    for(int i=0;i<=dato-1;i++){
     Nodo x= new Nodo();
     x.id=rand.nextInt(limite);
     x.valor=rand.nextInt(limite);
     x.nombre="Nom-no-def"+rand.nextInt(limite);
     x.genero="Gen-no-def"+rand.nextInt(limite);
     x.programa="Pro-no-def"+rand.nextInt(limite);
     if(L!=null) {
         Ins_final(x);
     }
     else {
         L=x;
     }
    }
 }
 //----mostrar menor valor
 public void Buscar_menor_valor(){
   String cad;
   Nodo x = new Nodo();
   cad="===============================\n";
   cad+="=======Menor valor de la lista======\n";
   cad+="===============================\n";
   Nodo p=L;
   if(L!=null){
    x.valor=p.valor;
    do{
     if(x.valor>p.valor){
         x=p;
     }
     p=p.sig;
    }while(p!=L);
   }
   cad+=x.id+" - "+x.nombre+" - "+x.genero+" - "+x.programa+" - "+x.valor+"\n";
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
 //----------- Contar nodos-----------
 public void Contar_nodos(){
   String cad;
   int cant = 0;
   cad="===============================\n";
   cad+="=Cuenta de Nodos de la lista==\n";
   cad+="===============================\n";
   Nodo p=L;
   if(L!=null){
    do{
     cant=cant+1;   
     p=p.sig;
    }while(p!=L);
   }
   cad+=cant+"\n";
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
 

 //end         
}//end class
