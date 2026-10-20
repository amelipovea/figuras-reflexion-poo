package com.arq.figurasreflexionpoo.controller;

import com.arq.figurasreflexionpoo.dto.FiguraRequest;
import com.arq.figurasreflexionpoo.model.FiguraGeometrica;
import com.arq.figurasreflexionpoo.service.FiguraFactoryService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/figuras")
public class FiguraController {

    private final FiguraFactoryService factoryService;

    public FiguraController(FiguraFactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @PostMapping("/calcular")
    public Map<String, Object> calcular(@RequestBody FiguraRequest request) {
        Map<String, Object> respuesta = new HashMap<>();

        try {
            FiguraGeometrica figura = factoryService.crearFigura(request.getTipo(), request.getParametros());

            respuesta.put("figura", request.getTipo());
            respuesta.put("area", figura.calcularArea());
            respuesta.put("perimetro", figura.calcularPerimetro());

        } catch (Exception e) {
            respuesta.put("error", "Error al instanciar la figura: " + e.getMessage());
        }

        return respuesta;
    }
}