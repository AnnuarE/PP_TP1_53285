public class Charla extends Actividad {
    private String disertante;


    public Charla (int id, String titulo, String disertante, int cupo){
        super(id,titulo,cupo); // Llamo al constructor de la clase padre (Actividad)
        this.disertante = disertante;
    }


    public double calcularCostoMateriales(){
        return 0.0; //Las charlas son gratuitas
    }

    public String getTipo(){
        return "Charla"; //le devuelve al getTipo la palabra Charla
    }
}
