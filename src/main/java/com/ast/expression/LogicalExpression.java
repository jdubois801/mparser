package com.ast.expression;

public class LogicalExpression extends Expression {
	private String operator;
	private Expression leftExpression;
	private Expression rightExpression;
	
	public LogicalExpression() {}
	
	public LogicalExpression(String operator, Expression left, Expression right) {
		this.operator = operator;
		this.leftExpression = left;
		this.rightExpression = right;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Expression getLeftExpression() {
		return leftExpression;
	}
	
	public void setLeftExpression(Expression leftExpression) {
		this.leftExpression = leftExpression;
	}
	
	public Expression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}
}
