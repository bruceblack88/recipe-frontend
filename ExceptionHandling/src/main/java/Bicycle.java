/*Bruce Black
 *Software Development
 * CSCI 505
 * Dr. James Dollens
 * May 23, 2021
 */
//Bicycle Class
//Implements Carbon Footprint Interface
public class Bicycle implements CarbonFootprint {

	double milesTraveledPerMonth;

	// Bicycle class attributes
	//Exception for double <=0
	Bicycle(double milesTraveledPerMonth) {
		if (milesTraveledPerMonth >= 0) {
			this.milesTraveledPerMonth = milesTraveledPerMonth;
		} else {
			throw new InvalidFootprintException();
		}
	}

	// Get Miles Traveled Per Month
	public double getMilesTraveledPerMonth(double milesTraveledPerMonth)

	{

		return milesTraveledPerMonth;

	}

	// Set Miles Traveled Per Month
	public void setMilesTraveledPerMonth(double milesTraveledPerMonth)

	{

		this.milesTraveledPerMonth = milesTraveledPerMonth;

	}

	// Calculate Carbon Footprint method
	public String getCarbonFootprint()

	{

		double footPrint = milesTraveledPerMonth * 0.95;

		return "Total Bicycle Carbon Footprint= " + String.valueOf(footPrint);

	}

}

