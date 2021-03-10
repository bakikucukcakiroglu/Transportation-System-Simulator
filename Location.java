
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package locations;

import java.util.ArrayList;
import passengers.*;

/**
 * This class implements a simple location with ID and x and y coordinates. The
 * location can save incoming and outgoing passengers with using history and
 * current lists.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 *
 */

public class Location {

	/**
	 * @param ID        location's ID
	 * @param locationX x coordinate of the location
	 * @param locationY y coordinate of the location
	 * @param history   the array list which keeps all passenger that been this
	 *                  location in the past or now
	 * @param current   the array list which keeps all passengers who currently been
	 *                  here.
	 */

	private int ID;
	private double locationX;
	private double locationY;
	private ArrayList<Passenger> history = new ArrayList<>();
	private ArrayList<Passenger> current = new ArrayList<>();

	/**
	 * This constructs a location by using ID, X coordinate and Y coordinate.
	 * 
	 * @param ID        the ID of location.
	 * @param locationX the X coordinate of the location.
	 * @param locationY the Y coordinate of the location.
	 */

	public Location(int ID, double locationX, double locationY) {

		this.ID = ID;
		this.locationX = locationX;
		this.locationY = locationY;

	}

	/**
	 * This method calculates and returns the distance between this location and
	 * given other location using basic math.
	 * 
	 * @param other the another location that we calculate distance with this
	 *              location.
	 * @return the distance between this location and given other location.
	 */
	public double getDistance(Location other) {

		return Math.sqrt(Math.pow(this.locationX - other.locationX, 2) + Math.pow(this.locationY - other.locationY, 2));

	}

	/**
	 * This method saves all passengers who has visited this location. This keep
	 * them in both of history and current locations.
	 * 
	 * @param p the passenger who has visited this location.
	 */
	public void incomingPassenger(Passenger p) {

		if (!history.contains(p)) {
			this.history.add(p);
		}

		this.current.add(p);

	}

	/**
	 * This method saves all passengers who has left this location. This delete them
	 * from current list.
	 * 
	 * @param p the passenger who has left this location.
	 */
	public void outgoingPassenger(Passenger p) {

		this.current.remove(p);

	}

	/**
	 * This method returns the ID of the location.
	 * 
	 * @return the ID of the location.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * This method enables us to set location's ID as given ID.
	 * 
	 * @param iD the ID that will be given to location.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * This method returns the X coordinate of this location.
	 * 
	 * @return X coordinate of this location.
	 */
	public double getLocationX() {
		return locationX;
	}

	/**
	 * This method enables us to set location's X coordinate as given X coordinate .
	 * 
	 * @param locationX the X coordinate that will be given to location.
	 */
	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	/**
	 * This method returns the Y coordinate of this location.
	 * 
	 * @return Y coordinate of this location.
	 */
	public double getLocationY() {
		return locationY;
	}

	/**
	 * This method enables us to set location's Y coordinate as given Y coordinate.
	 * 
	 * @param locationY Y coordinate that will be given to location.
	 */
	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	/**
	 * This method returns current array list of this location. Current array list
	 * keeps all passengers who is in this location right now.
	 * 
	 * @return current array list of this location.
	 */
	public ArrayList<Passenger> getCurrent() {
		return current;
	}

	/**
	 * This method enables us to set location's current array list as given array
	 * list.
	 * 
	 * @param current the array list that will be given to location.
	 */
	public void setCurrent(ArrayList<Passenger> current) {
		this.current = current;
	}

	/**
	 * This method returns history array list of this location. History array list
	 * keeps all passengers that been in this location.
	 * 
	 * @return history array list of this location.
	 */
	public ArrayList<Passenger> getHistory() {
		return history;
	}

	/**
	 * This method enables us to set location's history array list as given array
	 * list.
	 * 
	 * @param history the array list that will be given to location.
	 */
	public void setHistory(ArrayList<Passenger> history) {
		this.history = history;
	}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
