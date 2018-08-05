import java.util.ArrayList;
public class MinHeap<T extends Comparable<T>> {

	private ArrayList<T> list;

	public MinHeap(){
		list = new ArrayList();
	}

	public MinHeap(T element){
		list = new ArrayList();
		list.add(element);
	}

	public void insert(T value){
		
		this.list.add(value);
		//when the arraylist contains more than one element,call minFromBottom method from last index
		if(this.list.size() >1){
			minFromBottom(this.list.size()-1);
		}		
	}

	public T remove(){
		T temp = null;
		if(!this.list.isEmpty()){
			//swaps the first and last element in list, so that the least element lies on the last index
			swap(this.list.size()-1, 0);
			//removes the element from last index 
			temp = this.list.remove(this.list.size() -1);
			// calls minFromTop method with first index 
			minFromTop(0);
		}
		//returns the removed element
		return temp;
	}

	public boolean isEmpty(){
		return this.list.isEmpty();
	}

	public String toString(){
		String returnValue = "";
		for(T temp: this.list){
			returnValue += temp.toString() + " ";
		}
		return returnValue.trim();
	}

	//makes sure the the least value is at bottom
	public void minFromBottom(int index){
		int parentIndex = this.searchParentIndex(index);
		if(parentIndex >= 0){	
			if(this.list.get(index).compareTo(this.list.get(parentIndex)) < 0){
				swap(index, parentIndex);
				minFromBottom(parentIndex);
			}
		}
	}
	
	//makes sure the least value is at bottom
	public void minFromTop(int index){
		int leftIndex = this.searchLeftChildIndex(index);
		int rightIndex = this.searchRightChildIndex(index);
		if(leftIndex < this.list.size()){
			if(this.list.get(index).compareTo(this.list.get(leftIndex)) > 0){
				swap(index, leftIndex);
				minFromTop(leftIndex);
			}
			if(rightIndex < this.list.size()){
				if(this.list.get(index).compareTo(this.list.get(rightIndex)) >0){
					swap(index, rightIndex);
					minFromTop(rightIndex);
				}
			}
		}
	}


	public void swap(int index1, int index2){
		T temp = this.list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}

	// returns the parent index of the given index
	public int searchParentIndex(int index){
		return (index-1)/2;
	}

	//returns the left child index of the given index
	public int searchLeftChildIndex(int index){
		return index*2 +1;
	}

	//returns the right child index of the given index
	public int searchRightChildIndex(int index){
		return index*2 +2;
	}

	
}
