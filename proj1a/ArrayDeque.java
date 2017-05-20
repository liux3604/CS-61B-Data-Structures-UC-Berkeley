import java.util.Objects;

public class ArrayDeque<genericType>{
	//public void addFirst(Item): Adds an item to the front of the Deque.
	//public void addLast(Item): Adds an item to the back of the Deque.
	//public boolean isEmpty(): Returns true if deque is empty, false otherwise.
	//public int size(): Returns the number of items in the Deque.
	//public void printDeque(): Prints the items in the Deque from first to last, separated by a space.
	//public Item removeFirst(): Removes and returns the item at the front of the Deque. If no such item exists, returns null.
	//public Item removeLast(): Removes and returns the item at the back of the Deque. If no such item exists, returns null.
	//public Item get(int index): Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
	float ratio;
	int size;
	int nextFirst;
	int nextLast;//index of the nextLast, form zero to n-1
	Object[] items; //Java cannot create a generic array, hence you must type cast from Object to genericType

	public ArrayDeque(){
		size=0;
		nextFirst=4;
		nextLast=5;
		items=new Object[8];
	}

	public boolean isEmpty(){
		if(size==0){
			return true;
		}else{
			return false;
		}
	}

	private void resize(){
		Object[] newItems=new Object[2*items.length];

		for (int k=0;k<items.length;k++){
			newItems[k+1]=items[correctIndex(nextFirst+1+k, items.length)];
		}
		nextFirst=0;
		nextLast=items.length+1;
		items=newItems;
	}

	public int size(){
		return size;
	}



	private int correctIndex(int index, int length_of_array){
		int temp=index%(length_of_array);
		if(temp<0){
			temp= temp+length_of_array;
		}
		return temp;
	}


	public void addFirst(genericType value){
		if (size==items.length){
			this.resize();
		}

		items[nextFirst]=value;
		nextFirst--;
		nextFirst=correctIndex(nextFirst, items.length);
		++size;
	}

	public void addLast(genericType value){
		if (size==items.length){
			this.resize();
		}

		items[nextLast]=value;
		nextLast++;
		nextLast=correctIndex(nextLast, items.length);
		++size;
	}



	public void shrink(){
		Object[] tempArray=new Object[items.length/2];

		for(int k=0; k <size; k++){
			tempArray[1+k]=items[correctIndex(nextFirst+1+k, items.length)];
		}
		nextFirst=0;
		nextLast=size+1;
		items=tempArray;

	}

	//public Item removeLast(): Removes and returns the item at the back of the Deque. If no such item exists, returns null.
	public void removeLast(){
		if(!isEmpty()){
			items[correctIndex(nextLast-1,items.length)]=null;
			nextLast=correctIndex(nextLast-1, items.length) ;
			size--;
		}

		//shrink the size of items if the utilization rate is below 25%
		ratio=(float)size/items.length; //An integer divided by another integer, so we have to type cast

		if(ratio<0.25 && items.length>8){
			shrink();
		}
	}

	public void removeFirst(){
		if(!isEmpty()){
			items[correctIndex( nextFirst+1, items.length)]=null;
			nextFirst=correctIndex(nextFirst+1, items.length) ;
			size--;
		}

		//shrink the size of items if the utilization rate is below 25%
		ratio=(float)size/items.length; //An integer divided by another integer, so we have to type cast

		if(ratio<0.25 && items.length>8){
			shrink();
		}
	}



	public void printDeque(){
		for(int k=0;k<size;k++){
			System.out.print(items[correctIndex(nextFirst+k+1, items.length)] + " ");
		}

	}

	public genericType get(int index){
		if(!isEmpty()&& index<=(size-1)){
			return (genericType) items[nextFirst+1+ index];
		}else{
			return null;
		}
	}





}