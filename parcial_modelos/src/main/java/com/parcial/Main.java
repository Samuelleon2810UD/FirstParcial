package com.parcial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.parcial.Aditionals.Exam;
import com.parcial.Aditionals.SickPerson;
import com.parcial.Observer.BacteorologyBossMedObserver;
import com.parcial.Observer.EnfermBossMedObserver;
import com.parcial.Observer.IntesivistMedObserver;
import com.parcial.Observer.Observer;
import com.parcial.Subject.HCU;

public class Main {

    private static final HCU hcu = new HCU();
    private static final Map<String, Observer> vistasDisponibles = new LinkedHashMap<>();
    private static final List<String> vistasActivas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<SickPerson> pacientesSistema = generarPacientesAleatorios();

    public static void main(String[] args) {
        inicializarVistas();
        hcu.setMeasurements(pacientesSistema);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    listarEstadoVistas();
                    break;
                case 2:
                    agregarVista();
                    break;
                case 3:
                    quitarVista();
                    break;
                case 4:
                    mostrarPacientesSistema();
                    break;
                case 5:
                    mostrarVistaSeleccionada();
                    break;
                case 6:
                    mostrarVistasActivas();
                    break;
                case 0:
                    System.out.println("Cerrando el sistema de monitoreo. ¡Hasta luego!");
                    break;
                default:
                    System.out.println(">> Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void inicializarVistas() {
        vistasDisponibles.put("Jefe de Enfermeria", new EnfermBossMedObserver("Andrés Suárez", pacientesSistema));
        vistasDisponibles.put("Jefe de Bacteorologia", new BacteorologyBossMedObserver("Marta Gómez", pacientesSistema));
        vistasDisponibles.put("Medico Intensivista", new IntesivistMedObserver("Elena Ramos", pacientesSistema));
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU - MONITOREO DE PACIENTES =====");
        System.out.println("1. Ver estado de todas las vistas (activas/inactivas)");
        System.out.println("2. Activar una vista");
        System.out.println("3. Desactivar una vista");
        System.out.println("4. Mostrar pacientes del sistema");
        System.out.println("5. Mostrar la vista de un médico seleccionado");
        System.out.println("6. Mostrar el contenido de las vistas activas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void listarEstadoVistas() {
        System.out.println("\n--- Estado de las vistas ---");
        int i = 1;
        for (String nombre : vistasDisponibles.keySet()) {
            String estado = vistasActivas.contains(nombre) ? "ACTIVA" : "inactiva";
            System.out.println(i + ". " + nombre + " [" + estado + "]");
            i++;
        }
    }

    private static void agregarVista() {
        listarEstadoVistas();
        System.out.print("Escriba el nombre exacto de la vista a activar: ");
        String nombre = scanner.nextLine().trim();

        Observer obs = vistasDisponibles.get(nombre);
        if (obs == null) {
            System.out.println(">> Esa vista no existe en el catalogo.");
            return;
        }
        if (vistasActivas.contains(nombre)) {
            System.out.println(">> Esa vista ya se encuentra activa.");
            return;
        }

        hcu.registerObserver(obs);
        vistasActivas.add(nombre);
        hcu.notifyObservers();
        System.out.println(">> Vista '" + nombre + "' agregada y suscrita a las notificaciones.");
    }

    private static void quitarVista() {
        listarEstadoVistas();
        System.out.print("Escriba el nombre exacto de la vista a desactivar: ");
        String nombre = scanner.nextLine().trim();

        Observer obs = vistasDisponibles.get(nombre);
        if (obs == null) {
            System.out.println(">> Esa vista no existe en el catalogo.");
            return;
        }
        if (!vistasActivas.contains(nombre)) {
            System.out.println(">> Esa vista no esta activa actualmente.");
            return;
        }

        hcu.removeObserver(obs);
        vistasActivas.remove(nombre);
        hcu.notifyObservers();
        System.out.println(">> Vista '" + nombre + "' removida correctamente.");
    }

    private static void mostrarPacientesSistema() {
        System.out.println("\n--- Pacientes del sistema ---");
        if (pacientesSistema.isEmpty()) {
            System.out.println(">> No hay pacientes registrados.");
            return;
        }

        for (SickPerson paciente : pacientesSistema) {
            paciente.showSickPerson();
            System.out.println("--------------------");
        }
    }

    private static List<SickPerson> generarPacientesAleatorios() {
        List<String> nombres = Arrays.asList(
            "Ana Gómez", "Luis Pérez", "María Torres", "Carlos Ruiz",
            "Sofía Díaz", "Mateo López", "Valeria Silva", "Daniel Castro",
            "Camila Rojas", "Javier Moreno"
        );

        List<String> prioridades = Arrays.asList(
            "Urgente", "Alta", "Media", "Baja"
        );

        Random random = new Random();
        List<SickPerson> pacientes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SickPerson paciente = new SickPerson();
            String nombre = nombres.get(random.nextInt(nombres.size()));
            String prioridad = prioridades.get(random.nextInt(prioridades.size()));

            paciente.setName(nombre);
            paciente.setAge(18 + random.nextInt(60));
            paciente.setOxigenSaturation(80 + random.nextFloat() * 20);
            paciente.setArterialPressure(70 + random.nextFloat() * 50);
            paciente.setAtentionPriority(prioridad);
            paciente.setExams(Arrays.asList(
                new Exam("Hemograma", "Revisión general de sangre", nombre, prioridad),
                new Exam("Rayos X", "Evaluación torácica", nombre, prioridad),
                new Exam("Electrocardiograma", "Control cardiaco", nombre, prioridad)
            ));

            pacientes.add(paciente);
        }

        return pacientes;
    }

    public static List<SickPerson> getSickPersons() {
        return pacientesSistema;
    }

    private static void mostrarVistaSeleccionada() {
        if (vistasActivas.isEmpty()) {
            System.out.println(">> No hay vistas activas actualmente. Use la opcion 2 para agregar una.");
            return;
        }

        listarEstadoVistas();
        System.out.print("Escriba el nombre exacto del medico cuya vista desea ver: ");
        String nombre = scanner.nextLine().trim();

        if (!vistasActivas.contains(nombre)) {
            System.out.println(">> La vista seleccionada no está activa en este momento.");
            return;
        }

        Observer obs = vistasDisponibles.get(nombre);
        if (obs != null) {
            obs.UpdateDisplay(pacientesSistema);
        } else {
            System.out.println(">> Esa vista no existe.");
        }
    }

    private static void mostrarVistasActivas() {
        if (vistasActivas.isEmpty()) {
            System.out.println(">> No hay vistas activas actualmente. Use la opcion 2 para agregar una.");
            return;
        }

        System.out.println("\n--- Contenido de las vistas activas ---");
        for (String nombre : vistasActivas) {
            Observer obs = vistasDisponibles.get(nombre);
            if (obs != null) {
                obs.UpdateDisplay(pacientesSistema);
            }
        }
    }
}