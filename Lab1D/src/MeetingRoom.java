import java.util.Random;

public class MeetingRoom {
	
	static private int roomdata = -1; // empty data
	static private Object lock = new Object();
	static private Random random = new Random();
	
	
	public void supply(int threadid) throws InterruptedException{
		while(true){
			boolean haswait = false;
			int sleeptime= random.nextInt(1000);
			Thread.sleep(sleeptime);
			System.out.println("Supplier " + threadid + " sleeps " + sleeptime + " milliseconds.");
			
			synchronized(lock){
				
				long start = System.currentTimeMillis();
				while(roomdata > 0){
					haswait = true;
					System.out.println("Supplier " + threadid + " enters meeting room.");
					System.out.println("Supplier " + threadid + " enters waiting room.");
					lock.wait();
				}
				long end = System.currentTimeMillis();
				if(haswait){
					System.out.println("Supplier " + threadid + " wait " + (end-start) + " millisecond.");
				}
				roomdata = threadid;//supply as the thread id# as data
				System.out.println("Supplier " + threadid + " enters meeting room/leave data for consumer " + threadid);
				lock.notifyAll();
			}
			
		}
	}
	public void consume(int threadid) throws InterruptedException{
		while(true){
			boolean haswait = false;
			int sleeptime= random.nextInt(1000);
			Thread.sleep(sleeptime);
			System.out.println("Consumer " + threadid + " sleeps " + sleeptime + " milliseconds.");
			long start = System.currentTimeMillis();
			synchronized(lock){
				
				while(roomdata != threadid){
					haswait = true;
					System.out.println("Consumer " + threadid + " enters meeting room.");
					System.out.println("Consumer " + threadid + " enters waiting room.");
					lock.wait();
				}
				long end = System.currentTimeMillis();
				if(haswait){
					System.out.println("Consumer " + threadid + " wait " + (end-start) + " millisecond.");
				}
				roomdata = -1;//consume the data
				System.out.println("Consumer " + threadid + " enters meeting room/remove data.");;
				lock.notifyAll();
			}
		}
	}
	
	
	
	
	
}
