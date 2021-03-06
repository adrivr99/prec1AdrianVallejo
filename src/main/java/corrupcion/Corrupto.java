package main.java.corrupcion;

import java.util.Arrays;
import java.util.Comparator;

public class Corrupto implements Comparable <Corrupto> {
    private String nombre;
    private String apellidos;
    private int [] millones;
    public static int contador;

    public Corrupto() {
        contador++;
    }

    public Corrupto(String nombre, String apellidos, int[] millones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.millones = millones;
        contador++;
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

    public int[] getMillones() {
        return millones;
    }

    public void setMillones(int[] millones) {
        this.millones = millones;
    }

    @Override
    public String toString() {
        return "Corrupto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", millones=" + Arrays.toString(millones) +
                '}';
    }

    // Método para calcular la suma de los millones
    public static int sumarArray(int [] array){
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    // Metodo para comparar objetos Corrupto de la lista
    @Override
    public int compareTo(Corrupto corructoN1) {
        if (this.apellidos.equalsIgnoreCase(corructoN1.apellidos)) {
            return this.nombre.compareTo(corructoN1.nombre);
        } else{
            return this.apellidos.compareTo(corructoN1.apellidos);
        }

    }
    /*public int compareTo(Corrupto corruptoN1) {
        Comparator.comparing((Corrupto c)-> corruptoN1.getApellidos())
                .thenComparing((Corrupto c) -> corruptoN1.getNombre())
                .thenComparing((Corrupto c) -> corruptoN1.getMillones().toString());

    }*/
}
