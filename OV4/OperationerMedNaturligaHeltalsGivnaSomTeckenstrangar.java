package OV4;
import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main (String[] args)
    {
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner in = new Scanner (System.in);
        out.println ("En naturlig heltal:");
        String tal1 = in.next ();
        System.out.println("Din nästa tal, tal 2,");
        String tal2 = in.next ();
        out.println ();
    
        // addera heltalen och visa resultatet
        String summa = addera (tal1, tal2);
        visa (tal1, tal2, summa, '+');
        
        // subtrahera heltalen och visa resultatet
        String subtraktion = subtrahera(tal1, tal2);
        visa(tal1, tal2, subtraktion,'-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2)
    {
        StringBuilder tal = new StringBuilder("");
        int siffra1 = 0;
        int siffra2 = 0;
        int minnessiffra = 0;
        int resultat = 0;
        int position1 = tal1.length()-1;
        int position2 = tal2.length()-1;

        
        // Fortsätt addera tills det finns inga siffror i båda  
        while(position1>= 0 && position2>=0)
        {
            siffra1 = tal1.charAt(position1) - 48;
            siffra2 = tal2.charAt(position2) - 48;
            
            // Minnessiffra blir 1 ifall Summan blir större än 10 och ska till nästa tal 
            if(siffra1 + siffra2 >= 10)
            minnessiffra = 1;
            
            // Lägger till alla tal på Strinbuilder tal från höger till vänster så jag slipper reverse skiten
            tal.insert(0,resultat);
          
            // Så att While loopen fortsätter att minskas och inte kör förevig.
            position1-- ;
            position2--;
        }   

        while(position1>= 0)
        {
            siffra1 = tal1.charAt(position1) - 48;
            resultat = (siffra1 + minnessiffra) %10;
            
            // Minnessiffra blir 1 ifall Summan blir större än 10 och ska till nästa tal 
            if(siffra1 + minnessiffra >= 10)
            minnessiffra = 1;
            
            // Lägger till alla tal på Strinbuilder tal från höger till vänster så jag slipper reverse skiten
            tal.insert(0,resultat);
          
            // Så att While loopen fortsätter att minskas och inte kör förevig.
            position1-- ;
        }
      
        while(position2>=0)
        {
            siffra2 = tal2.charAt(position2) - 48;
            resultat = (siffra2 + minnessiffra) %10;
            
            // Minnessiffra blir 1 ifall Summan blir större än 10 och ska till nästa tal 
            if(siffra2 + minnessiffra >= 10)
            minnessiffra = 1;
            
            // Lägger till alla tal på Strinbuilder tal från höger till vänster så jag slipper reverse skiten
            tal.insert(0,resultat);
          
            // Så att While loopen fortsätter att minskas och inte kör förevig.
            position2--;
        }

        // Hantera Carry out
        if (minnessiffra >= 1)
        tal.insert(0,minnessiffra); 
    
        return tal.toString();
    }
 
    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2)
    {
        StringBuilder tal = new StringBuilder("");
        int siffra1 = 0;
        int siffra2 = 0;
        int minnessiffra = 0;
        int resultat = 0;
        int position = tal1.length()-1;
        tal2 = läggNollor(tal2 , tal1.length() - tal2.length());

        while(position>= 0)
        {
            siffra1 = tal1.charAt(position) - 48;
            siffra2 = tal2.charAt(position) - 48;
            
            //  Minnessiffran blir 10 ifall Siffra 1 < Siffra 2  
            if (siffra2 > siffra1-minnessiffra)
            {
                resultat = (siffra1 + 10) - minnessiffra - siffra2;
                minnessiffra = 1;
            }
            else
            {
                resultat = siffra1 - minnessiffra - siffra2;
                minnessiffra = 0;
            }
        
            // Lägger till alla tal på Stringbuilder tal från höger till vänster så jag slipper reverse skiten
            tal.insert(0,resultat);
          
            // Så att While loopen fortsätter att minskas och inte kör förevig.
            position-- ;
        }
        return tal.toString();
    }
 
    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2, String resultat, char operator)
    {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length ();
        int len2 = tal2.length ();
        int len = resultat.length ();
        int maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);
        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);
        
        // visa heltalen och resultatet
        out.println (" " + tal1);
        out.println ("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
        out.print ("-");
        out.println ();
        out.println (" " + resultat + "\n");
    }
 
    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal)
    {   
        StringBuilder sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");
        return sb.toString ();
    }

    // En metod som lägger till nollor så tal 2 blir lika lång som tal 1. 
    public static String läggNollor (String s, int antal)
    {   
        StringBuilder sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, "0");
        return sb.toString ();
    }
}
