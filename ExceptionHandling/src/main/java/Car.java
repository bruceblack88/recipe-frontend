/*Bruce Black
 *Software Development
 * CSCI 505
 * Dr. James Dollens
 * May 23, 2021
 */
//Car class
//Implements Carbon Footprint Interface
public class Car implements CarbonFootprint

{

	double milesDrivenPerYear;

	double milesPerGallon;

	// Car class attributes
	Car(double milesDrivenPerYear, double milesPerGallon) {
		if (milesDrivenPerYear >= 0 && milesPerGallon >= 0) {
			this.milesDrivenPerYear = milesDrivenPerYear;
			this.milesPerGallon = milesPerGallon;
		} else {
			throw new InvalidFootprintException();
		}
	}

	// Get Miles Driven Per Year
	public double getMilesDrivenPerYear(double milesDrivenPerYear)

	{

		return milesDrivenPerYear;

	}

	// Set Miles Driven Per Year
	public void setMilesDrivenPerYear(double milesDrivenPerYear)

	{

		this.milesDrivenPerYear = milesDrivenPerYear;

	}

	// Get Miles Per Gallon
	public double getMilesPerGallon(double milesPerGallon)

	{

		return milesPerGallon;

	}

	// Set Miles Per Gallon
	public void setMilesPerGallon(double milesPerGallon)

	{

		this.milesPerGallon = milesPerGallon;

	}

	// Calculate Carbon Footprint method
	public String getCarbonFootprint()

	{

		double footPrint = milesDrivenPerYear / milesPerGallon * 19.82;

		return "Total of Car Carbon Footprint = " + String.valueOf(footPrint);

	}

}