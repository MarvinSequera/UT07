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
public class CCuentaAhorro extends CCuenta{
    protected double cuotaMan;
    
    public CCuentaAhorro(String nombreTitular, String numCuenta, double ingreso, double tipoDeInteres) {
        this.setNombre(nombreTitular);
        this.setCuenta(numCuenta);
        this.ingreso(ingreso);
        this.setInteres(tipoDeInteres);
    }
    public double getCoutaMan() {
        return this.cuotaMan;
    }
    public void setCoutaMan(double cuota) {
        this.cuotaMan = cuota;
    }
    @Override
    public void comisiones() {
        Calendar calendar = new GregorianCalendar();
        if(this.getSaldo() <= 0 || calendar.get(Calendar.DAY_OF_MONTH) != 1) {
            this.reintegro(0.0);
        }else if(this.getSaldo() > 0 && this.getSaldo() < this.getCoutaMan()) {
            this.reintegro(this.getSaldo());
        }else {
            this.reintegro(this.getCoutaMan());
        }
    }
    @Override
    public void intereses() {
        Calendar calendar = new GregorianCalendar();
        if(calendar.get(Calendar.DAY_OF_MONTH) != 1 || this.getSaldo() <= 0) {
            this.ingreso(0.0);
        }
        double importeIntereses = this.getInteres() * this.getSaldo() / 100;
        
        this.ingreso(importeIntereses);
    }
}