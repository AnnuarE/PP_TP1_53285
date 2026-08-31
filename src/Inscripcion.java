import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;

    //lo conecto con Estudiante:
    private Estudiante estudiante;

    //constructor:
    public Inscripcion(String estado, Estudiante estudiante){
        this.fecha = LocalDate.now(); //la fecha del momento
        this.estado = estado;

        this.estudiante = estudiante;
    }

    //los llamo:
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }
}
