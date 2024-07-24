package mesas.impl;

import mesas.model.Menu;

public class PreparadorMenuClasico extends PreparadorMenu{
    @Override
    public String armadoDeMenu(Menu menu) {
        return "Preparando el menu clasico";
    }

    @Override
    public double calculoCosto(Menu menu) {
        return menu.getPrecioBase();
    }
}
