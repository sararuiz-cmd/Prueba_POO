package CuentaBancaria.main.models;

import javax.swing.*;
import java.lang.invoke.StringConcatFactory;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double consultarSaldo(){
        return getSaldo();
    }
    public void depositar(double monto){
        if (monto<0){
            System.out.println("No se permiten saldos negativos");
        }else {
            saldo+=monto;
        }
    }
    public double retirar(double monto) {
        if (monto > saldo) {
            System.out.println("Por favor, ingrese un monto menor al saldo");
        } else {
            saldo -= monto;
        }
        return saldo;
    }


    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    public String mostrarDatos(){

        return  "Número de cuenta: "+numeroCuenta+"\n"+"Saldo: "+saldo;
    }
}
