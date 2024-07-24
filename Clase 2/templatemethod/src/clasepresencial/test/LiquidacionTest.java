package clasepresencial.test;

import clasepresencial.impl.Liquidacion;
import clasepresencial.impl.LiquidacionContratado;
import clasepresencial.impl.LiquidacionEfectivo;
import clasepresencial.model.Contratado;
import clasepresencial.model.Efectivo;
import clasepresencial.model.Empleado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidacionTest {
    /*Dado: Un empleado efectivo, Martín Martini, con un sueldo básico de 400, un
valor fijo de descuentos de 40 y un total de 60 en premios.*/
    @Test
    @DisplayName("Debería emitir un documento en papel cuando es un empleado efectivo.")
    void caso1(){
        //Dado
        Empleado empleado = new Efectivo("Martin", "Martini", "54646",
                400, 60, 40);
        Liquidacion liquidacion = new LiquidacionEfectivo();
        String respuestaEsperada = "La liquidación generada es un documento impreso. Saldo a liquidar: 420.0";
        // cuando
        String respuestaObtenida = liquidacion.LiquidarSueldo(empleado);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Debería emitir un documento digital cuando es un empleado contratado.")
    void caso2(){
        //Dado
        Empleado empleado = new Contratado("Pompilia","Pompini", "546466", 120, 7);
        Liquidacion liquidacion = new LiquidacionContratado();
        String respuestaEsperada = "La liquidación generada es un documento digital. Saldo a liquidar: 840.0";
        // cuando
        String respuestaObtenida = liquidacion.LiquidarSueldo(empleado);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("El liquidador debería arrojar un mensaje de error cuando no es posible calcular la liquidación.")
    void caso3(){
        //Dado
        Empleado empleado = new Contratado("Pompilia","Pompini", "546466", 120, 7);
        Liquidacion liquidacion = new LiquidacionEfectivo();
        String respuestaEsperada = "La liquidación no pudo ser calculada";
        // cuando
        String respuestaObtenida = liquidacion.LiquidarSueldo(empleado);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }
}