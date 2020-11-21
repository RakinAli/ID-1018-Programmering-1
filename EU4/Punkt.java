package EU4;
class Punkt
{
    private String name;
    private int x;
    private int y;

    // Skapar en konstruktor. Detta är en mall för punkterna. Man tilldelar dem ett värde
    public Punkt(String name,int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y; 
    }
    
    // Andra punkten - Bara för att testa 
    public Punkt(Punkt andraPunkten)
    {
        this.name = andraPunkten.name;
        this.x = andraPunkten.x;
        this.y = andraPunkten.y;
    }
    
    // Denna metod tar fram namnet på punkten som är i private.
    public String getName()
    {
        return name;
    }
   
    // Dena metod låter mig skriva in namnet på punkten
    public void setName(String name)
    {
        this.name = name;
    }

    // Denna metod tar fram X från private 
    public int getX()
    {
        return x;
    }
    
    // Denna metod tar fram Y från Private
    public int getY()
    {
        return y;
    }
    
    // Denna metod refererar till X värde i en punkt 
    public void setX(int x)
    {
        this.x = x;
    }
   
    // Denna metod gör så att man kan ändra Y värdet i en punkt 
    public void setY(int y)
    {
        this.y = y;
    }
    
    // Man printar ut Punkterna i form av en String
    public String toString()
    {
        return "(" + name + "," + x + "," + y+")";
    }

    public double avstand(Punkt andraPunkten)
    {
        double avstand = 0.0;

        avstand = Math.sqrt((Math.pow((andraPunkten.x -x),2)+ Math.pow((andraPunkten.y-y),2)));
        return avstand;
    }
}
