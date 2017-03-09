import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Tester {

	public static void main(String[] args) {
		final MeetingRoom meetingroom = new MeetingRoom();
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		for(int i=1; i<=10; i++){
			
			executor.submit(new Supplier(meetingroom, i));
		}
		
		for(int i=1; i<=10; i++){
			executor.submit(new Consumer(meetingroom, i));
		}
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			
		}
		

		/*
		Thread s1 = new Thread(new Supplier(meetingroom, 1));
		Thread s2 = new Thread(new Supplier(meetingroom, 2));
		Thread s3 = new Thread(new Supplier(meetingroom, 3));
		Thread s4 = new Thread(new Supplier(meetingroom, 4));
		Thread s5 = new Thread(new Supplier(meetingroom, 5));
		Thread s6 = new Thread(new Supplier(meetingroom, 6));
		
		Thread c1 = new Thread(new Consumer(meetingroom, 1));
		Thread c2 = new Thread(new Consumer(meetingroom, 2));
		Thread c3 = new Thread(new Consumer(meetingroom, 3));
		Thread c4 = new Thread(new Consumer(meetingroom, 4));
		Thread c5 = new Thread(new Consumer(meetingroom, 5));
		Thread c6 = new Thread(new Consumer(meetingroom, 6));
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		s6.start();
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		
		*/
		

	}

}
