package impl;

import model.Persona;

import java.time.LocalDate;

public class Vacunacion implements ServicioVacunacion{
    @Override
    public String vacunar(Persona persona) {
        return "La persona "+persona.getNombre()+" "+ persona.getApellido()+" se vacuno el dia: "+
                LocalDate.now() +" con la vacuna "+ persona.getVacuna();
    }
}
