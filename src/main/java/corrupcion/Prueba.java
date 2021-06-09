package main.java.corrupcion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static main.java.corrupcion.Hacienda.leerTxt;

public class Prueba {
    public static void main(String[] args) throws IOException {
        ArrayList<Corrupto> listaCorruptos = new ArrayList<>();
        //System.out.println(leerTxt().toString());


        // Escribir JSON de corruptos
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./Corruptos.json"), generarCorrupto(listaCorruptos));

    }

    public static ArrayList<Corrupto> generarCorrupto(ArrayList<Corrupto> listaCorruptos) {
        ArrayList<Corrupto> lista = new ArrayList<>();
        lista.addAll(listaCorruptos);
        return lista;
    }
}
