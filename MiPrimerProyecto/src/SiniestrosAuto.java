/*En la ciudad de Buenos Aires suceden muchos accidentes de transito, se realizo un estudio indicando las marcas de autos mas propensas a participar de dichos accidentes, las cuales son las siguientes:
        - Audi
        - Alfa Romeo
        - Ferrari
        - Ford
        Para cada una de estas marcas, se esta realizando un analisis que nos permita
        entender cuales son los modelos que mas participaron.
        Se nos pidio desarrollar un programa que almacene y muestre lo siguiente:
        - De cada marca de autos, informar los modelos que participaron de los siniestros
        - Informar tambien la velocidad maxima de cada uno de los modelos
        DESARROLLAR un txt que muestre, ordenado alfabeticamente, las marcas y sus respectivos
        modelos y sus velocidades maximas permitidas.
        Almacenarlo en el branch de Desarrollo.
        "Los modelos son los siguientes:"
        ..
        ..
        "Su velocidad permitida es la siguiente:"
        ..
        ..*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SiniestrosAuto {

    public static void main(String[] args) {

        String nombreFichero = "marcas_modelos.txt";
        List<String> coches = new ArrayList<String>();
        List<String> modelos = new ArrayList<String>();
        List<String> velocidadesMaxima = new ArrayList<String>();


        BufferedReader br = null;
        String[] separacionLinea;
        String linea = null;

        try
        {
            br = new BufferedReader(new FileReader(nombreFichero));
            linea = br.readLine();
            while(linea != null){
                separacionLinea = linea.split("\t");
                coches.add(separacionLinea[0]);
                modelos.add(separacionLinea[1]);
                velocidadesMaxima.add(separacionLinea[2]);
                linea = br.readLine();
            }
            br.close();
        }catch(IOException e){
            System.err.println("No se ha podido leer el fichero");
            System.exit(1);
        }

        coches.remove(0);
        modelos.remove(0);
        velocidadesMaxima.remove(0);

        // Escritura en un txt

        String nombreFicheroSalida = "marcas_modelos_salida.txt";
        BufferedWriter bw = null;

        List<String> cochesOrdenados = new ArrayList<String>(coches);
        Collections.sort(cochesOrdenados);

        try{
            bw = new BufferedWriter(new FileWriter(nombreFicheroSalida));
            bw.write("Los coches ordenados alfabeticamente son:\n");
            for (String coche: cochesOrdenados){
                bw.write("\n" + coche);
            }
            bw.write("\n\nLas velocidad maximas de todos los coches son:\n");
            for (String velocidad : velocidadesMaxima){
                bw.write("\n" + velocidad + " Km/h ");
            }
            bw.close();
            System.out.println("Escritura realizada correctamente");

        }catch(IOException e){
            System.err.println("No se ha podido escribir el fichero " + nombreFicheroSalida);
            System.exit(1);
        }

    }
}
