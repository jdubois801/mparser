package com.ast;

import com.ast.expression.Expression;

public class MergeArg extends Arg {
	private Expression destExpression;

	public Expression getDestExpression() {
		return destExpression;
	}

	public void setDestExpression(Expression destExpression) {
		this.destExpression = destExpression;
	}
}
