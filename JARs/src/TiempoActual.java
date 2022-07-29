import static java.lang.Thread.sleep;

/*JAR3: Generar un JAR que informe el estado del tiempo actual de los 10 principales estados/ciudades del mundo:
        - Rio de Janeiro
        - Buenos Aires
        - Barcelona
        - Madrid
        - Nueva York
        - Los Angeles
        - Tokyo
        - Berlin
        - Paris
        - Manchester*/
public class TiempoActual {
    public static void main(String[] args) throws InterruptedException {

        String[] ciudades = {"Rio de Janeiro", "Buenos Aires", "Barcelona",
        "Madrid", "Nueva York", "Los Angeles", "Tokyo", "Berlin", "Paris", "Manchester"};

        String[] tiempo = {"Lluvioso", "Soleado", "Nublado", "Soleado", "Lluvioso",
        "Parcialmente nublado", "Soleado", "Lluvioso", "Parcialmente nublado", "Lluvioso"};

        System.out.println("Voy a darte el tiempo en las 10 ciudades mas importantes:\nBuscando...\n");

        sleep(1500);

        for (int i = 0; i < ciudades.length; i++){
            System.out.println("El tiempo en " + ciudades[i] + " será: " + tiempo[i]);
            sleep(1000);
        }

    }
}
