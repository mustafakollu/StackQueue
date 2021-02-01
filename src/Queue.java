import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Queue {
	private int number;

	public Queue(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	static final int MAX = 100; 						//queue's size
    static int rear=-1;									//rear variables
    static int rear2=-1;
    static int rear3=-1;
    static int rear4=-1;
    static int front=0;									//front variables
    static int front2=0;
    static int front3=0;
    static int front4=0;
    static int queue[] = new int[MAX];					//integer stacks
    static int queue2[] = new int[MAX];
    static int queue3[] = new int[MAX];
    static int queue4[] = new int[MAX];
	
    public static boolean isEmpty(){					//isEmpty() function
    	if(rear==-1) {
    		return true;
    	}
		return false;
    }
    
    public static boolean isFull() {					//isFull() function
    	if(rear==99) {
    		return true;
    	}
		return false;
    }
    
    public static void enqueue(int x) {					//enqueue function
    	if(isFull()==true) {
    		System.out.println("Queue contains a maximum of 100 elements");
    	}
    	else {
    		++rear;
    		queue[rear]=x;
    	}
    }
    
    public static void enqueue2(int x) {				//enqueue function of queue2
    	++rear2;
    	queue2[rear2]=x;
    }
	
	public static void enqueue3(int x) {				//enqueue function of queue3
    	++rear3;
    	queue3[rear3]=x;
    }
	
	public static void enqueue4(int x) {				//enqueue function of queue4
    	++rear4;
    	queue4[rear4]=x;
    }
	
	public static void enqueueRandom() {				//enqueue random number for addOrRemove function
    	Random rand = new Random();
    	int number = rand.nextInt(50);
    	++rear2;
    	queue2[rear2]=number;
    }
	
    public static int dequeue() {						//dequeue function
    	if(isEmpty()==true) {
    		System.out.println("Queue is Empty");
    	}
    	else {
    		int x=queue[front];
    		queue[front]=x;
        	front++;
        	return x;
    	}
		return front;
    }
    
    public static int dequeue2() {						//dequeue function of queue2
    	int x=queue2[front2];
    	queue2[front2]=x;
    	front2++;
        return x;
    }
    
    public static int dequeue3() {						//dequeue function of queue3
    	int x=queue3[front3];
    	queue3[front3]=x;
    	front3++;
        return x;
    }
    
    public static int dequeue4() {						//dequeue function of queue4
    	int x=queue4[front4];
    	queue4[front4]=x;
    	front4++;
        return x;
    }
	
    public static void addArraytoQueue(ArrayList<Queue> arrayQueue) {			//add Array to queue
		for(Queue emk:arrayQueue) {												//just used enqueue & dequeue
			enqueue2(emk.getNumber());
		}
		int temp2=rear2;
		int temp4=front2;
		for(;temp4<=temp2;temp4++) {
			enqueue(dequeue2());
		}
		rear2=-1;
		front2=0;
	}
    
    public static void change() {						// enqueue elements to queue from queue2
		int temp2=rear2;								//just used enqueue & dequeue
		int temp4=front2;
		for(;temp4<=temp2;temp4++) {
			enqueue3(dequeue2());
		}
		rear2=-1;
		front2=0;
		int temp3=rear3;
		int temp6=front3;
		for(;temp6<=temp3;temp6++) {
			enqueue(dequeue3());
		}
		rear3=-1;
		front3=0;
	}
    
    public static void how() {							// enqueue elements to queue2 from queue
		int temp=rear;									//just used enqueue & dequeue
		int temp1=front;
		for(;temp1<=temp;temp1++) {
			enqueue3(dequeue());
		}
		rear=-1;
		front=0;
		int temp3=rear3;
		int temp6=front3;
		for(;temp6<=temp3;temp6++) {
			enqueue2(dequeue3());
		}
		rear3=-1;
		front3=0;
	}
    
    public static void print() {						//print queue
		int temp=rear;									//just used enqueue & dequeue
		int temp1=front;
		int temp2=0;
		for(;temp1<=temp;temp1++) {
			temp2=dequeue();
			enqueue3(temp2);
			System.out.print(temp2+" ");
		}
		rear=-1;
		front=0;
		int temp3=rear3;
		int temp6=front3;
		for(;temp6<=temp3;temp6++) {
			enqueue2(dequeue3());
		}
		rear3=-1;
		front3=0;
		System.out.println();
	}
	
	public static void removeGreater(int k) {			//remove greater than k
		int temp2=rear2;								//just used enqueue & dequeue
		int temp4=front2;
		for(;temp4<=temp2;temp4++) {
			if(queue2[front2]<=k) {
				enqueue(dequeue2());
			}
			else {
				dequeue2();
			}
		}
		rear2=-1;
		front2=0;
	}
	
	public static int calculateDistance() {				//calculate distance of queue
		int temp11=0;									//just used enqueue & dequeue
		int temp2=rear2;
		int temp4=front2;
		int total=0;
		for(;temp4<=temp2;temp4++) {
			temp11=dequeue2();
			enqueue(temp11);
			enqueue3(temp11);
		}
		rear2=-1;
		front2=0;
		int temp=rear;
		int temp1=front;
		for(;temp1<=temp;temp1++) {
			int temp5=dequeue();
			enqueue4(temp5);
			int temp3=rear3;
			int temp6=front3;
			for(;temp6<=temp3;temp6++) {
				int temp22=dequeue3();
				total+=Math.abs(temp5-temp22);
			}
			rear3=-1;
			front3=0;
			int temp7=rear;
			int temp8=front;
			for(;temp8<=temp7;temp8++) {
				int temp22=dequeue();
				enqueue2(temp22);
				enqueue3(temp22);
			}
			rear=-1;
			front=0;
			int temp10=rear2;
			int temp12=front2;
			for(;temp12<=temp10;temp12++) {
				enqueue(dequeue2());
			}
			rear2=-1;
			front2=0;
		}
		rear=-1;
		front=0;
		int temp99=rear4;
		int temp88=front4;
		for(;temp88<=temp99;temp88++) {
			enqueue2(dequeue4());
		}
		rear4=-1;
		front4=0;
		return total;
	}
	
	public static void addOrRemove(int k) {				//add or remove number(s)
		if(k==Math.abs(k)) {							//just used enqueue & dequeue
			for(int i=0;i<k;i++) {
				enqueueRandom();
			}
		}
		else {
			for(int i=0;i<Math.abs(k);i++) {
				dequeue2();
			}
			int temp2=rear2;
			int temp4=front2;
			for(;temp4<=temp2;temp4++) {
				enqueue(dequeue2());
			}
			rear2=-1;
			front2=0;
		}
	}
	
	public static void reverse(int k) {					//reverse first k number of queue
		int temp2=rear2;								//just used enqueue & dequeue
		int temp4=front2;
		for(;temp4<k;temp4++) {
			enqueue(dequeue2());
		}
		int temp=rear;
		int temp1=front;
		for(;temp1<=temp;temp1++) {
			if(temp1<=temp-temp1) {
				int temp9=queue[temp1];
				queue[temp1]=queue[temp-temp1];
				queue[temp-temp1]=temp9;
			}
		}
		temp2=rear2;
		temp4=front2;
		for(;temp4<=temp2;temp4++) {
			enqueue(dequeue2());
		}
		rear2=-1;
		front2=0;
	}
	
	public static void sortElements() {					//sort elements
		int temp2=rear2;								//used enqueue & dequeue & Arrays.sort
		int temp4=front2;
		Arrays.sort(queue2,front2,temp2+1);
		for(;temp4<=temp2;temp4++) {
			int temp90= dequeue2();
			enqueue(temp90);
		}
		rear2=-1;
		front2=0;
	}
	
	public static int distinctElements() {				//find how many distinct numbers
		int temp2=rear2;								//just used enqueue & dequeue
		int temp4=front2;
		for(;temp4<=temp2;temp4++) {
			int temp8=dequeue2();
			enqueue(temp8);
			enqueue3(temp8);
		}
		rear2=-1;
		front2=0;
		int temp=rear;
		int temp1=front;
		int total=0;
		for(;temp1<=temp;temp1++) {
			int counter=0;
			int temp8=dequeue();
			enqueue2(temp8);
			int temp3=rear3;
			int temp6=front3;
			for(;temp6<=temp3;temp6++) {
				int temp99=dequeue3();
				if(temp8==temp99) {
					counter++;
					enqueue4(temp99);
				}
				else {
					enqueue4(temp99);
				}
			}
			rear3=-1;
			front3=0;
			if(counter>=1) {
				total++;
			}
			int temp9=rear4;
			int temp10=front4;
			for(;temp10<=temp9;temp10++) {
				int temp88=dequeue4();
				if(temp8==temp88) {
					continue;
				}
				else {
					enqueue3(temp88);
				}
			}
			rear4=-1;
			front4=0;
		}
		rear=-1;
		front=0;
		return total;
	}
	
	
	
	
	public static void readQueue(Scanner path, ArrayList<Queue> array) {		//read queue.txt
		while(path.hasNextLine()==true) {
			String l1 = path.nextLine();
			String[] arr=l1.split(" ");
				for(int i=0;i<arr.length;i++) {
					array.add(new Queue(Integer.parseInt(arr[i])));
				}
		}
	}
}
