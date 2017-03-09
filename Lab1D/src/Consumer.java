
public class Consumer implements Runnable{

	private MeetingRoom meetingroom;
	final private int threadid;
	public Consumer(MeetingRoom meetingroom, int id){
		this.meetingroom = meetingroom;
		this.threadid = id;
	}
	
	
	@Override
	public void run() {
		
		try {
			meetingroom.consume(threadid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
