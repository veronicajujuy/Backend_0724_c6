package impl;

import model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private static Map<String, Computadora> poolComputadoras = new HashMap<>();

    public static Computadora getComputadora(String tipo, int ram, int discoRigido){
        String clave = "key:"+tipo+ram+discoRigido;
        Computadora computadora;
        if(!poolComputadoras.containsKey(clave)){
            computadora = new Computadora(tipo, ram, discoRigido);
            System.out.println("Se creo una nueva instancia de computadora: "+ computadora);
            poolComputadoras.put(clave, computadora);
        }
        computadora = poolComputadoras.get(clave);
        System.out.println("Se obtuvo la computadora "+ computadora);
        return computadora;
    }
}
