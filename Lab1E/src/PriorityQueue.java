import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable> implements Iterator<T> {

	private ArrayList<T> queue;
	
	private int position;
	
	public PriorityQueue(){
		this.queue = new ArrayList<T>();
		position = 0;
	}
	
	@SuppressWarnings("unchecked")
	public void Add(T item){
		if (queue.isEmpty()){
			queue.add(item);
			return;
		} else {
			int index = 0;
			while(index < queue.size()){
				if(item.compareTo(queue.get(index)) <= 0){
					queue.add(index,item);
					return;
				}
				index++;
			}
		}
		queue.add(item);
	}
	
	public Iterator<T> getIterator(){
		position = 0;
		return this;
	}
	
	public T Remove(){
		if(queue.isEmpty()){
			return null;
		} 
		
		return queue.remove(0);
	}

	@Override
	public boolean hasNext() {
		if (position < queue.size())
			return true;
		return false;
	}

	@Override
	public T next() {
		T item = queue.get(position);
		position++;
		return item;
	}
	
}
