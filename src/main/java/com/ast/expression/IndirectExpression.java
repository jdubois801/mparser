package com.ast.expression;

public class IndirectExpression extends Expression {
	private Expression value;
	
	public IndirectExpression(Expression value) {
		this.value = value;
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

}
