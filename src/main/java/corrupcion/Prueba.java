package main.java.corrupcion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static main.java.corrupcion.Corrupto.sumarArray;
import static main.java.corrupcion.Hacienda.generarTxt;
import static main.java.corrupcion.Hacienda.leerTxt;

public class Prueba {
    public static void main(String[] args) throws IOException {
        ArrayList<Corrupto> listaCorruptos = leerTxt("corruptos2021.txt");

        Collections.sort(listaCorruptos);
        listaCorruptos.forEach(System.out::println);

        System.out.println("----------------------------------");
        for (int i = 0; i < listaCorruptos.size(); i++) {
            System.out.println(listaCorruptos.get(i).getNombre() + " , total de millones: " + sumarArray(listaCorruptos.get(i).getMillones()));
        }

        // MAP
        System.out.println("----------------------------------");
        System.out.println("MAP");
        Map<String, Integer> corruptosMap = new HashMap<>();
        for (Corrupto corrupto : listaCorruptos){
            try{
                corruptosMap.put(corrupto.getNombre(), Integer.parseInt(Arrays.toString(corrupto.getMillones())));
            }catch (NumberFormatException nfe){
                System.out.println(corrupto.toString());
            }
        }

        System.out.println(corruptosMap);

        generarTxt(listaCorruptos);

        buscarCorrupto(corruptosMap);



        // Escribir JSON de corruptos
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./Corruptos.json"), listaCorruptos);

    }

    private static int buscarCorrupto(Map<String, Integer> corruptosMap) {
        Scanner teclado = new Scanner(System.in);
        boolean corruptoTrue = false;
        do{
            System.out.println("Introduce el nombre de un corrupto:");
            String corrupto = teclado.next();
            for (int i = 0; i < corruptosMap.size(); i++) {
                if (corruptosMap.containsKey(corrupto)) {
                    System.out.println(corruptosMap.get(i).toString());
                    corruptoTrue = true;
                } else {
                    System.out.println("Corrupto no reconocido");
                    corruptoTrue = false;
                }
            }

        }while(!corruptoTrue);

        return 0;
    }
}
