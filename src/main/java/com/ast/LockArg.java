package com.ast;

import com.ast.expression.Expression;

public class LockArg extends Arg {
	private ArgList argList;
	private String append;
	private Expression timeout;
	
	public ArgList getArgList() {
		return argList;
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public String getAppend() {
		return append;
	}

	public void setAppend(String append) {
		this.append = append;
	}

	public Expression getTimeout() {
		return timeout;
	}

	public void setTimeout(Expression timeout) {
		this.timeout = timeout;
	}
}
