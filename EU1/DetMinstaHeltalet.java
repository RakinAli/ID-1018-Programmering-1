package EU1;

public class DetMinstaHeltalet
{
    // min returnerar det minsta elementet i en sekventiell samling.
    // Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
    public static int min (int[] element) throws IllegalArgumentException
    {
        if (element.length == 0)
        throw new IllegalArgumentException ("tom samling");
   
        // hör ihop med spårutskriften 2:
        int antalVarv = 1;
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;
        while (antaletPar > 0) // ------Här ligger det första felet. Ändrade det till antalet Par Så den inte går mot oändligheten
        {
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar)
            {
                delsekvens[j] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
               i += 2;
               j++;
            }
            if (antaletOparadeElement == 1)
            delsekvens[j] = sekvens[i]; // -------- Här blev det fel. Det sista positionen uppdateras ALDRIG vilket gör att den bara sparas 
          
            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2; // Först kommer antalet par att vara lika med antalet element delat på två
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement; // Sedan kommer antalet tankbara element vara DELAT med två en gång 

            // spårutskrift 1 – för att följa sekvensen
            System.out.println (java.util.Arrays.toString (sekvens));
           
            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            if (antalVarv++ == 10)
              System.exit (0);
        }
        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }
    
    public static void main(String[] args) 
    {
        int[] tal = {10,11,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,18,19};
        System.out.print("MInsta talet är :" + DetMinstaHeltalet.min(tal));

    }

}

