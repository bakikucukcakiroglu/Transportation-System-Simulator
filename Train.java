
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import passengers.*;
import locations.*;

/**
 * This class implements a simple train which is public transportation vehicle
 * with range. Train has all features of PublicTransport.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */
public class Train extends PublicTransport {

	/**
	 * This construct a train with an ID and range given as x1,x2,y1,y2 coordinates.
	 * 
	 * @param ID the ID of vehicle
	 * @param x1 the range of vehicle on the x axis.
	 * @param y1 the range of vehicle on the y axis.
	 * @param x2 the range of vehicle on the x axis.
	 * @param y2 the range of vehicle on the y axis.
	 */
	public Train(int ID, double x1, double y1, double x2, double y2) {
		super(ID, x1, y1, x2, y2);

	}

	/**
	 * This method calculates the travel fee according to type of passenger and
	 * distance of travel.
	 * 
	 * @param p        the passenger who wants to travel with this train.
	 * @param distance the distance between the current location of the passenger
	 *                 and the arrival point.
	 * @return the fee that will be taken from passenger's travel card. If passenger
	 *         is discounted, s/he has %20 discount.
	 */
	public double getPrice(Passenger p, double distance) {

		if (p instanceof DiscountedPassenger) {

			if ((distance / 15) - ((int) (distance / 15)) >= 0.5) {

				double fee = (((int) (distance / 15)) + 1) * 4;
				return fee;

			} else {
				double fee = ((int) (distance / 15)) * 4;
				return fee;
			}

		} else {
			if ((distance / 15) - ((int) (distance / 15)) >= 0.5) {

				double fee = (((int) (distance / 15)) + 1) * 5;
				return fee;

			} else {
				double fee = ((int) (distance / 15)) * 5;
				return fee;
			}

		}
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
