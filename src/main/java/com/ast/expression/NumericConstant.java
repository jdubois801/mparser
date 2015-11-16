package com.ast.expression;

public class NumericConstant extends Expression {
	private String value;

	public NumericConstant(String value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
