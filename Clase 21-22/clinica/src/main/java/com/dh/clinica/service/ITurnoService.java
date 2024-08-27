package com.dh.clinica.service;

import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    Turno guardarTurno(Turno turno);

    Optional<Turno> buscarPorId(Integer id);

    List<Turno> buscarTodos();

    void modificarTurno(Turno turno);
    void eliminarTurno(Integer id);
}
