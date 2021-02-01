import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
	static final int MAX = 100; 
    
	public static void work(String argument) throws FileNotFoundException { //this class run command of command.txt
		ArrayList<Stack> arrayStack = new ArrayList<>();
		ArrayList<Queue> arrayQueue = new ArrayList<>();
		ArrayList<Command> arrayCommand = new ArrayList<>();	//Arrays
		
		File f = new File("stack.txt");							//read stack.txt
		Scanner stacktxt = new Scanner(f);
		Stack.readStack(stacktxt,arrayStack);
		
		File g = new File("queue.txt");							//read stack.txt
		Scanner queuetxt = new Scanner(g);
		Queue.readQueue(queuetxt,arrayQueue);
		
		File h = new File(argument);							//read stack.txt
		Scanner commandtxt = new Scanner(h);
		Command.readCommand(commandtxt,arrayCommand);
		
		PrintStream stackOutTxt = new PrintStream("stackOut.txt");	
		PrintStream queueOutTxt = new PrintStream("queueOut.txt");
		PrintStream stackTxt = new PrintStream(f);
		PrintStream queueTxt = new PrintStream(g);
		
		Stack.addArraytoStack(arrayStack);						//add stacktxt's elements stack from array
		Stack.how();

		Queue.addArraytoQueue(arrayQueue);						//add queuetxt's elements queue from array
		Queue.how();
		
		for(Command emk:arrayCommand) {
			
			if(emk.getLetter().equals("S")) {					// run functions of Stack class
				System.setOut(stackOutTxt);
				if(emk.getCommand().equals("removeGreater")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Stack.removeGreater(emk.getNumber());
					Stack.print();
				}
				
				else if(emk.getCommand().equals("calculateDistance")) {
					System.out.println("After "+emk.getCommand()+":");
					System.out.println("Total distance="+Stack.calculateDistance());
				}
				
				else if(emk.getCommand().equals("addOrRemove")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Stack.change();
					Stack.addOrRemove(emk.getNumber());
					Stack.print();
				}
				
				else if(emk.getCommand().equals("reverse")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Stack.reverse(emk.getNumber());
					Stack.print();
				}
				
				else if(emk.getCommand().equals("sortElements")) {
					System.out.println("After "+emk.getCommand()+":");
					Stack.sortElements();
					Stack.print();
				}
				
				else if(emk.getCommand().equals("distinctElements")) {
					System.out.println("After "+emk.getCommand()+":");
					System.out.println("Total distinct element="+Stack.distinctElements());
				}
			}
			
			else if(emk.getLetter().equals("Q")) {					// run functions of Queue class
				System.setOut(queueOutTxt);
				if(emk.getCommand().equals("removeGreater")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Queue.removeGreater(emk.getNumber());
					Queue.print();
				}
				
				else if(emk.getCommand().equals("calculateDistance")) {
					System.out.println("After "+emk.getCommand()+":");
					System.out.println("Total distance="+Queue.calculateDistance());
				}
				
				else if(emk.getCommand().equals("addOrRemove")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Queue.addOrRemove(emk.getNumber());
					Queue.print();
				}
				
				else if(emk.getCommand().equals("reverse")) {
					System.out.println("After "+emk.getCommand()+" "+emk.getNumber()+":");
					Queue.reverse(emk.getNumber());
					Queue.print();
				}
				
				else if(emk.getCommand().equals("sortElements")) {
					System.out.println("After "+emk.getCommand()+":");
					Queue.sortElements();
					Queue.print();
				}
				
				else if(emk.getCommand().equals("distinctElements")) {
					System.out.println("After "+emk.getCommand()+":");
					System.out.println("Total distinct element="+Queue.distinctElements());
				}
			}
		}
					
		System.setOut(stackTxt);				//print updated stack.txt
		Stack.change();
		Stack.print();
		
		System.setOut(queueTxt);				//print updated queue.txt
		Queue.change();
		Queue.print();
		
	}
}
