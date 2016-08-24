public class Nodo {
 public int id;
 public String nombre;
 public String genero;
 public String programa;
 public double valor;
 public Nodo sig;//liga
 public Nodo ant;//liga
 public Nodo()
 {
     sig=this;
     ant=this;
 }       
 public Nodo(Nodo data)
 {
     id=data.id;
     nombre=data.nombre;
     genero=data.genero;
     programa=data.programa;
     valor=data.valor;
     sig=this;
     ant=this;
 }
}