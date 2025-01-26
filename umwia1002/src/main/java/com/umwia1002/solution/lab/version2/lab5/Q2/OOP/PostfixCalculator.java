package com.umwia1002.solution.lab.version2.lab5.Q2.OOP;

public class PostfixCalculator {
	private String expression;
	
	PostfixCalculator(String expression){
		this.expression = expression;
	}
	
	
	boolean isValidSequence(Operator inside, Operator outside) {
		return outside.precedence >= inside.precedence;
	}
	
	boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
	
	Operation[] getOperationArray() {
		String[] tmp  = expression.split("\\s");
		Operation[] arr = new Operation[tmp.length];
		int p = 0;
		for(String exp : tmp) {
			if(isInteger(exp)) {
				arr[p++] = new Operand(Integer.parseInt(exp));
			} else {
				arr[p++] = Operator.getOperator(exp);
			}
		}
		return arr;
	}
	
	
}
