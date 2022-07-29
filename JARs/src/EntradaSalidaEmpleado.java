import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;

interface EgresoIngreso{
    public void ingresar();
    public void salir();
}
class Persona{
    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

class Empleado extends Persona implements EgresoIngreso{
    int ID = 0;
    String password;

    String horaEntrada;
    String horaSalida;

    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM HH:mm:ss");

    public Empleado() {
        setID(++ID);
        password = "ABc" + (ID*2);
    }
    public Empleado(String nombre, int edad) {
        setID(++ID);
        password = "ABc" + (ID*2);
        setNombre(nombre);
        setEdad(edad);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void ingresar() {
        horaEntrada = dtf.format(LocalDateTime.now());
    }

    @Override
    public void salir() {
        horaSalida = horaEntrada = dtf.format(LocalDateTime.now());
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }
}

public class EntradaSalidaEmpleado {

    public static void imprimirInfoEmpleado(Empleado emp){
        System.out.println("\n" + emp.getNombre() + " con ID: " + emp.getID() + " Ha entrado hoy" +
                " a la siguiente hora: " + emp.getHoraEntrada() + " y ha salido a la siguiente: " + emp.getHoraSalida());
    }

    public static void main(String[] args) throws InterruptedException {

        Empleado emp1 = new Empleado();
        emp1.setNombre("Pepe");
        emp1.setEdad(28);

        Empleado emp2 = new Empleado("Juan", 52);

        Empleado emp3 = new Empleado("Lucia", 32);

        Empleado emp4 = new Empleado("Ramiro", 49);

        Empleado emp5 = new Empleado();
        emp5.setNombre("Diego");
        emp1.setEdad(24);

        //Vamos a registrar la hora de entrada
        System.out.println("Vamos a registrar la hora de entrada");

        emp1.ingresar();
        emp2.ingresar();
        emp3.ingresar();
        emp4.ingresar();
        emp5.ingresar();

        //Para hacerlo mas realista vamos a hacer que no salgan de golpe con un sleep
        System.out.println("Para hacerlo mas realista vamos a hacer que no salgan de golpe con un sleep");

        sleep(1000);

        emp3.salir();
        sleep(1000);
        emp1.salir();
        sleep(1000);
        emp2.salir();
        emp4.salir();
        sleep(2000);
        emp5.salir();

        //Imprimimos su info
        System.out.println("Imprimimos su info:");
        imprimirInfoEmpleado(emp1);
        imprimirInfoEmpleado(emp2);
        imprimirInfoEmpleado(emp3);
        imprimirInfoEmpleado(emp4);
        imprimirInfoEmpleado(emp5);

    }
}
