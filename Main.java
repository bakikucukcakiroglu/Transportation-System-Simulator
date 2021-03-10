
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;

import java.util.*;

import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;
import interfaces.*;

/**
 * This is a CMPE 160 project. This class implements a transportation simulation
 * contains passengers, cars, buses and trains and their actions such that
 * refilling card, refuel a car, traveling. This project reads a input file and
 * executes according to data in this file.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * @since 2020-03-28
 */

public class Main {

	/**
	 * This method executes code according to given arguments. It contains for
	 * loops, variables, scanners, print streams, array lists and if else
	 * statements.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("input.txt"));
		// reads the input from input file.

		PrintStream output = new PrintStream(new File("output.txt"));
		// provides us to write output in a blank file.

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();
		// array lists represent all passengers, all locations and all vehicles
		// respectively.
		// They are sorted by ID.

		Location l = new Location(0, 0, 0); // The first location is always (0,0).
		// The zero point where every passenger born in.

		locations.add(l);
		int operations = input.nextInt();
		// The code of operation.
		input.nextLine();
		// the number of operations

		int passengerId = 0;
		int locationId = 1;
		int vehicleId = 0;
		// integers represent ID of passenger, location and vehicle respectively.
		// Since there was a location before. LocationId starts from 1.

		for (int k = 0; k < operations; k++) {
			// This loop executes code operation number times.

			String line = input.nextLine();
			// The following line of the input.

			Scanner liner = new Scanner(line);
			// Enables us to make operations on line.

			int operationNum = liner.nextInt();
			// The code of operation that determines operation.

			if (operationNum == 1) {
				// 1 means create a new passenger.

				boolean DriverLicence = false;

				String passengerType = liner.next();
				// Takes next integer that determines the passenger type.

				int hasDriverLicence = liner.nextInt();
				// Takes next integer that determines if the passenger has driver license or
				// not.

				if (hasDriverLicence == 1) {
					DriverLicence = true;

				} else {
					DriverLicence = false;
				}

				int hasCar = liner.nextInt();
				// Takes next integer that determines if the passenger has car or not.

				if (hasCar == 1) {

					double fuelConsumptionRate = liner.nextDouble();
					// takes next double that gives us car's fuel consumption rate.

					if (passengerType.equals("D")) {
						// D means passenger is discounted.

						passengers.add(new DiscountedPassenger(passengerId, l, fuelConsumptionRate));
						// adds new passenger to passengers array list.

						l.incomingPassenger(passengers.get(passengerId));

						passengerId++;

					} else {
						// else it is S and it means passenger is standard.

						passengers.add(new StandardPassenger(passengerId, l, fuelConsumptionRate));
						// adds new passenger to passenger array list.

						l.incomingPassenger(passengers.get(passengerId));

						passengerId++;

					}

				} else {

					if (passengerType.equals("D")) {
						// D means discounted passenger

						passengers.add(new DiscountedPassenger(passengerId, DriverLicence, l));

						l.incomingPassenger(passengers.get(passengerId));

						passengerId++;

					} else {
						// else it means standard passenger

						passengers.add(new StandardPassenger(passengerId, DriverLicence, l));

						l.incomingPassenger(passengers.get(passengerId));

						passengerId++;
					}
				}

			}
			if (operationNum == 2) {
				// 2 means create a location

				double Xlocation = liner.nextDouble();
				double Ylocation = liner.nextDouble();
				// these gives X and Y coordinates of location respectively.

				locations.add(new Location(locationId, Xlocation, Ylocation));
				// adds new location to locations array list.

				locationId++;

			}
			if (operationNum == 3) {
				// 3 means create a public transportation vehicle.

				int vehicleType = liner.nextInt();
				// determines if vehicle is a bus or train.

				double rangeX1 = liner.nextDouble();
				double rangeY1 = liner.nextDouble();
				double rangeX2 = liner.nextDouble();
				double rangeY2 = liner.nextDouble();
				// these gives us X and Y coordinates of the range of vehicles.

				if (vehicleType == 1) {
					// 1 means bus

					vehicles.add(new Bus(vehicleId, rangeX1, rangeY1, rangeX2, rangeY2));
					// adds new vehicle to vehicles array list

				} else {
					// else it is 2 and it means train

					vehicles.add(new Train(vehicleId, rangeX1, rangeY1, rangeX2, rangeY2));
					// adds new vehicle to vehicles array list
				}

			}
			if (operationNum == 4) {//////////////
				// 4 means passenger will travel

				int passengerCode = liner.nextInt();
				int locationCode = liner.nextInt();
				int vehicleNum = liner.nextInt();
				// these gives us passenger ID, location ID and type of vehicle respectively.

				if (vehicleNum == 1 || vehicleNum == 2) {
					// 1 means bus 2 means train

					int vehicleCode = liner.nextInt();
					// takes vehicle ID

					if (vehicleNum == 1) {

						if (vehicles.get(vehicleCode) instanceof Bus) {
							// controls if the vehicle really a bus or not

							passengers.get(passengerCode).ride(vehicles.get(vehicleCode), locations.get(locationCode));
						}

					}
					if (vehicleNum == 2) {

						if (vehicles.get(vehicleCode) instanceof Train) {
							// controls if the vehicle really a train or not

							passengers.get(passengerCode).ride(vehicles.get(vehicleCode), locations.get(locationCode));
						}

					}

				} else if (vehicleNum == 3) {
					// 3 means private car

					if (passengers.get(passengerCode).getCar() != null) {
						// controls if passenger really has a car or not

						passengers.get(passengerCode).drive(locations.get(locationCode));
					}

				}

			}
			if (operationNum == 5) {
				// means passenger will purchase a car

				int passengerCode = liner.nextInt();
				// takes next integer that gives us passenger ID

				double fuelCons = liner.nextDouble();
				// takes next double that gives us the fuel consumption rate of new car

				passengers.get(passengerCode).purchaseCar(fuelCons);

				passengers.get(passengerCode).setHasDriversLicence(true);

			}
			if (operationNum == 6) {
				// means passenger will refuel his/her car

				int passengerCode = liner.nextInt();
				// takes next integer that gives us passenger ID

				double fuelAmount = liner.nextDouble();
				// takes next double that gives us fuel amount that will be loaded.

				if (passengers.get(passengerCode).getCar() != null) {
					// checks if passenger really has a car to refuel or not

					passengers.get(passengerCode).refuel(fuelAmount);
				}

			}
			if (operationNum == 7) {
				// 7 means refill the travel card

				int passengerCode = liner.nextInt();
				// takes next integer that gives us passenger ID

				double moneyAmount = liner.nextDouble();
				// takes next double that gives us amount of money that will be loaded to travel
				// card

				passengers.get(passengerCode).refillCard(moneyAmount);

			}

		}

		int listSize = locations.size();
		// gives us the size of locations list.

		for (int x = 0; x < listSize; x++) {
			// executes this part of the code listSize times to print all locations.

			double lx = locations.get(x).getLocationX();
			// x coordinate of the location

			String i = Double.toString(lx);
			i = i + "00";
			String printLx = i.substring(0, i.indexOf(".") + 3);
			// these three line takes 2 digit after dot without rounding

			double ly = locations.get(x).getLocationY();
			// y coordinate of the location

			String k = Double.toString(ly);
			k = k + "00";
			String printLy = k.substring(0, k.indexOf(".") + 3);
			// these three lines takes 2 digit after decimal without rounding

			output.println("Location " + x + ": " + "(" + printLx + ", " + printLy + ")");

			int passengerInLocation = locations.get(x).getCurrent().size();
			// number of passengers in that location

			Collections.sort(locations.get(x).getCurrent());
			// sorting current array list of this location according to ID

			for (int j = 0; j < passengerInLocation; j++) {
				// executes this part of the code to print all passengers in this location

				if (locations.get(x).getCurrent().get(j).getCar() != null) {
					// this statement checks if passenger has a car or not and if has it prints fuel
					// amount

					int ıd = locations.get(x).getCurrent().get(j).getID();
					// gives us passenger's ıd who is in this location right now

					double fuel = locations.get(x).getCurrent().get(j).getCar().getFuelAmount();
					// gives us the fuel amount of passenger's car

					String a = Double.toString(fuel);
					a = a + "00";
					int index = a.indexOf(".");
					String print = a.substring(0, index + 3);
					// these three lines takes 2 digit after decimal without rounding

					output.println("Passenger " + ıd + ": " + print);

				} else {
					// else means passenger doesn't have car and it prints card balance

					int ıd = locations.get(x).getCurrent().get(j).getID();
					// gives us the ID of passenger who is in this location right now

					double balance = locations.get(x).getCurrent().get(j).getCardBalance();
					// gives us the card balance of passenger

					String a = Double.toString(balance);
					a = a + "00";
					int index = a.indexOf(".");
					String print = a.substring(0, index + 3);
					// these three lines takes 2 digit after decimal without rounding

					output.println("Passenger " + ıd + ": " + print);

				}
			}
		}

	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
