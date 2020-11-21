package Ov5;
import java.util.Random; 

class ValjPolylinje 
{ 

    public static final Random rand = new Random(); 
    public static final int ANTAL_POLYLINJER = 10; 
    public static void main (String[] args) 
    { 
        // Skapa ett antal slumpmässiga polylinjer 
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER]; // En array av metoden Polylinje
        for (int i = 0; i < ANTAL_POLYLINJER; i++) // Loopar igenom alla polylinjer
            polylinjer[i] = slumpPolylinje(); //Slumpar de nu

        // Visa polylinjerna 
        for (int i = 0; i < polylinjer.length; i++) 
        System.out.println(polylinjer[i].toString()); 

        // Bestäm den kortaste av de polylinjer som är gula 
        double shortest = 0.0; int yellow = 0; int index = 0; 
        for (int i = 0; i < polylinjer.length; i++) // LOOPAR ALLA POLYLINJER
        { 
            if (polylinjer[i].getFarg() == "Gul") // if-satsen IFALL DEN HITTAR GUL
            { 
                if (yellow == 0)   
                { 
                    shortest = polylinjer[i].langd(); index = i; // Den första den hittar är per automatik den kortaste
                } 
            
                if(shortest > polylinjer[i].langd()) // Om du har flera gula linjer så kommer den att jämföra. 
                { 
                    shortest = polylinjer[i].langd(); index = i; 
                }
                yellow++; 
            } 
        }

         // IFALL DET INTE FINNS NÅGRA GULA HÄNDER DENNA 
         if (polylinjer[index].getFarg() != "Gul") 
            System.out.println("Finns inga gula polylinjer"); 
        else 
            System.out.println(polylinjer[index].toString()); 
    }
 
    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i 
    // det engelska alfabetet, och slumpmässiga koordinater. 
    public static Punkt slumpPunkt() 
    { 
        String n = "" + (char) (65 + rand.nextInt(26)); //Slumpar alla namn
        int x = rand.nextInt(11); //Slumpar alla tal till int
        int y = rand.nextInt(11);  // Slumptar till 
        return new Punkt (n, x, y); 
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, 
    // röd eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska 
    // alfabetet. Två hörn kan ej ha samma namn. 
   
    public static Polylinje slumpPolylinje() 
    { 
        // Skapa en tom polylinje, och lägg till hörn till den 
        Polylinje polylinje = new Polylinje(); 
        int antalHorn = 2 + rand.nextInt(7); 
        int antalValdaHorn = 0; 
        boolean[] valdaNamn = new boolean[26]; 

        // Ett och samma namn kan ej förekomma flera gånger 
        Punkt valdPunkt = null;
        char valtChar = 0; 
        while (antalValdaHorn < antalHorn) 
        { 
            valdPunkt = slumpPunkt(); // Välj en punkt
            valtChar = valdPunkt.getName().charAt(0); // Kolla om vald punkt har samma namn
            int index = valtChar - 65; 
            if(!valdaNamn[index]) 
            { 
                polylinje.laggTill(valdPunkt); 
                valdaNamn[index] = true;
                antalValdaHorn++; 
            } 
        } 
       
        // Sätt färg 
        String[] s = new String[3]; // Lagra alla färger i en array
        s[0] = "Blå"; 
        s[1] = "Röd";
        s[2] = "Gul"; 
        polylinje.setFarg(s[rand.nextInt(s.length)]); // Random emellan alla arrays.
        return polylinje; 
    } 
} 

