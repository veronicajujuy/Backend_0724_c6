package test;

import impl.ProcesaMail;
import model.Mail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorMailTest {

    @Test
    @DisplayName("Testear que un mail que corresponda a gerencial vaya a gerencia")
    void caso1(){
        //dado
        Mail mailRecibido = new Mail("pepito@gmail.com", "gerencia@colmena.com", "queja");
        ProcesaMail procesaMail = new ProcesaMail();
        String respuestaEsperada = "El mail corresponde a gerencia y será tratado";
        // cuando
        String respuestaObtenida = procesaMail.compruebaMail(mailRecibido);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Correo va a spam")
    void caso2(){
        //dado
        Mail mailRecibido = new Mail("pepito@gmail.com", "info@colmena.com", "queja");
        ProcesaMail procesaMail = new ProcesaMail();
        String respuestaEsperada = "El mail termino en Spam";
        // cuando
        String respuestaObtenida = procesaMail.compruebaMail(mailRecibido);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}