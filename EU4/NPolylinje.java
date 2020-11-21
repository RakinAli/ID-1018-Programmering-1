package EU4;
import java.util.Iterator;
public class NPolylinje implements Polylinje
{
    // Noder 
    private static class Nod
    {
        //Nodens egensakper
        public Punkt horn;
        public Nod nastaNod;
        
        // Konstruktör för Nod
        public Nod (Punkt horn)
        {
            this.horn = horn;
            nastaNod = null;
        }
    }
    
    // NPolylinje Egenskaper
    private Nod horn;
    private String farg = "svart";
    private int bredd = 1; // pixlar
    
    //Konstruktör för en NPolylinje fast utan hörn
    public NPolylinje ()
    {  
        this.horn = null;
    }
    public NPolylinje (Punkt [] horn)
    {
        if (horn.length > 0)
        {
            Nod nod = new Nod (new Punkt (horn[0]));
            this.horn = nod;
            int pos = 1;
            while (pos < horn.length)
            {
                nod.nastaNod = new Nod (new Punkt (horn[pos++]));
                nod = nod.nastaNod;
            }
        }
    }  
    
    // Alla Implemented  metoder
    public String getFarg() 
    {
        return this.farg;
    }
    public void setFarg(String farg) 
    {
        this.farg = farg;        
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
        // Först hur många element ska Punkt ha 
        int pos = 0;
        Nod nod = this.horn; // Pekar till horn  
        while(nod!= null)
        {
            pos++;
            nod = nod.nastaNod;
        }
        
        // Kopiera alla punkter 
        nod = this.horn; // Pekar tillbaka på horn  
        Punkt[] deepcopy = new Punkt[pos];
        for(int i = 0; i < pos; i++ )
        {
            deepcopy[i] = nod.horn;
            nod= nod.nastaNod;
        }
        return deepcopy;
    }
    public void laggTill(Punkt horn) 
    {
        Nod nod = this.horn;// Pekar till horn från NPOlyline 
        while(nod.nastaNod != null) // Letar efter sista noden. 
            nod = nod.nastaNod;
        nod.nastaNod = new Nod(horn);    // Lägger en nod på den sista noden
    }
    public void laggTillFramfor(Punkt horn, String hornNamn) 
    { 
        // Fall 1 = ifall Det finns inga Noder
        Nod copy = this.horn; //Pekar till horn från NPolyline
        if(copy == null)
        {
            Nod läggTill = new Nod(horn);  
            this.horn = läggTill;
        }
        else
        {
            // Fall 2 = Horn pekar på första Noden
           if(this.horn.horn.getName() == hornNamn )
            {
                Nod förstaNodenNuNod = new Nod(horn);
                förstaNodenNuNod.nastaNod = this.horn;
                this.horn=förstaNodenNuNod;
            }
           else //Fall 3 - Generella fall 
           {
               // Ifall den inte finns eller om den finns fast inte på pos 2
                while(copy.nastaNod!=null && copy.nastaNod.horn.getName().equals(hornNamn) == false ) // Lägg en throws null point exception
                {
                    copy = copy.nastaNod;
                }
                // Pekar till nästa Nästa nod

                Nod nyskapadNod = new Nod(horn);
                Nod copyNågot = copy.nastaNod;
                copy.nastaNod = nyskapadNod;
                nyskapadNod.nastaNod = copyNågot;
            }
        }
    }
    public void taBort(String hornNamn) 
    {
        // Kopiera referering till Horn
        Nod copy = this.horn;
        // Första fall ifall det inte finns några Noder
        if(copy == null)
        {
            // Gör ingeting på Kodding språk
        }
        else
        {
            // Andra Fall = Ifall första efter Horn ska bort 
            if(horn.horn.getName() == hornNamn)
            {
                Nod kopieraNext = copy.nastaNod.nastaNod;
                copy.nastaNod= kopieraNext;
            }
            else
            {
                // Tredje Fall = Generella fall 
                while(copy.nastaNod.horn.getName()!=hornNamn)
                {
                    // Den tar aldrig bort Noden utan hoppar över den 
                    copy = copy.nastaNod;
                }   
                Nod kopieraNext = copy.nastaNod.nastaNod;
                copy.nastaNod = kopieraNext;
            }
        }
    }
    public double langd() 
    {
        Nod copy = this.horn;
        // Ifall det finns en tom nod
        if(copy==null)
        {
            return 0;
        }
        else
        {
            // Ifall det finns EN NOD 
            if(copy.nastaNod==null)
            {
                return 0;
            }
            else
            {
                // Generell
                Nod copyslow = this.horn;
                Nod copyFast = copyslow.nastaNod;
                double längd = 0;

                while(copyFast.nastaNod != null)
                {
                    längd += copyslow.horn.avstand(copyFast.horn);
                    copyFast = copyFast.nastaNod;
                    copyslow = copyslow.nastaNod;
                }
                return längd;
            }
        }
    }
    public String toString()
    {  
        return "Klar";

    }

    // Iterator Klassen
    class Viterator implements Iterator<Punkt>
    {
        int aktuell = -1;

        //Konstruktör 
        public Viterator()
        {
            if(NPolylinje.this.horn != null)
                aktuell=0;
        }

        public boolean hasNext()
        {
            return aktuell != -1;
        }

        public Punkt next()
        {
            Punkt p = null;
            Punkt[] a = NPolylinje.this.getHorn();
            if(hasNext()==true)
            return a[aktuell++];
            else
            {
                return p;
            }
        }
    }
    public Iterator<Punkt> iterator() // FRÅGA FADIL HUR MAN GÖR
    {
        return NPolylinje.this.new Viterator();
    }
}
