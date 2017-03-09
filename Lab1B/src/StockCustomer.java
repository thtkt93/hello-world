
public abstract class StockCustomer implements StockObserver{
	int step;
	int limit;
	
	@Override
	public void pricedChanged(PriceChangeEvent PE) {
	}

}
