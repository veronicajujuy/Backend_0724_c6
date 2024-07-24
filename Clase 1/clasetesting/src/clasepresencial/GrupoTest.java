package clasepresencial;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    @BeforeAll
    static void antesDeLosTest(){
        System.out.println("Esto se ejecuta antes de todos los test");
        Grupo grupo = new Grupo();
    }

    @BeforeEach
    void antesDeCadaTest(){
        System.out.println("Esto se ejecuta antes cada test");
    }

    @Test
    @DisplayName("Chequear que solo se agreguen personas con nombres mayores a 4 letras")
    void caso1(){
        //Dado Juan, Pedro, Ana, Luz y Julián
        Persona persona1 = new Persona("Juan", 19);
        Persona persona2 = new Persona("Pedro", 19);
        Persona persona3 = new Persona("Ana", 19);
        Persona persona4 = new Persona("Luz", 19);
        Persona persona5 = new Persona("Julian", 19);
        Grupo grupo = new Grupo();
        // CUANDO se ejecuten los procesos
        grupo.agregarPersonas(persona1);
        grupo.agregarPersonas(persona2);
        grupo.agregarPersonas(persona3);
        grupo.agregarPersonas(persona4);
        grupo.agregarPersonas(persona5);

        // ENTONCES
        assertEquals(2, grupo.getPersonas().size());
    }

    @Test
    @DisplayName("Chequear que solo se agreguen personas mayores de edad")
    void caso2(){
        //Dado  (18 años, 17 años, 22 años, 14 años y 32 años)
        Persona persona1 = new Persona("Juanita", 18);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Analia", 22);
        Persona persona4 = new Persona("Luciana", 14);
        Persona persona5 = new Persona("Julian", 32);
        Grupo grupo = new Grupo();
        // CUANDO se ejecuten los procesos
        grupo.agregarPersonas(persona1);
        grupo.agregarPersonas(persona2);
        grupo.agregarPersonas(persona3);
        grupo.agregarPersonas(persona4);
        grupo.agregarPersonas(persona5);

        // ENTONCES
        // assertEquals(3, grupo.getPersonas().size());
        assertTrue(grupo.getPersonas().size() == 3);
    }

    @AfterAll
    static void despuesDeLosTest(){
        System.out.println("Esto se ejecuta despues de todos los test");
    }

    @AfterEach
    void despuesDeCadaTest(){
        System.out.println("Esto se ejecuta despues cada test");
    }

}