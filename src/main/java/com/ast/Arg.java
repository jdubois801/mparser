package com.ast;

import com.ast.expression.Expression;

public class Arg extends AstNode {
	private Expression expression;
	
	public Arg() {}
	
	public Arg(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
}
