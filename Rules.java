package Discrete;

import java.util.ArrayList;

public class Rules {

	
	Validity v;
	
	
	public Rules(FileHandling h) {
		
		v = h.getV();

		
	}
	
	public boolean rule1() {
		
		//If any Unary Operator
		
		boolean temp = false;
		ArrayList<Integer> check =new ArrayList<Integer>();
		
		
		if(v.getUser_check().size() == 1) {
			return false;
		}

		if(Character.isLetter(v.getUser_check().get(0).charAt(0))) {
			
			temp = true;
			
		}
		else
			check.add(1);
		
		
	
		
		for(int i = 0; i < v.getUser_check().size()-1 ; i++) {
		if(((i < v.getUser_check().size() - 1) &&
				(Character.isDigit(v.getUser_check().get(i+1).charAt(0)))) &&
				(temp == true )
				) {
			check.add(0);
		}
			else
				check.add(1);
			
			
		}
		
		if(!check.contains(1))
			return true;
		
		
		
		return false;
	}
	public boolean rule2(){
		
		ArrayList<Integer> check =new ArrayList<Integer>();
//		ArrayList clone = v.getUser_check();
//		v.getUser_check().clear();
		
		for(int i = 0 ; i < v.getUser_check().size() ; i++) {
			
			if(v.getUser_check().get(i).charAt(0) == '(') {
				
				check.add(1);
				
			}
if(v.getUser_check().get(i).charAt(0) == ')') {
				
				check.add(0);
				
			}
		}
		int count = 0;
		int count2 = 0;
		
for(int i = 0 ; i < check.size() ; i++) {
	
	if(check.get(i) == 1) {
		
		count++;
	}
	

else
	count2++;
	
}		
	if(count == count2)
		return true;
		
		
		
		return false;
	}
	@SuppressWarnings("unchecked")
	
