package com.dh.clinica.service;

import com.dh.clinica.entity.Odontologo;


import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);
    Optional <Odontologo> buscarPorId(Integer id);
}
