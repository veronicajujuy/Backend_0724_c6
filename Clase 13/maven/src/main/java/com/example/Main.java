package com.example;

import dao.impl.PacienteDaoH2;
import model.Paciente;
import service.PacienteService;



public class Main {
    public static void main(String[] args) {
        // listar todos los pacientes:
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        Paciente paciente = pacienteService.buscarPorId(1);
    }
}
