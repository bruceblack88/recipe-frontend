/*Bruce Black
 *Software Development
 * CSCI 505
 * Dr. James Dollens
 * May 23, 2021
 */
//Invalid Footprint Exception
//custom class that extends IllegalArgumentException
public class InvalidFootprintException extends IllegalArgumentException 
	{
	private static final long serialVersionUID = 1L;

	public InvalidFootprintException() {
		super("A negative footprint occured.");
	}

	public InvalidFootprintException(String message) {
		super(message);
	}

	public InvalidFootprintException(String message, Throwable exception) {
		super(message, exception);
	}

	public InvalidFootprintException(Throwable exception) {
		super(exception);
	}
}
