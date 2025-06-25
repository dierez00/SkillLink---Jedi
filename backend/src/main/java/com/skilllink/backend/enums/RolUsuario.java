package com.skilllink.backend.enums;

public enum RolUsuario {

    DOCENTE("Docente"),
    APRENDIZ("Aprendiz");

    private final String rolVisible;

    RolUsuario(String rolVisible){
        this.rolVisible = rolVisible;
    }

    public String getRolVisible(){
        return rolVisible;
    }

}
