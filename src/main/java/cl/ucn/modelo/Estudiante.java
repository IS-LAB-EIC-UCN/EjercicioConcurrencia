package cl.ucn.modelo;

public class Estudiante {

    private String nombre;

    public Estudiante(String nombre){

        this.nombre = nombre;

    }

    public void hacerTarea(Tarea tarea){

        System.out.println(this.nombre +" esta trabajando en la tarea de " + tarea.obtenerDescripcionTarea());
    }
}
