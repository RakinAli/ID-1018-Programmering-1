package Ov1;

import java.util.*; // Scanner, Locale

class Temperaturer
{
    public static void main (String[] args)
    {
       System.out.println ("TEMPERATURER, av Ali Rakin\n");

       // inmatningsverktyg
       Scanner in = new Scanner (System.in);
       in.useLocale (Locale.US);

       // mata in uppgifter om antalet veckor och antalet mätningar
       System.out.print ("antalet veckor: ");
       int antalVeckor = in.nextInt ();
       System.out.print ("antalet mätningar per vecka: ");
       int antalMatningarPerVecka = in.nextInt ();
  
       // plats att lagra temperaturer
       double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

       // mata in temperaturerna
       for (int vecka = 1; vecka <= antalVeckor; vecka++)
       {
          System.out.println ("temperaturer - vecka " + vecka + ":");
          for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
             t[vecka][matning] = in.nextDouble ();    
       } 
          System.out.println ();

       // visa temperaturerna
       System.out.println ("temperaturerna:");
       for (int vecka = 1; vecka <= antalVeckor; vecka++)
       {
          for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
             System.out.print (t[vecka][matning] + "      ");
             System.out.println ();
       }
          System.out.println ();      
          // den minsta, den största och medeltemperaturen – veckovis
       double[] minT = new double[antalVeckor + 1];
       double[] maxT = new double[antalVeckor + 1];
       double[] sumT = new double[antalVeckor + 1];
       double[] medelT = new double[antalVeckor + 1];
          
       // visa den minsta, den största och medeltemperaturen för varje vecka
       for (int vecka = 1; vecka <= antalVeckor ; vecka++)
       {
          minT[vecka] = t[vecka][1];
          maxT[vecka] = t[vecka][1];
          sumT [vecka] = t[vecka][1];
          
          for (int matning = 2; matning <= antalMatningarPerVecka ; matning++)
          { 
             // Koder för Minsta temperatur
             if (t[vecka][matning] < minT[vecka])
                minT[vecka] = t[vecka][matning];
            
                // Koder för Max Temperatur
                if (t[vecka][matning] > maxT[vecka])
                   maxT[vecka] = t[vecka][matning];
               
                // Kod för Summan
                sumT[vecka] += t[vecka][matning];
          } 
          // Kod för MedelTemperatur
          medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;

          // Formattering av hur den ska printa ut medel,min,max och summa veckovis
          System.out.println("Resultat för vecka " + vecka);
          System.out.println(maxT[vecka]+ " - Max Temperatur    vecka: " + vecka);
          System.out.println(minT[vecka]+ " - Mista Temperatur    vecka: " + vecka);
          System.out.println("Summan av alla mätvärden =" + sumT[vecka]);
          System.out.println("Antal matvärden är " + antalMatningarPerVecka);
          System.out.println("Medelvärdet för vecka " + vecka + " är: " + medelT[vecka]);
          System.out.println(" ");
       }

       // Den minsta, den största och medeltemperaturen - hela mätperioden
       double minTemp = minT[1];
       double maxTemp = maxT[1];
       double sumTemp = sumT[1];
       double medelTemp = 0;

       // visa den minsta, den största och medeltemperaturen i hela mätperioden
       for(int vecka = 2; vecka <=antalVeckor; vecka++)
       {   
          // Koden för minsta Temperaturen under hela mätperioden
          if(minTemp > minT[vecka])
             minTemp = minT[vecka];

          // Koden för största Temperaturen under hela mätperioden
          if(maxTemp < maxT[vecka]);
             maxTemp = maxT[vecka];

          // Koden för totala Summan under hela mätperioden 
          sumTemp+= sumT[vecka];
       }
       // Koden för medeltemperatur under hela mätperioden
       medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);

       //Printa ut svaret
       System.out.println("Minsta Temperaturen under hela mätperioden är: " + minTemp);
       System.out.println("Största Temperaturen under hela mätperioden är: " + maxTemp);
       System.out.println("Totala summan av alla temperaturer är " + sumTemp);
       System.out.println("Medelvärde av alla temperatureer under perioden är: "+ medelTemp);   
       System.out.println("");
      }
}