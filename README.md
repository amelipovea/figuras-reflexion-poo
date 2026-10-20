# Sistema de Arquitectura: Instanciación Dinámica de Figuras Geométricas

Este proyecto demuestra la implementación de un sistema backend basado en una arquitectura híbrida de instanciación dinámica. Permite calcular el área y perímetro de figuras geométricas sin estar acoplado estrictamente a clases precompiladas.

## Tecnologías Utilizadas
* **Java 17 (LTS)**
* **Spring Boot  (REST API)
* **API de Reflexión Nativa** (`java.lang.reflect`)
* **Motor Groovy** (`javax.script.ScriptEngine`)
* **RestTemplate** (Consumo de servicios externos)

## Arquitectura del Sistema
El sistema expone un endpoint POST (`/api/figuras/calcular`) que recibe peticiones en formato JSON. El procesamiento se divide en dos capas:
1. **Intento Estático (Reflexión):** El sistema intenta instanciar la figura solicitada buscando una clase compilada en el paquete nativo.
2. **Intento Dinámico (Groovy + API Externa):** Si la figura no existe (ej. `Hexagono`), el sistema consume una URL externa que sirve como servidor de archivos estáticos (GitHub Raw), descarga el código fuente en Groovy, lo compila en tiempo de ejecución en la memoria RAM y procesa el cálculo al instante.

## Prueba de Integración (Payload JSON)
Para probar la API en Postman, envía una petición **POST** a `http://localhost:8080/api/figuras/calcular` con el siguiente cuerpo (Body -> raw -> JSON):

```json
{
    "tipo": "Hexagono",
    "parametross": {
        "lado": 10.0
    }
}