package proyecto.recetas.logica;

public enum RangoDuracion {
    MENOS_DE_30_MIN, ENTRE_30_Y_60_MIN, MAS_DE_60_MIN;

    // Indica si una duración en horas cae dentro de este rango
    public boolean contiene(double horas) {
        double minutos = horas * 60;
        switch (this) {
            case MENOS_DE_30_MIN:
                return minutos < 30;
            case ENTRE_30_Y_60_MIN:
                return minutos >= 30 && minutos <= 60;
            default:
                return minutos > 60;
        }
    }
}