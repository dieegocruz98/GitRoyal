import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface InformaFecha{
    public static String asignaFecha() {
        return null;
    }
}

class Clima implements InformaFecha{
    public static String asignaFecha() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM");

        return dtf.format(LocalDateTime.now());
    }

    public static void main(String[] args) {

        System.out.println("Bienvenido al programa que le dará info del clima de Santander :)");

        String[] dias ={
                "Harán 16 grados de minima y 26 de máxima",
                "Harán 17 grados de minima y 27 de máxima",
                "Harán 19 grados de minima y 25 de máxima",
                "Harán 19 grados de minima y 24 de máxima",
                "Harán 18 grados de minima y 24 de máxima",
                "Harán 17 grados de minima y 26 de máxima",
                "Harán 18 grados de minima y 27 de máxima"};

        String fecha = asignaFecha();

        String ficheroSalida = "SALIDA_CLIMA_" + fecha +".txt";

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));

            bw.write("#######CLIMA DE SANTANDER#######\n\n");

            for(int i = 0; i< dias.length; i++){
                bw.write("Día " + (i+1) +": " + dias[i] + "\n");
            }
            bw.close();

        }catch (IOException e){
            System.err.println("No se ha podido realizar la escritura");
            System.exit(1);
        }


    }
}