package com.skilllink.backend.enums;

public enum NivelHabilidad {

    BASICO("Basico"),
    INTERMEDIO("Intermedio"),
    AVANZADO ("Avanzado");

    private final String nivelVisible;

    NivelHabilidad(String rolVisible){
        this.nivelVisible = rolVisible;
    }

    public String getRolVisible(){
        return nivelVisible;
    }

}
