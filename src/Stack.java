import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Stack {
	private int number;
	
    static final int MAX = 100; 						//stack's size
    static int top=-1;									//top variables
    static int top2=-1;
    static int top3=-1;
    static int top4=-1;
    static int stack[] = new int[MAX];					//integer stacks
    static int stack2[] = new int[MAX];
    static int stack3[] = new int[MAX];
    static int stack4[] = new int[MAX];
    
	public Stack(int number) {							//constructor for read stack.txt
		super();
		this.number = number;
	}

	public int getNumber() {							//getter & setter for read stack.txt
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
    public static boolean isEmpty(){					//isEmpty() function
    	if(top==-1) {
    		return true;
    	}
		return false;
    }
    
    public static boolean isFull() {					//isFull() function
    	if(top==99) {
    		return true;
    	}
		return false;
    }
	
	public static void push(int x) {					//push function
    	if(isFull()==true) {
    		System.out.println("Stack contains a maximum of 100 elements");
    	}
    	else {
    		++top;
    		stack[top]=x;
    	}
    }
	
	public static void pushStack2(int x) {				//push function of stack2
    	++top2;
    	stack2[top2]=x;
    }
	
	public static void pushStack3(int x) {				//push function of stack3
    	++top3;
    	stack3[top3]=x;
    }
	
	public static void pushStack4(int x) {				//push function of stack4
    	++top4;
    	stack4[top4]=x;
    }
	
	public static void pushRandom() {					//push random number for addOrRemove function
    	Random rand = new Random();
    	int number = rand.nextInt(50);
    	++top;
    	stack[top]=number;
    }
	
    public static int pop() {							//pop function
    	if(isEmpty()==true) {
    		System.out.println("Stack is Empty1");
    	}
    	else {
    		int x=stack[top];
    		stack[top]=x;
        	top--;
        	return x;
    	}
		return top;
    }
    
    public static int pop2() {							//pop function of stack2
    	int x=stack2[top2];
    	stack2[top2]=x;
        top2--;
        return x;
    }
    
    public static int pop3() {							//pop function of stack3
    	int x=stack3[top3];
    	stack3[top3]=x;
        top3--;
        return x;
    }
    
    public static int pop4() {							//pop function of stack4
    	int x=stack4[top4];
    	stack4[top4]=x;
        top4--;
        return x;
    }
    
    public static int calculateDistance() {				//calculate distance of stack
														//just used push & pop
		int temp=0;
		int temp2=top2;
		int total=0;
		for(int i=0;i<=temp2;i++) {
			temp=pop2();
			push(temp);
			pushStack3(temp);
		}
		int temp1=top;
		for(int i=0;i<=temp1;i++) {
			int temp5=pop();
			pushStack2(temp5);
			int temp3=top3;
			for(int j=0;j<=temp3;j++) {
				int temp6=pop3();
				total+=Math.abs(temp5-temp6);
			}
			int temp7=top;
			for(int j=0;j<=temp7;j++) {
				int temp8=pop();
				pushStack2(temp8);
				pushStack3(temp8);
			}
			int temp9=top3;
			for(int j=0;j<=temp9;j++) {
				push(pop2());
			}
		}
		return total;
	}
    
	public static void removeGreater(int k) {			//remove greater than k
		int temp2=top2;									//just used push & pop
		for(int j=0;j<=temp2;j++) {
			pushStack3(pop2());
		}
		int temp3=top3;
		for(int j=0;j<=temp3;j++) {
			if(stack3[temp3-j]<=k) {
				push(pop3());
			}
			else {
				pop3();
			}
		}
	}
	
	public static void addOrRemove(int k) {				//add or remove number
		if(k==Math.abs(k)) {							//just used push & pop
			for(int i=0;i<k;i++) {
				pushRandom();
			}
		}
		else {
			for(int i=0;i<Math.abs(k);i++) {
				pop();
			}
		}
	}
	
	public static void reverse(int k) {					// reverse first k number
		int temp2=top2;									//just used push & pop
		int tempk=k;
		for(int i=0;i<=temp2;i++) {
			pushStack3(pop2());
		}
		
		int temp3=top3;
		for(;tempk<=temp3;tempk++) {
			push(pop3());
		}
		
		temp3=top3;
		for(int i=0;i<=temp3;i++) {
			pushStack2(pop3());
		}
		
		temp2=top2;
		for(int i=0;i<=temp2;i++) {
			push(pop2());
		}
	}
	
	public static void sortElements() {					//sort stack
		int temp2=top2;									//used push & pop & Arrays.sort
		Arrays.sort(stack2,0,temp2+1);
		for(int i=0;i<=temp2;i++) {
			push(pop2());
		}
	}
	
	
	public static int distinctElements() {				//find how many distinct elements
		int temp2=top2;									//just used push & pop
		for(int i=0;i<=temp2;i++) {
			int temp8=pop2();
			push(temp8);
			pushStack3(temp8);
		}
		int temp=top;
		int total=0;
		for(int i=0;i<=temp;i++) {
			int counter=0;
			int temp8=pop();
			pushStack2(temp8);
			int temp3=top3;
			for(int j=0;j<=temp3;j++) {
				int temp99=pop3();
				if(temp8==temp99) {
					counter++;
					pushStack4(temp99);
				}
				else {
					pushStack4(temp99);
				}
			}
			if(counter>=1) {
				total++;
			}
			int temp9=top4;
			for(int j=0;j<=temp9;j++) {
				int temp88=pop4();
				if(temp8==temp88) {
					continue;
				}
				else {
					pushStack3(temp88);
				}
			}
		}
		return total;
		
	}
	
	
	public static void addArraytoStack(ArrayList<Stack> arrayStack) {		//add array to stack
		for(Stack emk:arrayStack) {											//just used push & pop
			pushStack2(emk.getNumber());
		}
		int temp2=top2;
		for(int i=0;i<=temp2;i++) {
			push(pop2());
		}
	}
	public static void change() {											//push elements to stack from stack2
		int temp2=top2;														//just used push & pop
		for(int j=0;j<=temp2;j++) {
			pushStack3(pop2());
		}
		int temp3=top3;
		for(int j=0;j<=temp3;j++) {
			push(pop3());
		}
	}
	
	public static void how() {												//push elements to stack2 from stack
		int temp=top;														//just used push & pop
		for(int j=0;j<=temp;j++) {
			pushStack3(pop());
		}
		int temp3=top3;
		for(int j=0;j<=temp3;j++) {
			pushStack2(pop3());
		}
	}
	
	public static void print() {											//print stack
		int temp=top;														//just used push & pop
		int temp2=0;
		for(int j=0;j<=temp;j++) {
			temp2=pop();
			pushStack3(temp2);
			System.out.print(temp2+" ");
		}
		int temp3=top3;
		for(int j=0;j<=temp3;j++) {
			pushStack2(pop3());
		}
		System.out.println();
	}
	
	
	public static void readStack(Scanner path, ArrayList<Stack> array) {	//read stack.txt
		while(path.hasNextLine()==true) {
			String l1 = path.nextLine();
			String[] arr=l1.split(" ");
				for(int i=0;i<arr.length;i++) {
					array.add(new Stack(Integer.parseInt(arr[i])));
				}
		}
	}
}
