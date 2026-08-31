public class Estudiante {
    private String legajo;
    private String nombre;

    //Constructor:
    public Estudiante(String legajo, String nombre){
        this.legajo = legajo;
        this.nombre = nombre;
    }

    //para que se pueda acceder desde otro lado:

    public String getNombre() {
        return nombre;
    }
    public String getLegajo() {
        return legajo;
    }
}
