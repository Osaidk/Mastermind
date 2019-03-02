package assignment2;

import java.util.*;

class Code {
	String code;
	String feedback;
	int black_pegs;
	int white_pegs;
	ArrayList <Character> code_ = new ArrayList<Character>();
	ArrayList <Character> input_ = new ArrayList<Character>();

	public Code (String code) {
		this.code=code;
	}

	public void CopyCodeInput(String code, String input){
		for (int i=0; i< code.length(); i++) {
			code_.add(code.charAt(i));
			input_.add(input.charAt(i));
		}
	}
	
	public void check_code(String input) {
		black_pegs=0;
		white_pegs=0;
		CopyCodeInput(code, input);

		for (int i=0; i<code_.size(); i++){
			
				if (input_.get(i)==code_.get(i)) {
						black_pegs++;
						code_.set(i, '1');
						input_.set(i, '2');
					}
				}
		check_code_white(input);
		code_.clear();
		input_.clear();
        feedback = (black_pegs+"b_"+white_pegs+"w");
        System.out.println(input + " -> " +feedback);
	}
	
	public void check_code_white(String input) {
		white_pegs=0;

		for (int i=0; i<code_.size(); i++) {
			for (int j=0; j<input_.size(); j++) {
				if (input_.get(j)==code_.get(i) ) {
						white_pegs++;	
						code_.set(i, '3');
						input_.set(j,'4');
						
				}
			}
		}
	}
	
	public boolean check_win() {
		return black_pegs==GameConfiguration.pegNumber;
	}
}
