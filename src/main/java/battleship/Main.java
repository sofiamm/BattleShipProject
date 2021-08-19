/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sofia.mora
 */
public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //se guarda la opcion del usuario

        System.out.println("1. Atacar");
        System.out.println("2. Ver tablero de ataque");
        System.out.println("3. Ver tablero propio");
        System.out.println("4. Hacer trampa");
        System.out.println("5. Salir");

        try {

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    Battle batalla= new Battle();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion 4");
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            sn.next();
        }

    }

}
