package unisa.dse.a2.students;

import java.util.HashMap;
import java.util.Scanner;

import unisa.dse.a2.interfaces.ListGeneric;

public class SecuritiesExchange {

	/**
	 * Exchange name
	 */
	private String name;
	
	public String getName() {
		return name;
	}
	
	/**
	 * List of brokers on this exchange
	 */
	public ListGeneric<StockBroker> brokers;
	
	/**
	 * List of announcements of each trade processed
	 */
	public ListGeneric<String> announcements;
	
	/**
	 * HashMap storing the companies, stored based on their company code as the key
	 */
	public HashMap<String, ListedCompany> companies;

	/**
	 * Initialises the exchange ready to handle brokers, announcements, and companies
	 * @param name
	 */
	public SecuritiesExchange(String name)
	{
		this.name = name;
		this.brokers = new DSEListGeneric<>();;
		this.announcements = new DSEListGeneric<>();
		this.companies = new HashMap<>();
	}
	
	/**
	 * Adds the given company to the list of listed companies on the exchange
	 * @param company
	 * @return true if the company was added, false if it was not
	 */
	/* The way in which this method works it retrieves the companies(which is hashmap of string type that also takees listed company class i made as anotherargument or parameter.
	 * then checks using if that, does the company exists in the companies list, if yes then return false , otherwise adds that company(actually the company code) since its a key value 
	 * thing in hashmap and the company itself in it.then returns true, */
	public boolean addCompany(ListedCompany company)
	{
		if (companies.containsKey(company.getCode()))
		{
			return false;
		}
		companies.put(company.getCode(), company);
		return true;
	}

	/**
	 * Adds the given broke to the list of brokers on the exchange
	 * @param company
	 */
	
	/* Using if to check the condition if the broker(passed as parameter) already exist), if yes then return true
	 * otherwise just add that inside the brokers(which is a lgeneric list of stockbroker type and return true*/
	public boolean addBroker(StockBroker broker)
	{
		if (brokers.contains(broker))
		{
			return false;			
		}
		brokers.add(broker);
		return true;
	}
	
	/**
	 * Process the next trade provided by each broker, processing brokers starting from index 0 through to the end
	 * 
	 * If the exchange has three brokers, each with trades in their queue, then three trades will processed, one from each broker.
	 * 
	 * If a broker has no pending trades, that broker is skipped
	 * 
	 * Each processed trade should also make a formal announcement of the trade to the announcements list in the form a string:
	 * "Trade: QUANTITY COMPANY_CODE @ PRICE_BEFORE_TRADE via BROKERNAME", 
	 * e.g. "Trade: 100 DALL @ 99 via Honest Harry Broking" for a sale of 100 DALL shares if they were valued at $99
	 * Price shown should be the price of the trade BEFORE it's processed. Each trade should add its announcement at 
	 * the end of the announcements list
	 * 
	 * @return The number of successful trades completed across all brokers
	 * @throws UntradedCompanyException when traded company is not listed on this exchange
	 */
	public int processTradeRound()
	{
		for (int i =0;i < brokers.size(); i++)
		{
			StockBroker broker = brokers.get(i);
			Trade trade = broker.getNextTrade();
			int quantity = trade.getShareQuantity();
			if (trade != null)
			{
				String companyCode = trade.getCompanyCode();
				if (companies.containsKey(companyCode))
				{
					ListedCompany company = companies.get(companyCode);
					company.getCurrentPrice();
					company.processTrade(quantity);
					
				}
			}
		}
	}
	
	
	/*Takes input sc(which is a user input) made int variable that will be used for counting the total rounds.
	 * and the checkInput (responisble for seeing what the user is typing) and then comparing it in further stage
	 * the while loops as long as user does not enter exit, it first check what the user types, compare that in if(to see if he/she typed trade)
	 * if yes then call the processTradeRound() method here and increase the int rounds vriable, at last return that rounds variable*/
	public int runCommandLineExchange(Scanner sc)
	{
		int totalRounds = 0;
		String checkInput = sc.nextLine();
		
		while(!checkInput.equals("exit"))
		{
			checkInput = sc.nextLine();
			if (checkInput.equals("trade")) {
				processTradeRound();
				totalRounds++;
			}
		}
		return totalRounds;
	}
}
