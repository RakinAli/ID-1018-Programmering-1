package Ov5;
import java.io.*; // Printwriter

class PunktTest
{
    public static void main (String[] args)
    {
        PrintWriter out = new PrintWriter (System.out, true);
        // testa en konstruktor och en transformator
        // Vi skapar två nya punkter som kallas P1 och P2. Konstruktorn anropas. 
        Punkt p1 = new Punkt ("A", 3, 4);
        Punkt p2 = new Punkt ("B", 5, 6);
        out.println (p1 + " " + p2);
 
        // testa inspektorer
        String n = p1.getName ();
    
        // Man refererar till metoden punkt från classen Punk. 
        int x = p1.getX ();
        int y = p1.getY ();
        out.println (n + " " + x + " " + y);
 
        // Testar om p1 och p2 är densamma vilket det inte är och därför visar den false.
        // B är referering till Boolean. 
    
        //Kombinatorn
        double d = p1.avstand (p2);
        out.println (d);
        
        // Den kollar om B = D alltså om P1 är lika med P2. 
        boolean b = p1.equals (p2);
        out.println (b);
 
        // De ändrar kordinaterna i P2, Du ändrar X och Y värdet. 
        p2.setX (1);
        p2.setY (2);
        out.println (p2);
      
        // Kopia av p1 fast som Objekt. 
        Punkt p = new Punkt (p1);
        out.println (p);
    }
}

