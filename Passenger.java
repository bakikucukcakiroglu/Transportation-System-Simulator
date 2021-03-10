
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import vehicles.*;
import locations.*;
import interfaces.*;
import passengers.*;

/**
 * This class implements a simple passenger that can purchase a car, refuel a
 * car, refill a card drive a car or ride a public transportation vehicle.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */

public class Passenger implements usePublicTransport, ownCar, Comparable<Passenger> {

	/**
	 * @param ID                Id of the passenger
	 * @param hasDriversLicence state of if the passenger has a license or not
	 * @param cardBalance       card balance of the passenger
	 * @param car               car of the passenger
	 * @param currentLocation   current location of the passenger.
	 */

	private int ID;
	private boolean hasDriversLicense;
	private double cardBalance;
	private Car car;
	private Location currentLocation;

	/**
	 * This constructs a passenger who doesn't have a car with a specified ID, state
	 * of having driver license and location.
	 * 
	 * @param ID                the ID of passenger. Starts from 0 and special for
	 *                          every passenger.
	 * @param hasDriversLicense State of if a passenger has driver license or not.
	 * @param l                the location where the passenger been created.
	 */

	public Passenger(int ID, boolean hasDriversLicense, Location l) {
		this.ID = ID;
		this.hasDriversLicense = hasDriversLicense;
		this.currentLocation = l;
		this.cardBalance = 0;

	}

	/**
	 * This constructs a passenger who has a car with a specified ID, car's fuel
	 * consumption and location.
	 * 
	 * @param ID              the ID of passenger
	 * @param l               the location where the passenger been created
	 * @param fuelConsumption the rate of fuel consumption per kilometer for
	 *                        passenger's car
	 */

	public Passenger(int ID, Location l, double fuelConsumption) {
		this.hasDriversLicense = true;
		this.ID = ID;
		this.currentLocation = l;
		this.setCar(new Car(this.getID(), fuelConsumption));
		this.car.setFuelAmount(0);
		this.cardBalance = 0;

	}

	/**
	 * This method provides passenger to purchase a car. When this method is
	 * executed passenger will have a car with a fuel consumption rate.
	 * 
	 * @param fuelConsumption the rate of fuel consumption per kilometer for the car
	 *                        which is purchased from the passenger.
	 */

	public void purchaseCar(double fuelConsumption) {

		if (this.getCar() == null) {
			this.setCar(new Car(this.getID(), fuelConsumption));
		} else {
			this.getCar().setFuelConsumption(fuelConsumption);
			this.getCar().setFuelAmount(0);
		}

	}

	/**
	 * This method provides passenger to refuel his/her car with given amount of
	 * oil. If passenger doesn't have a car this method doesn't work.
	 * 
	 * @param amount the amount of oil refueled.
	 */

	public void refuel(double amount) {

		if (this.getCar() != null) {
			this.getCar().refuel(amount);
		}
	}

	/**
	 * This method enables passenger to drive his/her car and travel a given
	 * location from his/her current location. If s/he is already at the location
	 * that s/he has to go the method doesn't work.
	 * 
	 * @param l
	 */
	public void drive(Location l) {

		double distance = Math.sqrt(Math.pow(this.currentLocation.getLocationX() - l.getLocationX(), 2)
				+ Math.pow(this.currentLocation.getLocationY() - l.getLocationY(), 2));

		if (this.currentLocation != l) {
			if (distance * this.getCar().getFuelConsumption() <= this.getCar().getFuelAmount()) {

				this.currentLocation.outgoingPassenger(this);

				this.currentLocation = l;

				l.incomingPassenger(this);

				this.getCar()
						.setFuelAmount(this.getCar().getFuelAmount() - (distance * this.getCar().getFuelConsumption()));

			}
		}

	}

	/**
	 * This method provides passengers to get on the bus or train according to given
	 * vehicle and go given location. If given location isn't in the given vehicles
	 * range or the card balance of passenger isn't enough to do this travel this
	 * method doesn't work.
	 * 
	 * @param p the public transportation vehicle object that will be used for
	 *          travel. It can be a bus or train.
	 * @param l the location where passenger want to reach.
	 */

	public void ride(PublicTransport p, Location l) {

		double distance = Math.sqrt(Math.pow(this.currentLocation.getLocationX() - l.getLocationX(), 2)
				+ Math.pow(this.currentLocation.getLocationY() - l.getLocationY(), 2));

		if (this.currentLocation != l && p.canRide(currentLocation, l)) {

			if (p instanceof Bus) {

				double fee = ((Bus) p).getPrice(this, distance);

				if (fee <= this.cardBalance) {

					this.cardBalance = this.cardBalance - fee;
					this.currentLocation.outgoingPassenger(this);

					l.incomingPassenger(this);
					this.currentLocation = l;

				}
			} else {

				double fee = ((Train) p).getPrice(this, distance);

				if (fee <= this.cardBalance) {

					this.cardBalance -= fee;
					this.currentLocation.outgoingPassenger(this);

					l.incomingPassenger(this);
					this.currentLocation = l;
				}

			}
		}
	}

	/**
	 * This method enables passengers to refill their travel card with the given
	 * amount of money.
	 * 
	 * @param amount the amount of money loaded the travel card.
	 */

	public void refillCard(double amount) {

		this.cardBalance += amount;

	}

	/**
	 * This method compares passengers according to their ID and enable us to sort
	 * them.
	 * 
	 * @param p the passenger comparing with another.
	 * @return an integer which gives difference of two ID.
	 */

	public int compareTo(Passenger p) {

		return this.ID - p.getID();
	}

	/**
	 * This method returns passenger's ID.
	 * 
	 * @return the passenger's ID.
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * This method enable us to set passenger's ID since it is private.
	 * 
	 * @param iD the given ID that will be given to passenger.
	 */
	public void setID(int iD) {
		this.ID = iD;
	}

	/**
	 * This method returns the state of if passenger has a driver license or not.
	 * 
	 * @return the state of having a driver license or not.
	 */

	public boolean gethasDriversLicence() {
		return this.hasDriversLicense;
	}

	/**
	 * This method enable us to set passenger's state of having a car or not since
	 * it is private.
	 * 
	 * @param hasDriversLicence given state of if passenger has a driver license or
	 *                          not.
	 */
	public void setHasDriversLicence(boolean hasDriversLicence) {
		this.hasDriversLicense = hasDriversLicence;
	}

	/**
	 * This method returns passenger's car balance.
	 * 
	 * @return the passenger's card balance.
	 */

	public double getCardBalance() {
		return this.cardBalance;
	}

	/**
	 * This method enable us to set passenger's card balance since it is private.
	 * 
	 * @param cardBalance the given card balance that will be given to passenger.
	 */
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	/**
	 * This method returns the passenger's car as a car object.
	 * 
	 * @return the passenger's car.
	 */

	public Car getCar() {
		return this.car;
	}

	/**
	 * This method enable us to set passenger's car since it is private.
	 * 
	 * @param iD the given car object that will be given to passenger.
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * This method returns passenger's current location.
	 * 
	 * @return passenger's current location.
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * This method enable us to set passenger's current location since it is
	 * private.
	 * 
	 * @param iD the given location that will be given to passenger.
	 */
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
