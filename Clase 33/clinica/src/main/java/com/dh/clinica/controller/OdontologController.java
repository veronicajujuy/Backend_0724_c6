package com.dh.clinica.controller;

import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.service.impl.OdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologController {
    private OdontologoService odontologService;

    public OdontologController(OdontologoService odontologService) {
        this.odontologService = odontologService;
    }

    @PostMapping("/guardar")
    @Operation(summary = "Guardar un odontologo", description = "Guardar un odontologo",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Odontologo.class),
                        examples = @ExampleObject(
                                name = "odontologo",
                                summary = "ejemplo de odontologo",
                                value = "{\"nroMatricula\": \"1162224567\", \"nombre\": \"Juan\", \"apellido\": \"Guerra\"}"
                        )
        )))
    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Ejemplo de respuesta",
                            summary = "Respuesta de usuario guardado",
                            value = "{ \"id\": 1, \"nroMatricula\": \"1162224567\", \"nombre\": \"Juan\", \"apellido\": \"Guerra\", \"turnoSet\": \"null\"}"
                    )
            )
    )
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologService.guardarOdontologo(odontologo));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        Optional<Odontologo> odontologo = odontologService.buscarPorId(id);
        if(odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }
}
