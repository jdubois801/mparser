package com.ast.expression;

public class StringConstant extends Expression {
	private String value;

	public StringConstant(String value) {
		setValue(value);
	}
	
	public void setValue(String value) {
		this.value = value;
		
		// TODO - kind of inefficient way to remove leading and trailing quotes
		if (this.value != null && this.value.length() > 1 && this.value.startsWith("\"")) {
			this.value = this.value.substring(1);
		}
		if (this.value != null && this.value.length() > 0 && this.value.endsWith("\"")) {
			this.value = this.value.substring(0, this.value.length()-1);
		}
	}
	
	public String getValue() {
		return value;
	}
}
