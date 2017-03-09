
public class PriceChangeEvent {
	private int abs_change;
	private StockExchange stockexchange;
	
	public PriceChangeEvent(StockExchange stockexchange, int change) {
		this.stockexchange = stockexchange;
		this.abs_change = change;
	}
	public int getChange(){
		return abs_change;
	}
	public StockExchange getStockExchange(){
		return stockexchange;
	}
	
	public void setChange(int i){
		this.abs_change = i;
	}
	
	
}
