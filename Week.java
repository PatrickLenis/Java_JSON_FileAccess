//Patrick Lenis 
//Group 1, Subgr. 2

import java.util.ArrayList;
import java.util.List;


/**
 * Constructor
 * Class to store informations relevant to a week's program
 * @author Patrick Lenis
 *
 */
public class Week {
	int number;
	
	/**
	 * 
	 * @param number the number of the week
	 */
	public Week(int number)
	{
		this.number = number;
	}
	
	List<Show> shows = new ArrayList<Show>();
	
	/**
	 * Add a show to the week
	 * @param show Select the specific show
	 */
	public void addShow(Show show)
	{
		shows.add(show);
	}
	
	/**
	 * Returns the types of shows in the week
	 */
	public void GetShowTypes()
	{
		for(Show s: shows)
		{
			System.out.print(s.showType() + ", ");
		}
	}
	
	/**
	 * Extends the movie search on a week level
	 * @param movie Name of the movie
	 */
	public void SearchForMovie(String movie)
	{
		boolean f = false;
		for(Show s: shows)
		{
			if(s.name.equals(movie))
			{
				System.out.println("movie found, starts at " + s.startHour);
				f = true;
			}
		}
		
		if(f == false)
		{
			System.out.println("not found");
		}
	}
}
