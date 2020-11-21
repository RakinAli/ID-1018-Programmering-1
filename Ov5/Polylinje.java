package Ov5;

public class Polylinje 
{ 
    // Du skapar en array av typen punkt. Arrayns referens heter horn. 
    // Alltså du skapar en polylinje. 

    private Punkt[] horn; // Det här bestämmer hur många punkter polylinjen har
    private String farg = "svart"; // Det här bestämmer färgen på polylinjen
    private int bredd = 1;  // Bestämmer hur bredd den är 
    
    // Du skapar en metod som skapar en  polylinje som är TOM UTAN HÖRN. Den har inga punkter. Denna metod ifall du har inga parametrar
    public Polylinje () 
    { 
        this.horn = new Punkt[0]; 
    } 
    
    // Det är en constructor. Du slänger in polylinjerna in som paramter 
    public Polylinje (Punkt[] horn) 
    { 
        /* Den loopar igenom alla hörn och sätter dom till en ny punkt
        // Horn är ju ett namn, man har en lokalt hörn som är 
        en array av punkter. Man göt  */ 
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) 
            this.horn[i] = new Punkt (horn [i]); 
    }
    
    // Den loopar igenom alla punkter och KOPPLAR ALLA PUNKTER. Den skriver ut polylinjen som vi kallar på
    public String toString () 
    { 
        StringBuilder n = new StringBuilder(); //
        for (int i = 0; i < horn.length; i++) // går igenom alla punkt//hörn i polylinjen
            n.append(this.horn[i]); 
            return "{[" + n.toString() + "]" + ", " + farg + ", " + bredd + "}"; 
    }

    // Här lagras alla punkter 
    public Punkt[] getHorn() // Här tar man ut punkterna från private
    { 
        Punkt[] h = new Punkt[this.horn.length]; // Man skapar en array av typen punkt. Man lagrar alla punktern i arrayen H
        for (int i = 0; i < this.horn.length; i++) 
        { 
            h[i] = new Punkt (this.horn[i]); // Här lagras alla punkternas
        } 
        return h;  
    }

    // Den tar ut färgen på polylinjen
    public String getFarg() 
    { 
        return this.farg; 
    } 
    
    // Den tar ut breddeen på polylinjen 
    public int getBredd() 
    { 
        return this.bredd; 
    } 
    
    // Nu ändrar du färgen på polylinjen 
    public void setFarg (String farg) 
    { 
        this.farg = farg; 
    }
    
    // Nu ändrar du bredden på polylinjen
    public void setBredd (int bredd) 
    { 
        this.bredd = bredd; 
    } 

    // Denna metod räknar längden av Polylinjen. 
    public double langd ()
    { 
        double langd = 0.0; 
        for (int i = 0; i < horn.length - 1; i++) 
            langd += horn[i].avstand(horn[i + 1]); // DEt som händer är att den adderar alla AVSTÅND från punkt till punkt 
        return langd; 
    }

    // Denna metod lägger till alla punkter/Hörn i polylinjen
    public void laggTill (Punkt horn) 
    { 
        Punkt[] h = new Punkt[this.horn.length + 1]; // Man kopierar H + 1 för att man vill lägga en ny punkt
        int i = 0; 
        for (i = 0; i < this.horn.length; i++) 
            h[i] = this.horn[i]; // Här kopieras alla gamla H till nya H. Den sista kommer vara tom.
        h[i] = new Punkt (horn);  // Här lägger man in sista punkten. 
        this.horn = h; 
    } 
    
    // I lagg till framför får du välja plats. Den kommer lagras framför punkten
    public void laggTillFramfor (Punkt horn, String hornNamn) 
    { 
        Punkt[] h = new Punkt[this.horn.length + 1]; // Här kommer den skapa en array och sedan ha en öppet lagringställe 
        int pos = 0; 
        for (int i = 0; i < this.horn.length; i++)  // Letar efter hela positionen 
        { 
            if(hornNamn == this.horn[i].getName()) // Om den hittar platsen där den ska lagras framför. Då bryts loopen
            { 
                pos = i; break; // Här väljs positionen du vill lagra den till 
            } 
        } 

        for (int j = 0; j < pos; j++) // Allt bakom är förändrat och lagras i this.horn[j]
        { 
            h[j] = this.horn[j]; 
        } 
        
        h[pos] = horn; 
    
        for (int j = pos + 1; j < h.length; j++) // Allt framför lagras en position framför
        { 
            h[j] = this.horn[j-1]; // Allt som finnas i hörn kopieras till h. J är 1 steg större än vilket är varför det står minus1. 
        } 
    } 
    
    public void taBort (String hornNamn) // Vilken vill du ta bort
    { 
        Punkt[] h = new Punkt[this.horn.length - 1]; 
        int pos = 0; 
        for (int i = 0; i < this.horn.length; i++) // Här loopas alla horn-namn och om namnet är lika tas den bort och loopen bryts.
        {    
            if(hornNamn == this.horn[i].getName()) // Här hittar den Hornnamn namn 
            { 
                pos = i; break; 
            }
        } 
    
        for (int i = 0; i < pos; i++) 
        { 
            h[i] = this.horn[i]; // Allt innan oförändrat bakom valda positonen
        } 
    
        for (int j = pos + 1; j < this.horn.length; j++) 
        { 
            h[j-1] = this.horn[j]; // Allt framför flyttas bakom. Den valda positionen ignoreras. Den väljs inte i indexen. Därför har man +1
        } 
    
    }

    public class PolylinjeIterator
{ 
    private int aktuell = -1; 
    public PolylinjeIterator () 
    { 
        if (Polylinje.this.horn.length > 0) 
        aktuell = 0; 
    } 
    
    public boolean finnsHorn () 
    { 
        return aktuell != -1; // NOt equal to minus 1
    } 
    
    public Punkt horn () throws java.util.NoSuchElementException
    { 
       if (!this.finnsHorn()) 
            throw new java.util.NoSuchElementException ("Slut av iterationen"); 
        Punkt horn = Polylinje.this.horn[aktuell]; 
        return horn;    
    }

    public void gaFram () 
    { 
        if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1) 
            aktuell++; 
        else 
            aktuell = -1; 
}
}
} 
    