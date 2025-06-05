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
	public void processTrade(int quantity)
	{
		
//		currentPrice  += quantity/100;
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
		ListedCompany cmp1 = new ListedCompany("456","CC Industries",60);
		System.out.println(cmp1.getCurrentPrice());
		cmp1.processTrade(-200);
		System.out.println(cmp1.getCurrentPrice());
	}
}
