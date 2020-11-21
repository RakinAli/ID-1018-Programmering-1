package Ov3;
import java.util.*;
class BestemDenKortasteVagen
{
    public static void main(String[]args)
    {
         // Inmatningsverktyg
         Scanner in = new Scanner (System.in);
         in.useLocale (Locale.US);

         // Mata in upppgifter om hur många stationer alla zoner har 
         System.out.println("Zon 1 har endast en station därmed endast en väg till Zon 2");
         System.out.println(" ");
         System.out.println("Hur många stationer har Zon 2 ");
         int AntalStationerZon2 = in.nextInt();
         System.out.println(" ");
         System.out.println("Hur många stationer har Zon 3");
         int AntalStationerZon3 = in.nextInt();
         System.out.println(" ");
         System.out.println("Zon 4 har endast en statation därmed endast en väg till slutsation Från Zon 3");
         System.out.println("");
        
         // plats att lagra alla sträckor
         double[] a = new double[AntalStationerZon2 + 1];
         double[][] b = new double[AntalStationerZon2 + 1][AntalStationerZon3 + 1];
         double[] c = new double[AntalStationerZon3 + 1];

         // Lagra och mata in alla sträckor 
         for(int StationerA = 1; StationerA<=AntalStationerZon2; StationerA++)
          { 
               // Från Zon 1 till Zon 2 
               System.out.println("Sträckan från Zon 1 till Zon 2: station " + StationerA + " är: ");
               a[StationerA] = in.nextDouble();
               System.out.println("");
            
               // Från Zon 2 till Zon 3
               for(int StationerB = 1; StationerB <=AntalStationerZon3; StationerB++)
               { 
                    System.out.println("Sträckan från Zon 2 : Station " + StationerA + " till Zon 3: Station " + StationerB + " är");
                    b[StationerA][StationerB] = in.nextDouble();
               } 
               System.out.println("");
          } 
          System.out.println("");

          // Från Zon 3 till Zon 4
          System.out.println("Vägen till slutationen som ligger i Zon 4");
          for(int StationerB = 1; StationerB<= AntalStationerZon3; StationerB++)
          {
               System.out.println("Sträckan från Zone 3: Station " + StationerB + " till Zone 4 är ");                 
               c[StationerB] = in.nextDouble();
               System.out.println(""); 
          } 
        
          //Visa Tabellen för alla vägar 
          System.out.println("Vägarna");
          for(int StationerA = 1; StationerA<=AntalStationerZon2; StationerA++)
          {
               for(int StationerB = 1; StationerB <=AntalStationerZon3; StationerB++)
               {
                    System.out.println(a[StationerA] + " - " + b[StationerA][StationerB] + " - " + c[StationerB] + " - ");
               }
          System.out.println("");
          }
         System.out.println("Den kortaste sträckan är " + DenKortasteVagen.langd(a, b, c));
         int[] mellanstationer = DenKortasteVagen.mellanstationer(a, b, c);

         System.out.println("Vägen dit är U" + mellanstationer[0] + " och V" + mellanstationer[1] );
     } 
}