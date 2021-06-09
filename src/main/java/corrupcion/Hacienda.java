package main.java.corrupcion;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hacienda {
    public static ArrayList<Corrupto> leerTxt() {
        ArrayList<Corrupto> lista = new ArrayList<>();
        String ruta = "./corruptos2021.txt";
        String linea;
        String[] tokens;
        try (Scanner datosFichero = new Scanner(new FileReader(ruta))) {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine(); //Se lee la línea
                tokens = linea.split(",");
                Corrupto objetoCorrupto = new Corrupto();
                objetoCorrupto.setApellidos(tokens[0]);
                objetoCorrupto.setNombre(tokens[1]);
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                objetoCorrupto.setMillones(tokens[Integer.parseInt(linea)].toCharArray());
                /*array[0] = (char) Integer.parseInt(tokens[0]);
                array[1] = (char) Integer.parseInt(tokens[1]);
                array[2] = (char) Integer.parseInt(tokens[2]);
                array[3] = (char) Integer.parseInt(tokens[3]);
                array[4] = (char) Integer.parseInt(tokens[4]);
                array[5] = (char) Integer.parseInt(tokens[5]);
                array[6] = (char) Integer.parseInt(tokens[6]);
                array[7] = (char) Integer.parseInt(tokens[7]);
                array[8] = (char) Integer.parseInt(tokens[8]);
                array[9] = (char) Integer.parseInt(tokens[9]);*/
                lista.add(objetoCorrupto);
            }
            return lista;
        } catch (FileNotFoundException e) {
            return lista;
        }
    }

    public static void generarTxt(ArrayList<Corrupto> corruptos) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter("corruptos.txt", true))) {

            //flujo.write sirve para escribir en el fichero
            flujo.write(String.valueOf(corruptos));
            //flujo.newLine sirve para pasar a la siguiente linea
            flujo.newLine();
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }

    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta+"/corruptos.txt");
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

}
