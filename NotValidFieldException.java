package EU3;

// Klassen är en exception klass som hanterar alla pjäser på felaktiga ställen
public class NotValidFieldException extends Exception
{
    public NotValidFieldException(String message)
    {
        super(message);
    }
}