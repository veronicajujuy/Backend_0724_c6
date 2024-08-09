package dao.impl;

import dao.IDao;
import model.Paciente;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PacienteDaoMemoria implements IDao<Paciente> {
    public static final Logger logger = Logger.getLogger(PacienteDaoMemoria.class);
    private List<Paciente> pacientes = new ArrayList<>();
    @Override
    public Paciente guardar(Paciente paciente) {
        paciente.setId(pacientes.size()+1);
        paciente.getDomicilio().setId(pacientes.size()+1);
        pacientes.add(paciente);
        logger.info("paciente guardado "+ paciente);
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Paciente pacienteARetornar = null;
        for(Paciente paciente: pacientes){
            if(paciente.getId() == id){
                pacienteARetornar = paciente;
            }
        }
        if(pacienteARetornar != null){
            logger.info("paciente encontrado "+ pacienteARetornar);
        }else logger.info("paciente no encontrado");
        return pacienteARetornar;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
