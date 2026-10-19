# Motor de Figuras Geométricas

Este repositorio contiene las prácticas de arquitectura de software enfocadas en el diseño base y la posterior extensibilidad dinámica mediante Spring y Groovy.

## Organización del Repositorio

El proyecto está dividido en dos ramas para facilitar su revisión:

*   **Rama `main` (Metodología de diseño orientado a objetos):** Contiene la primera fase. Define el contrato estándar (`FiguraGeometrica`) y las clases concretas nativas aplicando abstracción, polimorfismo y encapsulamiento.
*   **Rama `actividad-2-reflexion` (Reflexión y máquinas de interpretación):** Contiene la segunda fase. Implementa la arquitectura en Spring para instanciar objetos dinámicamente en tiempo de ejecución y compilar nuevas figuras usando scripts (Groovy/Rhino).

> **Nota para la evaluación:** Por defecto estás viendo el código de la rama `main` (Metodología de diseño orientado a objetos). Para revisar la implementación con Spring, por favor cambia a la rama `actividad-2-reflexion`.