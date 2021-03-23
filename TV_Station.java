//Patrick Lenis 
//Group 1, Subgr. 2

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store informations relevant to a TV Station
 * @author Patrick Lenis
 *
 */
public class TV_Station {
	
	String name;
	String description;
	boolean isMissing; 
	
	/**
	 * Constructor
	 * @param name TV Station name
	 * @param description Description for the station
	 * @param isMissing Checks if th station is missing a schedule
	 */
	public TV_Station(String name, String description, boolean isMissing)
	{
		this.name = name;
		this.description = description;
		this.isMissing = isMissing;
	}
	
	List<Week> weeks = new ArrayList<Week>();
	
	/**
	 * 
	 * @return Returns if the schedule is missing
	 */
	public boolean GetMissing()
	{
		return this.isMissing;
	}
	
	/**
	 * 
	 * @param week adds thi specific week to the schedule list
	 */
	public void addWeek(Week week)
	{
		weeks.add(week);
	}
	
	/**
	 * Returns all the weeks  stored
	 */
	public void getWeeks()
	{
		for(Week w : weeks)
			System.out.println(w.number);
	}
	
	/**
	 * Returns a TV Station report
	 */
	public void GetReport()
	{
		for(Week w : weeks)
		{
			w.GetShowTypes();
		}
	}
	
	/**
	 * Searches for a specific movie
	 * @param movie Name of the movie
	 */
	public void SearchFor(String movie)
	{
		for(Week w : weeks)
		{
			System.out.print("Week " + w.number + " : ");
			w.SearchForMovie(movie);
		}
	}
	
	/**
	 * Method to print a TV_Station
	 */
	public String toString() {
		return "TV_Station : " + this.name;
	}
}
