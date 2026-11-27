package proyecto.recetas.logica;

import java.io.Serializable;

public class Ingrediente implements Serializable {

    private String nombre;
    private boolean disponible;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
        this.disponible = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return nombre;
    }
}