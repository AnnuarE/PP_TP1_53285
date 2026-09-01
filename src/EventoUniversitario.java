import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EventoUniversitario {
    private final String ID;
    private String titulo;
    private double costoBase;
    private static int cantidadEventos;

    private boolean gratuito;

    private Sala sala;
    private List<Actividad> actividad;

    public EventoUniversitario(String ID, String titulo, double costoBase,
                               boolean gratuito) {
        this.ID = ID;
        this.titulo = titulo;
        this.gratuito = gratuito;
        this.costoBase = costoBase;

        cantidadEventos++;


        this.actividad = new ArrayList<>(); //Iniciar la lista
    }

    public EventoUniversitario(EventoUniversitario Evento1) {
        titulo = Evento1.titulo;
        costoBase = Evento1.costoBase;
        gratuito = Evento1.gratuito;
        this.ID = Evento1.ID;


        this.actividad = new ArrayList<>(); //Asigno para que funquen las copias
        // ni puta idea de por qué funciona asi
    }

    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }

        double costoTotalActividades = 0.0;
        for (Actividad actividad1 : actividad){
            costoTotalActividades += actividad1.calcularCostoMateriales(); //recorro la funcion
        }

        //Uso la fórmula del enunciado:
        return (this.costoBase + costoTotalActividades) * 1.21; //Valor de impuestos que pone el enunciado
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;   // se coloca this para que el programa sepa que el "sala" de la izq. es un atributo.

    }

    /* public void crearActividad(int ID, String titulo, int cupo, String tipo) {
         if (tipo.equalsIgnoreCase("Charla")) { //reviso si es charla

             //Creo una Charla modelo de ejemplo
             Actividad nuevaCharla = new Charla(ID, titulo, cupo, 33, "A confirmar");
             this.actividad.add(nuevaCharla); //Agrego la nueva actividad a la Lista que hicimos

         } else if (tipo.equalsIgnoreCase("Taller")) { //reviso si es taller

             //Tomo que sí necesitan notebook como ejemplo
             Actividad nuevoTaller = new Taller(ID, titulo, cupo, 33, true);
             this.actividad.add(nuevoTaller);
         } else {
             System.out.println("Tipo de actividad no reconocido");
         }
     } */
    public void crearActividad(int id, String titulo, int cupo, String tipoActividad) {

        Scanner scanner = new Scanner(System.in);

        switch (tipoActividad) {
            case "charla":
                System.out.print("Ingrese el nombre del disertante para la charla " + titulo + " :  ");
                String disertante = scanner.nextLine();
                Actividad charla = new Charla(id, titulo,  disertante,cupo );
                this.actividad.add(charla);
                break;
            case "taller":
                System.out.print("El taller " + titulo + " requiere el uso de Notebook? : S/N  ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                boolean requiereNotebook = false;
                if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                    requiereNotebook = true;
                }
                Actividad taller = new Taller(id, titulo,requiereNotebook, cupo);
                this.actividad.add(taller);
                break;
            default:
                System.out.println("Error: Tipo de actividad no reconocido.");
        }
    }

    public List<Actividad>  getActividades() {
        /* Se retorna una lista inmodificable para que mantener el encapsulamiento logrado con la composición
         * y que no puedan agregar actividades desde afuera. */
        return Collections.unmodifiableList(actividad);
    }


    public String getTitulo() {
        return titulo;
    }

    //buscar actividad
    public List<Actividad> getActividad() {
        return actividad;
    }

    public void mostrarDatos() {
        System.out.println("\nID: " + this.ID +
                "\n| Título: " + this.titulo +
                "\n| Costo Base: " + this.costoBase +
                "\n| Costo Estimado (Con impuestos): " + calcularCostoEstimado() +
                "\n| Gratuito: " + this.gratuito);

        if (this.sala != null){
            System.out.println("Sala Asignada: " + this.sala.getNombre());
        } else {
            System.out.println("Sin sala asignada");
        }

        System.out.println("\n         -----LISTA DE ACTIVIDADES-----");
        for (Actividad actividad1 : actividad){
            actividad1.mostrarIdentificacion();
            actividad1.mostrarInscripciones();
        }
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}