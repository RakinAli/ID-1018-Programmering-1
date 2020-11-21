package Ov2;
class Triangel
{

     // En metod som tar alla längder på en Triangel sedan returnerar Omkretsen
     public static double Circumference (Double l1, Double l2, Double l3)
     {
          double circumference = l1 + l2 + l3 ;
          return circumference;
     }

     /*  Bisektris tar emot två sidor i en traingel och vinkeln (i radianer) mellan dessa sidor. 
     Metoden returnerar längden av den motsvarande bisektrisen - den som delar den givna vinkeln i två lika delar. */

     public static double bisektris (double b, double c, double alfa)
     {
         double p = 2 * b * c * Math.cos (alfa / 2);
         double bis = p / (b + c);
         return bis;
     }

     // En metod som beräknar Semiperimeter
     private static double semiP (double a, double b , double c)
     {
         double semiperimeter = 0.5 * (a+b+c);
         return semiperimeter;
     }

     // En metod som beräknar radie för inskriven cirkel
     public static double inskrivnaCirkeln (double a, double b, double c)
     {
         double semiperimeter = semiP(a, b, c);
         double radie = Math.sqrt(( (semiperimeter - a)*(semiperimeter - b)*(semiperimeter - c) )/ semiperimeter);
         return radie;
     }

     // En metod som beräknar Omskriven cirkeln , "wikedia shit"
     public static double omskrivnaCirckeln (double a, double b, double c)
    {
        double semiperimeter = semiP(a, b, c);
        double radie = (a*b*c) /(4 * Math.sqrt(semiperimeter*(semiperimeter-a)*(semiperimeter-b)* (semiperimeter-c)));
        return radie;
    }   
}