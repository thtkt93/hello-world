
public class Tester {

	public static void main(String[] args) {
		
		
		StudentRecordManager ma = new StudentRecordManager();
		
		Student s1 = new Student("Tom","Tang","thtkt94@yahoo.com",ma); //id = 100
		s1.addcourse("biology");
		s1.addcourse("phyisc");
		s1.addcourse("PE");
		s1.addcourse("GAAAA");
		s1.removecourse("GAAAA");
		
		
		Student s2 = new Student("Ken","Tang","thtkt96@yahoo.com",ma); // id = 101
		s2.addcourse("biology");
		s2.addcourse("phyisc");
		s2.addcourse("PE");
		s2.addcourse("GAAAA");
		s2.removecourse("GAAAA");
		
		
		
		TranscriptPrinter p = new TranscriptPrinter();
		System.out.println("Transcript: 100");
		p.printTranscript(ma.getIterator(), 100); // tom tang
		
		ma.addStudent(s2);
		System.out.println("\nTranscript: 102");
		p.printTranscript(ma.getIterator(), 102); //no 102
		
		s1.addcourse("PE", "A");
		System.out.println("\nTranscript: 100 - 103");
		p.printTranscript(ma.getIterator(), 100,101,102,103); //tom tang PE:A and ken Tang
		
		Student s3 = new Student("Jimmy", "Lin", "gg@yahoo.com", ma);
		System.out.println("\nTranscript: 100 - 103");
		p.printTranscript(ma.getIterator(), 100,101,102,103); // print tom tang, ken tang, jimmy
		ma.removeStudent(s1); // remove Tom tang
		
		s2.removecourse("biology");
		p.printTranscript(ma.getIterator(), 100,101,102,103); 
		
		
		
		
	}

}
