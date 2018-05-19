package Discrete;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String args[]) throws FileNotFoundException {
		
		
		
		
		Scanner input = new Scanner(System.in);
		FileHandling h = new FileHandling();
		Rules rule = new Rules(h);
		
		CheckTrue chk = new CheckTrue(h);
		
		
		
		h.handling();
		
	
		
		String syntax;
		
		System.out.println("Enter valid Syntax");
		
		syntax = input.nextLine();
		
		if(syntax.isEmpty() || Character.isWhitespace(syntax.charAt(0))) {
			System.out.println("No syntax! No validation :(");
			return;
		}
		
		h.getV().addUserSyntax(syntax);
		
		String p = "(";
		
		rule.v.chunks();
	
		chk.count();
		
		boolean bool = Test.statementValidation(rule, syntax, p);
		System.out.println();
		
		if(bool) {
			boolean b;
			System.out.println("You Enter correct Statement");
			System.out.println();
			try {
			 b = chk.solve();
				if(b) {
					
					System.out.println("Your statement is True atlest once");
					
				}else
					System.out.println("Your statement is false all over the Truth table");
				}
			catch (Exception e) {
				System.out.println("Sorry! I cannot handle Single variable part!");
				System.out.println();
				System.out.println("But the good thing is: your statement may be true or may be false :*)");
			}
		
		
		}else {
			
			System.out.println("There is Syntactic error in your statement :(");
			System.out.println("You want me to check where is the problem y/n");
			String s = input.nextLine();
			if(s.charAt(0) == 'y') {
				
				System.out.println("i'm not smart enough. oneday I will :*)");
				
			}
	}
		
	
	}
		
		public static boolean statementValidation(Rules rule , String syntax , String p){
			
		
		
		if(rule.rule5() && rule.rule6()
			&& rule.rule7() && rule.rule9() && rule.rule8() && rule.rule10() && rule.rule11())
			{
		
			if(rule.rule4())
			{
				
			
		 if(!syntax.contains(p))	
		return(rule.rule1());
//	
		
		
	
		else if(rule.rule2())
		return(rule.rule3());
		else
			
			return(false);
	}
			else
			
				return(false);	
		}
		else {
		
		return(false);
	}
		
		//return false;
		
		
		}	
		
		

}