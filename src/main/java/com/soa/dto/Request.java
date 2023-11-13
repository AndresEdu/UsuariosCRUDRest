package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion resumida de una persona.
 */
public class Request {
    
    private String operacion;
    private Usuario usuario;
    
    
    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }


    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }


    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }


    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
