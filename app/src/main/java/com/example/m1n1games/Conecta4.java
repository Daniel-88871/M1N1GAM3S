package com.example.m1n1games;

import java.util.Scanner;

public class Conecta4 {

    public static String[][] tablero = new String[6][6];
    public static int Columnas;
    public static int Filas;
    public static boolean Fin = false;

    public static void main(String[] args) {
        Conecta4 conecta4 = new Conecta4();
        Scanner scanner = new Scanner(System.in);
        int jugadasMaximas = 1;
        int columna = 0;
        int contador = 0;
        int modoDeJuego = 0;
        String mensajeError = "";
        String jugador1;
        String caracter1;
        String jugador2;
        String caracter2;
        boolean verificador = false;
        boolean verificador2 = false;
        Columnas = tablero[1].length;
        Filas = tablero.length;
        String auxiliarJugador = "";
        String auxiliarCaracter = "";

        System.out.println("===============================================");
        System.out.println("         1.- Jugador 1 vs Jugador 2");
        System.out.println("===============================================");
        System.out.println("=== ELIGE EL MODO DE JUEGO QUE DESEAS JUGAR ===");
        System.out.println("===============================================");


        for (int i = 0; i <= Columnas - 1; i++) {
            for (int j = 0; j <= Filas - 1; j++) {
                tablero[i][j] = "O";
            }
        }

        while (!verificador) {
            try {
                String auxiliar = scanner.nextLine();
                modoDeJuego = Integer.parseInt(auxiliar);
                if (modoDeJuego == 1 || modoDeJuego == 2) {
                    verificador = true;
                } else {
                    System.out.println("Debes ingresar 1 o 2");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar 1 o 2");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        verificador = false;

        if (modoDeJuego == 1) {
            System.out.println("============================================");
            System.out.println("MODO SELECCIONADO:");
            System.out.println("             Jugador 1 vs Jugador 2");
            System.out.println("Ingresa un nick");
            jugador1 = scanner.nextLine();
            if (jugador1.equals(null) || jugador1.equals("")) {
                jugador1 = "Jugador 1";
            }

            jugador1 = jugador1;
            System.out.println(jugador1 + " ingresa un caracter para usarlo en el juego (puede ser un signo, numero, letra, etc)");
            caracter1 = scanner.nextLine();
            caracter1 = caracter1.toUpperCase();

            while (caracter1.length() > 1 || caracter1.equals(null) || caracter1.equals("")) {
                if (caracter1.length() > 1) {
                    System.out.println("El caracter debe ser de una sola letra");
                    caracter1 = scanner.nextLine();
                    caracter1 = caracter1.toUpperCase();
                }

                if (caracter1.equals(null) || caracter1.equals("")) {
                    System.out.println("El caracter no puede estar vacio, intente nuevamente");
                    caracter1 = scanner.nextLine();
                    caracter1 = caracter1.toUpperCase();
                }
            }

            System.out.println("=========================================================================");

            System.out.println("Ingresa un nick");
            jugador2 = scanner.nextLine();
            while (jugador2.equals(jugador1)) {
                System.out.println("El jugador 1 ya ha utilizado este nick, ingresa otro");
                jugador2 = scanner.nextLine();
            }

            if (jugador2.equals(null) || jugador2.equals("")) {
                jugador2 = "Jugador 2";
            }

            jugador2 = jugador2;

            System.out.println(jugador2 + " ingresa un caracter para usarlo en el juego (Puede ser un signo, numero, letra, etc)");
            caracter2 = scanner.nextLine();
            caracter2 = caracter2.toUpperCase();


            while (caracter2.equals(caracter1) || caracter2.length() > 1 || caracter2.equals(null) || caracter2.equals("")) {
                if (caracter2.equals(null) || caracter2.equals("")) {
                    System.out.println("El caracter no puede estar vacio, intentalo de nuevo");
                    caracter2 = scanner.nextLine();
                    caracter2 = caracter2.toUpperCase();
                }

                if (caracter2.equals(caracter1)) {
                    System.out.println("El caracter es igual al del jugador 1, ingresa otro");
                    caracter2 = scanner.nextLine();
                    caracter2 = caracter2.toUpperCase();
                }

                if (caracter2.length() > 1) {
                    System.out.println("El caracter debe ser de una sola letra, intentalo de nuevo");
                    caracter2 = scanner.nextLine();
                    caracter2 = caracter2.toUpperCase();
                }
            }

            verificador = false;

            caracter1 = caracter1;
            caracter2 = caracter2;

            while (!Fin) {
                while (!verificador) {

                    conecta4.mostrarTablero(tablero);
                    System.out.println(mensajeError);
                    mensajeError = "";

                    try {
                        System.out.println(jugador1 + " escribe el numero de columna para poner la ficha:");
                        String auxiliar = scanner.nextLine();
                        columna = Integer.parseInt(auxiliar) - 1;
                        if (columna > Columnas - 1 || columna < 0) {
                            mensajeError = "Debes ingresar un numero entre el 1 al " + Columnas;
                        } else {
                            contador = 1;
                            for (int i = Columnas - 1; i > -1; i = i - 1) {
                                if (!verificador2) {
                                    if (tablero[i][columna] != caracter1 && tablero[i][columna] != caracter2) {
                                        tablero[i][columna] = caracter1;
                                        verificador2 = true;
                                        verificador = true;
                                        jugadasMaximas++;
                                    } else {
                                        contador += 1;
                                    }
                                }

                                if (contador == Filas + 1) {
                                    mensajeError = "Esta columna esta completa, escoje otra";
                                }
                            }
                        }

                    } catch (NumberFormatException e) {
                        mensajeError = "Has puesto un caracter no valido, debes ingresar un NUMERO";
                    } catch (Exception e) {
                        mensajeError = "Debes ingresar un numero entre el 1 al " + Columnas;
                    }
                }

                verificador2 = false;
                verificador = false;
                auxiliarJugador = jugador1;
                auxiliarJugador = caracter1;

                conecta4.verificadorGanador(jugador1, caracter1);

                if (jugadasMaximas == (Filas * Columnas) + 1) {
                    Fin = true;
                    conecta4.mostrarTablero(tablero);
                    System.out.println("======================");
                    System.out.println("¡¡¡EMPATE!!!");
                    System.out.println("El tablero está lleno");
                    System.out.println("======================");
                }

                if (Fin == false) {
                    while (!verificador) {

                        conecta4.mostrarTablero(tablero);
                        System.out.println(mensajeError);
                        mensajeError = "";

                        try {
                            System.out.println(jugador2 + " escribe el numero de columna para poner tu ficha:");
                            String auxiliar = scanner.nextLine();
                            columna = Integer.parseInt(auxiliar) - 1;

                            if (columna > Columnas - 1 || columna < 0) {
                                mensajeError = "Debes ingresar un numero entre el 1 al " + Columnas;

                            } else {
                                contador = 1;

                                for (int i = Columnas - 1; i > -1; i = i - 1) {
                                    if (!verificador2) {

                                        if (tablero[i][columna] != caracter2 && tablero[i][columna] != caracter1) {
                                            tablero[i][columna] = caracter2;
                                            verificador2 = true;
                                            verificador = true;
                                            jugadasMaximas++;

                                        } else {
                                            contador += 1;
                                        }
                                    }

                                    if (contador == Filas + 1) {
                                        mensajeError = "Esta columna esta completa, escoje otra";
                                    }
                                }
                            }

                        } catch (NumberFormatException e) {
                            mensajeError = "Has puesto caracter no valido, debes ingresar un NUMERO";
                        } catch (Exception e) {
                            mensajeError = "Debes ingresar un numero entre el 1 al " + Columnas;
                        }
                    }

                    verificador2 = false;
                    verificador = false;
                    auxiliarJugador = jugador2;
                    auxiliarJugador = caracter2;

                    conecta4.verificadorGanador(jugador2, caracter2);

                    if (jugadasMaximas == (Filas * Columnas) + 1) {
                        Fin = true;
                        conecta4.mostrarTablero(tablero);
                        System.out.println("======================");
                        System.out.println("¡¡¡EMPATE!!!");
                        System.out.println("El tablero esta lleno");
                        System.out.println("======================");
                    }
                }
            }
        }
    }

    public void mostrarTablero(String[][] tabla) {
        System.out.print("          ");
        for (int i = 1; i < Columnas + 1; i += 1) {
            System.out.print(i + "   ");
        }

        System.out.println("");
        System.out.print("         ");
        for (int i = 0; i < Columnas; i += 1) {
            System.out.print("____");
        }

        System.out.println("");
        for (int i = 0; i < Filas; i++) {
            System.out.print("       ");
            for (int j = 0; j < Filas; j++) {
                System.out.print(" | " + tabla[i][j]);
            }

            System.out.println(" |");
            if (i < Filas - 1) {
                System.out.print("        |");
                for (int p = 1; p < Columnas - 1; p += 1) {
                    System.out.print("––––––");
                }
                System.out.println("|");
            }
        }

        System.out.print("         ");
        for (int i = 1; i < Columnas + 1; i += 1) {
            System.out.print("¯¯¯¯");
        }
        System.out.println("");
    }

    public void verificadorGanador(String auxiliarJugador, String auxilarCaracter) {
        for (int i = 1; i < Filas; i += 1) {
            for (int j = 0; j < Columnas - 3; j += 1) {
                if (tablero[i][j].equals(auxilarCaracter) && tablero[i][j + 1].equals(auxilarCaracter) && tablero[i][j + 2].equals(auxilarCaracter) && tablero[i][j + 3].equals(auxilarCaracter)) {
                    Fin = true;
                    mostrarTablero(tablero);
                    System.out.println("¡¡¡HA GANADO: " + auxiliarJugador + " CONECTÓ 4 HORIZONTALMENTE!!!");
                }
            }
        }

        for (int i = 0; i < Filas; i += 1) {
            for (int j = 0; j < Columnas - 3; j += 1) {
                if (tablero[j][i].equals(auxilarCaracter) && tablero[j + 1][i].equals(auxilarCaracter) && tablero[j + 2][i].equals(auxilarCaracter) && tablero[j + 3][i].equals(auxilarCaracter)) {
                    Fin = true;
                    mostrarTablero(tablero);
                    System.out.println("¡¡¡HA GANADO: " + auxiliarJugador + " CONECTÓ 4 VERTICALMENTE!!!");
                }
            }
        }

        for (int i = 0; i < Columnas - 4 + 1; i += 1) {
            for (int j = 0; j < Filas - 4 + 1; j += 1) {
                if (tablero[j][i].equals(auxilarCaracter) && tablero[j + 1][i + 1].equals(auxilarCaracter) && tablero[j + 2][i + 2].equals(auxilarCaracter) && tablero[j + 3][i + 3].equals(auxilarCaracter)) {
                    Fin = true;
                    mostrarTablero(tablero);
                    System.out.println("¡¡¡HA GANADO: " + auxiliarJugador + " CONECTÓ 4 DIAGONALMENTE!!!");
                }
            }
        }

        for (int i = Columnas; i > 3; i -= 1) {
            for (int j = 0; j < Filas - 3; j += 1) {
                if (tablero[j][i - 1].equals(auxilarCaracter) && tablero[j + 1][i - 2].equals(auxilarCaracter) && tablero[j + 2][i - 3].equals(auxilarCaracter) && tablero[j + 3][i - 4].equals(auxilarCaracter)) {
                    Fin = true;
                    mostrarTablero(tablero);
                    System.out.println("¡¡¡HA GANADO: " + auxiliarJugador + " CONECTÓ 4 DIAGONALMENTE!!!");
                }
            }
        }
    }
}



// rellenar todo el tablero con "O" (todas las casillas del tablero, es decir, todos los strings del tablero)
// con dos fors (un dentro de otro)

// luego ya empezar el juego
// el juego es un bucle (un while)
// ¿que haces en ese while?
// Primero primero, imprimir el tablero (con dos fors)
// primero le pides la columna ("En que columna quieres tirar?")
// luego buscas en esa columna del tablero, la primera casilla que tenga una "O" (de abajo a arriba) (con un for)
// Y a esa casilla le pones una "X" (siempre X)-. Ahora lo interesante es que las x se vayan "amontonando" en una columna

// Mas adelante lo que tienes que hacer es pasar el turno