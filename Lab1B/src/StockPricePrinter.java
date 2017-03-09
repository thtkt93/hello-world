
public class StockPricePrinter extends StockCustomer {
	
	public StockPricePrinter(){
		
	}
	
	@Override
	public void pricedChanged(PriceChangeEvent pricechangecent) {
		System.out.println("Current Stock Price: " + pricechangecent.getStockExchange().getPrice());
		
	}


}
