public class UnboundedPriorityQueue<T extends Comparable<T>>{

	private MinHeap<T> heap;

	//constructor
	public UnboundedPriorityQueue(){
		heap = new MinHeap<T>();
	}

	//overloaded constructor
	public UnboundedPriorityQueue(T givenValue){
		heap = new MinHeap<T>(givenValue);
	}

	//add the element in priority queue 
	public void enqueue(T givenValue){
		heap.insert(givenValue);
	}


	// remove and return the element from priority queue 
	public T dequeue(){
		return heap.remove();
	}

	public boolean isEmpty(){
		return heap.isEmpty();
	}

	public String toString(){
		return heap.toString();
	}

}
