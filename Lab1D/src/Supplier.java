
public class Supplier implements Runnable {
	private MeetingRoom meetingroom;
	final private int threadid;
	
	public Supplier(MeetingRoom meetingroom, int id){
		this.threadid = id;
		this.meetingroom = meetingroom;
	}

	@Override
	public void run() {
		try {
			meetingroom.supply(threadid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
