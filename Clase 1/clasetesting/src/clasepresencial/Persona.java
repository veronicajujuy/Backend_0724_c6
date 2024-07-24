package clasepresencial;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean chequearEdad(){
        return edad >= 18;
    }

    public boolean chequearCantLetras(){
        return nombre.length() >= 5;
    }

    public boolean chequearLetrasAZ(){
        return nombre.matches("[a-zA-Z]+");
    }

    public boolean chequearEdadEntre0y120(){
        return edad > 0 && edad < 120;
    }
}
