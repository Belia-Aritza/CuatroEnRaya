package org.iesalandalus.programacion.cuatroenraya.modelo;

import java.util.Objects;

public class Casilla {
    private Ficha ficha;

    public Casilla() {
        ficha = null;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha)  throws CuatroEnRayaExcepcion {
        Objects.requireNonNull(ficha, "No se puede poner una ficha nula.");
        if (estaOcupado()) {
            throw new CuatroEnRayaExcepcion("La casilla ya contiene una ficha.");
        }
        this.ficha = ficha;
    }

    public boolean estaOcupado() {
        //Si ficha existe devuelve true si es nulo devuelve false
        return ficha != null;
    }

    @Override
    public String toString() {
        String tostringFicha;
        if (!estaOcupado()) {
            tostringFicha = " ";
        } else {
            tostringFicha = ficha.toString();
        }
        return String.format(tostringFicha);
    }
}
