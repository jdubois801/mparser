package com.ast.command;

import com.ast.expression.Expression;

public class QuitCommand extends Command {
	private Expression returnExpression;

	public QuitCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setReturnExpression(Expression expr) {
		this.returnExpression = expr;
	}

	public Expression getReturnExpression() {
		return returnExpression;
	}
}

