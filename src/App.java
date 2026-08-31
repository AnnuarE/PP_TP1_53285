import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Crear evento con "new" y los datos
        EventoUniversitario evento1 = new EventoUniversitario("001", "Yoga para ingenieros", 5000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("002", "Clase loca de Sistemas Operativos", 0.0, true);

        //Crear Salas:
        Sala salaGrande = new Sala(1, "Sala Grande");
        Sala salaChica = new Sala(2, "Sala Chica");

        //Asignarle salas a los eventos de arriba:
        evento1.asignarSala(salaGrande);
        evento2.asignarSala(salaChica);

        // Crear copia con "new"
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaEvento2 = new EventoUniversitario(evento2);

        //Lista estudiantes:
        List<Estudiante> listaEstudiante = new ArrayList<>();
        listaEstudiante.add(new Estudiante("52359", "Ana Conda"));
        listaEstudiante.add(new Estudiante("33633", "Mica Rozo"));
        listaEstudiante.add(new Estudiante("87531", "Marcela Laloca")); //Marcela una copada, muak

        //crear actividades para los eventos:
        evento1.crearActividad(10, "Charla introductoria a Paradigmas",50, "Charla");
        evento1.crearActividad(21, "Clase de baile escoces",20, "Taller");

        evento2.crearActividad(33, "Taller de origamis",120, "Taller");


        //Obtener esas actividades
        Actividad charlaParadigmas = evento1.getActividad().get(0);
        Actividad claseBaile = evento1.getActividad().get(1);

        Actividad tallerOrigami = evento2.getActividad().get(0);

        //Inscribir estudiantes:
        charlaParadigmas.inscribir(listaEstudiante.get(0)); //0 es al primero que pusimos, o sea Ana
        charlaParadigmas.inscribir(listaEstudiante.get(1)); //Mica

        claseBaile.inscribir(listaEstudiante.get(2)); //Marcela
        claseBaile.inscribir(listaEstudiante.get(0)); //Ana


        // Con esto muestro los datos de los eventos:
        System.out.println("--+--+--+--+--+--+--+--+--+--- EVENTOS ---+--+--+--+--+--+--+--+--+--");
        //aestetik, rawwwr
        evento1.mostrarDatos();
        evento2.mostrarDatos();


        // Y con esto los datos de sus copias
       // System.out.println("\n--- COPIAS ---");
       // copiaEvento1.mostrarDatos();
       // copiaEvento2.mostrarDatos();
        // Saqué las copias porque se ven feas y no sirven para un poto

        // Mostrar contador
        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}