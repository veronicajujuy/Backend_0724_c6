package clasepresencial.model;

public class Efectivo extends Empleado {
    private double sueldoBasico;
    private double premios;
    private double descuento;

    public Efectivo(String nombre, String apellido, String nroCuenta, double sueldoBasico, double premios, double descuento) {
        super(nombre, apellido, nroCuenta);
        this.sueldoBasico = sueldoBasico;
        this.premios = premios;
        this.descuento = descuento;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
