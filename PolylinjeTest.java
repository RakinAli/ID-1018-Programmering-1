package Ov5;
class PolylinjeTest 
{ 
    public static void main(String[] args) 
    {

        // Testar getFarg och setFarg 
        Polylinje p = new Polylinje ();
         System.out.println(p.getFarg());
        p.setFarg("Rosa"); 
        System.out.println(p.getFarg()); 
       
        // Testar laggTill 
        p.laggTill (new Punkt ("A", 3, 7));
        p.setFarg("Grön");
        p.laggTill (new Punkt ("B", 1, 4));
        p.setFarg("Lila"); 
        p.laggTill (new Punkt ("C", 5, 9)); 
        p.laggTill (new Punkt ("D", 4, 4)); 
        System.out.println(p.toString()); 
        System.out.println(p.langd()); 
       
        // Testar laggTillFramfor 
        Punkt m = new Punkt ("A", 6, 8); 
        p.laggTillFramfor(m, "B"); 
        Polylinje s = new Polylinje(); 
        Punkt d = new Punkt ("L", 7, 0);
        s.laggTillFramfor(d, "C"); 
        Polylinje g = new Polylinje();
        Punkt h = new Punkt ("P", 2, 2);
        g.laggTillFramfor(h, "C"); 
    
        // Testar taBort 
        p.taBort("A"); 
    
        // Testar toString 
        System.out.println(d.toString()); 
    
        // Testar getHorn 
        Punkt [] o = p.getHorn(); System.out.println(java.util.Arrays.toString(o));

        // Testar polylinjeiterator 
        Polylinje.PolylinjeIterator c = p.new PolylinjeIterator(); 
        System.out.println(c.horn()); 
        c.gaFram(); 
        System.out.println(c.horn()); 
        c.gaFram(); 
        System.out.println(c.horn()); 
        c.gaFram(); 
        System.out.println(c.horn()); 
        c.gaFram(); 
        System.out.println(c.horn()); 
        while(c.finnsHorn()) 
        { 
            System.out.println(c.horn()); c.gaFram(); 
        } 
    }
 } 