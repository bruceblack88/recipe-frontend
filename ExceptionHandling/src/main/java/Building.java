/*Bruce Black
 *Software Development
 * CSCI 505
 * Dr. James Dollens
 * May 23, 2021
 */
//Building class
//Implements Carbon Footprint Interface
public class Building implements CarbonFootprint {

	double monthlyElectricBill;

	double monthlyGasBill;

	// Building class attributes
	//Exception for double <=0
	Building(double monthlyElectricBill, double monthlyGasBill) {
		if (monthlyElectricBill >= 0 && monthlyGasBill >= 0) {
			this.monthlyElectricBill = monthlyElectricBill;
			this.monthlyGasBill = monthlyGasBill;
		} else {
			throw new InvalidFootprintException();
		}
	}

	// Get Monthly Electric Bill
	public double getMonthlyElectricBill(double monthlyElectricBill)

	{

		return monthlyElectricBill;

	}

	// Set Monthly Electric Bill
	public void setMonthlyElectricBill(double monthlyElectricBill)

	{

		this.monthlyElectricBill = monthlyElectricBill;

	}

	// Get Monthly Gas Bill
	public double getMonthlyGasBill(double monthlyGasBill)

	{

		return monthlyGasBill;

	}

	// Set Monthly Gas Bill
	public void setMonthlyGasBill(double monthlyGasBill)

	{

		this.monthlyGasBill = monthlyGasBill;

	}

	// Calculate Carbon Footprint method
	public String getCarbonFootprint() {

		double footPrint = (monthlyGasBill / 10.68 * (119.58 * 12)) + (monthlyElectricBill / 0.1188 * (1232 * 12));

		return "Total of Building Carbon Footprint= " + String.valueOf(footPrint);

	}

}