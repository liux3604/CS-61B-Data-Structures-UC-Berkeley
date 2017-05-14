public class LinkedListDeque<genericType>{

	//functions to write: 
	//printDeque(), isEmpty(),size()
	//addLast(item), addFirst(item): take constant time
	//removeFirst(), removeLast(): take constant time 
	//getRecursive(int index): use recursive
	//get(int i): use interation



	//constructors to have:
	//public LinkedListDeque(): Creates an empty linked list deque.
	//
	private class intNode{
		public intNode prev;
		public intNode next;
		public genericType item;
	}

	intNode sentinel;
	int size;	


	public LinkedListDeque(){
		sentinel=new intNode();
		size=0;
		sentinel.next=sentinel;
		sentinel.prev=sentinel;
	}


	public boolean isEmpty(){
		if(sentinel.next==sentinel){
			return true;
		}else{
			return false;
		}
	}

	public int size(){
		return size;
	}

	public void addFirst(genericType newValue){
		intNode newNode=new intNode();
		newNode.item=newValue;
		newNode.next=sentinel.next;
		newNode.prev=sentinel;
		sentinel.next=newNode;
		newNode.next.prev=newNode;
		size++;
	}

	public void addLast(genericType newValue){
		intNode newNode=new intNode();
		newNode.item=newValue;
		newNode.prev=sentinel.prev;
		newNode.next=sentinel;
		sentinel.prev.next=newNode;
		sentinel.prev=newNode;
		size++;

	}

	public  void printDeque(){
		intNode intermediateNode=sentinel;
		for(int k=size;k>0;k--){
			intermediateNode=intermediateNode.next;
			System.out.print(intermediateNode.item + " ");
		}
	}

	public void removeLast(){
		sentinel.prev.prev.next=sentinel;
		sentinel.prev=sentinel.prev.prev;
		size--;
		if(size<=0){
			size=0;
		}
	}

	public void removeFirst(){
		sentinel.next=sentinel.next.next;
		sentinel.next.prev=sentinel;
		size--;

		if(size<=0){
			size=0;
		}	
	}

	//getRecursive(int index): use recursive
	
	//get(int i): use interation
	public genericType get(int i){
		intNode intermediateNode=sentinel;
		for(int k=1;k<=i;k++){
			intermediateNode=intermediateNode.next;
		}
		return intermediateNode.item;
	}

	//getRecursive(int index): use recursive
	private  genericType getRecursiveHelper(intNode tempNode, int index){
		if(index==0){
			return tempNode.item;
		}

		return getRecursiveHelper(tempNode.next, --index);

	}
	
	//getRecursive(int index): use recursive
	public genericType getRecursive(int index){
		return getRecursiveHelper(sentinel,index);

	}



}