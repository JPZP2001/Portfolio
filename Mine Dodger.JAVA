//Eduardo Flores 568379 Juan Pablo Zubieta 562827
//Fall 2020
//Juego del tablero donde tienes que llegar a la meta sin tocar obstáculos

import java.io.*;
import java.util.*;

class JuegoTablero {

  public static void imprimirArreglo(char[][] arreglo) { //Imprimir el arreglo
    for (int i = 0; i < arreglo.length; i++) { 
      for (int j = 0; j < arreglo[i].length; j++) {
        System.out.print("[ " + arreglo[i][j] + " ]");
      }
      System.out.println();
    }
  }

  public static void llenarArreglo(char[][] arreglo) { //Llenar arreglo con espacios vacíos
    for (int i = 0; i < arreglo.length; i++) {
	    for (int j = 0; j < arreglo[i].length; j++) {
    	  arreglo[i][j] = ' ';
      }
    }
  }

  public static void posicionarObjetos(char[][] arreglo, int cantidad, char objeto) { //Posicionar obstáculos y meta en el arreglo, usando el mismo metodo con diferentes parametros
    byte columnaAleatoria, filaAleatoria;
    for (byte i = 0; i < cantidad; i++) {
      filaAleatoria = (byte)(Math.random() * 8);
      columnaAleatoria = (byte)(Math.random() * 7);
        if (arreglo[filaAleatoria][columnaAleatoria] == ' ') {
          if (filaAleatoria == 0 || filaAleatoria == 7 || columnaAleatoria == 0 || columnaAleatoria == 6) {
            if ((filaAleatoria == 0) && (columnaAleatoria == 0) && (arreglo[filaAleatoria + 1][columnaAleatoria + 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((filaAleatoria == 0) && (columnaAleatoria == 6) && (arreglo[filaAleatoria + 1][columnaAleatoria - 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((filaAleatoria == 7) && (columnaAleatoria == 0) && (arreglo[filaAleatoria - 1][columnaAleatoria + 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((filaAleatoria == 7) && (columnaAleatoria == 6) && (arreglo[filaAleatoria - 1][columnaAleatoria - 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((filaAleatoria == 0) && (columnaAleatoria != 0) && (columnaAleatoria != 6) && (arreglo[filaAleatoria + 1][columnaAleatoria - 1] == ' ') && (arreglo[filaAleatoria + 1][columnaAleatoria + 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((filaAleatoria == 7) && (columnaAleatoria != 0) && (columnaAleatoria != 6) && (arreglo[filaAleatoria - 1][columnaAleatoria - 1] == ' ') && (arreglo[filaAleatoria - 1][columnaAleatoria + 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((columnaAleatoria == 0) && (filaAleatoria != 0) && (filaAleatoria != 7) && (arreglo[filaAleatoria + 1][columnaAleatoria + 1] == ' ') && (arreglo[filaAleatoria - 1][columnaAleatoria + 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else if ((columnaAleatoria == 6) && (filaAleatoria != 0) && (filaAleatoria != 7) && (arreglo[filaAleatoria + 1][columnaAleatoria - 1] == ' ') && (arreglo[filaAleatoria - 1][columnaAleatoria - 1] == ' '))
              arreglo[filaAleatoria][columnaAleatoria] = objeto;
            else
              i--; //Si no estaba disponible ese espacio, se intenta con otro diferente 
            continue;
          }
          if (arreglo[filaAleatoria + 1][columnaAleatoria + 1] != objeto && arreglo[filaAleatoria - 1][columnaAleatoria + 1] != objeto && arreglo[filaAleatoria + 1][columnaAleatoria - 1] != objeto && arreglo[filaAleatoria - 1][columnaAleatoria - 1] != objeto)
            arreglo[filaAleatoria][columnaAleatoria] = objeto;
          else
            i--; //Si no estaba disponible ese espacio, se intenta con otro diferente 
        } 
        else
          i--; //Si ya había un obstáculo en ese espacio, se intenta con otro diferente 
    }
  }

  public static void validarPosicion(char[][] arreglo, byte fila, byte columna) { //Para que no aparezca encima de un '#', o completamente rodeado de obstáculos
    switch (arreglo[fila][columna]) {
      case '#' : 
        posicionarObjetos(arreglo, 1, '#'); //Si el * se intenta poner encima de un #, se buscan nuevas posiciones
        break;
      case 'M' : 
        posicionarObjetos(arreglo, 1, 'M'); //Si el * se intenta poner encima de una M, se buscan nuevs posiciones
        break;
    }
    arreglo[fila][columna] = '*';
  }

  public static byte ejecucionJuego(char[][] arreglo, byte fila, byte columna, byte estado) { //Ejecución del juego: moverse arriba, abajo, izquierda, derecha y ganar o perder
    Scanner input = new Scanner(System.in);
    char mov;
    do { 
      validarPosicion(arreglo, fila, columna);//Primero se valida la posicion
      imprimirArreglo(arreglo);//Luegoo se imprime el arreglo
      arreglo[fila][columna] = ' ';
      mov = input.nextLine().charAt(0);
      if (mov == 'w' && fila != 0) //Arriba
        fila -= 1;
      else if (mov == 's' && fila != 7) //Abajo
        fila += 1;
      else if (mov == 'a' && columna != 0) //Izquierda
        columna -= 1;
      else if (mov == 'd' && columna != 6) //Derecha
        columna += 1;
      if (arreglo[fila][columna] == '#') //Perder
        estado -= 1;
      else if (arreglo[fila][columna] == 'M') //Ganar
        estado += 1;
    } while (estado == 0);
    return estado;
  }

  public static void finJuego(byte estado) { //Determinar si se ganó o se perdió gracias al valor de "estado" que se le suma 1 si llega  a la meta y se le resta 1 si choca con un obstaculo
    switch (estado) {
      case 1 :
        System.out.println("\n¡Ganaste!\n");
        break;
      case -1 :
        System.out.println("\nPerdiste :( Intenta de nuevo...\n");
        break;
    }
  }
  
  public static void main(String[] args) {
    char repetir = 's';
    Scanner input = new Scanner(System.in);
    char[][] tablero = new char[8][7]; 
    byte estado, columna, fila;
    System.out.println("Utiliza (w) para moverte arriba, (a) para izquierda, (s) para abajo y (d) para moverte a la derecha");
    do { //Repetir métodos de juego hasta ganar
      estado = 0;
      fila = (byte)(Math.random() * 8);
      columna = (byte)(Math.random() * 7);
      llenarArreglo(tablero);
      posicionarObjetos(tablero, 6, '#');
      posicionarObjetos(tablero, 1, 'M');
      estado = ejecucionJuego(tablero, fila, columna, estado);
      finJuego(estado);
      if (estado == 1) {
        System.out.println("¿Quieres jugar otra ronda? Elija [s/n]");
        do {
          System.out.println("Ingrese una opcion valida");
          repetir = input.nextLine().charAt(0);
        }while (repetir != 's' & repetir !='n');
      }
    } while (repetir =='s');
  }
}
