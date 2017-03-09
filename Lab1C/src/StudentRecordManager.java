import java.util.ArrayList;
import java.util.Iterator;

public class StudentRecordManager implements Iterator<Student> {
	private static ArrayList<Student> studentlist;
	private static int sid;
	
	int position;
	
	public StudentRecordManager(){
		studentlist = new ArrayList<Student>();
		sid = 100;
		position = 0;
				
	}
	public static ArrayList<Student> getStudentlist(){
		return studentlist;
	}
	
	public void addStudent(Student p){
		if (!studentlist.contains(p)){
			studentlist.add(p);
			p.setid(sid);
			sid++;
		}
	}
	public void removeStudent(Student p){
		studentlist.remove(p);
	}
	public void showAll(){
		for(Student s: studentlist){
			System.out.println(s.getid());
		}
	}
	public Student searchByID(int id){
		for(Student s: studentlist){
			if(s.getid() == id){
				return s;
			}
		}
		return null;
	}
	public ArrayList<Student> searchByName(String name){
		ArrayList<Student> result = new ArrayList<Student>() ;
		for (Student s: studentlist){
			if(s.get_firstname() == name || s.get_lastname() == name){
				result.add(s);
			}
		}
		return result;
	}
	
	public void addCourse(String course, Student s){
		
		s.addcourse(course);
	}
	public void removeCourse(String course, Student s){
		s.removecourse(course);
	}
	public void updateGrade(Student s, String course, String g){
		s.addcourse(course,g);
	}
	
	public Iterator<Student> getIterator(){
		//return new StudentRecordManager();
		position = 0;
		return this;
	}

	@Override
	public boolean hasNext(){
		if (position < studentlist.size())
			return true;
		return false;
	}
	
	@Override
	public Student next() {
		Student student = studentlist.get(position);
		position++;
		return student;
	}
	
	
	public void refreshIterator(){
		position = 0;
	}
	
	
		
	
	
}
