package clasepresencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;

    public Grupo() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersonas(Persona persona){
        if(persona.chequearCantLetras() && persona.chequearEdad() &&
        persona.chequearEdadEntre0y120() && persona.chequearLetrasAZ())
            personas.add(persona);
        else System.out.println("No se agrego a la persona");
    }

}
