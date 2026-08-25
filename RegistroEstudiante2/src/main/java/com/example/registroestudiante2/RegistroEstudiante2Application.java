package com.example.registroestudiante2;

import com.example.registroestudiante2.model.Estudiante;
import com.example.registroestudiante2.service.EstudianteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RegistroEstudiante2Application implements CommandLineRunner {

    private final EstudianteService estudianteService;

    public RegistroEstudiante2Application(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistroEstudiante2Application.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("     REGISTRO DE ESTUDIANTES");
            System.out.println("=================================");
            System.out.println("1. Ver estudiantes");
            System.out.println("2. Agregar estudiante");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    verEstudiantes();
                    break;

                case 2:
                    agregarEstudiante(scanner);
                    break;

                case 3:
                    buscarEstudiantePorId(scanner);
                    break;

                case 4:
                    eliminarEstudiante(scanner);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    // ==============================
    // VER ESTUDIANTES
    // ==============================

    private void verEstudiantes() {

        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();

        System.out.println();
        System.out.println("========== ESTUDIANTES ==========");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : estudiantes) {

            System.out.println("---------------------------------");
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Apellido: " + estudiante.getApellido());
            System.out.println("Carrera: " + estudiante.getCarrera());
            System.out.println("Correo: " + estudiante.getCorreo());
        }

        System.out.println("---------------------------------");
    }

    // ==============================
    // AGREGAR ESTUDIANTE
    // ==============================

    private void agregarEstudiante(Scanner scanner) {

        System.out.println();
        System.out.println("======= AGREGAR ESTUDIANTE =======");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        Estudiante estudiante = new Estudiante(
                nombre,
                apellido,
                carrera,
                correo
        );

        estudianteService.agregarEstudiante(estudiante);

        System.out.println();
        System.out.println("Estudiante agregado correctamente.");
    }

    // ==============================
    // BUSCAR ESTUDIANTE POR ID
    // ==============================

    private void buscarEstudiantePorId(Scanner scanner) {

        System.out.println();
        System.out.println("======= BUSCAR ESTUDIANTE =======");

        System.out.print("Ingrese el ID del estudiante: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Estudiante estudiante = estudianteService.buscarEstudiantePorId(id);

        if (estudiante == null) {
            System.out.println("No existe un estudiante con ese ID.");
            return;
        }

        System.out.println();
        System.out.println("======= ESTUDIANTE ENCONTRADO =======");
        System.out.println("-------------------------------------");
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Apellido: " + estudiante.getApellido());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println("Correo: " + estudiante.getCorreo());
        System.out.println("-------------------------------------");
    }

    // ==============================
    // ELIMINAR ESTUDIANTE
    // ==============================

    private void eliminarEstudiante(Scanner scanner) {

        System.out.println();
        System.out.println("======= ELIMINAR ESTUDIANTE =======");

        System.out.print("Ingrese el ID del estudiante: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Estudiante estudiante = estudianteService.buscarEstudiantePorId(id);

        if (estudiante == null) {
            System.out.println("No existe un estudiante con ese ID.");
            return;
        }

        estudianteService.eliminarEstudiante(id);

        System.out.println("Estudiante eliminado correctamente.");
    }
}