package com.ast.command;

import com.ast.AstNode;
import com.ast.expression.Expression;

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

