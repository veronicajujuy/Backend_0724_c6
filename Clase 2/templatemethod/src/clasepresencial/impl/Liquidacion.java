package clasepresencial.impl;

import clasepresencial.model.Empleado;

public abstract class Liquidacion {
    public String LiquidarSueldo(Empleado empleado){
        //1. calcular sueldo +
        double sueldo = calcularSueldo(empleado);
        if(sueldo == 0) return "La liquidación no pudo ser calculada";
        //2. imprimir comprobante +
        String comprobante = imprimirComprobante(empleado);
        //3. depositar cuenta
        depositarSueldo(empleado);

        return "La liquidación generada es un documento "+ comprobante+". Saldo a liquidar: "+ sueldo;

    }
    protected abstract double calcularSueldo(Empleado empleado);
    protected abstract String imprimirComprobante(Empleado empleado);
    private void depositarSueldo(Empleado empleado){
        System.out.println("Se deposito el sueldo del empleado "+ empleado.getApellido());
    }

}
