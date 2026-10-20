package com.arq.figurasreflexionpoo.service;

import com.arq.figurasreflexionpoo.model.FiguraGeometrica;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Constructor;
import java.util.Map;

@Service
public class FiguraFactoryService {

    public FiguraGeometrica crearFigura(String tipo, Map<String, Double> parametros) throws Exception {
        try {
            // INTENTO 1: Reflexión Nativa
            Class<?> claseFigura = Class.forName("com.arq.figurasreflexionpoo.model." + tipo);
            return instanciar(claseFigura, parametros);
        } catch (ClassNotFoundException e) {
            // INTENTO 2: Si la clase no existe, usamos la Máquina de Interpretación (Groovy)
            return crearFiguraConGroovy(tipo, parametros);
        }
    }

    private FiguraGeometrica instanciar(Class<?> clase, Map<String, Double> params) throws Exception {
        // Usamos Reflexión para obtener el primer constructor de la clase
        Constructor<?> constructor = clase.getConstructors()[0];

        // Extraemos los valores (ej. el 5.0 del radio) y los pasamos al constructor
        Object[] valores = params.values().toArray();

        // Se crea la instancia
        return (FiguraGeometrica) constructor.newInstance(valores);
    }


    private FiguraGeometrica crearFiguraConGroovy(String tipo, Map<String, Double> parametros) throws Exception {

        String urlBase = "https://raw.githubusercontent.com/amelipovea/api-figuras-groovy/refs/heads/main/";

        String urlServicioExterno = urlBase + tipo + ".groovy";

        RestTemplate restTemplate = new RestTemplate();
        String codigoGroovy = restTemplate.getForObject(urlServicioExterno, String.class);

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        Class<?> claseDinamica = (Class<?>) engine.eval(codigoGroovy);

        return instanciar(claseDinamica, parametros);
    }
}