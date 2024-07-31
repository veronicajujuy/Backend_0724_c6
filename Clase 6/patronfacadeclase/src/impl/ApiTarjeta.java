package impl;

import model.Tarjeta;

public class ApiTarjeta {
    public static int descuento(Tarjeta tarjeta){
        int descuentoTarjeta = 0;
        if(tarjeta.getBanco().equalsIgnoreCase("Star Bank")){
            descuentoTarjeta = 20;
        }
        return descuentoTarjeta;
    }
}
