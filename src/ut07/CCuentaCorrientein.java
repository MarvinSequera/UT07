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
public class CCuentaCorrientein extends CCuentaCorriente {
    public CCuentaCorrientein(String nombre, String cuenta, double ingreso, double interes) {
        super(nombre, cuenta, ingreso, interes);
    }
    public CCuentaCorrientein() {
        super("Pedro Perez", "1234test", 0.0, 0.0);
    }
    @Override
    public void intereses() {
        Calendar calendar = new GregorianCalendar();
        if(this.getSaldo() == 0 || calendar.get(Calendar.DAY_OF_MONTH) != 1){
            this.ingreso(0.0);
        }else if(this.getSaldo() <= 3000){
            this.ingreso(0.0);
        }else {
            double importeIntereses = this.getSaldo() * this.getInteres() / 100;
            super.ingreso(importeIntereses);
        }
    }
}
