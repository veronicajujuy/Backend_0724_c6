import org.apache.log4j.Logger;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        double promedio;
        ListaEnteros listaEnteros = new ListaEnteros();
        try{
            promedio = listaEnteros.promedio();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        listaEnteros.agregarEnteros(9);
        listaEnteros.agregarEnteros(8);
        listaEnteros.agregarEnteros(-10);
        listaEnteros.agregarEnteros(14);
        listaEnteros.agregarEnteros(20);
        listaEnteros.agregarEnteros(-5);
        try{
            promedio = listaEnteros.promedio();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
