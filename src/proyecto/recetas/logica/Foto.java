package proyecto.recetas.logica;

import java.io.Serializable;

public class Foto implements Serializable {

    private String ruta;

    public Foto(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}