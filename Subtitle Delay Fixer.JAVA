//Fixing Subtitle Delay
// ICPC GP Mexico 2021
//Problem F

import java.io.*;
import java.text.*;
import java.util.*;

class F{
public static void main(String[] args){
Scanner s = new Scanner(System.in);
int N = s.nextInt(); // Number of subtitles to fix
float D = s.nextFloat(); //Delay in seconds
F.arreglarDelay(N,D);
}

public static void arreglarDelay(int N, float D){
  Scanner s = new Scanner(System.in);
  DecimalFormat df = new DecimalFormat("0.000");
  NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
  df = (DecimalFormat)nf;
  DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
  otherSymbols.setDecimalSeparator(',');
   byte c;
  for(int i =0; i < N; i++){
   byte hours = s.nextByte(); //Initial hour of first subtitle
   int minutes = s.nextInt(); //Initial minute of first subtitle
   double seconds = s.nextDouble(); //Initial second of first subtitle
   byte hoursF = s.nextByte(); //Final hour of first subtitle
   int minutesF = s.nextInt(); //Final minute of first subtitle
   double secondsF = s.nextDouble(); //Final second of first subtitle 
   seconds += D;
   secondsF += D;
    s.nextLine();
    String sub = s.nextLine();
   if(seconds > 59.999){
      seconds = (seconds - 60.0);
      minutes++;
      }
   if(minutes > 59){
      minutes = (minutes - 60);
      hours++;
      }
   if(secondsF > 59.999){
      secondsF = (secondsF - 60.0);
      minutesF++;
      }
   if(minutesF > 59){
      minutesF = (minutesF - 60);
      hoursF++;
     }
       System.out.println((i+1)+"\n"+hours+":"+minutes+":"+df.format(seconds)+" --> "+hoursF+":"+minutesF+":"+df.format(secondsF));
       boolean f = sub.endsWith(".");
       if(f)
         c = 0;
         else
         c=1;
       if (i ==0 || c==1){
         System.out.println(" - "+sub);
            }else{
            System.out.println(sub);
            }
        }  
      }
   
   }
   
