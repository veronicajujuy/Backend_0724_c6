package test;

import impl.ProxyVacunacion;
import model.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioVacunacionTest {
    @Test
    @DisplayName("Testear que una persona que tenga una fecha valida se pueda vacunar")
    void caso1(){
        //Dado
        Persona persona = new Persona("Juan", "Perez", "4899494466",
                LocalDate.of(2024,07,24),"Pfizer");
        ProxyVacunacion proxyVacunacion = new ProxyVacunacion();
        String respuestaEsperada = "La persona Juan Perez se vacuno el dia: 2024-07-25 con la vacuna Pfizer";
        // cuando
        String respuestaObtenida = proxyVacunacion.vacunar(persona);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}