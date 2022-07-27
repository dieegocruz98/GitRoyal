import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class BotEstadoAnimo {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        LocalDate ld = LocalDate.from(LocalDateTime.now());

        System.out.println("Bienvenido! Hoy es: " + ld + " ¿Como te llamas?");
        String nombre = s.nextLine();

        System.out.println(nombre + ", qué tal estas hoy?\n1-Triste\n2-Alegre\n3-Nervioso");
        String animo = s.nextLine().toLowerCase();
        s.close();

        String[] chistes = {"¿Cuál es el último animal que subió al arca de Noé? El del-fin.",
        "¿Cómo se dice pañuelo en japonés? Saka-moko.",
        "Un pez le pregunta a otro pez: ¿qué hace tu mamá? Este le contesta: Nada, ¿y la tuya qué hace? Nada también.",
        "¿Cuál es el colmo de Aladín? Tener mal genio."};

        Random random = new Random();

        int limite = chistes.length;
        int numChiste = random.nextInt(limite);

        switch (animo){
            case "triste":
                String chiste = chistes[numChiste];
                System.out.println(nombre + ", ahí va un chiste para que te animes:\n" + chiste);
                break;
            case "alegre":
                System.out.println("Enhorabuena! Me alegro mucho");
                break;
            case "nervioso":
                System.out.println("Tranquil@! Tu puedes con esto y más!!!");
                break;
            default:
                System.err.println("No has introducido bien tu estado de animo\nAbortando programa!!");
        }

    }
}