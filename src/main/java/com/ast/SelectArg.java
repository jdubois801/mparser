package com.ast;

import com.ast.expression.Expression;

public class SelectArg extends Arg {
	private Expression option;

	public SelectArg(Expression expr) {
		super(expr);
	}
	
	public SelectArg(Expression expr, Expression option) {
		super(expr);
		this.option = option;
	}
	
	public Expression getOption() {
		return option;
	}

	public void setOption(Expression option) {
		this.option = option;
	}
}
