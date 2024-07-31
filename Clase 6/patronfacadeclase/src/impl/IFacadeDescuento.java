package impl;

import model.Producto;
import model.Tarjeta;

public interface IFacadeDescuento {
    int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad);
}
