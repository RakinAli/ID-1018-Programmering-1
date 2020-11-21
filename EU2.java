package EU2;
import java.util.*;
public class EU2
{
    public void sortera(int antalElementer, double[] elementer)
    {
        int tal1 = 0;
        for(tal1=0; tal1< antalElementer;tal1++)
        {
            int tal2 = tal1 + 1;
            while (tal2 < antalElementer)
            {
                if(elementer[tal2] < elementer[tal1])
                { 
                    double temp2 = elementer[tal2];
                    double temp1 = elementer[tal1];
                    elementer[tal1] = temp2;
                    elementer[tal2] = temp1;
                }
                tal2++;
            }
        } 
    }
    
    public static void main(String[]args)
    {
        //Inmatningsverktyg
        Scanner in = new Scanner (System.in);
      
        // Introduktion till programmet
        System.out.println("Denna program sorterar dina siffror i ordning från minsta till största.");   
        System.out.println("Den kommer först lagra allt i en Array sedan sortera Arrayn");
        
        // Användaren skriver in hur många elementer och definierar elementerna 
        System.out.println("Hur många siffror vill du lagra i en array?");
        int antalElementer = in.nextInt();
        System.out.println("Skrinv in dina siffror ");
        double[] vektor = new double[antalElementer];

        for(int i=0; i< antalElementer; i++)
        {
            System.out.println("Denna siffra kommer lagras på position " + i);
            vektor[i] = in.nextInt();
        }
       
        // Printar ut resultat 
        System.out.println("Här är din vektor" );
        System.out.print("[");
        for(int i =0; i < antalElementer; i++)
        {
            System.out.print( vektor[i] + " " );
        }
        System.out.println("]");
       
        // Sorteringen  
        EU2 objekt = new EU2();
        objekt.sortera(antalElementer, vektor); // Skapar en objekt av klassen sedan hämtar dess attributer 
        System.out.println("Här är alla siffror sorterat");
        System.out.println (java.util.Arrays.toString (vektor));

        //System.out.println("Här är sorteringen");
        // _________ Fråga Fadil eller Bengt om hur man ser själva sorteringen så det blir lättare att fatta minneskomplexitet________
    }

}