/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author sofia.mora
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Battle {

    public static void main(String[] args) {
        //Se declaración de variables:
        int tiros = 0;
        int randomTiros = 0;
        int col = 0;
        int fila = 0;
        int almirante = 4;
        int capitan1 = 3;
        int capitan2 = 3;
        int teniente = 3;
        int trampa = 0;
        int nave = 0;
        int random = 0;
        int verTablero = 0;
        int jugador = 1;
        boolean victoria = false;

        Scanner s = new Scanner(System.in);

        String nombreCPU = JOptionPane.showInputDialog("Ingrese un nombre para el CPU: ");
        String nombreUser = JOptionPane.showInputDialog("Ingrese su nombre: ");

        System.out.println("¿Quién juega primero? (1/2) ");
        int opcion = s.nextInt();

        switch (opcion) {
            case 1:
                do {
                    //TABLERO CPU
                    System.out.println("----------------");
                    System.out.println("| TABLERO DE " + nombreCPU + " |");
                    System.out.println("----------------");

                    char tablero[][] = new char[6][6];
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            tablero[i][j] = '_';
                        }
                    }

                    //ineas que tendra el tablero
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print(tablero[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println(" ");
                    }
                    do {
                        //Limpiar pantalla
                        //System.out.print("\033[H\033[2J");
                        //System.out.flush();

                        tiros += 1;
                        //Muestra el tiro actual del jugador
                        System.out.println(" ");
                        System.out.println("Tu tiro actual es el" + "  " + tiros);
                        System.out.println("Ingrese donde quiere atacar:");
                        System.out.println("Fila:");
                        fila = s.nextInt();
                        System.out.println("Columna:");
                        col = s.nextInt();
                        System.out.println("* Si quieres hacer trampa escribe 1 de lo contrario escribe 0:");
                        trampa = s.nextInt();
                        //Mostrar donde cayó el golpe, muestra con * 
                        tablero[fila][col] = '*';

                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                System.out.print(tablero[i][j]);
                                System.out.print(" ");
                            }
                            System.out.println(" ");
                        }
                        if (trampa == 0) {
                            //Mensaje de acierto o de fallo
                            if (fila == 2 && col == 0) {
                                if (almirante <= 4 && almirante > 1) {
                                    System.out.print("¡El disparo cayó en el barco del Almirante! \n");
                                    almirante -= 1;
                                    System.out.print("Al barco le quedan " + almirante + " puntos de vida");
                                    System.out.println(" ");
                                } else {
                                    System.out.print("¡El disparo ha destruido el barco del Almirante!");
                                    System.out.println(" ");
                                }
                            } else if (fila == 2 && col == 1) {
                                if (capitan1 <= 3 && capitan1 > 1) {
                                    System.out.print("¡El disparo cayó en el barco del Capitán #1! \n");
                                    capitan1 -= 1;
                                    System.out.print(" Al barco le quedan " + capitan1 + " puntos de vida");
                                    System.out.println(" ");
                                } else {
                                    System.out.print("¡El disparo ha destruido el barco del Capitán #1!");
                                    System.out.println(" ");
                                }
                            } else if (fila == 5 && col == 2) {
                                if (capitan2 <= 3 && capitan2 > 1) {
                                    System.out.print("¡El disparo cayó en el barco del Capitán #2! \n");
                                    capitan2 -= 1;
                                    System.out.print(" Al barco le quedan " + capitan2 + " puntos de vida");
                                    System.out.println(" ");
                                } else {
                                    System.out.print("¡El disparo ha destruido el barco del Capitán #2!");
                                    System.out.println(" ");
                                }
                            } else if (fila == 3 && col == 4 || fila == 4 && col == 5 || fila == 0 && col == 4) {
                                System.out.print("¡El disparo ha destruido el barco del Teniente!");
                                teniente -= 1;
                                System.out.println(" ");
                            } else {
                                System.out.print("¡El disparo cayó en agua!");
                                jugador = 2;
                            }
                            System.out.println(" ");
                        } else {
                            System.out.println(" ");
                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.print("- El barco del Almirante esta en la fila 2 y columa 0 y le quedan " + almirante + " puntos de vida. \n");
                            System.out.print("- El barco del Cápitan #1 esta en la fila 2 y columa 1 y le quedan " + capitan1 + " puntos de vida. \n");
                            System.out.print("- El barco del Cápitan #2 esta en la fila 5 y columa 2 y le quedan " + capitan2 + " puntos de vida. \n");
                            System.out.print("- El barco del Teniente #1 esta en la fila 3 y columa 4. \n");
                            System.out.print("- El barco del Teniente #2 esta en la fila 4 y columa 5. \n");
                            System.out.print("- El barco del Teniente #3 esta en la fila 0 y columa 4. \n");
                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println(" ");
                        }
                    } while (jugador == 1);
                    if (almirante == 0 && capitan1 == 0 && capitan2 == 0 && teniente == 0) {
                        System.out.println("¡Haz ganado!");
                        victoria = true;

                    } else if (tiros == 0) {
                        // Mensaje cuando se le acaban los tiros.
                        System.out.println("Se te acabaron los tiros");
                    } else if (jugador == 2) {
                        //TABLERO USER
                        //Creacion del TableroUser
                        System.out.println(" ");
                        System.out.println("----------------");
                        System.out.println("| TABLERO DE " + nombreUser + " |");
                        System.out.println("----------------");
                        char TableroUser[][] = new char[6][6];
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                TableroUser[i][j] = '_';
                            }
                        }
                        //ineas que tendra el TableroUser
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                System.out.print(TableroUser[i][j]);
                                System.out.print(" ");
                            }
                            System.out.println(" ");
                        }
                        //Muestra el tiro actual del jugador
                        System.out.println(" ");
                        System.out.println("Asigna tus naves:");
                        System.out.println("¿Quieres asignarlas o que sea random? (1/2)");
                        int naves = s.nextInt();

                        switch (naves) {
                            case 1:
                                //Asignación de naves manual
                                do {
                                    nave += 1;
                                    System.out.println(" ");
                                    System.out.println("Nave " + nave + ":");
                                    System.out.println("Fila:");
                                    fila = s.nextInt();
                                    System.out.println("Columna:");
                                    col = s.nextInt();

                                    if (nave == 2) {
                                        TableroUser[fila][col] = 'A';
                                    } else if (nave == 3) {
                                        TableroUser[fila][col] = 'P';
                                    } else if (nave == 4) {
                                        TableroUser[fila][col] = 'S';
                                    } else {
                                        TableroUser[fila][col] = 'T';
                                    }
                                } while (nave < 6);
                                System.out.println("¿Quieres ver tablero? (0/1)");
                                verTablero = s.nextInt();
                                switch (verTablero) {
                                    case 1:
                                        System.out.println(" ");
                                        for (int i = 0; i < 6; i++) {
                                            for (int j = 0; j < 6; j++) {
                                                System.out.print(TableroUser[i][j]);
                                                System.out.print(" ");
                                            }
                                            System.out.println(" ");
                                        }
                                        break;
                                    default:
                                        System.out.println(" ");
                                }
                                break;

                            case 2:
                                //Asignación de naves random
                                do {
                                    random += 1;
                                    fila = (int) (Math.random() * 6);
                                    col = (int) (Math.random() * 6);

                                    if (random == 2) {
                                        TableroUser[fila][col] = 'A';
                                    } else if (random == 3) {
                                        TableroUser[fila][col] = 'P';
                                    } else if (nave == 4) {
                                        TableroUser[fila][col] = 'S';

                                    } else {
                                        TableroUser[fila][col] = 'T';
                                    }
                                } while (random < 6);
                                System.out.println("¿Quieres ver tablero? (0/1)");
                                verTablero = s.nextInt();
                                switch (verTablero) {
                                    case 1:
                                        System.out.println(" ");
                                        for (int i = 0; i < 6; i++) {
                                            for (int j = 0; j < 6; j++) {
                                                System.out.print(TableroUser[i][j]);
                                                System.out.print(" ");
                                            }
                                            System.out.println(" ");
                                        }
                                        break;
                                    default:
                                        System.out.println(" ");
                                        do {
                                            randomTiros += 1;
                                            System.out.println(" ");
                                            System.out.println("El tiro actual es el" + "  " + randomTiros);
                                            fila = (int) (Math.random() * 6);
                                            col = (int) (Math.random() * 6);
                                            //Mostrar donde cayó el golpe, muestra con * 
                                            TableroUser[fila][col] = '*';

                                            if (TableroUser[fila][col] == 'A') {
                                                if (almirante <= 4 && almirante > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Almirante! \n");
                                                    almirante -= 1;
                                                    System.out.print("Al barco le quedan " + almirante + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Almirante!");
                                                    System.out.println(" ");
                                                }
                                            } else if (TableroUser[fila][col] == 'P') {
                                                if (capitan1 <= 3 && capitan1 > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Capitán #1! \n");
                                                    capitan1 -= 1;
                                                    System.out.print(" Al barco le quedan " + capitan1 + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Capitán #1!");
                                                    System.out.println(" ");
                                                }
                                            } else if (TableroUser[fila][col] == 'S') {
                                                if (capitan2 <= 3 && capitan2 > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Capitán #2! \n");
                                                    capitan2 -= 1;
                                                    System.out.print(" Al barco le quedan " + capitan2 + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Capitán #2!");
                                                    System.out.println(" ");
                                                }
                                            } else if (TableroUser[fila][col] == 'T') {
                                                System.out.print("¡El disparo ha destruido el barco del Teniente!");
                                                teniente -= 1;
                                                System.out.println(" ");
                                            } else {
                                                System.out.print("¡El disparo cayó en agua!");
                                                jugador = 1;
                                            }
                                            System.out.println(" ");
                                        } while (jugador == 2);
                                        if (almirante == 0 && capitan1 == 0 && capitan2 == 0 && teniente == 0) {
                                            System.out.println("¡Haz ganado!");
                                            victoria = true;

                                        } else if (tiros == 0) {
                                            // Mensaje cuando se le acaban los tiros.
                                            System.out.println("Se te acabaron los tiros");
                                        }

                                }
                                break;
                            default:
                                System.out.print("¡Ingrese una opción válida! ");
                        }
                    } else {
                        System.out.print("- El barco del Almirante estaba en la fila 2 y columa 0 y le quedaban " + almirante + " puntos de vida. \n");
                        System.out.print("- El barco del Cápitan #1 estaba en la fila 2 y columa 1 y le quedaban " + capitan1 + " puntos de vida. \n");
                        System.out.print("- El barco del Cápitan #2 estaba en la fila 5 y columa 2 y le quedaban " + capitan2 + " puntos de vida. \n");
                        System.out.print("- El barco del Teniente #1 estaba en la fila 3 y columa 4. \n");
                        System.out.print("- El barco del Teniente #2 estaba en la fila 4 y columa 5. \n");
                        System.out.print("- El barco del Teniente #3 estaba en la fila 0 y columa 4. \n");
                    }
                    break;
                } while (victoria == false);
            case 2:
                //TABLERO USER
                //Creacion del TableroUser
                System.out.println("----------------");
                System.out.println("| TABLERO DE " + nombreUser + " |");
                System.out.println("----------------");
                char TableroUser[][] = new char[6][6];
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        TableroUser[i][j] = '_';
                    }
                }

                //ineas que tendra el TableroUser
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print(TableroUser[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println(" ");
                }
                System.out.println(" ");
                System.out.println("Asigna tus naves:");
                System.out.println("¿Quieres asignarlas o que sea random? (1/2)");
                int naves = s.nextInt();

                switch (naves) {
                    case 1:
                        //Asignación de naves manual
                        do {
                            nave += 1;
                            System.out.println(" ");
                            System.out.println("Nave " + nave + ":");
                            System.out.println("Fila:");
                            fila = s.nextInt();
                            System.out.println("Columna:");
                            col = s.nextInt();

                            if (nave == 2) {
                                TableroUser[fila][col] = 'A';
                            } else if (nave == 3) {
                                TableroUser[fila][col] = 'P';
                            } else if (nave == 4) {
                                TableroUser[fila][col] = 'S';
                            } else {
                                TableroUser[fila][col] = 'T';
                            }
                        } while (nave < 6);
                        System.out.println("¿Quieres ver tablero? (0/1)");
                        verTablero = s.nextInt();
                        switch (verTablero) {
                            case 1:
                                System.out.println(" ");
                                for (int i = 0; i < 6; i++) {
                                    for (int j = 0; j < 6; j++) {
                                        System.out.print(TableroUser[i][j]);
                                        System.out.print(" ");
                                    }
                                    System.out.println(" ");
                                }
                                break;
                            default:
                                System.out.println(" ");
                        }
                        break;

                    case 2:
                        //Asignación de naves random
                        do {
                            random += 1;
                            fila = (int) (Math.random() * 6);
                            col = (int) (Math.random() * 6);

                            if (random == 2) {
                                TableroUser[fila][col] = 'A';
                            } else if (random == 3) {
                                TableroUser[fila][col] = 'P';
                            } else if (nave == 4) {
                                TableroUser[fila][col] = 'S';

                            } else {
                                TableroUser[fila][col] = 'T';
                            }
                        } while (random < 6);
                        System.out.println("¿Quieres ver tablero? (0/1)");
                        verTablero = s.nextInt();
                        switch (verTablero) {
                            case 1:
                                System.out.println(" ");
                                for (int i = 0; i < 6; i++) {
                                    for (int j = 0; j < 6; j++) {
                                        System.out.print(TableroUser[i][j]);
                                        System.out.print(" ");
                                    }
                                    System.out.println(" ");
                                }
                                break;
                            default:
                                System.out.println(" ");
                                do {
                                    randomTiros += 1;
                                    System.out.println(" ");
                                    System.out.println("El tiro actual es el" + "  " + randomTiros);
                                    fila = (int) (Math.random() * 6);
                                    col = (int) (Math.random() * 6);
                                    //Mostrar donde cayó el golpe, muestra con * 
                                    TableroUser[fila][col] = '*';

                                    if (TableroUser[fila][col] == 'A') {
                                        if (almirante <= 4 && almirante > 1) {
                                            System.out.print("¡El disparo cayó en el barco del Almirante! \n");
                                            almirante -= 1;
                                            System.out.print("Al barco le quedan " + almirante + " puntos de vida");
                                            System.out.println(" ");
                                        } else {
                                            System.out.print("¡El disparo ha destruido el barco del Almirante!");
                                            System.out.println(" ");
                                        }
                                    } else if (TableroUser[fila][col] == 'P') {
                                        if (capitan1 <= 3 && capitan1 > 1) {
                                            System.out.print("¡El disparo cayó en el barco del Capitán #1! \n");
                                            capitan1 -= 1;
                                            System.out.print(" Al barco le quedan " + capitan1 + " puntos de vida");
                                            System.out.println(" ");
                                        } else {
                                            System.out.print("¡El disparo ha destruido el barco del Capitán #1!");
                                            System.out.println(" ");
                                        }
                                    } else if (TableroUser[fila][col] == 'S') {
                                        if (capitan2 <= 3 && capitan2 > 1) {
                                            System.out.print("¡El disparo cayó en el barco del Capitán #2! \n");
                                            capitan2 -= 1;
                                            System.out.print(" Al barco le quedan " + capitan2 + " puntos de vida");
                                            System.out.println(" ");
                                        } else {
                                            System.out.print("¡El disparo ha destruido el barco del Capitán #2!");
                                            System.out.println(" ");
                                        }
                                    } else if (TableroUser[fila][col] == 'T') {
                                        System.out.print("¡El disparo ha destruido el barco del Teniente!");
                                        teniente -= 1;
                                        System.out.println(" ");
                                    } else {
                                        System.out.print("¡El disparo cayó en agua!");
                                        jugador = 1;
                                    }
                                    System.out.println(" ");
                                } while (jugador == 2);
                                if (almirante == 0 && capitan1 == 0 && capitan2 == 0 && teniente == 0) {
                                    System.out.println("¡Haz ganado!");

                                } else if (tiros == 0) {
                                    // Mensaje cuando se le acaban los tiros.
                                    System.out.println("Se te acabaron los tiros");
                                } else if (jugador == 2) {
                                    //TABLERO CPU
                                    System.out.println("----------------");
                                    System.out.println("| TABLERO DE " + nombreCPU + " |");
                                    System.out.println("----------------");

                                    char tableroCPU[][] = new char[6][6];
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {
                                            tableroCPU[i][j] = '_';
                                        }
                                    }

                                    //ineas que tendra el tablero
                                    for (int i = 0; i < 6; i++) {
                                        for (int j = 0; j < 6; j++) {
                                            System.out.print(tableroCPU[i][j]);
                                            System.out.print(" ");
                                        }
                                        System.out.println(" ");
                                    }
                                    do {
                                        //Limpiar pantalla
                                        //System.out.print("\033[H\033[2J");
                                        //System.out.flush();

                                        tiros += 1;
                                        //Muestra el tiro actual del jugador
                                        System.out.println(" ");
                                        System.out.println("Tu tiro actual es el" + "  " + tiros);
                                        System.out.println("Ingrese donde quiere atacar:");
                                        System.out.println("Fila:");
                                        fila = s.nextInt();
                                        System.out.println("Columna:");
                                        col = s.nextInt();
                                        System.out.println("* Si quieres hacer trampa escribe 1 de lo contrario escribe 0:");
                                        trampa = s.nextInt();
                                        //Mostrar donde cayó el golpe, muestra con * 
                                        tableroCPU[fila][col] = '*';

                                        for (int i = 0; i < 6; i++) {
                                            for (int j = 0; j < 6; j++) {
                                                System.out.print(tableroCPU[i][j]);
                                                System.out.print(" ");
                                            }
                                            System.out.println(" ");
                                        }
                                        if (trampa == 0) {
                                            //Mensaje de acierto o de fallo
                                            if (fila == 2 && col == 0) {
                                                if (almirante <= 4 && almirante > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Almirante! \n");
                                                    almirante -= 1;
                                                    System.out.print("Al barco le quedan " + almirante + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Almirante!");
                                                    System.out.println(" ");
                                                }
                                            } else if (fila == 2 && col == 1) {
                                                if (capitan1 <= 3 && capitan1 > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Capitán #1! \n");
                                                    capitan1 -= 1;
                                                    System.out.print(" Al barco le quedan " + capitan1 + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Capitán #1!");
                                                    System.out.println(" ");
                                                }
                                            } else if (fila == 5 && col == 2) {
                                                if (capitan2 <= 3 && capitan2 > 1) {
                                                    System.out.print("¡El disparo cayó en el barco del Capitán #2! \n");
                                                    capitan2 -= 1;
                                                    System.out.print(" Al barco le quedan " + capitan2 + " puntos de vida");
                                                    System.out.println(" ");
                                                } else {
                                                    System.out.print("¡El disparo ha destruido el barco del Capitán #2!");
                                                    System.out.println(" ");
                                                }
                                            } else if (fila == 3 && col == 4 || fila == 4 && col == 5 || fila == 0 && col == 4) {
                                                System.out.print("¡El disparo ha destruido el barco del Teniente!");
                                                teniente -= 1;
                                                System.out.println(" ");
                                            } else {
                                                System.out.print("¡El disparo cayó en agua!");
                                                jugador = 2;
                                            }
                                            System.out.println(" ");
                                        } else {
                                            System.out.println(" ");
                                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                            System.out.print("- El barco del Almirante esta en la fila 2 y columa 0 y le quedan " + almirante + " puntos de vida. \n");
                                            System.out.print("- El barco del Cápitan #1 esta en la fila 2 y columa 1 y le quedan " + capitan1 + " puntos de vida. \n");
                                            System.out.print("- El barco del Cápitan #2 esta en la fila 5 y columa 2 y le quedan " + capitan2 + " puntos de vida. \n");
                                            System.out.print("- El barco del Teniente #1 esta en la fila 3 y columa 4. \n");
                                            System.out.print("- El barco del Teniente #2 esta en la fila 4 y columa 5. \n");
                                            System.out.print("- El barco del Teniente #3 esta en la fila 0 y columa 4. \n");
                                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                                            System.out.println(" ");
                                        }
                                    } while (jugador == 1);
                                }
                        }
                        break;
                    default:
                        System.out.print("¡Ingrese una opción válida! ");
                }
        }
    }
}
