import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal desde la cual se crean y vinculan los objetos del modelo.
 * En este ejercicio se observa herencia y polimorfismo: el evento contiene Actividad,
 * pero en tiempo de ejecución se almacenan objetos Charla y Taller.
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar=true;
        int id=1;

        /* Se crean estudiantes } */
        List<Estudiante> estudiantes = new ArrayList<>();

        System.out.println("--+--+--+--+--+---REGISTRO DE ESTUDIANTES---+--+--+--+--+--+-- ");

        while (continuar){
            System.out.println("Ingrese Legajo del estudiante: ");
            String legajo = scanner.nextLine();
            System.out.println("Ingrese Nombre y Apellido del estudiante: ");
            String apenomb = scanner.nextLine();
            estudiantes.add(new Estudiante(legajo, apenomb));
            System.out.println("\n¿Quiere crear otro estudiante?   S/N");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            continuar = (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) ? true : false;
        };

        /* Se itera construyendo eventos */
        System.out.println("\n\n--+--+--+--+--+---REGISTRO DE EVENTOS--+--+--+--+--+---");

        continuar=true;
        while(continuar) {
            /* Se requieren datos por consola para construir un evento */
            System.out.println("Ingrese un titulo para el evento: ");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el costo base del evento:  ");
            double costoBase = scanner.nextDouble();
            scanner.nextLine(); //limpia el Enter pendiente
            System.out.println("¿El evento tendrá algún costo para los estudiantes?   S/N");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            boolean esGratuito= false;
            if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                esGratuito= true;
            }

            /* Se construye un objeto del tipo EventoUniversitario con el constructor de inicializacion de parametros */
            EventoUniversitario evento = new EventoUniversitario(
                    "EVT-" + id,
                    titulo,
                    costoBase,
                    esGratuito
            );

            /* Se crea una sala y se asigna al evento */
            System.out.println("Ingrese el nombre de la sala donde se realizará el evento: ");
            String nombreSala= scanner.nextLine();
            Sala sala = new Sala(id, nombreSala);
            evento.asignarSala(sala);

            /* Se crean las actividades del evento */
            System.out.println("\n\n --+--+--+--+--+---REGISTRO DE ACTIVIDADES PARA EL EVENTO `" + evento.getTitulo() + "` ---+--+--+--+--+--- ");

            int idActividad=1;
            while (continuar){
                System.out.println("Ingrese el título de la actividad: ");
                String tituloActividad= scanner.nextLine();
                System.out.println("Ingrese el cupo máximo de estudiantes admitidos para la actividad: ");
                int cupo= scanner.nextInt();
                scanner.nextLine(); //Se consume la linea.
                System.out.println("¿La actividad es una Charla o un Taller?  (Charla/Taller)");
                String tipo= scanner.nextLine().trim().toLowerCase();
                evento.crearActividad(idActividad, tituloActividad, cupo, tipo);
                System.out.println("¿Desea crear otra actividad para el  evento " + evento.getTitulo() + "?   S/N");
                respuesta = scanner.nextLine().trim().toLowerCase();
                continuar  = respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
                ++idActividad;
            }

            /* Se inscriben estudiantes en actividades */
            System.out.println("\n\n---|---|---|---|---INSCRIPCIÓN DE ESTUDIANTES EN ACTIVIDADES `" + evento.getTitulo() + "` ---|---|---|---|---53");
            continuar=true;
            while (continuar){
                System.out.println("Ingrese el Legajo del estudiante a inscribir: ");
                String legajo = scanner.nextLine();
                System.out.println("Ingrese el ID de la Actividad: (1, 2, 3, etc)");
                idActividad = scanner.nextInt();
                scanner.nextLine(); // se consume linea
                for (Estudiante estudiante: estudiantes){
                    if (estudiante.getLegajo().equals(legajo)){
                        evento.getActividad().get(--idActividad).inscribir(estudiante);
                    }
                }
                System.out.println("Desea generar otra inscripción  S/N?");
                respuesta = scanner.nextLine().trim().toLowerCase();
                continuar  = (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) ? true : false;
            }

            /* Se muestran datos del evento */
            System.out.println("\n\n------- DATOS DEL EVENTO -------");
            evento.mostrarDatos();

            /* Se consulta si se desea continuar creando eventos*/
            System.out.println("\n\n ¿Desea crear otro evento?  S/N");
            respuesta = scanner.nextLine().trim().toLowerCase();
            continuar  = (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) ? true : false;
        } ;

        /* Se muestra la cantidad total de eventos creados */;
        System.out.println("\n\n---#---#---#---TOTAL DE EVENTOS CREADOS: " + EventoUniversitario.getCantidadEventos());
    }
}