	public boolean rule3() {
		
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		ArrayList<String> clone = new ArrayList<String>();
		char s = 92; // \
		String collect = "";
		for(int i = 0 ; i < v.getUser_check().size() ; i++) {
			
		//	System.out.println(i);
			
			if(v.getUser_check().get(i).charAt(0) == '(' ||
					v.getUser_check().get(i).charAt(0) == ')' ||
					v.getUser_check().get(i).charAt(0) == '~' ||
					v.getUser_check().get(i).charAt(0) == s ||
					v.getUser_check().get(i).charAt(0) == '/'||
					v.getUser_check().get(i).charAt(0) == ' ')
			{
				 if(i < v.getUser_check().size() -1 && Character.isLetterOrDigit(v.getUser_check().get(i+1).charAt(0))){
					 for(int j = i+1;j < v.getUser_check().size() &&
							 Character.isLetterOrDigit(v.getUser_check().get(j).charAt(0)); j++) {
						 
						// System.out.println(v.getUser_check().get(j).charAt(0));
						collect +=   v.getUser_check().get(j).charAt(0) ;
						 
					//	System.out.println(collect);
					 }
					 
						 
					clone =	(ArrayList<String>) v.getUser_check().clone();
					v.getUser_check().clear();
					 v.addUserSyntax(collect);
					
					if(this.rule1()) {
					check.add(0);
						
					}
					else
						check.add(1);
					
					v.getUser_check().clear();
				
					
					v.setUser_check(clone);
					
					
					 collect = "";
				 }
				
				
				
				
			}
				
		}
		if(!check.contains(1) && !check.isEmpty())
			return true;
		
		
		return false;
	}
	

public boolean rule4() {
	ArrayList<Integer> check = new ArrayList<Integer>();
	char s = 92;
	
//System.out.println(v.getUser_check());
	
for(int i = 0 ; i < v.getUser_check().size() ; i++) {
	
	if(i < v.getUser_check().size()-1 
			&& v.getUser_check().get(i).contains("(")) {
		
		if(v.getUser_check().get(i+1).charAt(0) == '/' ||
				v.getUser_check().get(i+1).charAt(0) == s	||
				(v.getUser_check().get(i+1).charAt(0) == '~' && 
				v.getUser_check().get(i+2).charAt(0) == '>')) {
			
			check.add(1);
			
		}
		else check.add(0);
		//  /\ \/ -> 	
	}
}
for(int i = 1 ; i < v.getUser_check().size() ; i++) {
	
	if(i < v.getUser_check().size()-1 
			&& v.getUser_check().get(i).contains("(")) {
		
		if(v.getUser_check().get(i-1).charAt(0) == '/' ||
				v.getUser_check().get(i-1).charAt(0) == s	||
				v.getUser_check().get(i-1).charAt(0) == '~' || 
				v.getUser_check().get(i-1).charAt(0) == '>'|| 
		        v.getUser_check().get(i-1).charAt(0) == '('){
			
			
			check.add(0);
			
		}
		else { 
		//	System.out.println("1");
			check.add(1);
	}}
	
}
	//System.out.println(check);
if(check.contains(1))

    return false;	


return true;
	
}

public boolean rule5() {
	
	ArrayList<Integer> check = new ArrayList<Integer>();  // 2- /\ 
	
	char s = 92;
	
	//System.out.println(v.getUser_check());
		
	for(int i = 0 ; i < v.getUser_check().size() ; i++) {
		
		
			
			if(v.getUser_check().get(i).charAt(0) == '/' ||
					v.getUser_check().get(i).charAt(0) == s	||
					v.getUser_check().get(i).charAt(0) == '-' || 
					v.getUser_check().get(i).charAt(0) == '>'||
					v.getUser_check().get(i).charAt(0) == '('||
					v.getUser_check().get(i).charAt(0) == ')'||
					Character.isDigit(v.getUser_check().get(i).charAt(0))||
					v.getUser_check().get(i).charAt(0) == 'P' ||
					v.getUser_check().get(i).charAt(0) == 'p'||
					v.getUser_check().get(i).charAt(0) == ' '||
			        v.getUser_check().get(i).charAt(0) == '~'){
			
	                check.add(0);
	
				
			}
			else check.add(1);
		}
	
	
	
	if(check.contains(1))

                 return false;	
	
	
	return true;
}
public boolean rule6() {
	

ArrayList<Integer> check = new ArrayList<Integer>();  // 2- /\ 
	
	char s = 92;
	
	//System.out.println(v.getUser_check());
		
	for(int i = 1 ; i < v.getUser_check().size() ; i++) {
		
		
			
			if(v.getUser_check().get(i).charAt(0) == '/' &&!(
					v.getUser_check().get(i-1).charAt(0) == s))  
				{ // /\  \/
				if(v.getUser_check().get(i+1).charAt(0) == s )
					check.add(0);
				else
					check.add(1);
			}
				
			else if (v.getUser_check().get(i).charAt(0) == '>') {
						if(v.getUser_check().get(i-1).charAt(0) == '-' )	
							check.add(0);
						else
							check.add(1);
					}
			else if(v.getUser_check().get(i).charAt(0) == s &&!(
					v.getUser_check().get(i-1).charAt(0) == '/')) {   // /\  \/
						if(v.getUser_check().get(i+1).charAt(0) == '/')
							check.add(0);
						else
							check.add(1);
					
					}
	
				
			
		}
	
	//System.out.println(check);
	if(check.contains(1))

                 return false;	
	
	
	return true;
}
public boolean rule7() {
	
	ArrayList<Integer> check = new ArrayList<Integer>();
	String collect = "";
	int count = 0;
	
	for(int i = 1; i < v.getUser_check().size(); i++) {
		
		if(!Character.isLetterOrDigit(v.getUser_check().get(i).charAt(0))) {
			
			count++;
			
				if(!(v.getUser_check().get(i).charAt(0) == '('))
				{
					
					
					if(!(v.getUser_check().get(i).charAt(0)== ')')) 
					{
						for(int j = i; !Character.isLetterOrDigit(v.getUser_check().get(j).charAt(0));
								j++) {	
						
							if(!(v.getUser_check().get(j).charAt(0) == '('))
							{
								if(!(v.getUser_check().get(j).charAt(0)== ')')) 
								{
									if(!(v.getUser_check().get(j).charAt(0)== '~')) {
									
			collect += v.getUser_check().get(j).charAt(0);
		//	System.out.println(collect+" " + j);
				}
				}
							}			
		}
						i++;
			//			System.out.println("outer" + collect);
						if(collect.length() <= 2) {
							
							check.add(0);
							collect = "";
							
						}
						else  if(collect.length() > 2){
							
							check.add(1);
							collect = "";
							
						}
						
						
						}
		}
				}
		
	}
	//System.out.println(check);	
	
	if(check.contains(1))

        return false;	


return true;
}
public boolean rule8() {
	
	int count = 0;
	char s = 92;
	
	for(int i = 0 ; i < v.getUser_check().size() ;  i++) {
		
		
		if(v.getUser_check().get(i).charAt(0) == 'p' || v.getUser_check().get(i).charAt(0) == 'P'){
			
			count++;
			
		}
if((v.getUser_check().get(i).charAt(0) == '/' && v.getUser_check().get(i+1).charAt(0) == s)
		||(v.getUser_check().get(i).charAt(0) == s && v.getUser_check().get(i+1).charAt(0) == '/')||
		(v.getUser_check().get(i).charAt(0) == '-' && v.getUser_check().get(i+1).charAt(0) == '>')){
			
			count++;
			
		}
		if(v.getUser_check().get(i).charAt(0) == ')'||v.getUser_check().get(i).charAt(0) == '(') {
			
			count = 0;
		}
		
		if(count == 4) {
			return false;
			
		}
		
	}	
	return true;
}


public boolean rule9() {
	
	char s = 92;	
	
		if(v.getUser_check().get(0).charAt(0) == '~'||
				v.getUser_check().get(0).charAt(0) == s||
				v.getUser_check().get(0).charAt(0) == '/'||
				v.getUser_check().get(0).charAt(0) == '>') {
			
			
			
			return false;
			
			
		}
		

return true;	
}


public boolean rule10() {
	
	for(int j = 0 ; j < v.getUser_check().size() ; j++) {
	
	for( ;v.getUser_check().get(j).charAt(0) == '~';) {
		
		if(!(v.getUser_check().get(j-1).charAt(0) == '(' && v.getUser_check().get(j).charAt(0) == '~')) {
			
			
			return false;
			
		}
		
		j++;		
		
	}
	}
	
	
	return true;
}


//Check precedence



public boolean rule11() {
	
   boolean flag = false;
   int brak = 0;
   
	
	for(int i=0; i<v.getUser_check().size() ; i++) {
		
		if(v.getUser_check().get(i).charAt(0) == '(') {
			
				flag =  true;	
			    brak++;
			
			
		}
		if(v.getUser_check().get(i).charAt(0) == ')') {
			
		flag = false;
		brak--;
		if(i < v.getUser_check().size() - 1 && (!(v.getUser_check().get(i+1).isEmpty()) && brak == 0)) {
			
			return false;
			
		}
		
	}
	
	
	
	}
	
	return true;
}



}


























