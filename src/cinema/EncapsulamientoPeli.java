/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author Axel
 */
public class EncapsulamientoPeli {
    private int id_2;
    private int id;
    private String nombre;
    private String Fecha;
    private String sinopsis;
    private int Genero_ID;
    private int Clasificacion_ID;
    private String Genero;
    private String Clasificacion;
    private int costo;
    private String duracion;
     EncapsulamientoPeli(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getGenero_ID() {
        return Genero_ID;
    }

    public void setGenero_ID(int Genero_ID) {
        this.Genero_ID = Genero_ID;
    }

    public int getClasificacion_ID() {
        return Clasificacion_ID;
    }

    public void setClasificacion_ID(int Clasificacion_ID) {
        this.Clasificacion_ID = Clasificacion_ID;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public int getId_2() {
        return id_2;
    }

    public void setId_2(int id_2) {
        this.id_2 = id_2;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
     
     
     
     
}
