public class Taller extends Actividad {
    private boolean requiereNotebook; //Para anotar si necesita o no

    public Taller(int id, String titulo, boolean requiereNotebook, int cupoMaximo){
        super(id, titulo, cupoMaximo); //super: llamar al constructor padre
        this.requiereNotebook = requiereNotebook;
    }

    public double calcularCostoMateriales(){
        if (this.requiereNotebook){ //si es verdadero, o sea que necesita notebook
            return 5000.0;
        } else {
            return 2000.0;
        }
    }

    @Override
    public String getTipo() {
        return "Taller";
    }
}
