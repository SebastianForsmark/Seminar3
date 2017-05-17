package Projects.Intergration;

/**
 * An exception used to identify when a certain <code>regNo</code> was not found in <code>Database</code>.
 */
public class RegNoNotFoundException extends Exception{
    public RegNoNotFoundException(){
        super();
    }

    /**
     * @param message Notification to user that the registration number was not found.
     */
    public RegNoNotFoundException(String message){
        super(message);
    }
}
