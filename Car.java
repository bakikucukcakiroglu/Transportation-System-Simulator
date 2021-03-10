
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

/**
 * This class implements a simple car with it's owner ID, fuel amount and fuel
 * consumption rate.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */
public class Car {

	/**
	 * @param ownerID         the ID of car's owner
	 * @param fuelAmount      the amount of fuel in the fuel tank of the car
	 * @param fuelConsumption the fuel consumption rate of the car
	 */
	private int ownerID;
	private double fuelAmount;
	private double fuelConsumption;

	/**
	 * This constructs a car with the given ID and given fuel consumption rate.
	 * 
	 * @param ID              the car's ID.
	 * @param fuelConsumption the fuel consumption rate of the car.
	 */
	public Car(int ID, double fuelConsumption) {

		this.ownerID = ID;
		this.fuelConsumption = fuelConsumption;

	}

	/**
	 * This method provides us to refuel this car with the given amount of fuel.
	 * 
	 * @param amount the amount of fuel that will load to car.
	 */
	public void refuel(double amount) {

		this.fuelAmount += amount;

	}

	/**
	 * This method returns ID of car's owner since it is private.
	 * 
	 * @return the Id of car's owner.
	 */
	public int getOwnerID() {
		return ownerID;
	}

	/**
	 * This method enables us to set car's ID as given ID since it is private.
	 * 
	 * @param ownerID the ID that will be given to car.
	 */

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	/**
	 * This method returns car's fuel amount since it is private.
	 * 
	 * @return the fuel amount of the car.
	 */
	public double getFuelAmount() {
		return fuelAmount;
	}

	/**
	 * This method enables us to set car's fuel amount as given fuel amount since it
	 * is private.
	 * 
	 * @param fuelAmount the fuel amount that will be given to car.
	 */
	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	/**
	 * This method returns car's fuel consumption rate since it is private.
	 * 
	 * @return the fuel consumption rate of the car.
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * This method enables us to set car's fuel consumption rate as given rate since
	 * it is private.
	 * 
	 * @param fuelAmount the fuel consumption rate that will be given to car.
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
