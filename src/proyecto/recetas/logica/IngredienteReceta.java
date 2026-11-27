package proyecto.recetas.logica;

import java.io.Serializable;

public class IngredienteReceta implements Serializable {

    private String cantidad;
    private Ingrediente ingrediente;

    public IngredienteReceta(Ingrediente ingrediente, String cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}