import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaEnteros {
    public static final Logger logger = Logger.getLogger(ListaEnteros.class);
    List<Integer> listaEnteros = new ArrayList<>();

    public void agregarEnteros(Integer integer){
        listaEnteros.add(integer);
        logger.debug("el numero agregado es"+ integer);
        if(listaEnteros.size() > 5){
            logger.info("La lista tiene mas de 5 elementos");
        }
        if(listaEnteros.size() > 10){
            logger.info("La lista tiene mas de 10 elementos");
        }
    }

    public double promedio(){
        if(listaEnteros.isEmpty()){
            throw new RuntimeException("La lista no tiene elementos");
        }
        int suma = 0;
        for(int numero: listaEnteros){
            suma += numero;
        }
        double promedioARetornar = (double )suma / listaEnteros.size();
        logger.info("El promedio es "+ promedioARetornar);
        return promedioARetornar;
    }

    public int maximo(){
        Integer maximo = Integer.MIN_VALUE;
        for(int numero: listaEnteros){
            if(maximo < numero){
                maximo = numero;
            }
        }
        logger.info("el maximo es: "+maximo);
        return maximo;
    }

}
