package assignment2;

import java.util.Arrays;

public class Input {

	String colors=Arrays.toString(GameConfiguration.colors);
	
	public boolean check_input(String in) {
		for (int i=0; i<in.length(); i++){
           char ch = in.charAt(i);
            if (Character.isLowerCase(ch)) {  
            	return false;
               }
        }
		if (check_input_number(in) && check_colors(in))
			return true;
		return false;
	}
	
	
	public boolean check_input_number(String in) {
		if (in.length() > GameConfiguration.pegNumber ||in.length() < GameConfiguration.pegNumber ) {
			return false;
		}
		return true;
	}
	
	public boolean check_continuity(String in) {
		if (in.equals("Y"))
			return true;
		return false;
	}
	
	public boolean check_colors(String in) {
		boolean result=true;
		for (int i=0; i<in.length(); i++) {
			if (colors.indexOf(in.charAt(i)) == -1 || 
					in.charAt(i) == ',' || 
					in.charAt(i)== '[' ||
					in.charAt(i)== ']') 
				return false;
			
		}
		return result;
	}
}
