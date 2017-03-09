
public class Tester {
	public static void main(String[] args) {
		
		StockExchange stock1 = new StockExchange(20);
		
		
		StockPricePrinter printer = new StockPricePrinter();
		stock1.addObserver(printer);
		
		StockMonitor monitor1 = new StockMonitor(1);
		StockMonitor monitor2 = new StockMonitor(2);
		StockMonitor monitor3 = new StockMonitor(3);
		
		StockMonitor monitor5 = new StockMonitor(5);
		StockMonitor monitor15 = new StockMonitor(15);
		StockMonitor monitor20 = new StockMonitor(20);
		StockMonitor monitor25 = new StockMonitor(25);
		
		stock1.addObserver(monitor1);
		stock1.addObserver(monitor2);
		stock1.addObserver(monitor3);
		
		stock1.addObserver(monitor5);
		stock1.addObserver(monitor15);
		stock1.addObserver(monitor20);
		stock1.addObserver(monitor25);
		
		
		new Thread(stock1).start(); // thread.sleep(1000)
	}
}
