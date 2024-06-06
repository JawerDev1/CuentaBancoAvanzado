package com.proyecto7;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        CuentaBanco  cuentaBanco1 = new CuentaBanco();
        cuentaBanco1.setNombreCuenta("Jawer");
        cuentaBanco1.setSaldoCuenta(5000);


        CuentaBanco cuentaBanco2 = new CuentaBanco();
        cuentaBanco2.setNombreCuenta("Andres");
        cuentaBanco2.setSaldoCuenta(2000);

        Cajero cajero = new Cajero(cuentaBanco1);
        System.out.println("Bienvenido, "+ cuentaBanco1.getNombreCuenta());
        System.out.println("Ingresa la opcion que necesitar realizar (0 para finalizar el programa): ");
        System.out.println("0. Salir");
        System.out.println("1. Ver el dinero de la cuenta de: " + cuentaBanco1.getNombreCuenta());
        System.out.println("2. Depositar dinero a la cuenta de: " + cuentaBanco1.getNombreCuenta());
        System.out.println("3. Retirar dinero de la cuenta de: " + cuentaBanco1.getNombreCuenta());
        System.out.println("4. Transferir dinero");

        while (true){
            int input = sc.nextInt();
            switch (input){
                case 0:
                    System.out.println("Adios. Gracias por utilizar nuestros servicios!");
                    System.exit(0);
                case 1:
                    cajero.verSaldo();
                    System.out.println("Ingresa otra opcion: ");
                    break;
                case 2:
                    System.out.println(cuentaBanco1.getNombreCuenta() + ", ¿Cuanto dinero deseas depositar? ");
                    double depositar = sc.nextDouble();
                    cajero.depositar(depositar);
                    System.out.println("Ingresa otra opcion: ");
                    break;
                case 3:
                    System.out.println(cuentaBanco1.getNombreCuenta() + ", ¿Cuanto dinero deseas retirar? ");
                    double retirar = sc.nextDouble();
                    cajero.retirar(retirar);
                    System.out.println("Ingresa otra opcion: ");
                    break;
                case 4:
                    Thread hilo1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Ingresa la cantidad que deseas tranferir a la cuenta de: " + cuentaBanco2.getNombreCuenta());
                            double dinero = sc.nextInt();
                            sc.nextLine();
                            cajero.transferir(cuentaBanco2, dinero);
                            System.out.println("Transferencia exitosa de: " + dinero + " transferidos desde la cuenta de " +
                                    cuentaBanco1.getNombreCuenta() + " a la cuenta de: " + cuentaBanco2.getNombreCuenta());
                            System.out.println(cuentaBanco2.getNombreCuenta() + ", Tu saldo es de: " + cuentaBanco2.getSaldoCuenta());
                        }
                    });
                    hilo1.start();
                    try{
                        hilo1.join();
                    }catch (InterruptedException e){
                        e.getStackTrace();
                    }
                    System.out.println("Ingresa otra opcion: ");
                    break;
                default:
                    System.out.println("Error, ingresa nuevamente otra opcion: ");
                    break;
            }
        }

    }
}
