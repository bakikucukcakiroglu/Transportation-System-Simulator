
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import locations.*;

/**
 * This class implements a discounted passenger which is passenger but
 * discounted in public transportation. Discounted passenger has all features of
 * passenger.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */

public class DiscountedPassenger extends Passenger {

	/**
	 * This constructs a discounted passenger who doesn't have a car with a
	 * specified ID, state of having driver license and location.
	 * 
	 * @param ID                the ID of passenger. Starts from 0 and special for
	 *                          every passenger.
	 * @param hasDriversLicence State of if a passenger has driver license or not.
	 * @param f                 the location where the passenger been created.
	 */

	public DiscountedPassenger(int ID, boolean hasDriversLicense, Location f) {
		super(ID, hasDriversLicense, f);
	}

	/**
	 * This constructs a discounted passenger who has a car with a specified ID,
	 * car's fuel consumption and location.
	 * 
	 * @param ID              the ID of passenger
	 * @param f               the location where the passenger been created
	 * @param fuelConsumption the rate of fuel consumption per kilometer for
	 *                        passenger's car
	 */

	public DiscountedPassenger(int ID, Location f, double fuelConsumption) {
		super(ID, f, fuelConsumption);
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
