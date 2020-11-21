package EU4;

import java.util.Iterator;

public class VPolylinje implements Polylinje
{

    //VPolylinjes Egenskaper
    private Punkt[] horn;
    private String farg = "Röd";
    private int bredd = 1; 

    // Konstruktör för VPolylinje
    public VPolylinje(Punkt[]horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) 
            this.horn[i] = new Punkt (horn [i]); 
    }
    
    // Skapar Metodkroppar för alla implementerade metoder
    public String getFarg() 
    {
        return this.farg;
    }
    public int getBredd() 
    {
        return this.bredd;
    }
    public void setBredd(int bredd) 
    {
        this.bredd = bredd;
    }
    public Punkt[] getHorn() 
    {
        Punkt[] h = new Punkt[this.horn.length]; // Man skapar en array av typen punkt. Man lagrar alla punktern i arrayen H
        for (int i = 0; i < this.horn.length; i++) 
        { 
            h[i] = new Punkt (this.horn[i]); // Här lagras alla punkternas
        } 
        return h;
    }
    public double langd() 
    {
        double langd = 0.0; 
        for (int i = 0; i < horn.length - 1; i++) 
            langd += horn[i].avstand(horn[i + 1]); // DEt som händer är att den adderar alla AVSTÅND från punkt till punkt 
        return langd; 
    }
    public void setFarg(String farg) 
    {
        this.farg = farg;    
    }
    public void laggTill(Punkt horn) 
    {
        Punkt[] h = new Punkt[this.horn.length + 1]; // Man kopierar H + 1 för att man vill lägga en ny punkt
        int i = 0; 
        for (i = 0; i < this.horn.length; i++) 
            h[i] = this.horn[i]; // Här kopieras alla gamla H till nya H. Den sista kommer vara tom.
        h[i] = new Punkt (horn);  // Här lägger man in sista punkten. 
        this.horn = h;        
    }
    public void laggTillFramfor(Punkt horn, String hornNamn) 
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
    public void taBort(String hornNamn) 
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
   
    // Iterator klass
    class Viterator implements Iterator<Punkt>
    {   
        private int aktuell = -1;
        
        // Konstruktör
        public Viterator()
        {
            if(VPolylinje.this.horn.length>0)
            aktuell = 0;
        }

        public boolean hasNext() 
        {
            return aktuell !=-1;
        }

        public Punkt next() 
        {
            if (aktuell >= 0 && aktuell < VPolylinje.this.horn.length - 1) 
            aktuell++; 
        else 
            aktuell = -1; 
        return VPolylinje.this.horn[aktuell];
        }

    }
    public Iterator<Punkt> iterator() // FRÅGA FADIL HUR MAN GÖR
    {
        return new Viterator();
    }

    public String toString()
    {
        StringBuilder n = new StringBuilder(); //
        for (int i = 0; i < horn.length; i++) // går igenom alla punkt//hörn i polylinjen
            n.append(this.horn[i]); 
            return "{[" + n.toString() + "]" + ", " + farg + ", " + bredd + "}"; 
    }    
}