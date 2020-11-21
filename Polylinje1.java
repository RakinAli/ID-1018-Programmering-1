package Ov5;
class Polylinje1 
{ 
    private Punkt[] horn;  
    private String farg = "svart";
    private int bredd = 1; 
    
    public Polylinje1 () 
    { 
        this.horn = new Punkt[0]; 
    } 
    
    public Polylinje1 (Punkt[] horn) 
    { 
        this.horn = new Punkt[horn.length]; 
        for (int i = 0; i < horn.length; i++) 
        this.horn[i] = new Punkt (horn [i]); 
    } 
        
    public String toString ()
    { 
        StringBuilder n = new StringBuilder(); 
        for (int i = 0; i < horn.length; i++) 
        n.append(this.horn[i]); 
        return "{[" + n.toString() + "]" + ", " + farg + ", " + bredd + "}"; 
    } 

    public Punkt[] getHorn() 
    { 
        // Referensen till egna hörn returneras 
        return this.horn; 
    } 
    
    public String getFarg() 
    { 
        return this.farg; 
    } 
    
    public int getBredd() 
    { 
        return this.bredd; 
    } 
    
    public void setFarg (String farg) 
    { 
        this.farg = farg; 
    } 
    
    public void setBredd (int bredd) 
    { 
        this.bredd = bredd; 
    } 
    
    public double langd () 
    { 
        double langd = 0.0; 
        for (int i = 0; i < horn.length - 1; i++) 
        langd += horn[i].avstand(horn[i + 1]); 
        return langd; 
    } 
    
    public void laggTill (Punkt horn) 
    { 
        Punkt[] h = new Punkt[this.horn.length + 1]; 
        int i = 0; 
        for (i = 0; i < this.horn.length; i++) 
            h[i] = this.horn[i]; h[i] = new Punkt (horn); 
        
            this.horn = h; 
    } 
    
    public void laggTillFramfor (Punkt horn, String hornNamn)
    { 
        Punkt[] h = new Punkt[this.horn.length + 1]; 
        int pos = 0; 
        for (int i = 0; i < this.horn.length; i++) 
        { 
            if(hornNamn == this.horn[i].getName()) 
            { 
                pos = i; break; 
            } 
        } 
        for (int j = 0; j < pos; j++) 
        { 
            h[j] = this.horn[j]; 
        } 
 
        h[pos] = horn; 
        for (int j = pos + 1; j < h.length; j++) 
        { 
            h[j] = this.horn[j-1]; } 
        } 
        
    public void taBort (String hornNamn) 
    { 
        Punkt[] h = new Punkt[this.horn.length - 1]; 
        int pos = 0; 
        for (int i = 0; i < this.horn.length; i++) 
        { 
            if(hornNamn == this.horn[i].getName()) 
            { 
               pos = i; break; 
            } 
        } 
        for (int i = 0; i < pos; i++) 
        { 
            h[i] = this.horn[i]; } 
            for (int j = pos + 1; j < this.horn.length; j++) 
            { 
                h[j-1] = this.horn[j]; 
            } 
    }   

}