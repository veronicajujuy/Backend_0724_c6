package impl;

import model.Persona;

import java.time.LocalDate;

public class ProxyVacunacion implements ServicioVacunacion{
    private Vacunacion vacunacion;


    @Override
    public String vacunar(Persona persona) {
        if(persona.getFecha().isEqual(LocalDate.now()) || persona.getFecha().isBefore(LocalDate.now())){
            vacunacion = new Vacunacion();
            return vacunacion.vacunar(persona);
        }
        return "La persona no pudo vacunarse porque no correspondia el turno";
    }
}
