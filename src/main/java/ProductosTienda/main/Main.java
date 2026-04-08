package ProductosTienda.main;
import java.util.Scanner;
import ProductosTienda.main.models.Producto;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        do {
            System.out.print("Ingrese la cantidad de productos a registrar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while  (n <= 0);
        float valorTotalInventario = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Registro del Producto #" + i + " ---");
            String codigo;
            do {
                System.out.print("Código: ");
                codigo = scanner.next();
            } while (codigo.trim().isEmpty());

            System.out.print("Nombre: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();

            float precio = -1;
            do {
                System.out.print("Precio: ");
                while (!scanner.hasNextFloat()) {
                    System.out.println("Error: Ingrese un precio válido.");
                    scanner.next();
                }
                precio = scanner.nextFloat();
                if (precio < 0) System.out.println("El precio no puede ser negativo.");
            } while (precio < 0);


            int cantidad = -1;
            do {
                System.out.print("Cantidad en stock: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: Ingrese un número entero.");
                    scanner.next();
                }
                cantidad = scanner.nextInt();
                if (cantidad < 0) System.out.println("La cantidad no puede ser negativa.");
            } while (cantidad < 0);

            Producto prod = new Producto(codigo, nombre, precio, cantidad);

            System.out.println("\nInformación del producto:");
            System.out.println(prod.mostrarProducto());

            float montoProducto = prod.calcularMonto();
            System.out.println("Valor total (Precio x Cantidad): " + montoProducto);

            String estado = prod.disponible() ? "Sí" : "No";
            System.out.println("¿Está disponible?: " + estado);

            valorTotalInventario += montoProducto;
        }

        System.out.println("\n");
        System.out.println("VALOR TOTAL DEL INVENTARIO: " + valorTotalInventario);
        System.out.println("");

        scanner.close();
    }

}

