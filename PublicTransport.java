
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import locations.*;
import passengers.*;
import interfaces.*;

/**
 * This class implements a public transportation vehicle with a range. Public
 * transportation vehicles can be a bus or a train.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */

public abstract class PublicTransport {

	/**
	 * @param ID id of the public transportation vehicle
	 * @param x1 the x coordinate of vehicle's range
	 * @param x2 the x coordinate of vehicle's range
	 * @param y1 the y coordinate of vehicle's range
	 * @param y2 the y coordinate of vehicle's range
	 */
	private int ID;
	private double x1, y1, x2, y2;

	/**
	 * This construct a public transportation vehicle with an ID and range given as
	 * x1,x2,y1,y2 coordinates.
	 * 
	 * @param ID the ID of vehicle
	 * @param x1 the range of vehicle on the x axis.
	 * @param y1 the range of vehicle on the y axis.
	 * @param x2 the range of vehicle on the x axis.
	 * @param y2 the range of vehicle on the y axis.
	 */

	public PublicTransport(int ID, double x1, double y1, double x2, double y2) {

		this.ID = ID;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}

	/**
	 * This method determines if a travel to given arrival point from the given
	 * departure point is available or not by looking this locations are in the
	 * vehicle's range or not.
	 * 
	 * @param departure the location of travel starts.
	 * @param arrival   the location of travel ends.
	 * @return the state of if a travel between given two point is available or not.
	 */

	public boolean canRide(Location departure, Location arrival) {

		double minX = Math.min(x1, x2);
		double maxX = Math.max(x1, x2);
		double minY = Math.min(y1, y2);
		double maxY = Math.max(y1, y2);

		if (departure.getLocationX() >= minX && departure.getLocationX() <= maxX && departure.getLocationY() >= minY
				&& departure.getLocationY() <= maxY) {
			if (arrival.getLocationX() >= minX && arrival.getLocationX() <= maxX && arrival.getLocationY() >= minY
					&& arrival.getLocationY() <= maxY) {

				return true;
			}
			return false;

		}

		return false;

	}

	/**
	 * This method returns the vehicle's ID.
	 * 
	 * @return the vehicle's ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * This method enables us to set vehicle's ID.
	 * 
	 * @param iD the ID that will be given to vehicle.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * This method returns the vehicle's range on the X axis.
	 * 
	 * @return the vehicle's range on the X axis.
	 */
	public double getX1() {
		return x1;
	}

	/**
	 * This method enables us to set vehicle's range on the X axis.
	 * 
	 * @param x1 is the given range on X axis that will be given to vehicle.
	 */
	public void setX1(double x1) {
		this.x1 = x1;
	}

	/**
	 * This method returns the vehicle's range on the Y axis.
	 * 
	 * @return the vehicle's range on the Y axis.
	 */
	public double getY1() {
		return y1;
	}

	/**
	 * This method enables us to set vehicle's range on the Y axis.
	 * 
	 * @param y1 is the given range on Y axis that will be given to vehicle.
	 */
	public void setY1(double y1) {
		this.y1 = y1;
	}

	/**
	 * This method returns the vehicle's range on the X axis.
	 * 
	 * @return the vehicle's range on the X axis.
	 */
	public double getX2() {
		return x2;
	}

	/**
	 * This method enables us to set vehicle's range on the X axis.
	 * 
	 * @param x2 is the given range on X axis that will be given to vehicle.
	 */
	public void setX2(double x2) {
		this.x2 = x2;
	}

	/**
	 * This method returns the vehicle's range on the Y axis.
	 * 
	 * @return the vehicle's range on the Y axis.
	 */
	public double getY2() {
		return y2;
	}

	/**
	 * This method enables us to set vehicle's range on the Y axis.
	 * 
	 * @param y2 is the given range on Y axis that will be given to vehicle.
	 */
	public void setY2(double y2) {
		this.y2 = y2;
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
