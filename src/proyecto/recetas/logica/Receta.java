package proyecto.recetas.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Receta implements Serializable {

    private String nombre;
    private double duracionHoras;
    private Dificultad dificultad;
    private int porciones;
    private String procedimiento;

    
    private List<IngredienteReceta> ingredientes;
    private List<Utensilio> utensilios;
    private List<Etiqueta> etiquetas;
    private List<Foto> fotos;

    public Receta(String nombre, double duracionHoras, Dificultad dificultad,
            int porciones, String procedimiento) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.dificultad = dificultad;
        this.porciones = porciones;
        this.procedimiento = procedimiento;
        this.ingredientes = new ArrayList<>();
        this.utensilios = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
        this.fotos = new ArrayList<>();
    }

    //gets y sets

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public List<IngredienteReceta> getIngredientes() {
        return ingredientes;
    }

    public List<Utensilio> getUtensilios() {
        return utensilios;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    //ingredientes

    public void agregarIngrediente(Ingrediente ingrediente, String cantidad) {
        //si ya estaba en la receta, solo se actualiza la cantidad
        for (IngredienteReceta ir : ingredientes) {
            if (ir.getIngrediente() == ingrediente) {
                ir.setCantidad(cantidad);
                return;
            }
        }
        ingredientes.add(new IngredienteReceta(ingrediente, cantidad));
    }

    public void quitarIngrediente(Ingrediente ingrediente) {
        ingredientes.removeIf(ir -> ir.getIngrediente() == ingrediente);
    }

    public boolean usaIngrediente(Ingrediente ingrediente) {
        for (IngredienteReceta ir : ingredientes) {
            if (ir.getIngrediente() == ingrediente) {
                return true;
            }
        }
        return false;
    }

    //utensilios

    public void agregarUtensilio(Utensilio utensilio) {
        if (!utensilios.contains(utensilio)) {
            utensilios.add(utensilio);
        }
    }

    public void quitarUtensilio(Utensilio utensilio) {
        utensilios.remove(utensilio);
    }

    public boolean usaUtensilio(Utensilio utensilio) {
        return utensilios.contains(utensilio);
    }

    //etiquetas

    public void agregarEtiqueta(Etiqueta etiqueta) {
        if (!etiquetas.contains(etiqueta)) {
            etiquetas.add(etiqueta);
        }
    }

    public void quitarEtiqueta(Etiqueta etiqueta) {
        etiquetas.remove(etiqueta);
    }

    public boolean tieneEtiqueta(String nombre) {
        for (Etiqueta e : etiquetas) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    //fotos

    public void agregarFoto(Foto foto) {
        fotos.add(foto);
    }

    public void quitarFoto(Foto foto) {
        fotos.remove(foto);
    }

    //que cocinar

    //cuenta ingredientes y utensilios no dispo
    public int contarFaltantes() {
        int faltantes = 0;
        for (IngredienteReceta ir : ingredientes) {
            if (!ir.getIngrediente().isDisponible()) {
                faltantes++;
            }
        }
        for (Utensilio u : utensilios) {
            if (!u.isDisponible()) {
                faltantes++;
            }
        }
        return faltantes;
    }

    //para editar

    //copia de la receta: listas nuevas, pero con los mismos ingredientes,

    public Receta copiar() {
        Receta copia = new Receta(nombre, duracionHoras, dificultad, porciones, procedimiento);
        for (IngredienteReceta ir : ingredientes) {
            copia.agregarIngrediente(ir.getIngrediente(), ir.getCantidad());
        }
        for (Utensilio u : utensilios) {
            copia.agregarUtensilio(u);
        }
        for (Etiqueta e : etiquetas) {
            copia.agregarEtiqueta(e);
        }
        for (Foto f : fotos) {
            copia.agregarFoto(new Foto(f.getRuta()));
        }
        return copia;
    }
}