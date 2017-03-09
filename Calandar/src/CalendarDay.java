
public class CalendarDay implements Comparable<CalendarDay>  {
	private int month, day, year;
	
	public CalendarDay(){
		month = 1; 
		day = 1; 
		year = 1000;
	}
	
	
	public CalendarDay(int month, int day, int year) throws MonthException, DayException, YearException {
		this.setmonth(month);
		this.setday(day);
		this.setyear(year);
	}
	
	public CalendarDay (String s) throws MonthException, DayException, YearException {
		String parts[] = s.split("/");
		
		
		int month = Integer.parseInt(parts[0]);
		int day = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		
		this.setmonth(month);
		this.setday(day);
		this.setyear(year);
		 
	}
	
	public CalendarDay (CalendarDay obj) {
		this.day = obj.getday();
		this.month = obj.getmonth();
		this.year = obj.getyear();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getmonth() + "/" + this.getday() + "/" + this.getyear());
		return sb.toString();
	}
	public void setyear(int y) throws YearException {
		if (y<1000||y>3000) {
			throw new YearException();
		}
		this.year = y;
	}
	public void setmonth(int m) throws MonthException {
		if (m>12||m<1) {
			throw new MonthException();
		}
		this.month = m;
	}
	public void setday(int d) throws DayException{
		if (d<1 || d>31) throw new DayException();
		else if ((this.month==9 || this.month==4 || this.month==6 || this.month ==11)
				&& d==31) {
			throw new DayException();
		}
		
		else if (this.month==2) {
			if (d > 29) throw new DayException();
			else if (!isLeapyr(this.year) && d == 29)
				throw new DayException();
		}
		this.day = d;
		
	}
	
	public int getday() {
		return this.day;
	}
	
	public int getmonth() {
		return this.month;
	}
	public int getyear(){
		return this.year;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (this == obj) return true;
		else if (this.getday() != ((CalendarDay) obj).getday()) return false;
		else if (this.getmonth() != ((CalendarDay) obj).getmonth()) return false;
		else if (this.getyear() != ((CalendarDay) obj).getyear()) return false;
		return true;
		
	}
	
	public static boolean isLeapyr(int y) {
		if (y%4 != 0) return false;
		else if (y%100 != 0) return true;
		else if (y%400 != 0) return false;
		return true;
	}

	@Override
	public int compareTo(CalendarDay o) {
		if (this == o) return 0;
		else if (this.year > o.year) return 1;
		else if (this.year < o.year) return -1;
		
		else if (this.month > o.month) return 1;
		else if (this.month < o.month) return -1;
		
		else if (this.day > o.day) return 1;
		else if (this.day < o.day) return -1;
		return 0;
	}

	
}
