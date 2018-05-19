package Discrete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandling {

	FileInputStream in;
	Validity v;
	
	public FileHandling() throws FileNotFoundException {
		
		setIn(new FileInputStream("C:\\Users\\SFAdr\\eclipse-workspace\\Language\\src\\Discrete\\Rules"));
		v = new Validity();
		
	}


	public Validity getV() {
		return v;
	}


	public void setV(Validity v) {
		this.v = v;
	}


	public FileInputStream getIn() {
		return in;
	}


	public void setIn(FileInputStream in) {
		this.in = in;
	}
	
public void handling() {
	
	int c;
	String collect = "";
	try {
		while((c = in.read()) != -1) {
			
	//		System.out.println(c);
			if(c != 44) {
				
				String parse = String.valueOf(Character.toChars(c));
				
				collect += parse;
				
				
			}
			if(c == 44) {
				
				v.addSyntax(collect);
				
				collect = "";
				
			}
			
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}
}
