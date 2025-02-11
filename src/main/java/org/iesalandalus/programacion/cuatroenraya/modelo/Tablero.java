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
        Objects.requireNonNull(columna, "El parámetro columna no puede ser nulo");
        if (columna < 0 | columna > 6) {
            throw new CuatroEnRayaExcepcion("El parámetro columna no es válido");
        }
    }

    private int getPrimeraFilaVacia(int columna) throws CuatroEnRayaExcepcion {
        boolean primeraFilaVaciaBooleano = false;
        int primeraFilaVaciaNumero = 0;
        int indice = 0;
        do {
            if (casillasTablero[indice][columna] == null) {
                primeraFilaVaciaNumero = indice;
                primeraFilaVaciaBooleano = true;
            }
            indice++;
        } while (indice < FILAS || primeraFilaVaciaBooleano == true);
        if (primeraFilaVaciaBooleano == false) {
            throw new CuatroEnRayaExcepcion("No hay ninguna fila vacía en la columna [" + columna + "]");
        }
        return primeraFilaVaciaNumero;
    }

    private boolean comprobarTirada(int fila, int columna) {
        
    }

    private boolean objetivoAlcanzado(int fichasIgualesConsecutivas) {

    }

    private boolean comprobarHorizontal(int fila, Ficha ficha) {
        boolean comprobarHorizontal = false;
        int numeroSeguidoHorizontalVerde = 0;
        int numeroSeguidoHorizontalAzul = 0;
        for(int indice = 0;indice < COLUMNAS && numeroSeguidoHorizontalVerde == 4; indice++) {
            if (casillasTablero[fila][indice].equals(ficha.VERDE)) {
                numeroSeguidoHorizontalVerde++;
            } else {
                numeroSeguidoHorizontalVerde = 0;
            }
            if (casillasTablero[fila][indice] == ficha.AZUL) {

            }
        }
        if (numeroSeguidoHorizontalVerde == 4) {
            comprobarHorizontal = true;
        }
        return comprobarHorizontal;
    }

    private boolean comprobarVertical(int columna, Ficha ficha) {
        boolean comprobarVertical = false;
        int numeroSeguidoVertical = 0;
        for(int indice = 0;indice < FILAS && numeroSeguidoVertical == 4; indice++) {
            if (casillasTablero[indice][columna].equals(ficha)) {
                numeroSeguidoVertical++;
            } else {
                numeroSeguidoVertical = 0;
            }
        }
        if (numeroSeguidoVertical == 4) {
            comprobarVertical = true;
        }
        return comprobarVertical;
    }

    private boolean comprobarDiagonalNE(int filaActual, int columnaActual, Ficha ficha) throws CuatroEnRayaExcepcion {
        comprobarColumna(columnaActual);
        comprobarFicha(ficha);

        int fila1 = filaActual;
        int columna1 = columnaActual;
        do {
            fila1--;
            columna1--;
            if (fila1 == 0 && columna1 != 0) {
                columna1--;
            }
        } while (fila1 > 0 || columna1 > 0);

        int numeroSeguidoDiagonalNE = 0;
        boolean numeroSeguidoDiagonalNEBooleano = false;
        do {
            if (casillasTablero[fila1][columna1].equals(ficha)) {
                numeroSeguidoDiagonalNE++;
            } else {
                numeroSeguidoDiagonalNE = 0;
            }
            if (numeroSeguidoDiagonalNE == 4) {
                numeroSeguidoDiagonalNEBooleano = true;
            }
        } while ((fila1 < FILAS && columna1 < COLUMNAS) && (numeroSeguidoDiagonalNE == 4));
        return numeroSeguidoDiagonalNEBooleano;
    }

    private boolean comprobarDiagonalNO(int filaActual, int columnaActual, Ficha ficha) {
        comprobarColumna(columnaActual);
        comprobarFicha(ficha);

        int fila1 = filaActual;
        int columna1 = columnaActual;
        do {
            fila1--;
            columna1--;
            if (fila1 == 0 && columna1 != 0) {
                columna1--;
            }
        } while (fila1 > 0 || columna1 > 0);
    }

    private int menor(int fila, int columna) throws CuatroEnRayaExcepcion {
        comprobarColumna(columna);
        int menor = 0;
        if (fila > columna) {
            menor = fila;
        }
        if (columna > fila) {
            menor = columna;
        }
        return menor;
    }

    @Override
    public String toString() {
        return String.format("[casillasTablero=%s]", Arrays.toString(casillasTablero));
    }
}
