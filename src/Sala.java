public class Sala {
    private int id;
    private String nombre;

    //Constructor:
    public Sala(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //Para que EventoUniversitario pueda leer el nombre
    // También podria hacer uno con el id, pero creo que no hace falta

    public String getNombre() {
        return nombre;
    }

    //lo hago por las dudas:
    public int getId() {
        return id;
    }
}
