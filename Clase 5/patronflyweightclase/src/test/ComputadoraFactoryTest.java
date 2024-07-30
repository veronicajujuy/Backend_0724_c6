package test;

import impl.ComputadoraFactory;
import model.Computadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadoraFactoryTest {
    @Test
    @DisplayName("Testear que si obtengo muchas computadoras de un solo tipo el contador tiene que ser 1")
    void caso1(){
        //dado
        Computadora computadora1 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora2 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora3 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora4 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora5 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        //cuando
        int contador = Computadora.getContador();
        // entonces
        assertEquals(1,contador);
    }

    @Test
    @DisplayName("Testear que si obtengo muchas computadoras de un mismo tipo el contador tiene que ser igual a la cantidad de distintos tipos de computadora")
    void caso2(){
        //dado
        Computadora computadora1 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora2 = ComputadoraFactory.getComputadora("Mac16", 16, 500);
        Computadora computadora3 = ComputadoraFactory.getComputadora("Mac16", 16, 500);
        Computadora computadora4 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora5 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora6 = ComputadoraFactory.getComputadora("Windows11", 8, 256);
        //cuando
        int contador = Computadora.getContador();
        // entonces
        assertEquals(3,contador);
    }


}