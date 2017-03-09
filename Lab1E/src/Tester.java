
public class Tester {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.Add(4);
		queue.Add(2);
		queue.Add(6);
		queue.Add(7); 
		
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		System.out.println(queue.Remove());
		
		System.out.println("Queue2: ");
		PriorityQueue<Double> queue2 = new PriorityQueue<Double>();
		queue2.Add(4.5);
		queue2.Add(2.7);
		queue2.Add(34.000);
		queue2.Add(6.8);
		queue2.Add(7.9); 
		queue2.Add(7.9);
		
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		System.out.println(queue2.Remove());
		
		
		

	}

}
