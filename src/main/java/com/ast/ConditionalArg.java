package com.ast;

import com.ast.expression.Expression;

public class ConditionalArg extends Arg {
	private Expression condition;

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}
}
