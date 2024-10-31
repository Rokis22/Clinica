import java.util.LinkedList;
import java.util.Scanner;

class Paciente {
    private final String nombre;
    private final String motivoConsulta;

    public Paciente(String nombre, String motivoConsulta) {
        this.nombre = nombre;
        this.motivoConsulta = motivoConsulta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Motivo: " + motivoConsulta;
    }
}

public class Clinica {
    private final LinkedList<Paciente> filaEspera;

    public Clinica() {
        filaEspera = new LinkedList<>();
    }

    // Agregar un nuevo paciente a la fila de espera
    public void agregarPaciente(String nombre, String motivoConsulta) {
        Paciente paciente = new Paciente(nombre, motivoConsulta);
        filaEspera.addLast(paciente);
        System.out.println("Paciente agregado a la fila de espera.");
    }

    // Atender al siguiente paciente en la fila
    public void atenderPaciente() {
        if (filaEspera.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            Paciente pacienteAtendido = filaEspera.removeFirst();
            System.out.println("Atendiendo a " + pacienteAtendido.getNombre() + 
                               ", Motivo de consulta: " + pacienteAtendido.getMotivoConsulta());
        }
    }

    // Mostrar todos los pacientes en espera
    public void mostrarPacientesEnEspera() {
        if (filaEspera.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            System.out.println("Pacientes en espera:");
            for (Paciente paciente : filaEspera) {
                System.out.println(paciente);
            }
        }
    }

    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Fila de Espera de la Clínica ---");
            System.out.println("1. Agregar un nuevo paciente");
            System.out.println("2. Atender al siguiente paciente");
            System.out.println("3. Mostrar todos los pacientes en espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el motivo de consulta: ");
                    String motivoConsulta = scanner.nextLine();
                    clinica.agregarPaciente(nombre, motivoConsulta);
                    break;
                case 2:
                    clinica.atenderPaciente();
                    break;
                case 3:
                    clinica.mostrarPacientesEnEspera();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
