import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    protected int id;
    protected  String titulo;
    protected  int cupoMaximo;
    public final static int CUPO_MINIMO = 33;

    //Lista que pide el enunciado:
    private List<Inscripcion> inscripciones;


    //constructor:
    public Actividad(int id, String titulo, int cupoMaximo, int CUPO_MINIMO){
        this.id = id;
        this.cupoMaximo = cupoMaximo;
        this.titulo = titulo;

        this.inscripciones = new ArrayList<>(); //iniciar lista vacía llamada "inscripciones"
    }

    public Inscripcion inscribir (Estudiante estudiante){ // en realidad no es void sino del tipo "Inscripcion"
        if (this.inscripciones.size() < cupoMaximo){
            Inscripcion nuevaInscripcion = new Inscripcion("Inscripto", estudiante); //parametros que piden en "Inscripcion"
            this.inscripciones.add(nuevaInscripcion);//agrego a la lista la nueva inscripción
            return nuevaInscripcion;
        } else {
            System.out.println("Error: cupo máximo alcanzado superado para la actividad" + this.titulo);
            return null;
        }
    }


    public void mostrarInscripciones(){
        System.out.println("\n////Inscripciones para la actividad: " + this.titulo);
        if (inscripciones.size() == 0){
            System.out.println("////Sin inscriptos");
        }
        for (Inscripcion inscripcion1 : inscripciones){
            System.out.println("----Alumno: " + inscripcion1.getEstudiante().getNombre() +
                                " (" + inscripcion1.getEstudiante().getLegajo() + ") " +
                                "\n | Fecha: " + inscripcion1.getFecha() +
                                "\n | Estado: " + inscripcion1.getEstado());
        }
    }


    // FINAL: Las hijas lo heredan pero no pueden modificarlo
    public final void mostrarIdentificacion(){
        // getTipo resuelve lo de si es Taller o Charla
        System.out.println("Actividad [" +getTipo() + "] ID: " + this.id);
    }


    // ABSTRACTOS: La clase padre los crea, las hijas los programan
    public abstract double calcularCostoMateriales();

    public abstract String getTipo();  //podria poner esto arriba junto con los otros
                                        // pero para tenerlo más ordenado lo dejo acá
}

