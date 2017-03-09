import java.util.Iterator;

public class TranscriptPrinter {
	public void printTranscript(Iterator<Student> students, int id){
		
		System.out.println("\n---------Transcript-------");
		while(students.hasNext()){
			Student s = students.next();
			if (s.getid() == id){
				
				s.printInfo();
				return;
			
			}
		}
		
		
		System.out.println("No such student with ID: " + id);
	}
	
	public void printTranscript(Iterator<Student> students, int... ids){
		System.out.println("\n---------Transcript-------");
		while(students.hasNext()){
			Student s = students.next();
			for(int id: ids){
				if(s.getid() == id){
					s.printInfo();
				}
			}
		}
	}
}
