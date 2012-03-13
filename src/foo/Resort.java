package foo;

import java.util.ArrayList;
import java.util.List;

public class Resort {
   
	private String name;
	private String description;
	private double latitude;
	private double longitude;
	
	public Resort(String name, String description, double latitude,	 double longitude) {
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Resort() {
		this("", "", 0, 0);
	}

	public static List<Resort> getAll() {
		List<Resort> resortList = new ArrayList<Resort>();
		
		resortList.add(new Resort("La Tour Eiffel", "La Tour Eiffel", 48.85, 2.294));
		resortList.add(new Resort("University of Toronto", "University of Toronto", 43.6633, -79.3945));
		resortList.add(new Resort("Ontario Place", "Ontario Place", 43.6281, -79.4138));
		resortList.add(new Resort("University of Waterloo", "University of Waterloo", 43.4715, -80.5442));
		resortList.add(new Resort("Old Trafford", "Old Trafford", 53.463167, -2.28956));
		return resortList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
