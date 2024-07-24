package clasepresencial.impl;

import clasepresencial.model.Efectivo;
import clasepresencial.model.Empleado;

public class LiquidacionEfectivo extends Liquidacion{
    @Override
    protected double calcularSueldo(Empleado empleado) { // Efectivo o Contratado
       if(empleado instanceof Efectivo){
           // casteo
           Efectivo empleadoEfectivo = (Efectivo) empleado;
           return empleadoEfectivo.getSueldoBasico() + empleadoEfectivo.getPremios() - empleadoEfectivo.getDescuento();
       } else return 0;
    }

    @Override
    protected String imprimirComprobante(Empleado empleado) {
        return "impreso";
    }
}
