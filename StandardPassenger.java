
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import locations.*;

/**
 * This class implements a standard passenger which is passenger but discounted
 * in public transportation. Standard passenger has all features of passenger.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */

public class StandardPassenger extends Passenger {

	/**
	 * This constructs a standard passenger who doesn't have a car with a specified
	 * ID, state of having driver license and location.
	 * 
	 * @param ID                the ID of passenger. Starts from 0 and special for
	 *                          every passenger.
	 * @param hasDriversLicence State of if a passenger has driver license or not.
	 * @param f                 the location where the passenger been created.
	 */

	public StandardPassenger(int ID, boolean hasDriversLicence, Location f) {

		super(ID, hasDriversLicence, f);
	}

	/**
	 * This constructs a standard passenger who has a car with a specified ID, state
	 * of having driver license and location.
	 * 
	 * @param ID                the ID of passenger. Starts from 0 and special for
	 *                          every passenger.
	 * @param hasDriversLicence State of if a passenger has driver license or not.
	 * @param f                 the location where the passenger been created.
	 */
	public StandardPassenger(int ID, Location f, double fuelConsumption) {

		super(ID, f, fuelConsumption);
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
