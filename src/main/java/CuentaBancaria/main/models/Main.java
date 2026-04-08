package CuentaBancaria.main.models;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String identificacion;
        String nombres;
        String apellidos;
        String numeroCuenta;
        double saldoInicial = 0;
        int opcion;
        double monto;
        identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        nombres = JOptionPane.showInputDialog("Ingrese los nombres del cliente:");
        apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
        Cliente cliente = new Cliente(identificacion, nombres, apellidos);
        numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        while (true) {
            try {
                saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));
                if (saldoInicial < 0) {
                    JOptionPane.showMessageDialog(null, "No se permite un saldo inicial negativo");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
            }
        }
        Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial);
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "=== MENÚ CUENTA BANCARIA ===\n" +
                                "Cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + "\n" +
                                "1. Consultar saldo\n" +
                                "2. Depositar dinero\n" +
                                "3. Retirar dinero\n" +
                                "4. Salir\n\n" +
                                "Seleccione una opción:"
                ));
                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Saldo actual: C$ " + cuenta.consultarSaldo());
                        break;
                    case 2:
                        try {
                            monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
                            if (monto <= 0) {
                                JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0");
                            } else {
                                cuenta.depositar(monto);
                                JOptionPane.showMessageDialog(null,
                                        "Depósito realizado con éxito\nSaldo actual: C$ " + cuenta.consultarSaldo());
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un monto válido");
                        }
                        break;
                    case 3:
                        try {
                            monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                            if (monto <= 0) {
                                JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0");
                            } else if (monto > cuenta.consultarSaldo()) {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                            } else {
                                cuenta.retirar(monto);
                                JOptionPane.showMessageDialog(null,
                                        "Retiro realizado con éxito\nSaldo actual: C$ " + cuenta.consultarSaldo());
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un monto válido");
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema bancario");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                opcion = 0;
            }
        } while (opcion != 4);
    }
}