package com.ast.expression;

import com.ast.ArgList;

public class IndirectExpression extends Expression {
	private Expression value;
	private ArgList indirectArgList;
	
	public IndirectExpression(Expression value) {
		this.value = value;
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

	public ArgList getIndirectArgList() {
		return indirectArgList;
	}

	public void setIndirectArgList(ArgList indirectArgList) {
		this.indirectArgList = indirectArgList;
	}
}
