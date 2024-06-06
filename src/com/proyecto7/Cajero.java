package com.proyecto7;

public class Cajero {
    private CuentaBanco cuentaBanco;

    public Cajero(CuentaBanco cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public synchronized void  verSaldo(){
        System.out.println(cuentaBanco.getNombreCuenta() + ", Tu saldo es de: " + cuentaBanco.getSaldoCuenta());
    }
    public synchronized void depositar(double cantidad){
        cuentaBanco.setSaldoCuenta(cuentaBanco.getSaldoCuenta() + cantidad);
        verSaldo();
    }
    public synchronized void retirar(double cantidad){
        if (cantidad > cuentaBanco.getSaldoCuenta()){
            System.out.println("Saldo insuficiente.");
        }else {
            cuentaBanco.setSaldoCuenta(cuentaBanco.getSaldoCuenta() - cantidad);
            verSaldo();
        }
    }
    public synchronized void transferir(CuentaBanco cuentaBanco ,double cantidad){
        if (cuentaBanco.getSaldoCuenta() >= cantidad){
            retirar(cantidad);
            cuentaBanco.setSaldoCuenta(cuentaBanco.getSaldoCuenta() + cantidad);
        }else {
            System.out.println("Saldo insuficiente. No se puede transferir");
        }
    }

}
