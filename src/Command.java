import java.util.ArrayList;
import java.util.Scanner;

public class Command {												// this class hold and read command.txt's elements
	private String letter;
	private String command;
	private int number;
	
	public Command(String letter, String command) {						//constructor1
		super();
		this.letter = letter;
		this.command = command;
	}

	public Command(String letter, String command, int number) {			//constructor2
		super();
		this.letter = letter;
		this.command = command;
		this.number = number;
	}

	public int getNumber() {											//getter & setter function
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public static void readCommand(Scanner path, ArrayList<Command> array) {			//read command.txt
		while(path.hasNextLine()==true) {
			String l1 = path.nextLine();
			String[] arr=l1.split(" ",2);
			if(arr[1].contains(" ")) {
				String[] arr1 = arr[1].split(" ");
				array.add(new Command(arr[0],arr1[0],Integer.parseInt(arr1[1])));
			}
			else {
				array.add(new Command(arr[0],arr[1]));
			}
		}
	}
}
