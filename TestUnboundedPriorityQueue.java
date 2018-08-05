import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;


public class TestUnboundedPriorityQueue extends TestCase{
	private UnboundedPriorityQueue<Integer> queue1;
	private UnboundedPriorityQueue<String> queue2;

	public void setUp(){
	queue1 = new UnboundedPriorityQueue<Integer>(); 
	queue2 = new UnboundedPriorityQueue<String>();
	}

	public void testEnqueue(){
		queue1.enqueue(5);
		queue1.enqueue(6);
		queue1.enqueue(23);
		queue1.enqueue(22);
		queue1.enqueue(67);
		queue1.enqueue(96);

		assertTrue(queue1.toString().equals("5 6 23 22 67 96"));

		queue2.enqueue("E");
		queue2.enqueue("G");
		queue2.enqueue("B");
		queue2.enqueue("T");
		queue2.enqueue("A");
		queue2.enqueue("K");

		assertTrue(queue2.toString().equals("E G B T A K"));
	} 

	public void testDequeue(){
		queue1.enqueue(5);
		queue1.enqueue(6);
		queue1.enqueue(23);
		queue1.enqueue(22);
		queue1.enqueue(67);
		queue1.enqueue(96);
		
		assertTrue(queue1.dequeue() == 5);
		assertTrue(queue1.toString().equals("6 23 22 67 96"));
		assertTrue(queue1.dequeue() == 6);
		assertTrue(queue1.toString().equals("23 22 67 96"));
		assertTrue(queue1.dequeue() == 23);
		assertTrue(queue1.toString().equals("22 67 96"));
		assertTrue(queue1.dequeue() == 22);
		assertTrue(queue1.toString().equals("67 96"));
		assertTrue(queue1.dequeue() == 67);
		assertTrue(queue1.toString().equals("96"));
		assertTrue(queue1.dequeue() == 96);
		
		queue2.enqueue("X");
		queue2.enqueue("A");
		queue2.enqueue("R");
		assertTrue(queue2.toString().equals("X A R"));
		assertTrue(queue2.dequeue().equals("X"));
		assertTrue(queue2.toString().equals("A R"));
		assertTrue(queue2.dequeue().equals("A"));
		assertTrue(queue2.toString().equals("R"));
		assertTrue(queue2.dequeue().equals("R"));
	
	}
	
	public void testIsEmpty(){
		assertTrue(queue1.isEmpty());
		queue1.enqueue(3);
		assertFalse(queue1.isEmpty());

		assertFalse(queue2.isEmpty());
		queue2.dequeue();
		assertTrue(queue2.isEmpty());
		
	}

}

