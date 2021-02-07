/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut07;

/**
 *
 * @author marvin
 */
public abstract class CCuenta {
    
    protected String nombreTitular;
    protected String numCuenta;
    protected double saldo;
    protected double tipoDeInteres;
    
    public CCuenta(String nombreTitular, String numCuenta, double ingreso, double tipoDeInteres) {
        this.setNombre(nombreTitular);
        this.setCuenta(numCuenta);
        this.ingreso(ingreso);
        this.setInteres(tipoDeInteres);
    }
    
    protected String getNombre() {
        return this.nombreTitular;
    }
    protected void setNombre(String nombre) {
        this.nombreTitular = nombre;
    }
    protected String getCuenta() {
        return this.numCuenta;
    }
    protected void setCuenta(String cuenta){
        this.numCuenta = cuenta;
    }
    protected double getSaldo() {
        return this.saldo;
    }
    protected abstract void comisiones();
    protected void ingreso(double cantidad) {
        this.saldo += cantidad;
    }
    protected void reintegro(double cantidad) {
        if(this.getSaldo() == 0 || this.getSaldo() < cantidad) {
            return;
        }
        this.saldo -= cantidad;
    }
    protected double getInteres() {
        return this.tipoDeInteres;
    }
    protected void setInteres(double interes) {
        this.tipoDeInteres = interes;
    }
    protected abstract void intereses();
        
}
