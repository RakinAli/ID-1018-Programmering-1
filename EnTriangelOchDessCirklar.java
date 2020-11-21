package Ov2;
import java.util.*;

class EnTriangelOchDessCirklar{

    public static void main(String[]args)
    {
         //Inmatningsverktyg
         Scanner in = new Scanner (System.in);

         //Mata in sidorna 
         System.out.println("Ange längden av sida A");
         double aSida = in.nextDouble();
         System.out.println("Ange längden av sida B");
         double bSida = in.nextDouble();
         System.out.println("Ange längden av sida C");
         double cSida = in.nextDouble();  
         System.out.println("Ange vinkeln i radianer");
         double vinkel = in.nextDouble();

         // Spacing
         System.out.println("");
    
         // Printa ut Omkretsen
         System.out.println("Omkretsen är: " + Triangel.Circumference(aSida, bSida, cSida) + " Omkrets enheter");
         System.out.println(" ");
         
         // Inskrivna cirkelns radie för den traigenl vars sidor är givna
         System.out.println( "Radien av den inskriva Cirkeln är " + Triangel.inskrivnaCirkeln(aSida, bSida, cSida) + " radie enheter");
         System.out.println(" ");

         // Omskrivna cirkelns radie för den triangel vars sidor är givna
         System.out.println("Radien av den omskrivna Cirkeln är :" + Triangel.omskrivnaCirckeln (aSida, bSida, cSida) + " radie enheter");
         System.out.println(" ");

         // Bisektris av den triangel vars sidor är givna - Fadils kod
         System.out.println( "Längden av bisektrisen från hörnet A är: " + Triangel.bisektris(bSida, cSida, vinkel) );
         System.out.println(" ");
    }
}