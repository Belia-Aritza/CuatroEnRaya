package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    private Casilla[][] casillasTablero;

    public Tablero() {
        casillasTablero = new Casilla[FILAS][COLUMNAS];
    }

    public boolean columnaVacia(int columna) {
        int indice;
        for (indice = 0; indice < FILAS || casillasTablero != null; indice++) {
            if (casillasTablero[indice][columna] == null) {

            }
        }
        return (indice == FILAS);


    }


}
