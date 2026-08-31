public class Charla extends Actividad {
    private String disertante;


    public Charla (int id, String titulo, int cupoMaximo, int cupoMinimo, String disertante){
        super(id,titulo,cupoMaximo, cupoMinimo); // Llamo al constructor de la clase padre (Actividad)
        this.disertante = disertante;
    }


    public double calcularCostoMateriales(){
        return 0.0; //Las charlas son gratuitas
    }

    public String getTipo(){
        return "Charla"; //le devuelve al getTipo la palabra Charla
    }
}
