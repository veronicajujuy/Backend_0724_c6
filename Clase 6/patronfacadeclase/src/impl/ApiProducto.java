package impl;

import model.Producto;
import model.Tarjeta;

public class ApiProducto {
    public static int descuento(Producto producto){
        int descuentoProducto = 0;
        if(producto.getTipo().equalsIgnoreCase("latas")){
            descuentoProducto = 10;
        }
        return descuentoProducto;
    }
}
