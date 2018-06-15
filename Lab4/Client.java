package lab4;

public class Client {
	
	
	PrintCenter center = new PrintCenter(); 
	private int printOrder[]; 
	
	public Client(int a4, int a3, int a2) { 
		printOrder = new int[3];
		printOrder[0] = a4;
		printOrder[1] = a3;
		printOrder[2] = a2;
		
	}
	
	public void printing() { 
		center.executeOrder(printOrder);  
	}
	
}
