package impl;

import model.Producto;
import model.Tarjeta;

public class FacadeDescuento implements IFacadeDescuento{
    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuentoTotal = 0;
        descuentoTotal += ApiCantidad.descuento(cantidad);
        descuentoTotal += ApiProducto.descuento(producto);
        descuentoTotal += ApiTarjeta.descuento(tarjeta);
        return descuentoTotal;
    }
}
