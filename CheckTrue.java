package Discrete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CheckTrue {
	
	
	Validity v;
	static int  count = 0;
	static double rows = 0;
	static int size = 0;
    boolean []table;
	static int countOP;
	
	
	public CheckTrue(FileHandling h) {
		
		v = h.getV();

		
	}
	
	public void intialization() {
		
	
		
		 size = ((int) rows*count) + ((int)rows*count/2);
		
		table =new boolean[size];
		
	}
	
	public void decleration() {
		
		int loop = (int)rows/2;
		
		for(int i = 1; i <= size; i++) {
			
			if( i <= loop) {
				
				table[i] = true;
				
			}
			if(i <= rows) {
				
				table[i] = false;
			}
			if(i == rows) {
				loop = loop/2;
				
			}
		}
		}
	
	
public void count() {
	
	     
	 count = v.getVariables().size();
	 
	 countOP = v.operators.size();
	
	rows = Math.pow(2 , count);

	}
	



public boolean trueOrNot(ArrayList<String> list ,ArrayList<String> op2) {
	

	
	int j = 0;
	
	if(list.size() == 1) {
		if(op2.isEmpty()) {
			
			return true;
			
		}
		
	}
	
	
	for(int i = 0 ; i < list.size() ; i++) {
		
		if(op2.get(j)== "&") {
			
             if(i < list.size()-1 && list.get(i).matches(list.get(i+1))) {
            	 
            	 if(j > 0 && op2.get(j-1) == "~") {
            		 
            		 return false;
            	 }
            	 else if(j < op2.size()-1 && op2.get(j+1) == "~") {
            		 
            		 return false;
            	 }
            	 else {
            		 
            		 return true;
            	 }
            	 
            	 
             }else
             {
            	 return true;
            	 
             }
            
		}
		 if(op2.get(j)== "~") {
			 j++;
			//--i;
		 }
		 
		 
			if(op2.get(j) == "|") {
				
				
				if(i < list.size()-1 && list.get(i).matches(list.get(i+1)))
				{
					
				if(j > 0 && op2.get(j-1) == "~") {
					if(j < op2.size()-1 &&op2.get(j+1) == "~") {
						
					
						return false;
						
					}
					}
					
					else {
						return true;
					}
			}
				else {return true;}
	}
			
		if(op2.get(j) == "->") {
			
		
			if(i < list.size()-1 && list.get(i).matches(list.get(i+1)))
			{
			
				if(j < op2.size() -1 && op2.get(j+1) == "~") {
					
					return false;
					
				}
				
				else {
					return true;
				}
			
				
			}
			else {return true;}
		}
}

return false;
}


public boolean solve() {
	
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> op = new ArrayList<String>();
	ArrayList<String> op2 = new ArrayList<String>();
	ArrayList<Boolean> bool = new ArrayList<Boolean>();
	int j = 0;
	
	

	for(int i = 0 ; i <= count/2+countOP -2;i++ ) {
		
		  if(j <= countOP-1 && j!= countOP-1 && v.operators.get(j) == "~") {
				op2.add(v.operators.get(j));
				j++;
				
			}
		
		if(i <= count-1) {
		list.add(v.getVariables().get(i));
		i++;
		}
		
    
		if(j <= countOP-1) {
		
			op2.add(v.operators.get(j));
			j++;
			
		}
		 if(j <= countOP-1 && v.operators.get(j) == "~") {
				op2.add(v.operators.get(j));
				j++;
				
			}
		if(i <= count-1) {
		list.add(v.getVariables().get(i));
		
		}
		
		 if(j <= countOP-1) {
			 
			 op.add(v.operators.get(j));
			 j++;
			 
			 
			 
		 }
		 if(! list.isEmpty()) {
		bool.add(trueOrNot(list , op2));
		list.clear();
		op2.clear();
		 }
		
	}

	for(int i = 0 ; i < op.size() ; i++) {
		
		if(!op.isEmpty() && op.get(i) == "->") {
			
			if(bool.get(i) == true && bool.get(i+1) == false){
				
				bool.remove(i);
				bool.remove(i);
				op.remove(i);
				bool.add(i, false);
			}
			else {
				
				bool.remove(i);
				bool.remove(i);
				op.remove(i);
				bool.add(i, true);
				
			}
			
		}
if(!op.isEmpty() && op.get(i) == "&") {
			
			if(bool.get(i) == true && bool.get(i+1) == false ||
					bool.get(i) == false && bool.get(i+1) == true ||
					bool.get(i) == false && bool.get(i+1) == false){
				
				bool.remove(i);
				bool.remove(i);
				op.remove(i);
				bool.add(i, false);
			}
			else {
				
				bool.remove(i);
				bool.remove(i);
				op.remove(i);
				bool.add(i, true);
				
			}
			
		}
if(!op.isEmpty() && op.get(i) == "|") {
	
	if(bool.get(i) == false && bool.get(i+1) == false){
		
		bool.remove(i);
		bool.remove(i);
		op.remove(i);
		bool.add(i, false);
	}
	else {
		
		bool.remove(i);
		bool.remove(i);
		op.remove(i);
		bool.add(i, true);
		
	}
	
}
		
		
		
		
	}
	
if(!bool.isEmpty())
	return bool.get(0);
	
return true;
}
	
	
	
}


