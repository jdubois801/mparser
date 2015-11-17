package com.ast.expression;

public class ExtSyntaxConstant extends Expression {
	private String text;
	
	public ExtSyntaxConstant(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
