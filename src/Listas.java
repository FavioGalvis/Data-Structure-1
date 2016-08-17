
import java.util.Arrays;
import java.util.Random;

public class Listas {
 private Nodo L;//inicio de la lista
 public Listas()
 {
     L=null; //lista vacia
 }       
//-------------imprimir-----
 public void Imprimir()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Datos de la lista======\n";
   cad+="===============================\n";
   Nodo p=L;
   while(p!=null)
   {
    cad+=p+" - "+p.Dato+"\n";   
    p=p.sig;
   }//end while    
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
//-------------imprimir inverso-----
 public void Imprimir_inverso()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Datos de la lista======\n";
   cad+="===============================\n";
   Nodo p=Ultimo();
   while(p!=null)
   {
    cad+=p+" - "+p.Dato+"\n";   
    p=p.ant;
   }//end while    
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
//---- ultimo--------------
 public Nodo Ultimo()
 {
     Nodo p=L;
     while(p!=null)
     {
         if(p.sig==null) return p;
      p=p.sig;   
     }    
     return null;
 }//end Ultimo        
//------buscar-------------
 public Nodo Buscar(int dato)
 {
     Nodo p=L;
     while(p!=null)
     {
      if(p.Dato==dato) return p;
      p=p.sig;   
     }    
     return null;
 }//end Buscar 
//--------elementos posiciones pares-----
 public void Pares()
 {
   String cad;
   cad="===============================\n";
   cad+="=======Datos en pos pares======\n";
   cad+="===============================\n";
   Nodo p=L;
   int c=1;
   while(p!=null)
   {
    if(c % 2 == 0)   
        cad+=p+" - "+p.Dato+"\n";   
    p=p.sig;
    c++;
   }//end while    
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }      
//--------insertar al inicio----
 public void Ins_inicio(int dato)
 {
     Nodo x= new Nodo(dato);
     if( L!=null ){
         x.sig=L;
         L.ant=x;
     } else {
         L=x;
     }
 }        
//--------insertar al final----- 
 public void Ins_final(int dato)
 {
     Nodo x= new Nodo(dato);
     Nodo U= Ultimo();
     if(U!=null) {
        U.sig=x;
        x.ant=U;
     }
     else {
        L=x;
     }
 }
 //-----insertar despues de-----
 public void Ins_despues_de (int dato1, int dato2){
     Nodo b=Buscar(dato1);
     Nodo x;
     if(b!=null){
        if(b.sig==null){
            Ins_final(dato2);
        } else {
            x= new Nodo(dato2);
            x.sig=b.sig;
            x.ant=b;
            (b.sig).ant=x;
            b.sig=x;
        }
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----insertar antes de-----
 public void Ins_antes_de (int dato1, int dato2){
     Nodo b= Buscar(dato1);
     Nodo x;
     if(b!=null){
         if(b==L){
             Ins_inicio(dato2);
         }else{
             x= new Nodo(dato2);
             x.sig=b;
             x.ant=b.ant;
             (b.ant).sig=x;
             b.ant=x;
         }
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----Eliminar un nodo----
 public void Eliminar(int dato){
     Nodo b= Buscar(dato);
     if(b!=null){
        if(b.sig==null && b.ant==null){
            L=null;
        } else {
         if(b.sig==null && b.ant!=null){
             (b.ant).sig=null;
             b.sig=null;
             b.ant=null;
             b=null;
         } else {
            if(b==L){
                L=b.sig;
                L.ant=null;
                (b.sig).ant=L;
                b.sig=null;
                b.ant=null;
                b=null;
            }else{
                (b.ant).sig = b.sig;
                (b.sig).ant = b.ant;
                b.sig=null;
                b.ant=null;
                b=null;
            }
         }
        }
     }else{
         javax.swing.JOptionPane.showMessageDialog(null,"Nodo no encontrado.");
     }
 }
 //-----insertar N aleatorios-----
 public void Ins_aleatorios(int dato)
 {
     int limite=99;
    Random rand = new Random();
    for(int i=0;i<=dato-1;i++){
     Nodo x= new Nodo(rand.nextInt(limite));
     Nodo U= Ultimo();
     if(U!=null) {
         U.sig=x;
         x.ant=U;
     }
     else {
         L=x;
     }
    }
 }
//----ordenar lista ascendentemente-----
 public void Imprimir_ascendente(){
   String cad;
   int cant = 0;
   cad="===============================\n";
   cad+="=======Datos de la lista======\n";
   cad+="===============================\n";
   Nodo p=L;
   while(p!=null)
   {
    cant = cant+1; 
    p=p.sig;
   }//end while
   int[] orden = new int[cant];
   cant = 0;
   p=L;
   while(p!=null)
   {
    orden[cant]=p.Dato;
    cant = cant+1; 
    p=p.sig;
   }//end while
   Arrays.sort(orden);
   for(int i=0;i<orden.length;i++){
       cad+=orden[i]+"\n";
   }
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
 //----mostrar menor valor-----
 public void Buscar_menor(){
   String cad;
   int cant = 0;
   cad="===============================\n";
   cad+="=======Datos de la lista======\n";
   cad+="===============================\n";
   Nodo p=L;
   while(p!=null)
   {
    cant = cant+1; 
    p=p.sig;
   }//end while
   int[] orden = new int[cant];
   cant = 0;
   p=L;
   while(p!=null)
   {
    orden[cant]=p.Dato;
    cant = cant+1; 
    p=p.sig;
   }//end while
   Arrays.sort(orden);
   cad+=orden[0]+"\n";
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
   while(p!=null)
   {
    cant = cant+1; 
    p=p.sig;
   }//end while
   cad+=cant+"\n";
   cad+="===============================\n";
   javax.swing.JOptionPane.showMessageDialog(null,cad);
 }
 

 //end         
}//end class
