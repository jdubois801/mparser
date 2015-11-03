package com.ast;

public class ForCommand extends Command {
	private Expression expr1;
	private Expression expr2;
	private Expression expr3;

	public void setExpression1(Expression expr) {
		this.expr1 = expr;
	}

	public Expression getExpression1() {
		return expr1;
	}

	public void setExpression2(Expression expr) {
		this.expr2 = expr;
	}

	public Expression getExpression2() {
		return expr2;
	}

	public void setExpression3(Expression expr) {
		this.expr3 = expr;
	}

	public Expression getExpression3() {
		return expr3;
	}
}

