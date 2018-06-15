package lab4;


public class PrintCenter extends Thread{
	
	
	class FirstPrinterThread extends Thread
	{
		private int num;
		
		FirstPrinterThread(int num)
		{
			this.num = num;
		}
		
		public void run()	
		{
			int i = 0;
			System.out.println("kek");
			while(true) {
			
				try{
					Thread.sleep(1000);		
					
				}catch(InterruptedException e){}
			
			
				System.out.println("The first printer printed a sheet A4!");
				i++;
				if (i>=num)
					break;
				System.out.println("The first printer printed a sheet A4!");
				i++;
				if (i>=num)
					break;
				System.out.println("The first printer printed a sheet A4!");
				i++;
				if (i>=num)
					break;
				
			}
		
		}
	}

	class SecondPrinterThread extends Thread
	{
		private int num;
		
		SecondPrinterThread(int num)
		{
			this.num = num;
		}
		
		public void run()	
		{
			int i = 0;
			while(true) {
			
				try{
					Thread.sleep(2000);		
					
				}catch(InterruptedException e){}
			
			
				System.out.println("The second printer printed a sheet A3!");
				i++;
				if (i>=num)
					break;
				System.out.println("The second printer printed a sheet A3!");
				i++;
				if (i>=num)
					break;

			}
		
		}
	}
	
	class ThirdPrinterThread extends Thread
	{
		private int num;
		
		ThirdPrinterThread(int num)
		{
			this.num = num;
		}
		
		public void run()	
		{
			int i = 0;
			while(true) {
			
				try{
					Thread.sleep(3000);		
					
				}catch(InterruptedException e){}
			
			
				System.out.println("The third printer printed a sheet A2!");
				i++;
				if (i>=num)
					break;
			}
		
		}
	}
	
	static FirstPrinterThread Print1;
	static SecondPrinterThread Print2;
	static ThirdPrinterThread Print3;

	
	public void executeOrder(int printOrder[]) {  
		
		System.out.println("The center is starting to print..\n\n\n");	
	
			 	
			Print1 = new FirstPrinterThread(printOrder[0]);
			Print2 = new SecondPrinterThread(printOrder[1]);
			Print3 = new ThirdPrinterThread(printOrder[2]);
			
			
			Print1.start();
			Print2.start();
			Print3.start();
			
		
		while(Print1.isAlive() || Print2.isAlive() || Print3.isAlive()) { 
			
		}
		
		System.out.println("\n\n\nThe center ended printing!");	

	}
}
