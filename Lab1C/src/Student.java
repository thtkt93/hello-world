import java.util.ArrayList;
import java.util.Iterator;

public class Student implements Iterator{
	private String first_name;
	private String last_name;
	private int id;
	private String Email;
	
	int pos;
	
	ArrayList<Course> courses;
	
	
	public Student(String first_name, String last_name, String mail, StudentRecordManager m){
		this.first_name = first_name;
		this.last_name = last_name;
		this.Email = mail;
		courses = new ArrayList<Course>();
		m.addStudent(this);
		
	}
	
	public Student(Student s){
		this.first_name = s.get_firstname();
		this.last_name = s.get_lastname();
		this.id = s.getid();
		this.Email = s.getmail();
		courses = new ArrayList<Course>();
	}
	
	
	public void addcourse(String desc, String grade) {
		for (Course c: courses) {
			if (c.course_name == desc){
				c.changeGrade(grade);
				return;
			}
		}
		courses.add(new Course(desc,grade));
	}
	
	public void addcourse(String desc) {
		for (Course c: courses) {
			if (c.course_name == desc){
				return;
			}
		}
		this.addcourse(desc,"N/A");
	}
	public void removecourse(String desc) {
		for (Course c: courses){
			if (c.course_name == desc) {
				courses.remove(c);
				return;
			}
		}
	}
	public void updateGrade(String desc, String g){
		this.addcourse(desc, g);
	}
	
	

	public int getid() {
		return id;
	}
	
	public void setid(int id){
		this.id = id;
	}
	public String get_lastname(){
		return last_name;
	}
	public String get_firstname(){
		return first_name;
	}
	public String getmail(){
		return Email;
	}
	public Iterator getIterator(){
		pos = 0;
		return this;
	}
	public void printInfo(){
		
		System.out.println("Name:" + this.get_firstname() + " " + this.get_lastname()
		+ " StudentID:" + this.getid() + " Email:" + this.getmail());
		this.printclass();
	}
	
	public void printclass(){
		for(Course c: this.courses){
			System.out.println(c.course_name + ": " + c.grade);
		}
	}
	
	public class Course{
		private String course_name;
		private String grade;
		
		
		public Course(String course, String grade) {
			this.course_name = course;
			this.grade = grade;
		}
		public Course(String course) {
			this.course_name = course;
			this.grade = "N/A";
		}
		
		public Course(Course c){
			this.grade = c.getgrade();
			this.course_name = c.getCourse();
		}
		public String getCourse(){
			return course_name;
		}
		public String getgrade(){
			return grade;
		}
		
		public void changeGrade(String g) {
			this.grade = g;
		}
	}

	@Override
	public boolean hasNext() {
		if (pos < courses.size())
			return true;
		return false;
		
	}

	@Override
	public Course next() {
		Course course = courses.get(pos);
		pos++;
		return course;
	}
		
}
	
