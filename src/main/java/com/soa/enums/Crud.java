package com.soa.enums;

import com.soa.tools.UnknownCrudException;

/**
 * 
 */
public enum Crud {
    CREATE("create"), 
    READ("read"), 
    UPDATE("update"), 
    DELETE("delete");

    private String value;

    /**
     * Constructor del enumerador
     * @param value Valor asociado a cada elemento
     */
    Crud(String value) {
        this.setValue(value);
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Encontrar un elemento del enum por operacion
     * @param operacion Operacion a buscar
     * @return Elemento del enum correspondiente a la operacion
     */
    public static Crud findByValue(String operacion) {
        Crud[] values = Crud.values();
        for (Crud crud : values) {
            if(operacion.equalsIgnoreCase(crud.getValue())) {
                return crud;
            }
        }
        throw new UnknownCrudException();
    }
}
