import java.io.*;
import java.util.Random;
import java.text.*;
import java.math.*;
import java.util.*;

class Juego {

public static int enemigo(int ranEnemigo){
Random random = new Random();  
ranEnemigo = (int)Math.floor(Math.random()*(8000-5001)+5000);
return ranEnemigo;
}

public static int attack(int ranAttack){
Scanner s = new Scanner(System.in);
Random random = new Random();
System.out.println("Choose an attack: "+"\n"+"1) Fast Jab"+"\n"+"2) Fire Kick"+"\n"+"3) Fire ball!!!");
byte a = s.nextByte();
if(a == 1)
   ranAttack = (int)Math.floor(Math.random()*(1000-401)+400);
   else if (a==2){
      ranAttack = (int)Math.floor(Math.random()*(1500-201)+200);;
      }else{
       ranAttack= random.nextInt(2000);
       }
return ranAttack;
}

public static void combate(int ranEnemigo, int ranAttack){
byte c = 0;
byte fightResult = 0;
byte fight = 0;
do{
ranAttack = Juego.attack(ranAttack);
if(ranAttack <= 333){
   System.out.println("Su ataque fue poco efectivo!!!");
}else if(ranAttack <= 666){
   System.out.println("Su ataque fue efectivo!!!!");
   }else{
      System.out.println("Su ataque fue super efectivo!!!!");
      }
ranEnemigo -= ranAttack;
System.out.println("Azoth el Conquistador");
System.out.println("HP: "+ranEnemigo);
c++;
if(ranEnemigo <= 1 || c == 7)
   fight = 1;
} while (fight == 0);
if(c == 7)
   fightResult = 0;
else
   fightResult = 1;
if(fightResult == 1)
System.out.println("Azoth ha sido derrotado");
else{
   System.out.println("Azoth te ha derrotado!!!!");
   }
}

public static void main(String[] args){
int ranAttack = 0;
int ranEnemigo = 0;
int combat = 0;
ranEnemigo = Juego.enemigo(ranEnemigo);
System.out.println("Azoth el Conquistador");
System.out.println("HP: "+ranEnemigo);
Juego.combate(ranEnemigo, ranAttack);
}
}


