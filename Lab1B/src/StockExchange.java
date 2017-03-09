
import java.util.Iterator;
//import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class StockExchange implements Runnable{
	private int start_price = 100;
	private int current_price;
	private CopyOnWriteArrayList<StockObserver> observers;
	private PriceChangeEvent pricechangeevent;
	
	public StockExchange(){
		observers = new CopyOnWriteArrayList<StockObserver>();
		pricechangeevent = new PriceChangeEvent(this, 0);
		current_price = start_price;
	}
	
	public StockExchange(int startPrice){
		this();
		start_price = startPrice;
		current_price = start_price;

	}
	
	public void addObserver(StockObserver newObserver) {
		observers.add(newObserver);
	}
	public void RemoveObserver(StockObserver deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		
		observers.remove(observerIndex);
	}
	
	
	
	public void notifyObserver() {
		
		
		Iterator<StockObserver> iterator = observers.iterator();
		while (iterator.hasNext()){
			StockObserver observer = iterator.next();
			
			observer.pricedChanged(pricechangeevent);
		}
	}
	
	public void setPrice(int newPrice){
		this.current_price = newPrice;
		this.pricechangeevent.setChange(Math.abs(start_price - newPrice));
		
		notifyObserver();
	}
	
	
	public int getPrice(){
		return this.current_price;
	}
	
	

	@Override
	public void run() {
		this.setPrice(start_price);
		while (observers.size() != 1) {
			
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			Random r = new Random();
			int choice = r.nextInt(2);
			int increment;
			if (choice==0)
				increment = 1;
			else
				increment = -1;
			
			this.setPrice(getPrice()+increment);
		}
	}
	
}
