package impl;

import model.Producto;

public class ApiCantidad {
    public static int descuento(int cantidad){
        int descuentCantidad = 0;
        if(cantidad > 12){
            descuentCantidad = 15;
        }
        return descuentCantidad;
    }
}
