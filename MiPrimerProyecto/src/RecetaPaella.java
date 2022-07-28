//CONSIGNA:
// Desarrollar un programa que genere N txts de salida conteniendo la siguiente información:
// Un TXT que informe los ingredientes que son los siguientes:
//Arroz bomba
//1500 g
//Pollo de corral 1
//Conejo 0.5
//Judía verde plana 500 g
//Garrofó 500 g
//Alcachofa (opcional) 500 g
//Aceite de oliva virgen extra
//Pimentón dulce
//Tomate triturado
//Azafrán
//Romero fresco
//Sal
//Otro TXT que genere las instrucciones:
// Dificultad: Media
// Tiempo total 1 h 25 m
// Elaboración 10 m
// Cocción 1 h 15 m
// Reposo 5 m
// Estructura del programa:
// Una clase de Ingredientes
// Una clase de preparacion
// Una interfaz que implemente el metodo abstracto generaSalida
//Una vez generado el archivo txt subirlo a traves de la consola a nuestro repositorio remoto de GitHub
// Entregables:
// Captura del CMD (consola)
// LINK del Repositorio

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Ingredientes{
    int arrozGramos;
    float polloUds;
    float conejoUds;
    int judiaverdeGramos;
    int garrofoGramos;
    int alcachofaGramos;
    String restoIngredientes = "Aceite oliva virgen extra, pimentón dulce, tomate triturado, azafran," +
            " romero y sal al gusto";

}

class Preparacion extends Ingredientes{
    String dificultad;
    String tiempoTotal;
    String elaboracion;
    String coccion;
    String reposo;
}

class Paella extends Preparacion{

}


public class RecetaPaella {

    public static void generaSalida(Paella paella, StringBuilder ingredientesArchivo,
                                    StringBuilder preparacionArchivo){
        try{
            BufferedWriter ingredientesSalida = new BufferedWriter(new FileWriter(ingredientesArchivo.toString()));
            ingredientesSalida.write("//////////// INGREDIENTES PAELLA ////////////\n" +
                    "\nArroz bomba: " + paella.arrozGramos + " g" +
            "\nPollo de corral: " + paella.polloUds + " unidades"+ "" +
                    "\nConejo: " + paella.conejoUds + " unidades" +
                    "\nJudía verde plana: " + paella.judiaverdeGramos + " gramos" +
                    "\nGarrofó: " + paella.garrofoGramos + " gramos" +
                    "\n" + paella.restoIngredientes);
            ingredientesSalida.close();

            BufferedWriter preparacionSalida = new BufferedWriter(new FileWriter(preparacionArchivo.toString()));
            preparacionSalida.write("//////////// PREPARACIÓN PAELLA ////////////\n" +
                    "\nDificultad: " + paella.dificultad +
                    "\nTiempo total: " + paella.tiempoTotal +
                    "\nTiempo de elaboración: " + paella.elaboracion +
                    "\nTiempo de cocción: " + paella.coccion +
                    "\nTiempo de reposo: " + paella.reposo);
            preparacionSalida.close();



        }catch(IOException e){
            System.err.println("Ha habido un error en la escritura del archivo");
            System.exit(1);
        }
        
        System.out.println("Escritura realizada correctamente!");

    }

    public static void main(String[] args) {

        Paella paella = new Paella();

        paella.arrozGramos = 1500;
        paella.polloUds = 1;
        paella.judiaverdeGramos = 500;
        paella.garrofoGramos = 500;
        paella.alcachofaGramos = 500;

        paella.dificultad = "Media";
        paella.tiempoTotal = "1h y 25 mins";
        paella.elaboracion = "10 mins";
        paella.coccion = "1h y 25 mins";
        paella.reposo = "5 mins";


        StringBuilder ingredientesArchivo;
        JOptionPane.showMessageDialog(null,"Bienvenido al programa de generación de la receta de la Paella Valenciana");
        ingredientesArchivo = new StringBuilder(JOptionPane.showInputDialog(null, "Digame el nombre del archivo en el que quiere guardar los ingredientes:"));
        ingredientesArchivo.append(".txt");

        StringBuilder preparacionArchivo;
        preparacionArchivo = new StringBuilder(JOptionPane.showInputDialog(null, "Digame el nombre del archivo en el que quiere guardar la preparación de la receta:"));
        preparacionArchivo.append(".txt");



        generaSalida(paella, ingredientesArchivo, preparacionArchivo);
        




    }
}