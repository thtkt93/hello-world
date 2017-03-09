
public class StockMonitor extends StockCustomer {

	
	public StockMonitor(int limit){
		
		this.limit = limit;
			
	}
	
	@Override
	public void pricedChanged(PriceChangeEvent PE) {
		
		if (PE.getChange()==limit) {
			
			System.out.println("Price changed " + limit + " unit amount after " + step + " steps");
			PE.getStockExchange().RemoveObserver(this);
			
			
		}
		step++;
		
	}

	

}
