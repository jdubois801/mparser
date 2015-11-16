package com.ast.expression;

public class MatchExpression extends Expression {
	private String operator;
	private Expression leftExpression;
	private String pattern;
	
	public MatchExpression() {}
	
	public MatchExpression(String operator, Expression left, String pattern) {
		this.operator = operator;
		this.leftExpression = left;
		this.pattern = pattern;
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

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
