package ProductosTienda.main;
import java.util.Scanner;
import ProductosTienda.main.models.Producto;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar la cantidad de productos
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int n = scanner.nextInt();

        float valorTotalInventario = 0;

        // 2. Usar un ciclo para registrar los productos
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Registro del Producto #" + i + " ---");

            System.out.print("Código: ");
            String codigo = scanner.next();

            System.out.print("Nombre: ");
            scanner.nextLine(); // Limpiar el buffer
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            float precio = scanner.nextFloat();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            // Crear el objeto producto
            Producto prod = new Producto(codigo, nombre, precio, cantidad);

            // 3. Mostrar información por cada producto
            System.out.println("\nInformación del producto:");
            System.out.println(prod.mostrarProducto());

            float montoProducto = prod.calcularMonto();
            System.out.println("Valor total (Precio x Cantidad): " + montoProducto);

            String estado = prod.disponible() ? "Sí" : "No";
            System.out.println("¿Está disponible?: " + estado);

            // Acumular para el total final
            valorTotalInventario += montoProducto;
        }

        // 4. Mostrar el valor total acumulado al finalizar
        System.out.println("\n========================================");
        System.out.println("VALOR TOTAL DEL INVENTARIO: " + valorTotalInventario);
        System.out.println("========================================");

        scanner.close();
    }
}

