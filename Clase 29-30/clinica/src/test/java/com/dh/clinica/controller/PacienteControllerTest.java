package com.dh.clinica.controller;

import com.dh.clinica.entity.Domicilio;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.service.impl.PacienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PacienteService pacienteService;

    private Paciente paciente;

    void crearPaciente(){
        Domicilio domicilio = new Domicilio(null,"Falsa", 456, "Cipolleti", "Rio Negro");
        paciente = new Paciente();
        paciente.setApellido("Romero");
        paciente.setNombre("Luciana");
        paciente.setDni("56655789");
        paciente.setFechaIngreso(LocalDate.of(2024, 7, 16));
        paciente.setDomicilio(domicilio);
    }
// (paciente ->) JSON -> http//localhost:8080/paciente/guardar -> esperamos -> codigo de status -> JSON

    @Test
    @DisplayName("Testeamos el guardado de un paciente en la base ded atos")
    void guardarPaciente() throws Exception {
        crearPaciente();
        // transformamos el paciente en un objeto JSON
        String pacienteJson = objectMapper.writeValueAsString(paciente);
        // mockeamos la peticion
        mockMvc.perform(post("/paciente/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacienteJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.apellido").value("Romero"))
                .andExpect(jsonPath("$.nombre").value("Luciana"))
                .andExpect(jsonPath("$.domicilio.calle").value("Falsa"))
                .andExpect(jsonPath("$.domicilio.localidad").value("Cipolleti"));

    }

    @Test
    @DisplayName("Buscar un paciente por Id")
    void buscarPorIdPaciente() throws Exception {
        crearPaciente();
        Paciente pacienteGuardado = pacienteService.guardarPaciente(paciente);

        mockMvc.perform(get("/paciente/buscar/{id}", pacienteGuardado.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pacienteGuardado.getId()))
                .andExpect(jsonPath("$.apellido").value("Romero"))
                .andExpect(jsonPath("$.nombre").value("Luciana"))
                .andExpect(jsonPath("$.domicilio.calle").value("Falsa"))
                .andExpect(jsonPath("$.domicilio.localidad").value("Cipolleti"));
    }

    @Test
    @DisplayName("Buscar un paciente que no existe por Id")
    void buscarPorIdPacienteQueNoExiste() throws Exception {

        mockMvc.perform(get("/paciente/buscar/{id}",10)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}