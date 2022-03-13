/*Bruce Black
 *Software Development
 * CSCI 505
 * Dr. James Dollens
 * May 23, 2021
 */
public class Main

{

	public static void main(String[] args)

	{
		
		// Enter (Miles Driven Per Year, Miles Per Gallon)
		Car myCar = new Car(100000, 25.00);
		try {
		System.out.println("Car Miles Driven Per Year = " + myCar.milesDrivenPerYear);
		System.out.println("Car Miles Per Gallon = " + myCar.milesPerGallon);
		}
		//catch illegal argument exception
		catch (IllegalArgumentException e)
		{
			System.err.println(e.toString());
		}
		// Enter (Monthly Gas Bill, Monthly Electric Bill
		Building myBuilding = new Building(70.00, 123.00);
		System.out.println("Building Monthly Gas Bill = " + myBuilding.monthlyGasBill);
		System.out.println("Building Monthly Electric Bill = " + myBuilding.monthlyElectricBill);
		
		// Enter (Miles Traveled Pen Month)
		Bicycle myBicycle = new Bicycle(100);
		System.out.println("Bicycle Monthly Miles Traveled Per Month = " + myBicycle.milesTraveledPerMonth);
		// Carbon Footprints for Building, Car, and Bicycle
		CarbonFootprint[] carbonFootprints = { myCar, myBuilding, myBicycle };

		for (CarbonFootprint carbonFootprint : carbonFootprints)

		{

			System.out.println(carbonFootprint.getCarbonFootprint());
			
		}

	}

}