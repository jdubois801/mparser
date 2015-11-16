package com.ast.expression;

public class UnaryExpression extends Expression {
	private String operator;
	private Expression value;
	
	public UnaryExpression(String operator, Expression value) {
		this.operator = operator;
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}
}
