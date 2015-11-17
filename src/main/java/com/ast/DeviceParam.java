package com.ast;

import com.ast.expression.Expression;

public class DeviceParam extends AstNode {

	// if a device param has both a name and an expression then it implies a set operation.
	private String name;
	private Expression expression;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
}
