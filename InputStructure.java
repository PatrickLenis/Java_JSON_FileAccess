//Patrick Lenis 
//Group 1, Subgr. 2

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Patric Lenis
 *
 */
public class InputStructure {
	
	/**
	 * Main method
	 *
	 */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileName = "src/TV_Scheduler.json";
        Path path = Paths.get(fileName);
        
        List<TV_Station> tvStationList = new ArrayList<TV_Station>();
        /**
         * Reads from file
         */
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);

            JsonArray array = tree.getAsJsonArray();
            
            //List<TV_Station> tvStationList = new ArrayList<TV_Station>();
            
            for (JsonElement element: array) {

                if (element.isJsonObject()) {
                	
                	JsonObject tvStation = element.getAsJsonObject();
                	
                	boolean missing = false;
                	
                	//JsonElement check = tvStation.get("schedule").getAsJsonArray();
                	
                	if(tvStation.get("schedule").isJsonNull()) {
                		missing = true;
                	}
                	
                	TV_Station tvStationSave = new TV_Station(tvStation.get("name").getAsString(), tvStation.get("description").getAsString(), missing);
                	
                	if(tvStationSave.GetMissing() == false)
                	{
                		JsonArray schedule = tvStation.get("schedule").getAsJsonArray();
                		int wn = 1;
                		for (JsonElement w: schedule)
                		{
                			
                			if(w.isJsonArray())
                			{
                				Week week = new Week(wn);
                		
                				JsonArray weeks = w.getAsJsonArray();
                				for (JsonElement s: weeks)
                				{
                					if(s.isJsonObject())
                					{
                						JsonObject show = s.getAsJsonObject();
                						//System.out.println(show.get("stoptHour").getAsInt());
                						Show showSave = new Show(show.get("startHour").getAsInt(), show.get("stopHour").getAsInt(), show.get("type").getAsString(), show.get("name").getAsString(), show.get("shortDescription").getAsString());
                						
                						week.addShow(showSave);
                					}
                				}
                				
                				tvStationSave.addWeek(week);
                			}
                			wn = wn+1;
                		}
                		
                		//tvStationList.add(tvStationSave);
                	}
                	tvStationList.add(tvStationSave); 
                }
            }
            
        }catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
        
        //display results
        
        //A
        /**
         * Task A
         */
        System.out.println();
        System.out.println("_______Point A_______");
        System.out.println("Created classes and JSON tree structure");
        
        //B
        /**
         * Task B
         */
        
        System.out.println();
        System.out.println("_______Point B_______");
        System.out.println("Imported GSON and eclipse JSON plugin");
        System.out.println("File readed");
        
        //C
        /**
         * Task C
         */
        
        System.out.println();
        System.out.println("_______Point C_______");
        
        int nrm = 0;
        System.out.println("Tv_Stations with no schedule : ");
        for (TV_Station t: tvStationList)
        {
        	if(t.GetMissing() == true)
        	{
        		System.out.println(t);
        		nrm = nrm+1;
        	}
        	//System.out.println(t.GetMissing());
        }
        
        if(nrm == 0)
        {
        	System.out.println("none");
        }
        
        //D
        /**
         * Task D
         */
        
        System.out.println();
        System.out.println("_______Point D_______");
        
        for (TV_Station t: tvStationList)
        {
        	if(t.GetMissing() == false)
        	{
        		System.out.print(t + " : ");
        		t.GetReport();
        		System.out.println();
        	}
        	else
        	{
        		System.out.println(t + " : Missing schedule");
        	}
        }
        
        //E
        /**
         * Task E
         */
        
        System.out.println();
        System.out.println("_______Point E_______");
        
        String movie = "Movie1";
        
        
        for (TV_Station t: tvStationList)
        {
        	if(t.GetMissing() == false)
        	{
	        	System.out.println(t + " : ");
	        	t.SearchFor(movie);
	        	System.out.println();
        	}
        	else
        	{
        		System.out.println(t + " : ");
        		System.out.println("Missing schedule");
        		System.out.println();
        	}
        }
    }
}