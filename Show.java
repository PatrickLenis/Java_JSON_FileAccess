//Patrick Lenis 
//Group 1, Subgr. 2

/**
 * Class to store informations relevant to a show
 * @author Patrick Lenis
 *
 */
public class Show {
	int startHour;
	int stopHour;
	String type;
	String name;
	String shortDescription;
	
	/**
	 * Constructor
	 * @param startHour The hour on which the show starts
	 * @param stopHour The hour on which the show ends
	 * @param type The type of the show
	 * @param name The name of the show
	 * @param shortDescription The description of a show
	 */
	public Show(int startHour, int stopHour, String type, String name, String shortDescription)
	{
		this.startHour = startHour;
		this.stopHour = stopHour;
		this.type = type;
		this.name = name;this.
		shortDescription = shortDescription;
	}
	
	/**
	 * 
	 * @return Returns show type
	 */
	public String showType()
	{
		return this.type;
	}
	
	/**
	 * Method to print a Show
	 */
	public String toString() {
		return "Show : " + this.name;
	}
}
