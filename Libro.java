import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class Libro {
    private int id;
    private String titulo;
    private String edicion;
    private String autor;

    // Constructor
    public Libro(int id, String titulo, String edicion, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.edicion = edicion;
        this.autor = autor;
    }

    // Método para mostrar la información del libro
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Edición: " + edicion);
        System.out.println("Autor: " + autor);
        System.out.println("-------------------------");
    }

    // Sobrescribimos equals y hashCode para evitar duplicados en el Set
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Libro)) return false;
        Libro otro = (Libro) obj;
        return this.id == otro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

 class GestionLibros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Libro> biblioteca = new LinkedHashSet<>();
        String continuar;

        do {
            System.out.println("Ingrese los datos del libro:");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpiar el salto de línea

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Edición: ");
            String edicion = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            Libro libro = new Libro(id, titulo, edicion, autor);
            boolean agregado = biblioteca.add(libro);

            if (agregado) {
                System.out.println("📚 Libro agregado correctamente.");
            } else {
                System.out.println("⚠️ Ya existe un libro con ese ID, no se agregó.");
            }

            System.out.print("¿Desea agregar otro libro? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        // Mostrar los libros
        System.out.println("\nListado de libros ingresados:");
        for (Libro libro : biblioteca) {
            libro.mostrarInformacion();
        }

        scanner.close();
    }
}
