package com.ast.expression;

import com.ast.ArgList;

public class FunctionExpression extends Expression {
	private String name;
	private ArgList argList;
	
	public FunctionExpression() {}
	
	public FunctionExpression(String name, ArgList argList) {
		this.name = name;
		this.argList = argList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArgList getArgList() {
		return argList;
	}
	
	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
}
