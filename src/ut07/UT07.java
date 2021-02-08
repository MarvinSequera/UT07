/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut07;

import java.io.IOException;

/**
 *
 * @author marvin
 */
public class UT07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        CCuentaAhorro cliente01 = new CCuentaAhorro("Angel Lillo", "111/6666", 10000, 3.5, 30);

 

        System.out.println(cliente01.getNombre());

        System.out.println(cliente01.getCuenta());

        System.out.println(cliente01.getSaldo());

        System.out.println(cliente01.getInteres());

        System.out.println(cliente01.getInteres());

 

        CCuentaCorrientein cliente02 = new CCuentaCorrientein();

        cliente02.setNombre("Ainhoa");

        cliente02.setCuenta("1234567890");

        cliente02.setInteres(3.0);

        cliente02.setTransExentas(0);

        cliente02.setImportePorTrans(1.0);

 

        cliente02.ingreso(20000);

        cliente02.reintegro(10000);

        cliente02.intereses();

        cliente02.comisiones();

        System.out.println(cliente02.getNombre());

        System.out.println(cliente02.getCuenta());

        System.out.println(cliente02.getSaldo());
    }
    
}
