package unisa.dse.a2.students;

import java.util.PriorityQueue;

public class StockBroker {

	
	
	/**
	 * List of pending trades to be completed. Must store a generic type.
	 */
	private PriorityQueue<Trade> pendingTrades = new PriorityQueue<Trade>();
	
	/**
	 * List of stocks this stock broker is "watching"
	 */
	private DSEListGeneric<String> watchList = new DSEListGeneric<String>();

	/**
	 * returns a DEEP copy of the watchlist. Changes to the list returned from here
	 * should NOT change the list stored by this broker
	 * @return
	 */
	public DSEListGeneric<String> getWatchlist() 
	{
		return new DSEListGeneric<String>(watchList);
	}
	
	/**
	 * Adds the company code to the watchlist if it's not null and not already in there
	 * @param companyCode
	 * @return true if added
	 */
	//Responisble for adding the companyCode to the watchList, The way i done it is: first retrieved the watch list size by calling the size() method and storing it in vairable
	//and then checked the invalid case first where if company code is null return false, then used for loop and used listSize(explained already in above line) to go through the list.
	// and check if the companyCode matches that of the code which is already in the list, if it does then return false.
	//these to if and for check if they are null and already exist, the last part gets done after these two check blocks become false, by adding the code to the list and returning true.
	public  boolean addWatchlist(String companyCode)
	{
		int listSize = watchList.size();
		if (companyCode == null)
		{
			return false;
		}
		for (int i = 0; i < listSize; i++)
		{
			if (watchList.get(i).equals(companyCode))
			{
				return false;
			}
		}
		
		watchList.add(companyCode);	
		return true;
		
	}
	// private string used in below code
	private String name;

	/**
	 * Name of the stock brokerage firm
	 * @return
	 */
	
	//basic getter to get the name of the stockbroker
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Should store the broker's name and ensure the broker is setup ready to use
	 * @param name
	 */
	//Constructor which makes a stockbroker with name, this one is a parameterised constructor if i am not wrong.
	public StockBroker(String name)
	{
		this.name = name;
	}
	
	/**
	 * Adds the Trade to the pendingTrades list if it's not null and not already in there
	 * @param companyCode
	 * @return true if added
	 */
	//Here in this method used if to check the invalid condition where order could be null first, and second if order matches to the one inside the queue(if same return false)
	//last else block when both statement become false(not return false), add the order onto the pendingTrades and then return true.
	public boolean placeOrder(Trade order)
	{
		if (order == null)
		{
			return false;
		}
		else if (pendingTrades.contains(order))
		{
			return false;
		}
		else 
		{
			pendingTrades.add(order);
			return true;
		}
	}
	
	/**
	 * Gets, removes, and returns the next trade to process
	 * @return Trade to process
	 */
	//Got the next Trade in queue by calling the priorityqueue poll method(as it is 
	//responsible for getting the head(which should be the highest priority queue) ,
	//stored it in variable and returned it.
	public Trade getNextTrade()
	{
		Trade nextPendingTrade = pendingTrades.poll();
		return nextPendingTrade;
		
	}
	
	/**Cg
	 * @return Number of pending trades
	 */
	
	//Achieved the below functianilty by calling the priorityqueue size method,
	//stored it in variable and returned it.
	public int getPendingTradeCount()
	{
		int pendingQueueSize = pendingTrades.size();
		return pendingQueueSize;
	}

	/**
	 * Do not modify this equals, it is used for testing purposes
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockBroker other = (StockBroker) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	//testing code i ran to check how the implementation is working.
	public static void main(String[] args) {
		StockBroker broker1 = new StockBroker("Ashish");
//		DSEListGeneric watchList1 = new DSEListGeneric<>();
//		
//		String companycode1 = "ashish2004";
//		String companycode2 = "ashish2004";
		PriorityQueue pendingTrade1 = new PriorityQueue<>();
		System.out.println(broker1.placeOrder(null));
		broker1.getName();
		
//		System.out.println(watchList1.add(companycode1));
//		System.out.println(broker1.addWatchlist(companycode1));
//		System.out.println(broker1.addWatchlist(companycode2));
		
		
	}
}
