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
public class Battle {
   
 public static void main(String[] args) {
    Scanner s = new Scanner (System.in);

   //Creacion del Tablero 
  char tablero[][] = new char [6][6];
       for (int i=0; i<6; i++)
        for (int j=0; j<6; j++)
         tablero[i][j]='_';  
       
       //ineas que tendra el tablero
         for (int i=0; i<6; i++)
         {
             for (int j=0; j<6; j++)
             {
                 System.out.print(tablero[i][j]);
                 System.out.print(" ");
             }
             System.out.println(" ");
         }
        
  //Se declararon los tiros que el jugador tiene para terminar 
     int tiros = 0;

 do 
  {     
     
 //Aqui le pediremos al usuario que ingrese las coordenadas  
   int col = 0;    
   int fila =0; 
   tiros+=1; 
   //Muestra el tiro actual del jugador
   
    System.out.println("                                             ");       
    System.out.println("Tu tiro actual es el"+ "  "+ tiros);    
    System.out.println("                                             "); 
   
    
    System.out.println("                                             ");    
    System.out.println("Ingrese donde quiere atacar");
    System.out.println("Fila:");
    fila=s.nextInt();
    System.out.println("Columna");
    col=s.nextInt();
    
    //Mostrar donde cayó el golpe, muestra con * 
 
    tablero[fila][col]='*';
    
       for (int i=0; i<6; i++)
         {
             for (int j=0; j<6; j++)
             {
                 System.out.print(tablero[i][j]);
                 System.out.print(" ");
             }
             System.out.println(" ");
         }   
       
         
     //Mensaje de acierto o de fallo
       
    //Buque 1: Ubicacion
     int buques =0; 
     switch (buques)
     {
         case 1:   
           if (fila==2 && col ==0)
           {
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           System.out.print ("El disparo cayo en BUQUE!");
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           } break; 
           
           
         case 2: 
          if (fila==2 && col ==1)
           {
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           System.out.print ("El disparo cayo en BUQUE!");
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           } break; 
         
    //Buque 2: Ubicacion   
         case 3:
           if (fila==5 && col ==6)
           {
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           System.out.print ("El disparo cayo en BUQUE!");
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           } break; 
           
           
         case 4:    
           if (fila==5 && col ==7)
           {
           System.out.println("                                             ");    
           System.out.println("                                             ");    
           System.out.print ("El disparo cayo en BUQUE!");
           System.out.println("                                             ");    
           System.out.println("                                             "); 
           
           } break;
             
         default:  
                 {
             System.out.println("                                             ");    
           System.out.println("                                             ");    
           System.out.print ("El disparo cayo en AGUA!");
           System.out.println("                                             ");    
           System.out.println("                                             "); 
         }
     }
         
 } 
 

 // Mensaje cuando se le acaban los tiros. 
 while (tiros<3);
 {
     System.out.println ("Se te acabaron los tiros");
     System.out.println ("Fin del Juego");
 }  
 
}      
}