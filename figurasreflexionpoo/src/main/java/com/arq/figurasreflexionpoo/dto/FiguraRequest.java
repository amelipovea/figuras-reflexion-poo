package com.arq.figurasreflexionpoo.dto;

import java.util.Map;

public class FiguraRequest {
    private String tipo;
    private Map<String, Double> parametros;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Map<String, Double> getParametros() { return parametros; }
    public void setParametros(Map<String, Double> parametros) { this.parametros = parametros; }
}