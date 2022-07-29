import java.util.Scanner;

public class SalarioNeto {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Dígame su salario bruto:");
        double salarioBruto = s.nextDouble();
        System.out.println("Digame que porcentaje de retención tiene: ");
        int porcentajeRetencion = s.nextInt();

        double salarioNeto = salarioBruto * (1 - (porcentajeRetencion / 100d));
        System.out.println("Su salario neto es de: " + salarioNeto);


    }
}
