
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import passengers.*;

import interfaces.usePublicTransport;
import main.*;
import interfaces.*;

/**
 * This class implements a simple bus which is public transportation vehicle
 * with range. Bus has all features of PublicTransport.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */
public class Bus extends PublicTransport {

	/**
	 * This construct a bus with an ID and range given as x1,x2,y1,y2 coordinates.
	 * 
	 * @param ID the ID of vehicle
	 * @param x1 the range of vehicle on the x axis.
	 * @param y1 the range of vehicle on the y axis.
	 * @param x2 the range of vehicle on the x axis.
	 * @param y2 the range of vehicle on the y axis.
	 */
	public Bus(int ID, double x1, double y1, double x2, double y2) {

		super(ID, x1, y1, x2, y2);

	}

	/**
	 * This method calculates the travel fee according to type of passenger and
	 * distance of travel.
	 * 
	 * @param p        the passenger who wants to travel with this bus.
	 * @param distance the distance between the current location of the passenger
	 *                 and arrival point.
	 * @return the fee that will be taken from passenger's travel card.If passenger
	 *         is discounted, s/he has %50 discount.
	 */
	public double getPrice(Passenger p, double distance) {

		if (p instanceof DiscountedPassenger) {

			return 1.;
		} else {
			return 2.;
		}

	}

}
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
