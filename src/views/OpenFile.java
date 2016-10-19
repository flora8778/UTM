package views;

import java.util.Scanner;
import java.io.File;
import javax.swing.JFileChooser;

public class OpenFile {
	
	//Declare Variable
	 JFileChooser fileChooser = new JFileChooser();
	 public StringBuilder sb = new StringBuilder();
	
	public void PickMe() throws Exception {
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			//get the file
			// java.io.File file = fileChooser.getSelectedFile();
			File openfile = fileChooser.getSelectedFile();
			
			//create a scanner for the file
			Scanner input = new Scanner(openfile);
			
			//read text from file
			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
			}
			input.close();
		}else{
			sb.append("no file was selected.");
		}
	}

}
