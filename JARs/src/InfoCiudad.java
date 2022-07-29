import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;

/*JAR4: Generar un programa que solicite por consola el ingreso de la siguiente información:
        Ciudad donde habita:
        Dimensiones de la ciudad donde habita:
        Cantidad de personas que habitan en la ciudad:
        Condiciones climaticas actuales de la ciudad donde habita:
        Realizarlo para 3 ciudades (pueden ser las ciudades de la actividad 3 si asi lo desea)
        Luego de ingresar dichos valores, mostrarlos por consola y generar un txt de salida con esta información.*/
public class InfoCiudad {
    public static void main(String[] args) throws InterruptedException {

        String[] ciudades = {"Madrid", "Nueva York", "Tokyo"};
        double[] dimensiones = {604.3, 783.8, 2194};
        double[] personas = {3.22, 8.38, 13.96};
        String[] tiempo = {"Soleado", "Lluvioso", "Soleado"};

        String archivo = "infociudades.txt";

        System.out.println("Voy a darte la información mas importante de Madrid, Nueva York y Tokyo:\n\n");

        sleep(1500);

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("####INFO GENERADA####\n\n");

            for (int i = 0; i< ciudades.length; i++){
                String info = ciudades[i] + ": se extiende " + dimensiones[i] + " km^2. Viven" +
                        " " + personas[i] + " millones de personas y hoy su tiempo sera " + tiempo[i].toLowerCase();
                System.out.println(info);
                bw.write(info + "\n");
            }
            bw.close();

        }catch (IOException e){

        }

    }
}
