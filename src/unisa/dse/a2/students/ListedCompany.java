package unisa.dse.a2.students;

public class ListedCompany {

	/**
	 * The full name of the company
	 */
	private String name;
	

	/**
	 * The listing code of the company
	 */
	private String code;
	
	/**
	 * Current price of the company after last trade
	 */
	private int currentPrice;
	
	public ListedCompany(String code, String name, int currentPrice)
	{
		this.code = code;
		this.name = name;
		this.currentPrice = currentPrice;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getCode() 
	{
		return code;
	}

	public int getCurrentPrice() 
	{
		return currentPrice;
	}
	
	
	/**
	 * Processing a trade should increase the current price of the company by 
	 *    quantity / 100
	 * A company's price CANNOT go below 1
	 * 
	 * @param quantity
	 * @return the price after adjustment
	 */
	/*using quantity to check if its greather than 0, divide the quantity by 100 and onto currentprice
	 * else if less than do the following math on line 62, and if newPrice is greater than equal to 1 change the
	 * current price to newPrice*/
	public void processTrade(int quantity)
	{
		if (quantity > 0)
		{
			currentPrice  += quantity/100;
		}
		else if (quantity < 0)
		{
			int newPrice = currentPrice + (quantity / 100);
			if (newPrice >=1)
			{
				currentPrice = newPrice;
			}
		}
	}
	public static void main(String[] args) {
		ListedCompany cmp1 = new ListedCompany("456","CC Industries",5);
		System.out.println(cmp1.getCurrentPrice());
		cmp1.processTrade(-300);
		System.out.println(cmp1.getCurrentPrice());
	}
}
