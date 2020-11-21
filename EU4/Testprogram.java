package EU4;
public class Testprogram
{
    
    public static void main(String[]args)
    {
        Polylinje polylinje = null;
        Punkt[] punkter = new Punkt[5];

        punkter[0] = new Punkt("a", 1,1);
        punkter[1] = new Punkt( "b",2,2);
        punkter[2] = new Punkt("gul",3,3);
        punkter[3] = new Punkt("d",4,4);
        punkter[4] = new Punkt("gul",5,5);

        //polylinje = new VPolylinje (punkter); // (1)
        polylinje = new NPolylinje (punkter); // (2)
        System.out.println(polylinje);

       
    }
    
}


