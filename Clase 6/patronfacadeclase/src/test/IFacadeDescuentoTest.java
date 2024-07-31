package test;

import impl.FacadeDescuento;
import impl.FacadeDescuento2;
import impl.IFacadeDescuento;
import model.Producto;
import model.Tarjeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeDescuentoTest {

    @Test
    @DisplayName("Testear si se aplican todos los descuentos")
    void caso1(){
        //dado
        Tarjeta tarjeta = new Tarjeta("4567", "Star Bank");
        Producto producto = new Producto("Pepsi", "latas");
        int cantidad = 15;
        //FacadeDescuento facadeDescuento = new FacadeDescuento();
        IFacadeDescuento facadeDescuento = new FacadeDescuento2();
        //cuando
        int descuentosAcumulados = facadeDescuento.calcularDescuento(tarjeta, producto, cantidad);
        //entonces
        assertEquals(45, descuentosAcumulados);
    }

    @Test
    @DisplayName("Testear si no se aplica ningun descuentos")
    void caso2(){
        //dado
        Tarjeta tarjeta = new Tarjeta("8974", "Macro");
        Producto producto = new Producto("Doritos", "paquetes");
        int cantidad = 3;
        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        //cuando
        int descuentosAcumulados = facadeDescuento.calcularDescuento(tarjeta, producto, cantidad);
        //entonces
        assertEquals(0, descuentosAcumulados);
    }

}