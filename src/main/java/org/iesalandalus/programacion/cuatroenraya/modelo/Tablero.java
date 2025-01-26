package org.iesalandalus.programacion.cuatroenraya.modelo;

import java.util.Arrays;
import java.util.Objects;

public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    private Casilla[][] casillasTablero;

    public Tablero() {
        casillasTablero = new Casilla[FILAS][COLUMNAS];
    }

    public boolean estaVacio() throws CuatroEnRayaExcepcion{
        boolean estaVacio = true;
        if (columnaVacia(0) && columnaVacia(1) && columnaVacia(2) && columnaVacia(3) && columnaVacia(4) && columnaVacia(5) && columnaVacia(6)) {
            estaVacio = false;
        }
        return estaVacio;
    }

    public boolean columnaVacia(int columna) throws CuatroEnRayaExcepcion{
        comprobarColumna(columna);
        boolean columnaVacia = true;
        for (int indice = 0; indice < FILAS && columnaVacia; indice++) {
            columnaVacia = casillasTablero[indice][columna] == null;
        }
        return columnaVacia;
    }

    public boolean estaLleno() throws CuatroEnRayaExcepcion{
        boolean estaLleno = false;
        if (columnaLlena(0) && columnaLlena(1) && columnaLlena(2) && columnaLlena(3) && columnaLlena(4) && columnaLlena(5) && columnaLlena(5) && columnaLlena(6)) {
            estaLleno = true;
        }
        return estaLleno;
    }

    public boolean columnaLlena(int columna) throws CuatroEnRayaExcepcion{
        comprobarColumna(columna);
        boolean columnaLlena = false;
        int casillasLlenas = 1;
        for (int indice = 0; indice < FILAS; indice++) {
            if (casillasTablero[indice][columna] != null) {
                casillasLlenas += 1;
            }
        }
        if (casillasLlenas ==FILAS) {
            columnaLlena = true;
        }
        return columnaLlena;
    }

    public boolean introducirFicha(int columna, Ficha ficha) throws CuatroEnRayaExcepcion{
        comprobarColumna(columna);
        comprobarFicha(ficha);

    }

    private void comprobarFicha(Ficha ficha) throws CuatroEnRayaExcepcion{
        if (!(ficha == ficha.VERDE && ficha == ficha.AZUL && ficha == null)) {
            throw new CuatroEnRayaExcepcion("El parámetro ficha no es válido");
        }
    }

    private void comprobarColumna(int columna) throws CuatroEnRayaExcepcion{
        if (columna < 0 | columna > 6) {
            throw new CuatroEnRayaExcepcion("El parámetro columna no es válido");
        }
    }

    private int getPrimeraFilaVacia(int columna) {

    }

    private boolean comprobarTirada(int fila, int columna) {

    }

    private boolean objetivoAlcanzado(int fichasIgualesConsecutivas) {

    }

    private boolean comprobarHorizontal(int fila, Ficha ficha) {

    }

    private boolean comprobarVertical(int columna, Ficha ficha) {

    }

    private boolean comprobarDiagonalNE(int filaActual, int columnaActual, Ficha ficha) {

    }

    private boolean comprobarDiagonalNO(int filaActual, int columna, Ficha ficha) {

    }

    private int menor(int fila, int columna) {

    }

    @Override
    public String toString() {
        return String.format("[casillasTablero=%s]", Arrays.toString(casillasTablero));
    }
}
