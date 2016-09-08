public class Nodo {
 public int id;//identificacion del usuario
 public String nombre;//nombres del usuario
 public String genero;//genero del usuario
 public String ecivil;//estado civil del usuario
 public double salario;//salario del usuario
 public int tservicio;//tiempo de servicio en meses
 public Nodo sig;//apuntador a nodo siguiente
 public Nodo ant;//apuntador a nodo anterior
 public Nodo()//constructor nulo
 {
     sig=this;
     ant=this;
 }       
 public Nodo(Nodo data)//constructor sobrecargado con datos
 {
     id=data.id;
     nombre=data.nombre;
     genero=data.genero;
     ecivil=data.ecivil;
     salario=data.salario;
     tservicio=data.tservicio;
     sig=this;
     ant=this;
 }
}