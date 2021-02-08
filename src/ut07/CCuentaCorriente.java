/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut07;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author marvin
 */
public class CCuentaCorriente extends CCuenta {
    protected int transacciones;
    protected double importePorTrans;
    protected int transExentas;
    
    public CCuentaCorriente(String nombre, String cuenta, double ingreso, double interes) {
        super(nombre, cuenta, ingreso, interes);
    }
    public double getImportePorTrans() {
        return this.importePorTrans;
    }
    public void setImportePorTrans(double importe) {
        this.importePorTrans = importe;
    }
    public void resetTransacciones() {
        this.transacciones = 0;
    }
    public void incrementarTransacciones() {
        if(this.getTransExentas() == 0) {
            this.transacciones ++;
        }
    }
    public int getTransacciones() {
        return this.transacciones;
    }
    public void decrementarTransacciones() {
        this.transacciones --;
    }
    public void setTransExentas(int exentas) {
        this.transExentas = exentas;
    }
    public int getTransExentas() {
        return this.transExentas;
    }
    public void decreseTransExentas() {
        if(this.getTransExentas() > 0){
            this.transExentas --;
        }
    }
    @Override
    public void ingreso(double cantidad) {
        super.ingreso(cantidad);
        this.incrementarTransacciones();
    }
    @Override
    public void reintegro(double cantidad) {
        super.reintegro(cantidad);
        this.incrementarTransacciones();
    }

    @Override
    public void comisiones() {
        Calendar calendar = new GregorianCalendar();
        if(this.getSaldo() == 0 || calendar.get(Calendar.DAY_OF_MONTH) != 1){
            this.reintegro(0.0);
        }else if(this.getTransExentas() >= this.getTransacciones()){
            int leftTranacciones = this.getTransExentas() - this.getTransacciones();
            this.setTransExentas(leftTranacciones);
        }else {
            double totalComisiones = this.importePorTrans * this.transacciones;
            this.reintegro(totalComisiones);
            this.resetTransacciones();
        }
    }
    @Override
    public void intereses() {
        Calendar calendar = new GregorianCalendar();
        if(this.getSaldo() == 0 || calendar.get(Calendar.DAY_OF_MONTH) != 1){
            this.ingreso(0.0);
        }else if(this.getSaldo() <= 3000){
            this.setInteres(0.5);
            double importeIntereses = this.getSaldo() * this.getInteres() / 100;
            super.ingreso(importeIntereses);
        }else {
            double importeIntereses = this.getSaldo() * this.getInteres() / 100;
            super.ingreso(importeIntereses);
        }
    }
    
}