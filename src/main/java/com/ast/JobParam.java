package com.ast;

import com.ast.expression.Expression;

public class JobParam extends Expression {
	private Expression timeout;
	private ArgList processParams;

	public Expression getTimeout() {
		return timeout;
	}

	public void setTimeout(Expression timeout) {
		this.timeout = timeout;
	}

	public ArgList getProcessParams() {
		return processParams;
	}

	public void setProcessParams(ArgList processParams) {
		this.processParams = processParams;
	}
}
