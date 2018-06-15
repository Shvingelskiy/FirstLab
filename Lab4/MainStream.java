package lab4;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;




public class MainStream {
	public static Shell ConfigureShell(Display display) {
		
		//PrintCenter center = new PrintCenter(); // Object of print center 
		
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("PRINT CENTER");
		shell.setSize(360, 250);
		
		shell.setLayout(new GridLayout(2, true));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		
		
		new Label(shell, SWT.LEFT).setText("Printer A4");
		final Text printerA4 = new Text(shell, SWT.BORDER);	
		printerA4.setLayoutData(gridData);

		
		new Label(shell, SWT.LEFT).setText("Printer A3");
		final Text printerA3 = new Text(shell, SWT.BORDER);	
		printerA3.setLayoutData(gridData);
		
			
		new Label(shell, SWT.LEFT).setText("Printer A2");
		final Text printerA2 = new Text(shell, SWT.BORDER);
		printerA2.setLayoutData(gridData);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
	
		Button printButton = new Button(shell, SWT.PUSH);	
		printButton.setText("Print!");
		printButton.setLayoutData(gridData);
		new Label(shell, SWT.NONE);

		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
		Label resultLabel = new Label(shell, SWT.LEFT);
		resultLabel.setText("Number of sheets: ");
		
			
		printButton.addListener(SWT.Selection, new Listener(){  
			
			boolean checkInput = true; 
			
			public void handleEvent(Event event) { 
									
				isParsable(printerA4.getText(),printerA3.getText(),printerA2.getText()); 
	
				
				if (checkInput) { 
					int A4 = Integer.parseInt(printerA4.getText());
					int A3 = Integer.parseInt(printerA3.getText());
					int A2 = Integer.parseInt(printerA2.getText());
						
					
					// Create client 
					Client client = new Client(A4,A3,A2);   
					client.printing();
												
					resultLabel.setText("Number of sheets: \n" + "A4:    " + A4 + "    A3:    " + A3 + "    A2:    " + A2);
					resultLabel.getParent().layout();
				}		
				checkInput = true;
							
			}	
			
			public void isParsable(String strA4, String strA3, String strA2){  
				MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		    	dialog.setText("Error");
			    
			    try{ 
			        Integer.parseInt(strA4);
			        Integer.parseInt(strA3);
			        Integer.parseInt(strA2);
			        if (Integer.parseInt(strA4) < 0 ||Integer.parseInt(strA3) < 0 || Integer.parseInt(strA2) < 0) 
			        	throw new Exception("The number is less than 0");  
			    
			    
			    }catch(NumberFormatException e){
			    	System.out.println("Error!");    	
			    	dialog.setMessage("Incorrect data entry\r\n" + "\r\n" + "Enter only integer numbers");
			    	dialog.open(); 	
			    	checkInput = false;
			    }
			    catch(Exception ex){
			    	dialog.setMessage("Incorrect data entry\r\n" + "\r\n" + "Number of sheets can't be negative");
			    	dialog.open();
			    	checkInput = false;			    				        
			    }
			}		
		});
		return shell;	
	}	
	
		public static void main(String[] args) {
			Display display = new Display();
			Shell shell = ConfigureShell(display);
			
			shell.open();
					
			while (!shell.isDisposed()) {
			
				if (!display.readAndDispatch())
				display.sleep();
				
			}
		}
}
