package Discrete;

import java.util.ArrayList;

public class Validity {

	ArrayList<String> list;
	ArrayList<String> user_check;
	ArrayList<String> variables;
	ArrayList<String> operators;
	
	public Validity() {
		
		
		 list = new ArrayList<String>();
		 user_check = new ArrayList<String>();
		 variables = new ArrayList<String>();
		 operators = new ArrayList<String>();
			
	}

	
	
	
	public ArrayList<String> getVariables() {
		return variables;
	}




	public void setVariables(ArrayList<String> variables) {
		this.variables = variables;
	}




	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	
	
	public ArrayList<String> getUser_check() {
		return user_check;
	}

	public void setUser_check(ArrayList<String> user_check) {
		this.user_check = user_check;
		
	}

	public void addSyntax(String e) {
		
		this.getList().add(e);
		

		
		
	}
	private void breakSyntax(String str) {
		
	
		
		for(int i = 0 ; i < str.length() ; i++) {
			
			this.getUser_check().add(str.substring(i, i+1));
			
			
		}
		//System.out.println(this.getUser_check());
		
		
		
	}
	public void addUserSyntax(String str) {
		
		this.breakSyntax(str);
		
	}
	public void chunks() {
		
		String store = "";
		boolean flag = false;
		
		for(int i = 0 ; i < this.getUser_check().size() ; i++) {
			
		  if(Character.isLetterOrDigit(this.getUser_check().get(i).charAt(0)) ) {
			  
			  store = store + this.getUser_check().get(i).charAt(0);
			  flag = true;
			  
		  }
		  if(flag == true && !(Character.isLetterOrDigit(this.getUser_check().get(i).charAt(0)) )) {
			
			  
			 
			  this.getVariables().add(store);
			  flag = false;
			  store = "";
			  
			  
			
		  }
		  if(this.getUser_check().get(i).charAt(0) != '(' &&
				  this.getUser_check().get(i).charAt(0) != ')' &&
				  !(Character.isLetterOrDigit(this.getUser_check().get(i).charAt(0)) ))
		  {
			  
			 if(this.getUser_check().get(i).charAt(0) == '/' && this.getUser_check().get(i+1).charAt(0) == '\\') {
				 
				 this.operators.add("&");
				 
			 }
			 else if(this.getUser_check().get(i).charAt(0) == '\\' && this.getUser_check().get(i+1).charAt(0) == '/') {
				 
				 this.operators.add("|");
				 
			 }
             else if(this.getUser_check().get(i).charAt(0) == '-' && this.getUser_check().get(i+1).charAt(0) == '>') {
				 
				 this.operators.add("->");
				 
			 }
             else if(this.getUser_check().get(i).charAt(0) == '~') {
            	 this.operators.add("~");
			  
             }
		  }
		  
		}
		
		
		
	}
	
}
