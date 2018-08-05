import org.junit.Assert;
import junit.framework.TestCase;

public class TestMinHeap extends TestCase{
	private MinHeap<Integer> heap1;
	private MinHeap<Integer> heap2;

	public void setUp(){
		heap1 = new MinHeap<Integer>();
		heap2 = new MinHeap<Integer>(34);
	}
	
	public void testInsert(){
		heap1.insert(5);
		heap1.insert(3);
		heap1.insert(4);
		heap1.insert(8);
		heap1.insert(21);
		heap1.insert(34);
		heap1.insert(64);

		assertTrue(heap1.toString().equals("5 3 4 8 21 34 64"));

		heap2.insert(18);
		heap2.insert(23);
		heap2.insert(56);
		heap2.insert(23);
		heap2.insert(65);
		heap2.insert(43);
		heap2.insert(73);
		heap2.insert(45);
		heap2.insert(76);
		heap2.insert(71);
		heap2.insert(34);

		assertTrue(heap2.toString().equals("18 23 56 23 65 43 73 45 76 71 34"));
	}

	
	public void testRemove(){
		heap1.insert(34);
		heap1.insert(12);
		heap1.insert(45);
		heap1.insert(54);
		heap1.insert(76);
		heap1.insert(55);
		heap1.insert(13);

		assertTrue(heap1.remove() == 12);
		assertTrue(heap1.toString().equals("13 34 45 54 55 76"));
		assertTrue(heap1.remove() == 13);
		assertTrue(heap1.toString().equals("34 45 54 55 76"));
		assertTrue(heap1.remove() == 34);
		assertTrue(heap1.toString().equals("45 54 55 76"));

	
		heap2.insert(18);
		heap2.insert(34);
		heap2.insert(36);
		heap2.insert(54);
		heap2.insert(21);
		heap2.insert(74);
		heap2.insert(3);
		heap2.insert(6);

		assertTrue(heap2.remove() == 3);
		assertTrue(heap2.toString().equals("18 48 38 87 62 56 50"));
		assertTrue(heap2.remove() == 6);
		assertTrue(heap2.toString().equals("38 50 48 87 62 56"));
		assertTrue(heap2.remove() == 18);
		assertTrue(heap2.toString().equals("48 56 50 87 62"));
		assertTrue(heap2.remove() == 21);
		assertTrue(heap2.toString().equals("50 62 56 87"));
		assertTrue(heap2.remove() == 34);
		assertTrue(heap2.toString().equals("56 87 62"));
		assertTrue(heap2.remove() == 36);
		assertTrue(heap2.toString().equals("62 87"));
		assertTrue(heap2.remove() == 54);
		assertTrue(heap2.toString().equals("87"));
		assertTrue(heap2.remove() == 74);

	}


	public void testIsEmpty(){
		assertTrue(heap1.isEmpty());
		assertFalse(heap2.isEmpty());
		heap1.insert(2);
		assertFalse(heap1.isEmpty());
		heap2.remove();
		assertTrue(heap2.isEmpty());
	}

}
