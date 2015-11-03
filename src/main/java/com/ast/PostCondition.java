package com.ast;

public class PostCondition extends AstNode {
	Expression expr;

	public PostCondition(Expression expr) {
		this.expr = expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}
}

