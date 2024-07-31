package impl;

import model.Producto;
import model.Tarjeta;

public class FacadeDescuento2 implements IFacadeDescuento{
    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        return 0;
    }
}
