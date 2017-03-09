
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Tester {
	
	


	public static void main(String[] args)  {
		
		
		CalendarDay[] calendar=  new CalendarDay[50];
		for (int i = 0; i < 50; i++){
			int day = ThreadLocalRandom.current().nextInt(1, 31 + 1);
			int month = ThreadLocalRandom.current().nextInt(1, 12 + 1);
			int year = ThreadLocalRandom.current().nextInt(1000, 3000 + 1);
			
			try {
				CalendarDay date = new CalendarDay(month, day, year);
				calendar[i] = date;
			} catch (MonthException | DayException | YearException e) {
				i=i-1;
			}
			
		}
		
		
		Arrays.sort(calendar);
		for(CalendarDay d: calendar){
			System.out.println(d.toString());
		}
		
		Scanner in = new Scanner(System.in);
		boolean validinput = false;
		
		System.out.println("what is your input for calendar? : ");
		String input = in.nextLine();
		while (validinput == false){
			try {
				
				CalendarDay obj1 = new CalendarDay(input);
				System.out.println("Valid Calendar Obj: "+ obj1.toString() );
				
				validinput = true;
				
				
			} catch (MonthException | DayException | YearException e) {
				System.out.println(e.getClass().getName());
				System.out.println("Invalid Calendar input: "+ input + 
						"\nTry another input: ");
				
				input = in.nextLine();
			}
		}
		
		
		
		
		
	}
	
	
}
