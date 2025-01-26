package com.umwia1002.solution.lab.version2.lab5.Q2.OOP;

import java.util.function.BinaryOperator;

public enum Operator implements Operation {
	ADD('+', 1, (val2, val1) -> new Operand(val1.value + val2.value)),
	SUB('-', 1, (val2, val1) -> new Operand(val1.value - val2.value)),
	MUL('*', 2, (val2, val1) -> new Operand(val1.value * val2.value)),
	DIV('/', 2, (val2, val1) -> new Operand(val1.value / val2.value)),
	MOD('%', 2, (val2, val1) -> new Operand(val1.value % val2.value));

	public final char symbol;
	public final int precedence;
	private final BinaryOperator<Operand> operation;

	Operator(char symbol, int precedence, BinaryOperator<Operand> operation) {
		this.symbol = symbol;
		this.precedence = precedence;
		this.operation = operation;
	}

	public Operand operate(Operand val2, Operand val1) {
		return new Operand(operation.apply(val1, val2).value);
	}
	
	public static Operator getOperator(String operator) {
		switch(operator) {
		case "add": return ADD;
		case "sub": return SUB;
		case "mul": return MUL;
		case "div": return DIV;
		case "mod": return MOD;
		default : return null;
		}
	}
}
