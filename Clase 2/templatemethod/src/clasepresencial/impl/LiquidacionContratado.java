package clasepresencial.impl;

import clasepresencial.model.Contratado;
import clasepresencial.model.Efectivo;
import clasepresencial.model.Empleado;

public class LiquidacionContratado extends Liquidacion{
    @Override
    protected double calcularSueldo(Empleado empleado) { // Efectivo o Contratado
        if(empleado instanceof Contratado){
            // casteo
            Contratado empleadoContratado = (Contratado) empleado;
            return empleadoContratado.getCantHoras() * empleadoContratado.getTarifaPorHora();
        } else return 0;
    }

    @Override
    protected String imprimirComprobante(Empleado empleado) {
        return "digital";
    }
}
