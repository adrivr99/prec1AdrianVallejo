package main.java.corrupcion;

import java.util.Arrays;
import java.util.Comparator;

public class Corrupto implements Comparable <Corrupto> {
    private String nombre;
    private String apellidos;
    private char [] millones = new char[10];

    public Corrupto() {
    }

    public Corrupto(String nombre, String apellidos, char [] millones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.millones = millones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char[] getMillones() {
        return millones;
    }

    public void setMillones(char[] millones) {
        this.millones = millones;
    }

    // Método para calcular la suma de los millones
    public int sumarArray(char [] array){
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    @Override
    public String toString() {
        return "Corrupto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", millones=" + Arrays.toString(millones) +
                '}';
    }

    // Metodo para comparar objetos Corrupto de la lista
    @Override
    public int compareTo(Corrupto corructoN1) {
        if (this.apellidos == corructoN1.apellidos) {
            return this.nombre.compareTo(corructoN1.nombre);
        } else{
            return this.apellidos.compareTo(corructoN1.apellidos);
        }

    }
}
