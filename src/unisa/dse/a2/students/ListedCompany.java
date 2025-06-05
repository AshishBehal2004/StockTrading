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
	
	public void getName() 
	{
		
	}
	
	public void getCode() 
	{
		
	}
	

	
	public void getCurrentPrice() {
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
	}
}
